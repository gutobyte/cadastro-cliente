package com.cadastro.cliente.cadastrocliente.repository;

import java.util.Optional;

import com.cadastro.cliente.cadastrocliente.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Optional<Usuario> findByUsername(String username);

    //select count (*) > 0 from usuario where username = :login
    boolean existsByUsername(String username);
    
}
