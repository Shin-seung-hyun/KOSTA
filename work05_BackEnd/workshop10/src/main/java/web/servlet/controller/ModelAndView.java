package web.servlet.controller;

//결과 페이지의 이름과 이동방법을 저장하는 클래스
public class ModelAndView {
	private String path; 	// jsp, 결과페이지 정보
	private boolean isRedirect; // 이동 방식(기본이 false이기에)
	
	
	public ModelAndView() {}
	public ModelAndView(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public ModelAndView(String path) { // forward 방식일 때
		this.path = path;
	}
	
	
	public String getPath() {
		return path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}


}
