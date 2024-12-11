package com.matera.blog.service;

import com.matera.blog.model.Funcionario;
import com.matera.blog.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    //Retorna uma lista com todos posts inseridos
    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    //Retorno um post a partir do ID
    public Optional<Funcionario> findOne(Long id) {
        return repository.findById(id);
    }

    //Salva ou atualiza um post
    public Funcionario save(Funcionario funcionario) {
        return repository.saveAndFlush(funcionario);
    }

    //Exclui um post
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
