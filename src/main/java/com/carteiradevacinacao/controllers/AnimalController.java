package com.carteiradevacinacao.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.carteiradevacinacao.models.Animal;
import com.carteiradevacinacao.models.Carteira;
import com.carteiradevacinacao.repository.AnimalRepo;
import com.carteiradevacinacao.repository.CarteiraRepo;
import com.carteiradevacinacao.service.AnimalService;




@Controller
public class AnimalController {


    @Autowired
    private AnimalRepo repository;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private CarteiraRepo carteiraRepo;




    // Lista dos cadastros
    @GetMapping("/animal")
    public String index(Model model) {
        List<Animal> animais = (List<Animal>) repository.findAll();
        model.addAttribute("animais", animais);
        return "animal/index";
    }

    // Novo cadastro
    @GetMapping("/animal/novo")
    public String novo() {
        return "animal/novo";
    }

    // Salvando a criação do cadastro no banco
    @PostMapping("/animal/criar")
    public String criar(Animal animal) {
        repository.save(animal);
        return "redirect:/animal";
    }

    @GetMapping("/animal/{id}")
    public String busca(@PathVariable int id, Model model) {
        Optional<Animal> animal = repository.findById(id);
        try {
            model.addAttribute("animal", animal.get());
        } catch (Exception err) {
            return "redirect:/animal";
        }

        return "/animal/editar";
    }

    @PostMapping("/animal/{id}/atualizar")
    public String atualizar(@PathVariable int id, Animal animal) {
        if (!repository.existsById((int) id)) {
            return "redirect:/animal";
        }
        repository.save(animal);
        return "redirect:/animal";
    }

    @GetMapping("/detalhesAnimal/{id}")
    public ModelAndView getAnimalDetalhes(@PathVariable(name = "id") Integer id) {

        Animal animal = animalService.getAnimalById(id);
        ModelAndView mv = new ModelAndView("animal/detalhesAnimal");
        mv.addObject("animal", animal);

        return mv;  
    }


    // GET pode ser usado quando se trata de html e fosse uma api usar o delete
    @GetMapping("/animal/{id}/excluir")
    public String excluir(@PathVariable int id) {
        repository.deleteById(id);
        return "redirect:/animal";
    }


    @GetMapping("/carteira/novo")
    public String novoCarteira() {
        return "carteira/novo";
    }

    @PostMapping("/carteira/criar")
    public String criar(Carteira carteira) {
        carteiraRepo.save(carteira);
        return "redirect:/carteira";

    }
}
