package com.java.robin.config;

import ch.qos.logback.core.net.SocketConnector;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class,NullPointerException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleException( RuntimeException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

}
