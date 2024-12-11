package com.matera.blog.service;

import com.matera.blog.model.TipoAcesso;
import com.matera.blog.repository.TipoAcessoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAcessoService {

    @Autowired
    private TipoAcessoRepository tipoAcessoRepository;

    public List<TipoAcesso> findAll(){
        return tipoAcessoRepository.findAll();
    }
}
