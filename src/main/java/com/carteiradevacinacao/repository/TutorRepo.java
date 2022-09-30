package com.carteiradevacinacao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.carteiradevacinacao.models.Tutor;

public interface TutorRepo extends JpaRepository<Tutor, Integer>{

    
}
