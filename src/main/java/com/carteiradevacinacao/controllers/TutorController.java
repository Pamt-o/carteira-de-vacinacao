package com.carteiradevacinacao.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carteiradevacinacao.models.Animal;
import com.carteiradevacinacao.models.Tutor;
import com.carteiradevacinacao.repository.TutorRepo;
import com.carteiradevacinacao.service.AnimalService;
import com.carteiradevacinacao.service.TutorService;


@Controller
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @Autowired
    private TutorRepo repository;

    @Autowired
    private AnimalService animalService;
    


    // Lista dos cadastros
    @GetMapping("/tutor")
    public String index(Model model) {
        List<Tutor> tutores = (List<Tutor>) repository.findAll();
        model.addAttribute("tutores", tutores);
        return "tutor/index";
    }

    // Novo cadastro
    @GetMapping("/tutor/novo")
    public String novo() {
        
 
        return "tutor/novo";
    }

    // Salvando a criação do cadastro no banco
    @PostMapping("/tutor/criar")
    public String criar(Tutor tutor) {
        repository.save(tutor);
        return "redirect:/tutor";
    }

    
    @GetMapping("/tutor/{codigo}")
    public String busca(@PathVariable int codigo, Model model) {
        Optional<Tutor> tutor = repository.findById(codigo);
        try {
            model.addAttribute("tutor", tutor.get());
        } catch (Exception err) {
            return "redirect:/tutor";
        }

        return "/tutor/editar";
    }

    @PostMapping("/tutor/{codigo}/atualizar")
    public String atualizar(@PathVariable int codigo, Tutor tutor) {
        if (!repository.existsById((int) codigo)) {
            return "redirect:/tutor";
        }
        repository.save(tutor);
        return "redirect:/tutor";
    }

    

    @PostMapping("/associarAnimalTutor")
    public String associarAnimal(@ModelAttribute Animal animal, @RequestParam Integer codigotutor) {
        
        Tutor tutor = tutorService.getTutorById(codigotutor);
        animal = animalService.getAnimalById(animal.getId());

        tutor.getAnimais().add(animal);
        tutorService.salvar(tutor);

        return "redirect:/detalhesTutor/" + codigotutor;
    }

    
    @GetMapping("/detalhesTutor/{codigo}")
    public ModelAndView getTutorDetalhes(@PathVariable(name = "codigo") Integer codigo) {

        Tutor tutor = tutorService.getTutorById(codigo);
        ModelAndView mv = new ModelAndView("tutor/detalhesTutor");
        mv.addObject("tutor", tutor);
        List <Animal> animaisNaoAssociados = animalService.getAnimais();
        animaisNaoAssociados.removeAll(tutor.getAnimais());
        mv.addObject("animais", animaisNaoAssociados);

        return mv;
    }

    // GET pode ser usado quando se trata de html e fosse uma api usar o delete
    @GetMapping("/tutor/{codigo}/excluir")
    public String excluir(@PathVariable int codigo) {
        repository.deleteById(codigo);
        return "redirect:/tutor";
    }

}
