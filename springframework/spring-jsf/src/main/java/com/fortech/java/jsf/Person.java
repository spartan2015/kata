package com.fortech.java.jsf;

import java.util.Date;
import java.util.Set;


public class Person {

	private Long id;

	private String name;

	private Date birthDate;

	private int weight;

	private int height;

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return height;
	}
	
	
}
