package com.edu.statictest;

/*
 * 4. static한 변수는 생성된 객체들에서 공유하는 값이다.
 * 
 */


class Car{
	int serialNumber;
	static int counter;
	
	Car(){
		counter++;
		serialNumber = counter;
	}
	
}
public class StaticExamTest2 {

	public static void main(String[] args) {
		
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		
		System.out.println("============ field value ============");
		System.out.println(car1.serialNumber);
		System.out.println(car2.serialNumber);
		System.out.println(car3.serialNumber);
		
		System.out.println("============ static value ============");
		System.out.println(car1.counter);
		System.out.println(car2.counter);
		System.out.println(car3.counter);
		System.out.println(Car.counter);
	}

}
