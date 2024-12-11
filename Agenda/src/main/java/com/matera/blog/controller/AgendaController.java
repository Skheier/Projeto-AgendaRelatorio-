package com.matera.blog.controller;

import com.matera.blog.model.Agenda;
import com.matera.blog.service.AgendaService;
import com.matera.blog.service.ClienteService;
import com.matera.blog.service.FuncionarioService;
import com.matera.blog.service.ServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

//Vai ter controle da página de listagem geral e de adição de agendamentos
@Controller
public class AgendaController {

    @Autowired private AgendaService agendaService;     //injetou os servicos de agenda
    @Autowired private ServicoService servicoService;   //injetou os servicos de servico
    @Autowired private FuncionarioService funcionarioService;
    @Autowired private ClienteService clienteService;   //injetou os servicos de servico//injetou os servicos de servico
    //@Autowired private UsuarioService usuarioService;    //injetou os servicos de usuario

    //Vai para tela principal do CRUD aonde são listados todos os posts
    @GetMapping("/agendamentos") public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("/agenda"); //nome do arquivo html
        mv.addObject("agendamentos", agendaService.findAll());
        mv.addObject("servicos", servicoService.findAll());
        mv.addObject("funcionarios", funcionarioService.findAll());
        mv.addObject("clientes", clienteService.findAll());

        return mv;
    }

    //Vai para tela de adição de post
    @GetMapping("/agendamento/add") public ModelAndView add(Agenda agendamento) {

        ModelAndView mv = new ModelAndView("/agendamentoAdd");
        mv.addObject("agendamento", agendamento);
        mv.addObject("servicos", servicoService.findAll());
        mv.addObject("funcionarios", funcionarioService.findAll());
        mv.addObject("clientes", clienteService.findAll());

        //IMPORTANTICICICICICISIMO//já pega o objeto de usuario "setado" com setUsuarioUsado na pagina de login. Assim podendo referencialo no html como "usuarioAtuante"
        //mv.addObject("usuarioAtuante", UsuarioService.getUsuarioUsado) //get & setUsuarioUsado será declarado na classe userService

        return mv;
    }

    //Vai para tela de edição de posts (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
    @GetMapping("agendamento/edit/{id}") public ModelAndView edit(@PathVariable("id") Long id) {

        return add(agendaService.findOne(id).get());
    }


    //Exclui um post por seu ID e redireciona para a tela principal
    @GetMapping("agendamento/delete/{id}") public ModelAndView delete(@PathVariable("id") Long id) {
        agendaService.delete(id);
        return findAll();
    }

    @PostMapping("/agendamento/save") public ModelAndView save(Agenda agendamento, BindingResult result) {
        if(result.hasErrors()) {
            return add(agendamento);
        }

        agendaService.save(agendamento);
        return findAll();
    }
}
