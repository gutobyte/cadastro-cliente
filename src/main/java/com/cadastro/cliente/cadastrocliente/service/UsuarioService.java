package com.cadastro.cliente.cadastrocliente.service;


import com.cadastro.cliente.cadastrocliente.controller.exception.UsuarioCadastradoException;
import com.cadastro.cliente.cadastrocliente.model.Usuario;
import com.cadastro.cliente.cadastrocliente.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){

        boolean exist = usuarioRepository.existsByUsername(usuario.getUsername());
        if(exist){
            throw new UsuarioCadastradoException(usuario.getUsername());
        }
        return usuarioRepository.save(usuario);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        Usuario usuario = usuarioRepository
                                    .findByUsername(username)
                                    .orElseThrow( () -> new UsernameNotFoundException("Login não encontrado"));
        
        return User
                  .builder()
                  .username(usuario.getUsername())
                  .password(usuario.getPassword())
                  .roles("USER")
                  .build();
    }
    
}
