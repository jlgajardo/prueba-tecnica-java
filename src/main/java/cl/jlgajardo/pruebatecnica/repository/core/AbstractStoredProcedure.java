package cl.jlgajardo.pruebatecnica.repository.core;

import cl.jlgajardo.pruebatecnica.exception.APIException;
import cl.jlgajardo.pruebatecnica.exception.APIExceptionBadRequest;
import cl.jlgajardo.pruebatecnica.exception.APIExceptionEmptyOrNullParam;
import cl.jlgajardo.pruebatecnica.repository.annotations.InputOutputDefinition;
import cl.jlgajardo.pruebatecnica.repository.annotations.SPInput;
import cl.jlgajardo.pruebatecnica.repository.annotations.SPOutput;
import cl.jlgajardo.pruebatecnica.repository.annotations.TableColumn;
import cl.jlgajardo.pruebatecnica.utils.APIUtils;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

import static cl.jlgajardo.pruebatecnica.utils.APIUtils.castObject;
import static cl.jlgajardo.pruebatecnica.utils.APIUtils.toJsonString;

public class AbstractStoredProcedure extends StoredProcedure implements Invokable {


    protected AbstractStoredProcedure(JdbcTemplate jdbcTemplate, String name) {
        super(jdbcTemplate, name);
    }


    protected void declareSpInputParameters(Stream<DeclaredSpParam> params) {
        Objects.requireNonNull(params);
        params.forEach(arg -> declareParameter(new SqlParameter(arg.getParamName(), arg.getJdbcType())));
    }

    protected <T> void declareInputOuputParameters(Class<T> tClass) {
        Objects.requireNonNull(tClass);
        declareSpInputParameters(extractInputParametes(tClass));
        declareSpOuputParameters(extractOuputParametes(tClass));
    }

    protected void declareSpOuputParameters(Stream<DeclaredSpParam> aprams) {
        Objects.requireNonNull(aprams);
        aprams.forEach(arg -> declareParameter(new SqlOutParameter(arg.getParamName(), arg.getJdbcType())));
    }

    public <T> Stream<DeclaredSpParam> extractOuputParametes(Class<T> inputClassType) {
        return Arrays.stream(inputClassType.getDeclaredFields())
                .filter(field -> field.getAnnotation(SPOutput.class) != null)
                .map(field -> new DeclaredSpParam(getType(field), getColumnName(field)));
    }

    public <T> Stream<DeclaredSpParam> extractInputParametes(Class<T> inputClassType) {
        return Arrays.stream(inputClassType.getDeclaredFields())
                .filter(field -> field.getAnnotation(SPInput.class) != null)
                .map(field -> new DeclaredSpParam(getType(field), getColumnName(field)));
    }

    private String getColumnName(Field field) {

        String name = field.getName();
        TableColumn annotation = field.getAnnotation(TableColumn.class);
        if (annotation != null && !annotation.name().isEmpty()) {
            name = annotation.name();
        }
        return name;
    }

    private int getType(Field field) {
        String[] tokens = field.getType().getTypeName().toUpperCase().split("\\.");
        return JavaTypes.valueOf(tokens[tokens.length - 1]).toJdbcType();
    }

    @Override
    public SPResponse create(Stream<InputSPParam> parameters) {
        return invoke(parameters);
    }

    public <T> SPResponse insert(T obj) {

        final SPResponse rsp = create(createSpInputParams(obj));
        final boolean isNull = Objects.isNull(rsp.getErrorMsg());
        if (rsp.getOutRetorno() == 501) {


            throw new APIExceptionBadRequest(isNull ? rsp.getSuccessMsg() : rsp.getErrorMsg());
        } else if (rsp.getOutRetorno() > 0) {

            APIException.throwPreconditionFailException(isNull ? rsp.getSuccessMsg() : rsp.getErrorMsg());
        }

        return rsp;
    }

    @Override
    public <T> SPResponse query(T obj) {

        final SPResponse spResponse = query(createSpInputParams(obj));


        if (spResponse.getOutRetorno() > 0) {
            final boolean isNull = Objects.isNull(spResponse.getErrorMsg());
            throw new APIExceptionEmptyOrNullParam(isNull ? spResponse.getSuccessMsg() : spResponse.getErrorMsg());
        }


        return spResponse;
    }

    @Override
    public SPResponse query(Stream<InputSPParam> parameters) {
        return invoke(parameters);
    }

    private <T> Stream<InputSPParam> createSpInputParams(T obj) {
        Objects.requireNonNull(obj);

        String message = "La clase " + obj.getClass() + " No fue marcada como un objeto de entrada al SP";

        final InputOutputDefinition annotation = obj.getClass().getAnnotation(InputOutputDefinition.class);
        InputOutputDefinition inputOutputDefinition = Optional
                .ofNullable(annotation)
                .orElseThrow(APIException.createAPIException(message, HttpStatus.PRECONDITION_FAILED));

        assert inputOutputDefinition != null;

        return Arrays.stream(obj.getClass().getDeclaredFields())
                .map(field -> toInputParam(field, obj));
    }

    private <T> InputSPParam toInputParam(Field field, T obj) {

        String fieldName = field.getName();
        String getterName = new StringBuilder(fieldName)
                .deleteCharAt(0)
                .insert(0, String.valueOf(fieldName.charAt(0)).toUpperCase())
                .insert(0, "get").toString();

        Object value = null;

        try {
            value = obj.getClass().getDeclaredMethod(getterName).invoke(obj);
        } catch (Exception e) {
            logger.info("ignored = " + e.getMessage());
        }

        return new InputSPParam(fieldName, value);
    }


    private SPResponse invoke(Stream<InputSPParam> parameters) {
        return APIUtils.castObject(APIUtils.toJsonString(invokeSp(parameters)), SPResponse.class);
    }

    private Map<String, Object> invokeSp(Stream<InputSPParam> inputParams) {
        Map<String, Object> inputMap = inputParams.collect(HashMap::new, (m, v) -> m.put(v.getParamName(), v.getValue()), HashMap::putAll);
        return inputMap.isEmpty() ? super.execute() : super.execute(inputMap);
    }
}
