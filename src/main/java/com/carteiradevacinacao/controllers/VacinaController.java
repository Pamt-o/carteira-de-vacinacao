package com.carteiradevacinacao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.carteiradevacinacao.models.Vacina;
import com.carteiradevacinacao.repository.VacinaRepo;

@Controller
public class VacinaController {

 
    @Autowired
    private VacinaRepo repository;
    
    @GetMapping("/vacina")
    public String index(Model model) {
        List<Vacina> vacinas = (List<Vacina>) repository.findAll();
        model.addAttribute("vacinas", vacinas);
        return "vacina/index";
    }
    
}
