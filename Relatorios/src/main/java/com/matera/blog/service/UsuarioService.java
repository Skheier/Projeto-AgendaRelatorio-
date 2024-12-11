package com.matera.blog.service;

import com.matera.blog.model.Usuario;
import com.matera.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service public class UsuarioService {

    @Autowired private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() { return usuarioRepository.findAll(); }

    public Usuario findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }


    ///////////////////////
    Long idUsuarioUsado;

    public void setUsuarioUsado(Long id){ idUsuarioUsado = id; }

    public Usuario getUsuarioUsado(Long idUsuarioUsado){
        Optional<Usuario> usuarioUsado = usuarioRepository.findById(idUsuarioUsado);
        return usuarioUsado.orElse(null);
    }


}