package com.proyecto.pruebatecnicaback.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
