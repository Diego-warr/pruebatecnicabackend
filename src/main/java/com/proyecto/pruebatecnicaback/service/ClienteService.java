package com.proyecto.pruebatecnicaback.service;

import com.proyecto.pruebatecnicaback.dto.ClienteBodyDTO;
import com.proyecto.pruebatecnicaback.dto.ClienteResponseDTO;
import com.proyecto.pruebatecnicaback.dto.KPIClientes;

import java.util.List;

public interface ClienteService {


    List<ClienteResponseDTO> findAll();

    List<ClienteResponseDTO> listaClientes();

    KPIClientes kpitclientes();

    ClienteResponseDTO create(ClienteBodyDTO clienteBodyDTO);

    Double promedioEdades();

    List<Integer> listaEdades();
}
