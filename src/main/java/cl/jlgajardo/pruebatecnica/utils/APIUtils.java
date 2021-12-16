package cl.jlgajardo.pruebatecnica.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jooq.lambda.Unchecked;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;


public class APIUtils {
    private static final Logger logger = LoggerFactory.getLogger(APIUtils.class);


    private APIUtils() {
    }

    public static <T> T castObject(Object obj, Class<T> clazz) {
        return objectMapperProcessor(Unchecked.function(objectMapper -> objectMapper.readValue(toJsonString(obj), clazz)));
    }

    public static <T> T castObject(String json, TypeReference<T> typeReference) {
        return objectMapperProcessor(Unchecked.function(objectMapper -> objectMapper.readValue(json, typeReference)));
    }

    public static <T> T castObject(Object obj, TypeReference<T> typeReference) {
        return objectMapperProcessor(Unchecked.function(objectMapper -> objectMapper.readValue(toJsonString(obj), typeReference)));
    }

    public static <T> T castObject(String json, Class<T> clazz) {
        return objectMapperProcessor(Unchecked.function(objectMapper -> objectMapper.readValue(json, clazz)));
    }

    private static <R> R objectMapperProcessor(Function<ObjectMapper, R> code) {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return code.apply(objectMapper);
    }

    public static String toJsonString(Object stringObjectMap) {
        return objectMapperProcessor(Unchecked.function(objectMapper -> objectMapper.writeValueAsString(stringObjectMap)));
    }

    public static String toJsonString(Map<String, Object> stringObjectMap) {
        return objectMapperProcessor(Unchecked.function(objectMapper -> objectMapper.writeValueAsString(stringObjectMap)));
    }


    public static String timeStampToStringDate(String timestamp) {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(Long.parseLong(timestamp));

        return sf.format(date);
    }

    @SuppressWarnings("rawtypes")
    public static <T> T capitalizeStringValues(T t) {

        Arrays.stream(t.getClass().getDeclaredFields()).filter(field -> field.getType().equals(String.class))
                .forEach(field -> {
                    final String capitalizedFieldName = StringUtils.capitalize(field.getName());
                    String getterName = "get" + capitalizedFieldName;
                    String setterName = "set" + capitalizedFieldName;

                    try {
                        final Class[] parameterTypes = null;
                        final Object[] emptyArgs = null;
                        String oldValue = t.getClass().getDeclaredMethod(getterName, parameterTypes).invoke(t, emptyArgs).toString();
                        if (oldValue != null) {
                            t.getClass().getDeclaredMethod(setterName, String.class).invoke(t, StringUtils.capitalize(oldValue.toLowerCase()));
                        }
                    } catch (Exception e) {

                        logger.info(e.getMessage());
                    }
                });
        return t;
    }

}
