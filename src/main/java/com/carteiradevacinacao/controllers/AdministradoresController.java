package com.carteiradevacinacao.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.carteiradevacinacao.models.Administrador;
import com.carteiradevacinacao.repository.AdministradoresRepo;



@Controller
public class AdministradoresController {

    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/administradores")
    public String index(Model model){
        List<Administrador>administradores =(List<Administrador>) repo.findAll(); 
        model.addAttribute("administradores", administradores);
        return "administradores/index";
    }


    @GetMapping("/administradores/novo")
    public String novo(){
        return "administradores/novo";
    }

    @PostMapping("/administradores/criar")
    public String criar(Administrador administrador){
        repo.save(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}")
    public String busca(@PathVariable int id, Model model) {
        Optional<Administrador> administrador = repo.findById(id);
        try {
            model.addAttribute("administrador", administrador.get());
        } catch (Exception err) {
            return "redirect:/administradores";
        }

        return "/administradores/editar";
    }

    @PostMapping("/administradores/{id}/atualizar")
    public String alterar(@PathVariable int id, Administrador administrador) {
        if (!repo.existsById((int) id)) {
            return "redirect:/administradores";
        }
        repo.save(administrador);
        return "redirect:/administradores";
    }


    @GetMapping("/administradores/{id}/excluir")
    public String excluir(@PathVariable int id) {
        repo.deleteById(id);
        return "redirect:/administradores";
    }
}
