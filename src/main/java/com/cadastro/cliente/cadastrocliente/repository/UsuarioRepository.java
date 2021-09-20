package com.cadastro.cliente.cadastrocliente.repository;

import com.cadastro.cliente.cadastrocliente.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
