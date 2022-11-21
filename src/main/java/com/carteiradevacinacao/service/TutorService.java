package com.carteiradevacinacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carteiradevacinacao.models.Tutor;
import com.carteiradevacinacao.repository.TutorRepo;

@Service
public class TutorService {

    @Autowired
    private TutorRepo repository;
    
    public void salvar(Tutor tutor) {
        repository.save(tutor);
    }

    public List<Tutor> getTutores() {
        return repository.findAll();
    }

    public Tutor getTutorById(int codigo) {
        return repository.findById(codigo).get();
    }

    public void remover(Tutor tutor) {
        repository.delete(tutor);
	}
    
   
}
