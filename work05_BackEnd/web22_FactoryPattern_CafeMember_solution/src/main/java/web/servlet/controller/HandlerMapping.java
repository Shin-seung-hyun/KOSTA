package web.servlet.controller;

//Component를 생성하는 일종의 공장
//서블릿이 전해주는 command값에 따라서 Component를 생성
//그리고 다시 서블릿에게 생성한 Component를 반환할때는 Controller 인터페이스 타입으로 반환
public class HandlerMapping {

	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getFactory() {
		return factory;
	}
	
	//Component를 생성하는 기능...
	public Controller createComponent(String command) {
		Controller controller = null;
		if(command.equals("find.do")) {
			controller = new FindController();			
		}else if(command.equals("register.do")) {
			controller = new RegisterController();
		}else if(command.equals("login.do")) {
			controller = new LoginController();
		}else if(command.equals("logout.do")) {
			controller = new LogoutController();
		}else if(command.equals("showAll.do")) {
			controller = new ShowAllController();
		}else if(command.equals("update.do")) {
			controller = new UpdateController();
		}
		return controller;
	}
}









