package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Item;
import web.servlet.model.ItemDao;

public class recordCountController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemNum = Integer.parseInt(request.getParameter("itemNum"));
		String path = "itemView.jsp";
		
		try {
			
			boolean isSuccess = ItemDao.getInstance().updateRecordCount(itemNum);
			
			if(isSuccess) {
				Item item =ItemDao.getInstance().getItem(itemNum);
				
				request.setAttribute("item", item);
				path = "itemView.jsp";
			}	
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView(path);
	}

}
