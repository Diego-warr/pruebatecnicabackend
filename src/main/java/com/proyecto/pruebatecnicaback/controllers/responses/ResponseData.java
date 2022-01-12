package com.proyecto.pruebatecnicaback.controllers.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseData<E>{
    private E data;
    private String message;
    private String status;
    private String apiVersion;

    public ResponseData(String message, String status, String apiVersion) {
        this.message = message;
        this.status = status;
        this.apiVersion = apiVersion;
    }

    public ResponseData(E data, String message, String status, String apiVersion) {
        this.data = data;
        this.message = message;
        this.status = status;
        this.apiVersion = apiVersion;
    }
}
