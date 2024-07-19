package test3;


class Person{}

class Worker extends Person{}

class Employee extends Person{}

class Engineer extends Employee{}

class Manager extends Employee{}

class Application<T>{ // 클래스 선언부에는 제한된 파라미터 타입을 사용 못함
	T kind;

	public Application(T kind) {
		super();
		this.kind = kind;
	}
}

class PersonService{
	public static void register1(Application<?> application ) { // 모든 것 다 할당 가능, 이럴 경우 주로 ?말고 T로 쓰임
		System.out.println(application.kind.getClass().getSimpleName() + " 이 등록됨");
	}
	
	public static void register2(Application<? super Worker> application ) { // Worker, Person 할당 가능
		System.out.println(application.kind.getClass().getSimpleName() + " 이 등록됨");
	}
	
	public static void register3(Application<? extends Employee> application ) {
		System.out.println(application.kind.getClass().getSimpleName() + " 이 등록됨");
	}
}

public class GenericWildCardTest3 {
	public static void main(String[] args) {
		
		System.out.println("======== <?> ================");
		PersonService.register1(new Application(new Employee()) ); // OK
		
		System.out.println("\n======== <? super Worker> ================");
		PersonService.register2(new Application(new Person()) ); // OK
		PersonService.register2(new Application(new Worker()) ); // OK
		PersonService.register2(new Application(new Employee()) ); // OK
		PersonService.register2(new Application(new Engineer()) ); // OK
		PersonService.register2(new Application(new Manager()) ); // OK
		
		
		System.out.println("\n======== <? extends Employee> ================");
		PersonService.register3(new Application(new Engineer()) );  // OK
		PersonService.register3(new Application(new Manager()) );  // OK
		PersonService.register3(new Application(new Employee()) );  // OK
		PersonService.register3(new Application(new Person()) ); // fail
		

	}
	
}
