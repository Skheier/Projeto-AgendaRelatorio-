package com.matera.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matera.blog.model.Endereco;
import com.matera.blog.repository.EnderecoRepository;

@Service //Define a classe como um bean do Spring
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository; //Injeta o repositório

    //Retorna uma lista com todos posts inseridos
    public List<Endereco> findAll() { return repository.findAll(); }

    //Retorno um post a partir do ID
    public Optional<Endereco> findOne(Long id) { return repository.findById(id); }

    //Salva ou atualiza um post
    public Endereco save(Endereco endereco) {
        return repository.saveAndFlush(endereco);
    }

    //Exclui um post
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
