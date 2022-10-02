package com.carteiradevacinacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carteiradevacinacao.models.Veterinario;
import com.carteiradevacinacao.repository.VeterinarioRepo;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepo repository;

    public void salvar(Veterinario veterinario) {
        repository.save(veterinario);
    }

    public List<Veterinario> getTutores() {
        return repository.findAll();
    }

    public Veterinario getVeterinarioById(int matricula) {
        return repository.findById(matricula).get();
    }

    public void remover(Veterinario veterinario) {
        repository.delete(veterinario);
	}
}
