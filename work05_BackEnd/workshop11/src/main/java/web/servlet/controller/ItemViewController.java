package web.servlet.controller;


import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Item;
import web.servlet.model.ItemDao;


public class ItemViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemNum = Integer.parseInt(request.getParameter("itemNum"));
		String path = "itemList.jsp";
		
		try {
			
			Item item =ItemDao.getInstance().getItem(itemNum);
			
			if(item != null) {
				
				boolean isUpdate = ItemDao.getInstance().updateRecordCount(itemNum);
				
				if(isUpdate) {
					
					request.setAttribute("item", item);
					path = "itemView.jsp";
					
				}
				
				
			}	
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView(path);

		
	}

}
