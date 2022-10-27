package dev.bigstack.springboot.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dev.bigstack.springboot.object.ResponseObject;
import dev.bigstack.springboot.object.GlobalExceptionObject;

import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GlobalExceptionObject.class)
    protected ResponseEntity<?> handleGlobalException(GlobalExceptionObject simpleExceptionObj, Locale locale) {
        return ResponseEntity.badRequest()
                .body(ResponseObject.builder().code(simpleExceptionObj.getCode())
                        .message(simpleExceptionObj.getMessage()).build());
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<?> handleException(Exception e, Locale locale) {
        return ResponseEntity.badRequest().body("Exception occur inside API " + e);
    }

}
