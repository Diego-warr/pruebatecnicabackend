package com.proyecto.pruebatecnicaback.service.impl;


import com.proyecto.pruebatecnicaback.dto.ClienteBodyDTO;
import com.proyecto.pruebatecnicaback.dto.ClienteResponseDTO;
import com.proyecto.pruebatecnicaback.dto.KPIClientes;
import com.proyecto.pruebatecnicaback.entities.Cliente;
import com.proyecto.pruebatecnicaback.repository.ClienteRepository;
import com.proyecto.pruebatecnicaback.service.ClienteService;
import com.proyecto.pruebatecnicaback.utils.UtilsMethods;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ClienteResponseDTO> findAll() {

        return null;
    }

    @Override
    public List<ClienteResponseDTO> listaClientes() {

        List<ClienteResponseDTO> listaResponseDTOS = this.clienteRepository
                .findAll()
                .stream()
                .map(c->modelMapper.map(c,ClienteResponseDTO.class)).collect(Collectors.toList());

        return listaResponseDTOS;
    }

    @Override
    public KPIClientes kpitclientes() {

        Double promedio = this.promedioEdades();
        Double ds = UtilsMethods.desviacionstandar(this.listaEdades());

        return new KPIClientes(promedio,ds);
    }

    @Override
    public ClienteResponseDTO create(ClienteBodyDTO clienteBodyDTO) {

        Cliente cliente = modelMapper.map(clienteBodyDTO, Cliente.class);
        cliente.setCreatedAt(new Date());
        cliente.setStatus("A");
        Date fecha = null;
        try {
            fecha = UtilsMethods.dateFromString(clienteBodyDTO.getFechaNacimiento());
            cliente.setEdad(UtilsMethods.getEdad(fecha));
            cliente.setFechaProblableDeMuerte(UtilsMethods.setFechaProbableDeMuerte(fecha));

            Cliente clienteNuevo = clienteRepository.save(cliente);

            ClienteResponseDTO clienteResponseDTO = modelMapper.map(clienteNuevo,ClienteResponseDTO.class);
            return clienteResponseDTO;
        } catch (ParseException e) {
            e.printStackTrace();
            return  null;
        }

    }

    @Override
    public Double promedioEdades() {

        return clienteRepository.promedioEdades();
    }

    @Override
    public List<Integer> listaEdades() {

        return clienteRepository.listaEdades();
    }




}
