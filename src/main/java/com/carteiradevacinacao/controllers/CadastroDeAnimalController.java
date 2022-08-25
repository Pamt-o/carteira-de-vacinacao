package com.carteiradevacinacao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.carteiradevacinacao.models.CadastroDeAnimal;
import com.carteiradevacinacao.repository.CadastroAnimalRepo;

public class CadastroDeAnimalController {

    @Autowired
    private CadastroAnimalRepo repo;

    @GetMapping("/cadastro")
  public String index(Model model){
    List<CadastroDeAnimal> animais = (List<CadastroDeAnimal>)repo.findAll();
    model.addAttribute("animais", animais);
    return "cadastro/index";
  }
    
}
