package com.carteiradevacinacao.controllers;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.carteiradevacinacao.models.Administrador;
import com.carteiradevacinacao.repository.AdministradoresRepo;
import com.carteiradevacinacao.service.CookieService;

@Controller
public class LoginController {

    @Autowired
    private AdministradoresRepo repo;

    @GetMapping("/login")
    public String index(){
        return "login/index";
    }

    
    @PostMapping("/logar")
    public String logar(Model model, String email, String senha, String lembrar, HttpServletResponse response) throws IOException{
        Administrador adm = this.repo.Login(email, senha);
        if(adm != null){
            int tempoLogado = (60*60);//um dia
            if(lembrar != null) tempoLogado = (60*60*24*365);  //um ano de cookie 
            CookieService.setCookie(response, "usuarioId", String.valueOf(adm.getId()), tempoLogado);
            CookieService.setCookie(response, "nomeUsuario", String.valueOf(adm.getNome()), tempoLogado);
            return "redirect:/";
        }
        model.addAttribute("erro", "Usuário ou senha inválido");
        return "login/index";
    }

    @GetMapping("/sair")
    public String sair( HttpServletResponse response) throws IOException{ 
        CookieService.setCookie(response, "usuarioId", "", 0);
            return "redirect:/login";
        }
        
}
