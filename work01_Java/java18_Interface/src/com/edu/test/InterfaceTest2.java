package com.edu.test;


class Unit{ // 공격 대상
	int currentHP;	// 유닛의 체력
	int x;	//유닛의 x 좌표
	int y;	//유닛의 y 좌표
}

interface Attackable{
	void attack(Unit u);
}

interface Movable{
	void move(int  x, int y);
	void jump(int height);
	
}

interface Fightable extends Attackable, Movable{
	//구현을 하지 않아도 template 기능 3개를 포함하고 있음
}

class Fighter extends Unit implements Fightable{	//클래스와 인터페이스를 동시에 상속 받음. 1) extends 먼저 2) implements 다음으로 쓰기

	@Override
	public void attack(Unit u) {
	}

	@Override
	public void move(int x, int y) {
	}

	@Override
	public void jump(int height) {
	}
	
}


public class InterfaceTest2 {

	public static void main(String[] args) {
		
		 Fighter f = new Fighter();
		 
		 if( f instanceof Unit)
			 System.out.println("f는 Unit의 자손입니다.");
		 
		 if( f instanceof Fightable)
			 System.out.println("f는 Fightable의 자손입니다.");
		 
		 if( f instanceof Movable)
			 System.out.println("f는 Movable의 자손입니다.");
		 
		 if( f instanceof Attackable)
			 System.out.println("f는 Attackable의 자손입니다.");
		 
		 if( f instanceof Object)
			 System.out.println("f는 Object의 자손입니다.");
	
	}

}
