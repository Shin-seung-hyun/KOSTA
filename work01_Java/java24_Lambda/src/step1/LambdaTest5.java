package step1;


@FunctionalInterface
interface Attackable{
	void attack(); // 인자값 X, 반환값 void 
}


@FunctionalInterface
interface Movable{
	void move(int right, int left); // 인자값 2개, 반환값 void
}

class Fighter{
	
	//method Overloading
	//1.
	public void action(Attackable a){
		a.attack();
	}
	
	//2.
	public void action(Movable m) {
		m.move(100, 20);
	}
}

public class LambdaTest5 {

	public static void main(String[] args) {
	
		Fighter fighter = new Fighter();
	
	//1. Attackable 
		// @Override attack
		//실행문이 하나일 때 (action 호출과 동시에 람다식 구현)
		fighter.action( () -> System.out.println("드론을 이용해서 공중공격 합니다") );
		
		//실행문이 두개일 때
		fighter.action( () -> {
			System.out.println("드론을 이용해서 공중공격 합니다");
			System.out.println("방어전선을 구축.. 공격 개시!");
		});
		
		System.out.println();
		
	//2. Movable
		// @Override move 람다식 구현
		fighter.action((a, b) ->{
			int right = a * 100;
			int left  = b +20;
			System.out.println("오른쪽으로 " + right + "km 이동합니다."); 	//오른쪽으로 1000km(100 * 100) 이동합니다.
			System.out.println("왼쪽으로 " + left + "km 이동합니다.");	//왼쪽으로 40km(20+20) 이동합니다.
		});
		
	}
}
