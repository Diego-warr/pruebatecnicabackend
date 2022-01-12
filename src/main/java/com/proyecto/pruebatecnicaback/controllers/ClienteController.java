package com.proyecto.pruebatecnicaback.controllers;


import com.proyecto.pruebatecnicaback.controllers.responses.ConstansResponses;
import com.proyecto.pruebatecnicaback.controllers.responses.ResponseData;
import com.proyecto.pruebatecnicaback.dto.ClienteBodyDTO;
import com.proyecto.pruebatecnicaback.dto.ClienteResponseDTO;
import com.proyecto.pruebatecnicaback.dto.KPIClientes;
import com.proyecto.pruebatecnicaback.exceptions.CustomException;
import com.proyecto.pruebatecnicaback.service.ClienteService;
import com.proyecto.pruebatecnicaback.utils.UtilsMethods;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.proyecto.pruebatecnicaback.controllers.responses.ConstansResponses.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "cliente",produces = "application/hal+json")
@Api
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @PostMapping("/creacliente")
    public ResponseEntity<?> creacliente(@Valid @RequestBody(required = true) ClienteBodyDTO clienteBodyDTO, Errors errors){

        if(errors.hasErrors()){
            throwError(errors);
        }
        if(!UtilsMethods.validarFecha(clienteBodyDTO.getFechaNacimiento())){
            return ResponseEntity.ok(new ResponseData(FORMATO_FECHA_INCORRECTO, FAILED,KO,API_VERSION));
        }else {
            ClienteResponseDTO clienteResponseDTO = clienteService.create(clienteBodyDTO);
            return ResponseEntity.ok(new ResponseData(clienteResponseDTO, SUCCESS,OK,API_VERSION));
        }

    }

    @GetMapping("/kpideclientes")
    public ResponseEntity<?> kpiClientes(){

        KPIClientes kpiClientes = clienteService.kpitclientes();

        return ResponseEntity.ok(new ResponseData(kpiClientes,SUCCESS,OK,API_VERSION));
    }

    @GetMapping("/listclientes")
    public ResponseEntity<?> listClientes(){
        List<ClienteResponseDTO> lista = clienteService.listaClientes();

        return ResponseEntity.ok(new ResponseData(lista,SUCCESS,OK,API_VERSION));
    }

    public void throwError(Errors errors){

        StringBuilder mensajes = new StringBuilder();
        int index = 0;

        for (ObjectError error : errors.getAllErrors()){
            if(index>0){
                mensajes.append(" | ");
            }

            mensajes.append(String.format("Parámetro: %s - mensaje: %s", error.getObjectName(), error.getDefaultMessage()));
        }

        throw  new CustomException(mensajes.toString());
    }

}
