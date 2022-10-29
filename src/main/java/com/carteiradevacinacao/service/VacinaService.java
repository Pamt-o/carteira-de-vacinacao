package com.carteiradevacinacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carteiradevacinacao.models.Vacina;
import com.carteiradevacinacao.repository.VacinaRepo;

@Service
public class VacinaService {
    
    @Autowired
    private VacinaRepo repository;
    
    public void salvar(Vacina vacina) {
        repository.save(vacina);
    }

    public List<Vacina> getVacinas() {
        return repository.findAll();
    }


    public Vacina getVacinaById(int id) {
        return repository.findById(id).get();
    }

    public void remover(Vacina vacina) {
        repository.delete(vacina);
	}
}
