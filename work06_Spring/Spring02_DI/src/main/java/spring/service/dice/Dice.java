package spring.service.dice;

//핵심 기능의 템플릿
public interface Dice {
	
	//Method (getter/setter)
	int getValue();
	
	//==> 주사위를 던저 선택되는 숫자를 생산하는 행위(무작위로 숫자 생산)
	void selectedNumber();
	
}
