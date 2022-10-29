package com.carteiradevacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carteiradevacinacao.models.Carteira;

public interface CarteiraRepo extends JpaRepository <Carteira, Integer> {  
    
}
