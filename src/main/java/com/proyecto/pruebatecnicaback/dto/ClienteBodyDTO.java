package com.proyecto.pruebatecnicaback.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteBodyDTO {

    @NotEmpty(message = "El campo nombre no debe estar vacio")
    private String nombre;

    @NotEmpty(message = "El campo apellido no debe estar vacio")
    private String apellido;

    @NotEmpty(message = "El campo fecha no debe estar vacio")
    private String fechaNacimiento;
}
