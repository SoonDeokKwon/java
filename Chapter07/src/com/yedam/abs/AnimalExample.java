package com.yedam.abs;

public class AnimalExample {
	public static void main(String[] args) {
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		dog.sound();
		cat.sound();
		System.out.println("-------------------");
		
		
		//추상클래스를 다형성으로 표현	
		//Animal animal = null;
		animalSound(new Dog());
		//animal = new Dog();
		//animal.sound();
		animalSound(new Cat());
		//animal = new Cat();
		//animal.sound();
		
		
	}
	
	//매개변수의 다형성을 활용한 추상 클래스 사용
	public static void animalSound(Animal animal) {
		animal.sound();
	}
	
	
}
