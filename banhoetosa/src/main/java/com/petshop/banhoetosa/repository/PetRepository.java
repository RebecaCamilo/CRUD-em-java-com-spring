package com.petshop.banhoetosa.repository;

//import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.petshop.banhoetosa.model.Pet;

//O @Repository tem como objetivo criar beans para a parte de persistência, 
//além de capturar exceções específicas de persistência e repeti-las novamente 
//como uma das exceções não verificadas e unificadas do Spring.
public interface PetRepository extends PagingAndSortingRepository<Pet, Integer> {
	
	public Iterable<Pet> findByNameContaining(String partName);

	
	
	
}
