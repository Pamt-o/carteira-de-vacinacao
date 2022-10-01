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
import com.carteiradevacinacao.models.Veterinario;
import com.carteiradevacinacao.repository.VeterinarioRepo;
import com.carteiradevacinacao.service.AnimalService;
import com.carteiradevacinacao.service.VeterinarioService;

@Controller
public class VeterinarioController {

    @Autowired
    private VeterinarioRepo repository;
    
    @Autowired
    private VeterinarioService veterinarioService;

    @Autowired
    private AnimalService animalService;

    // Lista dos cadastros
    @GetMapping("/veterinario")
    public String index(Model model) {
        List<Veterinario> veterinarios = (List<Veterinario>) repository.findAll();
        model.addAttribute("veterinarios", veterinarios);
        return "veterinario/index";
    }

    // Novo cadastro
    @GetMapping("/veterinario/novo")
    public String novo() {
        return "veterinario/novo";
    }

    // Salvando a criação do cadastro no banco
    @PostMapping("/veterinario/criar")
    public String criar(Veterinario veterinario) {
        repository.save(veterinario);
        return "redirect:/veterinario";
    }

    @GetMapping("/veterinario/{matricula}")
    public String busca(@PathVariable int matricula, Model model) {
        Optional<Veterinario> veterinario = repository.findById(matricula);
        try {
            model.addAttribute("veterinario", veterinario.get());
        } catch (Exception err) {
            return "redirect:/veterinario";
        }

        return "/veterinario/editar";
    }

    @PostMapping("/veterinario/{matricula}/atualizar")
    public String atualizar(@PathVariable int matricula, Veterinario veterinario) {
        if (!repository.existsById((int) matricula)) {
            return "redirect:/veterinario";
        }
        repository.save(veterinario);
        return "redirect:/veterinario";
    }


    @PostMapping("/associarAnimalVeterinario")
    public String associarAnimalVet(@ModelAttribute Animal animal, @RequestParam Integer matriculavet) {
        
        Veterinario veterinario = veterinarioService.getVeterinarioById(matriculavet);
        animal = animalService.getAnimalById(animal.getId());

        veterinario.getAnimais().add(animal);
        veterinarioService.salvar(veterinario);

        return "redirect:/detalhesVeterinario/" + matriculavet;
    }
    
    @GetMapping("/detalhesVeterinario/{matricula}")
    public ModelAndView getVeterinarioDetalhes(@PathVariable(name = "matricula") Integer matricula) {

       Veterinario veterinario = veterinarioService.getVeterinarioById(matricula);
        ModelAndView mv = new ModelAndView("veterinario/detalhesVeterinario");
        mv.addObject("veterinario", veterinario);
        List <Animal> animaisNaoAssociados = animalService.getAnimais();
        animaisNaoAssociados.removeAll(veterinario.getAnimais());
        mv.addObject("animais", animaisNaoAssociados);

        return mv;
    }

    // GET pode ser usado quando se trata de html e fosse uma api usar o delete
    @GetMapping("/veterinario/{matricula}/excluir")
    public String excluir(@PathVariable int matricula) {
        repository.deleteById(matricula);
        return "redirect:/veterinario";
    }


   

    

}
