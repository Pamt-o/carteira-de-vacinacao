package com.carteiradevacinacao.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.carteiradevacinacao.models.Animal;
import com.carteiradevacinacao.models.Carteira;
import com.carteiradevacinacao.models.Vacina;
import com.carteiradevacinacao.repository.CarteiraRepo;
import com.carteiradevacinacao.repository.VacinaRepo;
import com.carteiradevacinacao.service.AnimalService;
import com.carteiradevacinacao.service.CarteiraService;



@Controller
public class CarteiraController {

    @Autowired
    private CarteiraRepo carteiraRepo;

    @Autowired
    private CarteiraService carteiraService;

    @Autowired
    private VacinaRepo vacinaRepo;

    @Autowired
    private AnimalService animalService;


    @GetMapping("/carteira")
    public String index(Model model) {
        List<Carteira> carteiras = (List<Carteira>) carteiraRepo.findAll();
        model.addAttribute("carteiras", carteiras);
        return "carteira/index";
    }

    @GetMapping("/detalhesCarteira/{idCarteira}")
    public ModelAndView getAnimalDetalhes(@PathVariable(name = "idCarteira") Integer idCarteira) {

        Carteira carteira = carteiraService.getCarteiraById(idCarteira);
        ModelAndView mv = new ModelAndView("carteira/detalhesCarteira");
        mv.addObject("carteira", carteira);
        List <Animal> animaisNaoAssociados = animalService.getAnimais();
        animaisNaoAssociados.removeAll(carteira.getAnimais());
        mv.addObject("animais", animaisNaoAssociados);

        Iterable<Vacina> vacinas = vacinaRepo.findByCarteira(carteira);
        mv.addObject("vacinas", vacinas);

        return mv;  
    }

    //Associar Animal com a Carteira
    @PostMapping("/associarAnimalCarteira")
    public String associarAnimalCarteira(@ModelAttribute Animal animal, @RequestParam Integer idCarteira) {
        
        Carteira carteira = carteiraService.getCarteiraById(idCarteira);
        animal = animalService.getAnimalById(animal.getId());

        carteira.getAnimais().add(animal);
        carteiraService.salvar(carteira);
    
        return "redirect:/detalhesCarteira/" + idCarteira;
    }

    @PostMapping("/detalhesCarteira/{idCarteira}")
    public String detalhesCarteira(@PathVariable(name = "idCarteira") Integer idCarteira, Vacina vacina) {
        Carteira carteira = carteiraService.getCarteiraById(idCarteira);
        vacina.setCarteira(carteira);
        vacinaRepo.save(vacina);
        
        return "redirect:/detalhesCarteira/{idCarteira}";
    }
}