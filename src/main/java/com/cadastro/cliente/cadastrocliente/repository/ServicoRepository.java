package com.cadastro.cliente.cadastrocliente.repository;

import com.cadastro.cliente.cadastrocliente.model.Servico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer>{
    
}
