package com.petshop.banhoetosa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.banhoetosa.model.Pet;
import com.petshop.banhoetosa.repository.PetRepository;

@RestController
public class PetController {
	
	@Autowired
	PetRepository petRepository;
	
	@GetMapping
	public String oi() {
		return "Hello, World!";
	}
	
	
	@PostMapping
	public Pet novoPet(@RequestParam String name, int idade) {
		Pet pet = new Pet(name, idade);
		petRepository.save(pet);
		return pet;
		
	}

	
	

}
