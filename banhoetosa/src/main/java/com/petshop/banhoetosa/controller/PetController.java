package com.petshop.banhoetosa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.banhoetosa.model.Pet;
import com.petshop.banhoetosa.repository.PetRepository;

@RestController
@RequestMapping("/api")
public class PetController {
	
	@Autowired
	PetRepository petRepository;
	
//	POST
	
	@PostMapping	
	public ResponseEntity<Pet> savePet(Pet pet) {
		try {
			Pet _pet = petRepository.save(new Pet(pet.getName(), pet.getAge()));
			return new ResponseEntity<>(_pet, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
//	PUT

//	@PutMapping
//	public Pet updatePet(@Valid Pet pet) {
//		petRepository.save(pet);
//		return pet;
//	}
	
		
	
	
//	GET AND FIND
	
	@GetMapping("/list")
	public Iterable<Pet> listPet() {
		return petRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Pet> detailPet(@PathVariable int id) {
		return petRepository.findById(id);
	}
	
	@GetMapping("/name/{partname}")
	public Iterable<Pet> detailPetByName(@PathVariable String partname) {
		return petRepository.findByNameContaining(partname);
	}
	
	
//	DELETE
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deletePet(@PathVariable("id") int id) {
	    try {
	    	petRepository.deleteById(id);
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }	
	
	@DeleteMapping("/delete")
//	public void deletePet() {
	public ResponseEntity<HttpStatus> deleteAllPets() {
		try {
			petRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
} // End of class PetController
