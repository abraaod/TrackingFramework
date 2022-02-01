package br.ufrn.trackingframework.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //TODO improve exceptions
    @ExceptionHandler(value = Exception.class)
    public void handleConflict(RuntimeException ex){
        throw ex;
    }
}
