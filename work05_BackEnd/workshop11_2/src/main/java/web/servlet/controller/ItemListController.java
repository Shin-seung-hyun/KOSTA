package web.servlet.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Item;
import web.servlet.model.ItemDao;

public class ItemListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		
		///////// 브라우저에서 전달되는 모든 쿠키정보를 받는 로직 ///////////
		// request.getCookies() 중에서 fruit 사이트의 쿠키만 받아옴
		Cookie [] cookies = request.getCookies();
		ArrayList<String> fruits = new ArrayList<String>();
		
		// 쿠키를 차단하는 사이트가 있음, 또한 만료기간이 있음
		if(cookies !=null) {
			
			for(Cookie c : cookies) {
				
				if(c.getName().startsWith("fruitshop")) {
					fruits.add(c.getValue());
					
				}
			}
		}
		
		request.setAttribute("fruits", fruits);

		//////////////////////////////////////////////////////
		
		
		ArrayList<Item> list=ItemDao.getInstance().getAllItem();
		System.out.println(list);
		request.setAttribute("list", list);
		return new ModelAndView("itemList.jsp");
	}
}
