package com.matera.blog.service;

import com.matera.blog.model.Agenda;
import com.matera.blog.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    //Retorna uma lista com todos posts inseridos
    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    //Retorno um post a partir do ID
    public Optional<Agenda> findOne(Long id) {
        return agendaRepository.findById(id);
    }

    //Salva ou atualiza um post
    public Agenda save(Agenda agenda) {
        return agendaRepository.saveAndFlush(agenda);
    }

    //Exclui um post
    public void delete(Long id) {
        agendaRepository.deleteById(id);
    }
}
