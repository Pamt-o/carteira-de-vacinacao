package com.carteiradevacinacao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.carteiradevacinacao.models.Animal;

public interface CadastroAnimalRepo extends CrudRepository<Animal, Integer>{

    //controller atualizar
    @Query(value = "select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from animal where id = :id", nativeQuery = true)
    public boolean exist(int id);

}
