package com.carteiradevacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carteiradevacinacao.models.Carteira;
import com.carteiradevacinacao.models.Vacina;

public interface VacinaRepo extends JpaRepository <Vacina, Integer>{
    
    Iterable<Vacina> findByCarteira(Carteira carteira);
    
}
