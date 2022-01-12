package com.proyecto.pruebatecnicaback.exceptions;

public class CustomException extends RuntimeException{

    public CustomException(String mensaje){
        super(mensaje);
    }
}
