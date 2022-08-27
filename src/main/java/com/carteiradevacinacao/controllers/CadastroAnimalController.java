package com.carteiradevacinacao.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.carteiradevacinacao.models.Animal;
import com.carteiradevacinacao.repository.CadastroAnimalRepo;

@Controller
public class CadastroAnimalController {

  @Autowired
  private CadastroAnimalRepo repo;

  @GetMapping("/cadastro")
  public String index(Model model) {
    List<Animal>animais = (List<Animal>) repo.findAll();
    model.addAttribute("animais", animais);
    return "cadastro/index";
  }

  @GetMapping("/cadastro/novo")
  public String novo() {
    return "cadastro/novo";
  }

  @PostMapping("/cadastro/criar")
  public String criar(Animal animal) {
    repo.save(animal);
    return "redirect:/cadastro";
  }


  @GetMapping("/cadastro/{id}")
  public String busca(@PathVariable int id, Model model) {
    Optional<Animal> cadastro = repo.findById(id);
    try{
      model.addAttribute("animal", cadastro.get());
    }
    catch(Exception err){ return "redirect:/cadastro";}
    
    return "/cadastro/editar";
  }

  @PostMapping("/cadastro/{id}/atualizar")
  public String atualizar(@PathVariable int id, Animal animal) {
    if(!repo.existsById(id)){ 
    return "redirect:/cadastro";
  }
    repo.save(animal);
    return "redirect:/cadastro";
  }



  @GetMapping("/cadastro/{id}/excluir")
  public String excluir(@PathVariable int id) {
    repo.deleteById(id);
    return "redirect:/cadastro";
  }

}
