package com.carteiradevacinacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carteiradevacinacao.models.Animal;
import com.carteiradevacinacao.models.Carteira;
import com.carteiradevacinacao.repository.AnimalRepo;
import com.carteiradevacinacao.repository.CarteiraRepo;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepo repository;

    @Autowired
    private CarteiraRepo carteiraRepo;
    
    // public void salvar(Animal animal) {
    //     repository.save(animal);
    // }

    public List<Animal> getAnimais() {
        return repository.findAll();
    }


    public Animal getAnimalById(int id) {
        return repository.findById(id).get();
    }

    public void remover(Animal animal) {
        repository.delete(animal);
	}
    
    public void salvarAnimalComCarteira(Animal animal, Carteira carteira) {
        repository.save(animal);
        this.getException(); 
        carteiraRepo.save(carteira); 
    }


    private void getException() {
    }
    
}
