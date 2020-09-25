package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.ShopDao;
import model.Shop;

public class C_shopList implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session= request.getSession();
		String id=(String)session.getAttribute("id");
		CustomerDao cd=CustomerDao.getInstance();
		
		String path = request.getContextPath();
		
		String n=request.getParameter("n_type");
		ShopDao sd=ShopDao.getInstance();
		int an=Integer.parseInt(request.getParameter("anum"));
		List<Shop> list=sd.list(n,an);
		request.setAttribute("list", list);
		if(n.equals("한식")) {
			request.setAttribute("type", "kor");
		}
		else if(n.equals("중식")) {
			request.setAttribute("type", "chi");
		}
		else if(n.equals("일식")) {
			request.setAttribute("type", "jpn");
		}
		else if(n.equals("양식")) {
			request.setAttribute("type", "wes");
		}
		request.setAttribute("path", path);
		request.setAttribute("sid", null);
		request.setAttribute("n_type", n);
		request.setAttribute("anum", an);
		return "c_shopList";
	}

}
