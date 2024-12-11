package com.matera.blog.controller;

import com.matera.blog.model.Endereco;
import com.matera.blog.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

//Vai ter controle da página de listagem geral e de adição de agendamentos
@Controller
public class EnderecoController {

    @Autowired private EnderecoService enderecoService;     //injetou os servicos de agenda

    //Vai para tela principal do CRUD aonde são listados todos os posts
    @GetMapping("/enderecos") public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/endereco"); //nome do arquivo html
        mv.addObject("enderecos", enderecoService.findAll());

        return mv;
    }

    //Vai para tela de adição de post
    @GetMapping("/endereco/add") public ModelAndView add(Endereco endereco) {

        ModelAndView mv = new ModelAndView("/enderecoAdd");
        mv.addObject("endereco", endereco);
        return mv;
    }

    //Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("endereco/edit/{id}") public ModelAndView edit(@PathVariable("id") Long id) {

        return add(enderecoService.findOne(id).get());
    }


    //Exclui um post por seu ID e redireciona para a tela principal
    @GetMapping("endereco/delete/{id}") public ModelAndView delete(@PathVariable("id") Long id) {
        enderecoService.delete(id);
        return findAll();
    }

    @PostMapping("/endereco/save") public ModelAndView save(Endereco endereco, BindingResult result) {
        if(result.hasErrors()) {
            return add(endereco);
        }

        enderecoService.save(endereco);
        return findAll();
    }
}
