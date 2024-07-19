package test1;


//Generic을 사용 안 하고 Box에 뭐든지 담을 수 있도록 설계했을 때..
/*
 * 장점 : 뭐든지 담긴다.
 * 단점 : 꺼낼 때마다 Object Casting을 해야 한다.
*/
class Box{
	
	// box에 뭐든지 담을 수 있기 위해서는 무엇을 지정해야 하는가
	// Object로 지정해야 한다.
	Object content;
	
	public Object selectContent() { // 박스에 들어 있는 내용물을 꺼내는 함수
		return content;
	}
	
}


public class GenericTest01 {

	public static void main(String[] args) {
		Box box = new Box();
		box.content = "곰돌이 인형";
		
		//String bearDoor = box.selectContent(); // (x)
		String bearDoor = (String)box.selectContent(); // 계속 Object casting을 해야 함.

	}

}
