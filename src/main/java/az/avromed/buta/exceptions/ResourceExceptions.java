package az.avromed.buta.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceExceptions extends Exception {
    private static final long serialVersionUID = 1L;

    public ResourceExceptions(String message) {
        super(message);
    }
}
