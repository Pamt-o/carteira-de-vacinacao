package com.carteiradevacinacao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    
    @GetMapping("/vacina/novo")
    public String novo() {
        return "vacina/novo";
    }

    //Salvando a criação do cadastro no banco
    @PostMapping("/vacina/criar")
    public String criar(Vacina vacina) {
        repository.save(vacina);
        
        return "redirect:/vacina";
    }


    // @PostMapping("/detalhesCarteira/{id}")
    // public String getDetalhes(@PathVariable(name = "id") Integer id, Vacina vacina) {
    //     Carteira carteira = carteiraService.getCarteiraById(id);
    //     vacina.setCarteira(carteira);
    //     repository.save(vacina);
        
    //     return "redirect:/detalhesCarteira/{id}";
    // }
    
    

}
