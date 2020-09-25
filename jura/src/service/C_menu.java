package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenuDao;
import dao.ShopDao;
import model.Menu;

public class C_menu implements CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String sid=request.getParameter("s_id");
		request.setAttribute("sid", sid);
		ShopDao sd=ShopDao.getInstance();
		String sadd=sd.address(sid);
		
		String path = request.getContextPath();
		
		MenuDao md=MenuDao.getInstance();
		List<Menu> list=md.list(sid);
		request.setAttribute("list", list);
		request.setAttribute("sadd", sadd);
		int anum=Integer.parseInt(request.getParameter("anum"));
		request.setAttribute("anum", anum);
		request.setAttribute("path", path);
		return "c_menu";
	}
}
