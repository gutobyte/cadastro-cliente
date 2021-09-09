package com.cadastro.cliente.cadastrocliente.repository;

import com.cadastro.cliente.cadastrocliente.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}
