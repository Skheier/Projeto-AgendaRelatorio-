package com.matera.blog.controller;

import com.matera.blog.model.Cliente;
import com.matera.blog.service.ClienteService;
import com.matera.blog.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

    @Autowired private ClienteService clienteService;     //injetou os servicos de cliente
    @Autowired private EnderecoService enderecoService;   //injetou os servicos de endereco

    //Vai para tela principal do CRUD aonde são listados todos os posts
    @GetMapping("/clientes") public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/cliente"); //nome do arquivo html
        mv.addObject("clientes", clienteService.findAll());
        mv.addObject("enderecos", enderecoService.findAll());

        return mv;
    }

    //Vai para tela de adição de post
    @GetMapping("/cliente/add") public ModelAndView add(Cliente cliente) {

        ModelAndView mv = new ModelAndView("/clienteAdd");
        mv.addObject("cliente", cliente);
        mv.addObject("enderecos", enderecoService.findAll());

        return mv;
    }

    //Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("cliente/edit/{id}") public ModelAndView edit(@PathVariable("id") Long id) {

        return add(clienteService.findOne(id).get());
    }


    //Exclui um post por seu ID e redireciona para a tela principal
    @GetMapping("cliente/delete/{id}") public ModelAndView delete(@PathVariable("id") Long id) {
        clienteService.delete(id);
        return findAll();
    }

    @PostMapping("/cliente/save") public ModelAndView save(Cliente cliente, BindingResult result) {
        if(result.hasErrors()) {
            return add(cliente);
        }

        clienteService.save(cliente);
        return findAll();
    }
}