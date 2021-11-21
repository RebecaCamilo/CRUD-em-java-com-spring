package com.petshop.banhoetosa.repository;

import org.springframework.data.repository.CrudRepository;

import com.petshop.banhoetosa.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Integer> {

}
