package com.matera.blog.controller;

import com.matera.blog.repository.ServicoRepository;
import com.matera.blog.service.ServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.matera.blog.model.Servico;

import java.util.List;

@Controller
public class ServicoController {

    @Autowired
    private ServicoService service; //	Injeta a classe de serviços

    @GetMapping("/servicos")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("/servico"); //nome do arquivo html
        mv.addObject("servicos", service.findAll());
        return mv;
    }

    @GetMapping("/servico/add")
    public ModelAndView add(Servico servico) {
        ModelAndView mv = new ModelAndView("/servicoAdd");
        mv.addObject("servico", servico);
        return mv;
    }

    @GetMapping("/servico/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(service.findOne(id).get());
    }

    @GetMapping("/servico/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        service.delete(id);
        return findAll();
    }

    @PostMapping("/servico/save")
    public ModelAndView save(Servico servico, BindingResult result) {

        if(result.hasErrors()) {
            return add(servico);
        }
        service.save(servico);
        return findAll();
    }

}