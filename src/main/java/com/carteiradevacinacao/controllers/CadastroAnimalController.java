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

    //Lista dos cadastros de animais realizados
    @GetMapping("/animal")
    public String index(Model model) {
        List<Animal> animais = (List<Animal>) repo.findAll();
        model.addAttribute("animais", animais);
        return "animal/index";
    }

    //Novo cadastro
    @GetMapping("/animal/novo")
    public String novo() {
        return "animal/novo";
    }

    //Salvando a criação do cadastro no banco
    @PostMapping("/animal/criar")
    public String criar(Animal animal) {
        repo.save(animal);
        return "redirect:/animal";
    }


    @GetMapping("/animal/{id}")
    public String busca(@PathVariable long id, Model model) {
        Optional<Animal> animal = repo.findById(id);
        try {
            model.addAttribute("animal", animal.get());
        } catch (Exception err) {
            return "redirect:/animal";
        }

        return "/animal/editar";
    }

    @PostMapping("/animal/{id}/atualizar")
    public String atualizar(@PathVariable long id, Animal animal) {
        if (!repo.existsById((long) id)) {
            return "redirect:/animal";
        }
        repo.save(animal);
        return "redirect:/animal";
    }

    //GET pode ser usado quando se trata de html e fosse uma api usar o delete
    @GetMapping("/animal/{id}/excluir")
    public String excluir(@PathVariable long id) {
        repo.deleteById(id);
        return "redirect:/animal";
    }


}
