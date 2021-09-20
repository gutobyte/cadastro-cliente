package com.cadastro.cliente.cadastrocliente.controller;

import javax.validation.Valid;

import com.cadastro.cliente.cadastrocliente.model.Usuario;
import com.cadastro.cliente.cadastrocliente.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    //annotation lombok 
    // @Autowired
    // public UsuarioController(UsuarioRepository usuarioRepository){
    //     this.usuarioRepository = usuarioRepository;
    // }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar( @RequestBody @Valid Usuario usuario ){
        usuarioRepository.save(usuario);
    }
    
}
