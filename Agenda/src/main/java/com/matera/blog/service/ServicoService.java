package com.matera.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matera.blog.model.Servico;
import com.matera.blog.repository.ServicoRepository;

@Service //Define a classe como um bean do Spring
public class ServicoService {

    @Autowired
    private ServicoRepository repository; //Injeta o repositório
    //Retorna uma lista com todos posts inseridos
    public List<Servico> findAll() {
        return repository.findAll();
    }

    //Retorno um post a partir do ID
    public Optional<Servico> findOne(Long id) {
        return repository.findById(id);
    }

    //Salva ou atualiza um post
    public Servico save(Servico servico) {
        return repository.saveAndFlush(servico);
    }

    //Exclui um post
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
