package com.matera.blog.controller;

import com.matera.blog.model.Funcionario;
import com.matera.blog.service.FuncionarioService;
import com.matera.blog.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuncionarioController {

    @Autowired private FuncionarioService funcionarioService;     //injetou os servicos de funcionarios
    @Autowired private EnderecoService enderecoService;   //injetou os servicos de endereco

    //Vai para tela principal do CRUD aonde são listados todos os posts
    @GetMapping("/funcionarios") public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/funcionario"); //nome do arquivo html
        mv.addObject("funcionarios", funcionarioService.findAll());
        mv.addObject("enderecos", enderecoService.findAll());

        return mv;
    }

    //Vai para tela de adição de post
    @GetMapping("/funcionario/add") public ModelAndView add(Funcionario funcionario) {

        ModelAndView mv = new ModelAndView("/funcionarioAdd");
        mv.addObject("funcionario", funcionario);
        mv.addObject("enderecos", enderecoService.findAll());

        return mv;
    }

    //Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("funcionario/edit/{id}") public ModelAndView edit(@PathVariable("id") Long id) {

        return add(funcionarioService.findOne(id).get());
    }


    //Exclui um post por seu ID e redireciona para a tela principal
    @GetMapping("funcionario/delete/{id}") public ModelAndView delete(@PathVariable("id") Long id) {
        funcionarioService.delete(id);
        return findAll();
    }

    @PostMapping("/funcionario/save") public ModelAndView save(Funcionario funcionario, BindingResult result) {
        if(result.hasErrors()) {
            return add(funcionario);
        }

        funcionarioService.save(funcionario);
        return findAll();
    }
}