package com.pawe322.webmanager.beans;

public class Pet {
	private int id;
	private String name;
	private String typeOfAnimal;
	private int age;
	private int height;
	
	public Pet(){}
	public Pet(String name, String typeOfAnimal, int age, int height){
		this.name = name;
		this.typeOfAnimal = typeOfAnimal;
		this.age = age;
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeOfAnimal() {
		return typeOfAnimal;
	}

	public void setTypeOfAnimal(String typeOfAnimal) {
		this.typeOfAnimal = typeOfAnimal;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", typeOfAnimal=" + typeOfAnimal + ", age=" + age + ", height="
				+ height + "]";
	}

}
