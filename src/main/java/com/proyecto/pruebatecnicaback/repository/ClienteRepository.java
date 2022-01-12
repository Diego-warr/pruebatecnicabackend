package com.proyecto.pruebatecnicaback.repository;

import com.proyecto.pruebatecnicaback.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {


    @Query("select avg(edad) from Cliente")
    Double promedioEdades();


    @Query("select edad from Cliente")
    List<Integer> listaEdades();

}
