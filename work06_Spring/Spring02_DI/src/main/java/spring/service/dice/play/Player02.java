package spring.service.dice.play;

import spring.service.dice.Dice;

/*
 *	직접적인 연관성ㅇ르 피해서
 *  조금 더 느슨한 연관성을 갖도록 하자! (인터페이스로 연결한다.)
 *  재사용성이 강화된다.
 *    
 */
public class Player02 {
	
	///Field
	//private DiceA diceA = new DiceA();
	private Dice dice;
	private int totalValue;
	
	///Constructor Method
	public Player02() {
	}
	
	public Player02(Dice dice) {
		this.dice = dice;
	}


	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	//==> count 만큼 주사위를 굴려서 합을 후하는 행위
	public void playDice(int count){
		
		System.out.println("==>"+getClass().getName()+".playDice() start....");

		for (int i = 0; i < count; i++) {
			dice.selectedNumber();
			System.out.println("::[ "+dice.getClass().getName()+" ] 의 선택된수 : "+dice.getValue());
			totalValue += dice.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}

}//end of class