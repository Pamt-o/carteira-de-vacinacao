package com.carteiradevacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.carteiradevacinacao.models.Animal;

public interface AnimalRepo extends JpaRepository<Animal, Integer>{

    //controller atualizar
    @Query(value = "select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from animal where id = :id", nativeQuery = true)
    public boolean exist(int id);


   
}
