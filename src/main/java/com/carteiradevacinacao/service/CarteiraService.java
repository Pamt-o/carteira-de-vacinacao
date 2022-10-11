package com.carteiradevacinacao.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carteiradevacinacao.models.Carteira;
import com.carteiradevacinacao.repository.CarteiraRepo;


@Service
public class CarteiraService {

    @Autowired
    private CarteiraRepo repository;
    
    public void salvar(Carteira carteira) {
        repository.save(carteira);
    }

    public List<Carteira> getCarteiras() {
        return repository.findAll();
    }

    public Carteira getCarteiraById(int codigo) {
        return repository.findById(codigo).get();
    }

    public void remover(Carteira carteira) {
        repository.delete(carteira);
	}
    
}
