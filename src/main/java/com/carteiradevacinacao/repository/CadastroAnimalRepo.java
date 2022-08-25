package com.carteiradevacinacao.repository;

import org.springframework.data.repository.CrudRepository;

import com.carteiradevacinacao.models.CadastroDeAnimal;

public interface CadastroAnimalRepo extends CrudRepository<CadastroDeAnimal, Integer>{

}
