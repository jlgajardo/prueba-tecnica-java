package cl.jlgajardo.pruebatecnica.exception;

import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

public class APIException extends RuntimeException {

    private final HttpStatus status;


    public APIException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public static Supplier<APIException> createAPIException(String message, HttpStatus status) {
        return () -> new APIException(message, status);
    }

    public static void throwPreconditionFailException(String message) {
        throw createAPIException(message, HttpStatus.PRECONDITION_FAILED).get();
    }

    public static Supplier<APIException> throwBadRequestFailException(String message) {
        return createAPIException(message, HttpStatus.PRECONDITION_FAILED);
    }

    public HttpStatus getStatus() {
        return status;
    }

}
