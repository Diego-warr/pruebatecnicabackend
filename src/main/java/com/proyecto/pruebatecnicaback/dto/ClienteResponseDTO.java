package com.proyecto.pruebatecnicaback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO {

    private Integer idCliente;

    private String nombre;

    private String apellido;

    private Date fechaNacimiento;

    private Integer edad;

    private Date fechaProblableDeMuerte;;

    private String status;
}
