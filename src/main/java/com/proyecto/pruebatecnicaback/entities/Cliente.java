package com.proyecto.pruebatecnicaback.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @NotBlank(message = "El campo nombre no debe estar vacio")
    private String nombre;

    @Column(name = "apellido", columnDefinition = "varchar(60)")
    private String apellido;


    @Column(name = "fecha_nacimiento", columnDefinition = "DATE")
    private Date fechaNacimiento;

    @Column(name = "edad", columnDefinition = "Integer")
    private Integer edad;

    @Column(name = "fecha_probable_de_muerte", columnDefinition = "Date")
    private Date fechaProblableDeMuerte;
}
