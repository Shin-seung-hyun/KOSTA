package test3;

import java.util.*;

abstract class Animal{ //abstract는 객체 생성의 대상이 안된다. super로써만 가능함.
	public void eat() {System.out.println("Animal eating...");}
}

class Dog extends Animal{
	@Override
	public void eat() {System.out.println("Dog eat");}
	
	void bark() { System.out.println("Dog Bark");}
	
}

class Cat extends Animal{
	
	@Override
	public void eat(){System.out.println("Cat eat");}
	
	void meow() { System.out.println("Cat Meow");}
	
}

public class GenericWildCardTest4 {
	public static void main(String[] args) {
		
		//왜 제한된 파라미터 타입을 써야하는지 알아보자
		

		List<Animal> animals = List.of(new Dog(), new Cat(), new Dog());
		System.out.println( "List<Animal> animals 적용 : ");
		takeAnimals(animals);
		
		System.out.println( "\nList<? extends Animal> animals 적용 : ");
		takeAnimals2(animals);
		
		System.out.println("\n======== List<Animal> animals 적용 =========");
		List<Dog> dogs = List.of(new Dog(),new Dog());
		//takeAnimals(dogs);	 //Error 발생
		//Q. dogs가 animals가 할당 되야하지 않느냐? 다형성이 아닌가??
		//A. 다형성에서 
		
		System.out.println("\n======== List<? extends Animal> animals 적용 =========");
		List<Dog> dogs2 = List.of(new Dog(),new Dog());
		takeAnimals2(dogs2);
	}
	
	//List<Dog> dog는 할당 안된다 ... 다형성적용 안됨
	public static void takeAnimals(List<Animal> animals){	
		for(Animal a : animals) a.eat();
	}
	
	//wild card 적용하는 기능 정의
	//List< ? extends Animal>을 하면 heterogeneous, homogeneous 모두 가능함.
	public static void takeAnimals2(List<? extends Animal> animals) {
		for(Animal a : animals) a.eat();
	}
	
}