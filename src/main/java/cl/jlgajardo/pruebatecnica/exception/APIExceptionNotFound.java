package cl.jlgajardo.pruebatecnica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class APIExceptionNotFound extends RuntimeException {

    public APIExceptionNotFound(String message) {
        super(message);
    }
}
