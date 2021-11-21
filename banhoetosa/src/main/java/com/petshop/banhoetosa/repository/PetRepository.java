package com.petshop.banhoetosa.repository;

//import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.petshop.banhoetosa.model.Pet;

public interface PetRepository extends PagingAndSortingRepository<Pet, Integer> {
	
	public Iterable<Pet> findByNameContaining(String partName);

	
	
	
}
