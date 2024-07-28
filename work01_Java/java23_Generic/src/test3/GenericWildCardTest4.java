package test3;

import java.util.*;

abstract class Animal{ 		//abstract 는 객체 생성의 대상이 아니다. super 로써만 가능함.
	public void eat() {System.out.println("Animal eating...");}
}

//vo class 
class Dog extends Animal{
	@Override
	public void eat() {System.out.println("Dog eat");}
	
	void bark() { System.out.println("Dog Bark");}
	
}

//vo class 
class Cat extends Animal{
	
	@Override
	public void eat(){System.out.println("Cat eat");}
	
	void meow() { System.out.println("Cat Meow");}
	
}


public class GenericWildCardTest4 {
	
	//service class 
	public static void takeAnimals(List<Animal> animals){	
		for(Animal a : animals) a.eat();
	}
	
	public static void takeAnimals2(List<? extends Animal> animals) { // heterogeneous, homogeneous 모두 가능하다.
		for(Animal a : animals) a.eat();
	}
	
	//test class
	public static void main(String[] args) {
		
		//왜 제한된 파라미터 타입을 써야하는지 알아보자!
		List<Animal> animals = List.of(new Dog(), new Cat(), new Dog()); // 다형성
																	     // 부모의 타입 배열 안에 자식 객체들을 생성할 수 있다.
		
		System.out.println("\n======== List<Animal> animals 적용 1 ==================");
		takeAnimals(animals);
		
		System.out.println("\n======== List<? extends Animal> animals 적용 1 =========");
		takeAnimals2(animals);
		
		//------------------------------------------------------------------------
		
		List<Dog> dogs = List.of(new Dog(), new Dog(), new Dog());
		
		System.out.println("\n======== List<Animal> animals 적용 2 ==================");
		//takeAnimals(dogs);	 // Error 발생
							 // Q. 다형성을 적용해 List<Animal> animals = List<Dog> dogs; 이 돼야 하는거 아닌가?
							 // A. List<Dog> dog 를 바로 할당할 수 없다. Animal 타입에 Dog 를 저장할 수 있지만(= 다형성), 참조형으로 다형성을 이용할 수 없다.)
							 // Animal a = new Dog(); (O) 
							 // List<Animal> animals = List<Dog> dogs; (X)
		
		System.out.println("\n======== List<? extends Animal> animals 적용 2 =========");
		takeAnimals2(dogs);
	}
	
}