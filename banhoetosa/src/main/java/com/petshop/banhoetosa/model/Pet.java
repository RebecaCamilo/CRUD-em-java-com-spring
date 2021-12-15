package com.petshop.banhoetosa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity	//indica que é uma classe de persistencia Java
public class Pet {
	
	@Id	//define o atributo abaixo (ou seja, "private int id") como chave primária
	@GeneratedValue(strategy = GenerationType.AUTO)	//define a estratégia para a geração da pk, "GenerationType.AUTO" ou seja, um um campo auto incrementável nesse caso
	private int id;
	private String name;
	private int age;
	
		
	public Pet() {
		super();
	}
	
	public Pet(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
