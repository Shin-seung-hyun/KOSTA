package web.servlet.controller;


//Component를 생성하는 일종의 공장
// 서블릿이 전해주는 command 값에 따라서 Component를 생성함
// 그리고 다시 서블릿에게 생성한 Componet를 반환할 때는 Controller interface 타입으로 반환한다.
public class HandlerMapping {
	
	private static HandlerMapping factory  = new HandlerMapping();
	
	private HandlerMapping() {}
	public static HandlerMapping getFactory() {
		return factory;
	}
	
	
	//컴포넌트를 생성하는 기능
	public Controller createComponent(String command) {
		
		Controller controller = null;
		
		if( command.equals("find.do")) {
			controller = new FindController();
			System.out.println("FindController 생성됨...");
		}
		
		
	
		
		return controller;
	
	}

}
