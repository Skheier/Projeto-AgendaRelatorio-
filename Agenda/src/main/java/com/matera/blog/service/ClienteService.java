package com.matera.blog.service;

import com.matera.blog.model.Cliente;
import com.matera.blog.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    //Retorna uma lista com todos posts inseridos
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    //Retorno um post a partir do ID
    public Optional<Cliente> findOne(Long id) {
        return repository.findById(id);
    }

    //Salva ou atualiza um post
    public Cliente save(Cliente cliente) {
        return repository.saveAndFlush(cliente);
    }

    //Exclui um post
    public void delete(Long id) {
        repository.deleteById(id);
    }
}