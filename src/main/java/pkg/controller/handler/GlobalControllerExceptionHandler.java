package pkg.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pkg.dto.ErrorDto;
import pkg.exception.ControllerException;
import pkg.exception.CustomException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final String GLOBAL_CONTROLLER_EXCEPTION_HANDLER = "GlobalControllerExceptionHandler:";

    @ExceptionHandler(ControllerException.class)
    public ResponseEntity handleCommonException(ControllerException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(
                GLOBAL_CONTROLLER_EXCEPTION_HANDLER + " ControllerException"));
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity handleCustomException(CustomException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(
                GLOBAL_CONTROLLER_EXCEPTION_HANDLER + " CustomException"));
    }

}
