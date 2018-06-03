package pkg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ControllerException extends RuntimeException {

    public ControllerException(String s) {
        super(s);
    }

}
