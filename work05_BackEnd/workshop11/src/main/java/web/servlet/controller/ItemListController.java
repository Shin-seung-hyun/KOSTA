package web.servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Item;
import web.servlet.model.ItemDao;

// 전체 가져오기
public class ItemListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path = "index.jsp";
		
		try {
			ArrayList<Item> items = ItemDao.getInstance().getAllItem();
			
			
			if(items != null) {
				request.setAttribute("items", items);
				path = "itemList.jsp";
			}	
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView(path);
	}

}
