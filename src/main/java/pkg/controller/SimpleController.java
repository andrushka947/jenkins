package pkg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pkg.dto.ErrorDto;
import pkg.exception.ControllerException;
import pkg.exception.CustomException;

@RestController
@RequestMapping("/")
public class SimpleController {

    @ExceptionHandler(ControllerException.class)
    public ResponseEntity handleCommonException(ControllerException ex) {
        ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto("local handler"));
    }

    @RequestMapping("/index")
    public ResponseEntity index(@RequestHeader("header") String header) {
        if ("400".equals(header)) {
            throw new ControllerException("Controller exc");
        } else if ("4000".equals(header)) {
            throw new CustomException("Custom exc");
        }
        return ResponseEntity.ok().body("ok");
    }

}
