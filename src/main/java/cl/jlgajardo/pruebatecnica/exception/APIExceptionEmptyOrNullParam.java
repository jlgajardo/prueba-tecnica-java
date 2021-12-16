package cl.jlgajardo.pruebatecnica.exception;

public class APIExceptionEmptyOrNullParam extends RuntimeException {

    public APIExceptionEmptyOrNullParam(String message) {
        super(message);
    }
}
