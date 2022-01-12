package com.proyecto.pruebatecnicaback.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerHandler {

    @ExceptionHandler(CustomException.class)
    public ErrorMensaje errorMensaje(CustomException customException){

        return new ErrorMensaje("Exception: ", customException.getMessage());
    }
}
