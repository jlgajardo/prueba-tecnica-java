package cl.jlgajardo.pruebatecnica.exception;

import cl.jlgajardo.pruebatecnica.model.Status;
import cl.jlgajardo.pruebatecnica.model.PruebaTecnicaResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class APIExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String FORMATO_FECHA_INCORRECTO = "Formato fecha incorrecto";
    public static final String FORMATO_INCORRECTO_EN = "Formato incorrecto en: ";
    public static final String FORMATO_INCORRECTO = "Formato Incorrecto";
    public static final String VIOLATION_OF_PRIMARY_KEY = "Violation of PRIMARY KEY";

    @ExceptionHandler(APIException.class)
    public final ResponseEntity<PruebaTecnicaResponse> handleEAFException(APIException ex) {
        setLog(ex.getMessage(), ex.getStackTrace());
        final HttpStatus status = ex.getStatus();
        final String code = String.valueOf(status.value());
        final String message = setMessageException(ex.getMessage());

        final PruebaTecnicaResponse body = new PruebaTecnicaResponse()
                .setStatus(new Status(code, message))
                .setData(message);
        return ResponseEntity.status(status).body(body);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<PruebaTecnicaResponse> handleParserException(Exception ex, WebRequest request) {


        setLog(ex.getMessage(), ex.getStackTrace());
        HttpStatus status = HttpStatus.PRECONDITION_FAILED;
        final PruebaTecnicaResponse pruebaTecnicaREsponse = new PruebaTecnicaResponse();
        pruebaTecnicaREsponse.setToken("");


        pruebaTecnicaREsponse.setStatus(new Status(status.toString(), getMessage(ex.getMessage())));
        pruebaTecnicaREsponse.setData(getMessage(ex.getMessage()));
        return ResponseEntity.status(status).body(pruebaTecnicaREsponse);
    }


    @ExceptionHandler({Exception.class})
    public final ResponseEntity<PruebaTecnicaResponse> handleException(Exception ex, WebRequest request) {


        setLog(ex.getMessage(), ex.getStackTrace());

        HttpStatus status = HttpStatus.BAD_REQUEST;
        final PruebaTecnicaResponse pruebaTecnicaREsponse = new PruebaTecnicaResponse();
        pruebaTecnicaREsponse.setToken("");
        pruebaTecnicaREsponse.setStatus(new Status(status.toString(), ex.getMessage()));
        return ResponseEntity.status(status).body(pruebaTecnicaREsponse);
    }


    @ExceptionHandler({APIExceptionEmptyOrNullParam.class})
    public final ResponseEntity<PruebaTecnicaResponse> emptyOrNullParam(Exception ex, WebRequest request) {


        setLog(ex.getMessage(), ex.getStackTrace());

        HttpStatus status = HttpStatus.PRECONDITION_FAILED;
        final PruebaTecnicaResponse pruebaTecnicaREsponse = new PruebaTecnicaResponse();
        pruebaTecnicaREsponse.setToken("");
        pruebaTecnicaREsponse.setStatus(new Status(status.toString(), ex.getMessage()));
        pruebaTecnicaREsponse.setData(ex.getMessage());
        return ResponseEntity.status(status).body(pruebaTecnicaREsponse);
    }


    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public final ResponseEntity<PruebaTecnicaResponse> handleMismatchException(Exception ex, WebRequest request) {


        setLog(ex.getMessage(), ex.getStackTrace());
        HttpStatus status = HttpStatus.PRECONDITION_FAILED;
        final PruebaTecnicaResponse pruebaTecnicaREsponse = new PruebaTecnicaResponse();


        pruebaTecnicaREsponse.setToken("");
        pruebaTecnicaREsponse.setStatus(new Status(status.toString(), FORMATO_INCORRECTO));
        pruebaTecnicaREsponse.setData(getMessage(ex.getMessage()));
        return ResponseEntity.status(status).body(pruebaTecnicaREsponse);
    }


    @ExceptionHandler({APIExceptionBadRequest.class})
    public final ResponseEntity<PruebaTecnicaResponse> badRequest(Exception ex, WebRequest request) {

        final PruebaTecnicaResponse pruebaTecnicaREsponse = new PruebaTecnicaResponse();


        pruebaTecnicaREsponse.setToken("");
        pruebaTecnicaREsponse.setStatus(new Status(String.valueOf(HttpStatus.BAD_REQUEST.value()), ex.getMessage()));
        pruebaTecnicaREsponse.setData(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(pruebaTecnicaREsponse);
    }




    @ExceptionHandler({APIExceptionNotFound.class})
    public final ResponseEntity<PruebaTecnicaResponse> noContent(Exception ex, WebRequest request) {

        final PruebaTecnicaResponse pruebaTecnicaREsponse = new PruebaTecnicaResponse();


        pruebaTecnicaREsponse.setToken("");
        pruebaTecnicaREsponse.setStatus(new Status(String.valueOf(HttpStatus.NOT_FOUND.value()), ex.getMessage()));
        pruebaTecnicaREsponse.setData(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(pruebaTecnicaREsponse);
    }







    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<PruebaTecnicaResponse> handleDateException(Exception ex, WebRequest request) {


        setLog(ex.getMessage(), ex.getStackTrace());
        HttpStatus status = HttpStatus.PRECONDITION_FAILED;
        final PruebaTecnicaResponse pruebaTecnicaREsponse = new PruebaTecnicaResponse();

        pruebaTecnicaREsponse.setToken("");
        pruebaTecnicaREsponse.setStatus(new Status(status.toString(), FORMATO_FECHA_INCORRECTO));
        pruebaTecnicaREsponse.setData(FORMATO_FECHA_INCORRECTO);
        return ResponseEntity.status(status).body(pruebaTecnicaREsponse);
    }


    private String getMessage(String message) {
        String[] parts = message.split("\\.");
        String[] variable = parts[parts.length - 1].split("\"");
        return FORMATO_INCORRECTO_EN + variable[1];
    }

    private void setLog(String message, StackTraceElement[] trace) {
        logger.error(message, "  ", trace);
    }


    private String setMessageException(String message) {


        if (message.contains(VIOLATION_OF_PRIMARY_KEY)) {
            return "El registro ingresado ya se encuentra en la Base de Datos";
        }

        return message;


    }

}
