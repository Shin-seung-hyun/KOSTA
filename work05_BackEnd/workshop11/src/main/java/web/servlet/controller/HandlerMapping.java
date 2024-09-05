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
		
		// 전체 보기
		if( command.equals("itemList.do")) {
			controller = new ItemListController();
			System.out.println("ItemListController 실행");
		}
		
		// 상세 보기
		else if( command.equals("itemView.do")) {
			controller = new ItemViewController();
			System.out.println("itemListController 실행");
		}
		
		else if( command.equals("recordCount.do")) {
			controller = new recordCountController();
			System.out.println("recordCountController 실행");
		}
		
		return controller;
	}

}
