package com.cadastro.cliente.cadastrocliente.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import com.cadastro.cliente.cadastrocliente.controller.dto.ServicoPrestadoDTO;
import com.cadastro.cliente.cadastrocliente.model.Cliente;
import com.cadastro.cliente.cadastrocliente.model.ServicoPrestado;
import com.cadastro.cliente.cadastrocliente.repository.ClienteRepository;
import com.cadastro.cliente.cadastrocliente.repository.ServicoPrestadoRepository;
import com.cadastro.cliente.cadastrocliente.util.BigDecimalConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/servico-prestado")
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository servicoPrestadoRepository;
    private final BigDecimalConverter bigDecimalConverter;

    @Autowired
    ServicoPrestadoController(ClienteRepository clienteRepository, ServicoPrestadoRepository servicoPrestadoRepository, BigDecimalConverter bigDecimalConverter){
        this.clienteRepository = clienteRepository;
        this.servicoPrestadoRepository = servicoPrestadoRepository;
        this.bigDecimalConverter = bigDecimalConverter;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO dto){

        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        ServicoPrestado servicoPrestado = new ServicoPrestado();
        Integer idCliente = dto.getIdCliente();

        Cliente cliente = clienteRepository
                                .findById(idCliente)
                                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));
        
        
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));
        
        return servicoPrestadoRepository.save(servicoPrestado);

    }

    @GetMapping
    public List<ServicoPrestado> pesquisar(
        @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
        @RequestParam(value = "mes", required = false) Integer mes){

            //where cliente.nome like %fula% <- uso do percent
            return servicoPrestadoRepository.findByNomeClienteAndMes("%" + nome +"%", mes);
        }
    
}
