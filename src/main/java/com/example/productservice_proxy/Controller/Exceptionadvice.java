package com.example.productservice_proxy.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class Exceptionadvice {
    @ExceptionHandler({NullPointerException.class,IllegalArgumentException.class})
    public ResponseEntity<String> Exceptionhandle(Exception e){
        return new ResponseEntity<>("kuch to phata hai", HttpStatus.BAD_REQUEST);
    }

}
