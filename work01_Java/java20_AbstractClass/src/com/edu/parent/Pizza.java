package com.edu.parent;

/*
 * 추상 클래스의 용도
 * 1. 공통의 피자를 만들어 내기 위한 공통의 작업은(필드, 메소드) 그래돌 자식 클래스에서 물려주고
 * 2. 반면에 서로 다른 여러 종류의 피자가 만들어질 수 있는 결정적인 부부은 추상 메소드로 물려준다.
 * 	 topping 에 따라서 서로 다른 피자 종류가 만들어진다.
 * 
 * 	 인터페이스와의 차이점 : 추상성
 * 	 완벽한 추상성  : Interface (사용자와 밴더 사이의 규약, 표준화)
 * 	 부분적인 추상성 : 추상 클래스 (자식들에 있어서 결정적인 다른 부분들은 미완성으로 물려준다., 자식에게서 완성하도록 하는 기법)
 *  
 */

public abstract class Pizza {
	
	protected int price;
	protected String storeName;
	
	public Pizza() {
		this(15_000, "PizzaHut");
	}

	public Pizza(int price, String storeName) {
		super();
		this.price = price;
		this.storeName = storeName;
	}
	
	
	// 기능을 최종적으로 추가
	public void sequencePizza() {
		dogh();
		topping();
		bake();
		cutting();
		boxing();
	}
	private void dogh() {
		System.out.println("피자 반죽과 함께 도우를 잘 만들어 줍니다.");
	}
	
	private void bake() {
		System.out.println("180도 오븐에서 10분간 구워냅니다.");
	}
	
	private void cutting() {
		System.out.println("피자를 8조각으로 자릅니다.");
	}
	
	private void boxing() {
		System.out.println("잘려진 피자를 박스에 포장합니다.");
	}
	
	public abstract void topping(); // 물려줘야 하기에 public 
	
	
	@Override
	public String toString() {
		return "상점명 : " + storeName + " 가격 : " + price;
	}

}
