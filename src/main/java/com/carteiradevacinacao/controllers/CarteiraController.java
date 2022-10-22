package com.carteiradevacinacao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.carteiradevacinacao.models.Animal;
import com.carteiradevacinacao.models.Carteira;
import com.carteiradevacinacao.repository.CarteiraRepo;
import com.carteiradevacinacao.service.AnimalService;
import com.carteiradevacinacao.service.CarteiraService;

@Controller
public class CarteiraController {

    @Autowired
    private CarteiraRepo carteiraRepo;

    @Autowired
    private CarteiraService carteiraService;
    
    @Autowired
    private AnimalService animalService;


    @GetMapping("/carteira")
    public String index(Model model) {
        List<Carteira> carteiras = (List<Carteira>) carteiraRepo.findAll();
        model.addAttribute("carteiras", carteiras);
        return "carteira/index";
    }

    @GetMapping("/detalhesCarteira/{id}")
    public ModelAndView getCarteiraDetalhes(@PathVariable(name = "id") Integer id) {

        Carteira carteira = carteiraService.getCarteiraById(id);
        ModelAndView mv = new ModelAndView("carteira/detalhesCarteira");
        mv.addObject("carteira", carteira);
        List <Animal> animaisNaoAssociados = animalService.getAnimais();
        animaisNaoAssociados.removeAll(carteira.getAnimais());
        mv.addObject("animais", animaisNaoAssociados);

        return mv;
    }

    @PostMapping("/associarAnimalCarteira")
    public String associarAnimalVet(@ModelAttribute Animal animal, @RequestParam Integer idcarteira) {
        
        Carteira carteira = carteiraService.getCarteiraById(idcarteira);
        animal = animalService.getAnimalById(animal.getId());

        carteira.getAnimais().add(animal);
        carteiraService.salvar(carteira);

    
        return "redirect:/detalhesCarteira/" + idcarteira;
    }

    @GetMapping("/carteira/{id}/excluir")
    public String excluir(@PathVariable int id) {
        carteiraRepo.deleteById(id);
        return "redirect:/carteira";
    }

    
}