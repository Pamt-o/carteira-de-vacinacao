package com.carteiradevacinacao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.carteiradevacinacao.models.Administrador;
import com.carteiradevacinacao.repository.AdministradoresRepo;

@Controller
public class LoginController {
    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/login")
    public String index(){
      return "login/index";
    }

    @PostMapping("/logar")
    public String logar(Model model, Administrador admParam, String lembrar){
      Administrador adm = this.repo.Login(admParam.getEmail(), admParam.getSenha());
      if(adm != null){
        return "redirect:/";
      }
      model.addAttribute("erro", "Usuário ou senha inválidos");
      return "login/index";
    }
    
}
