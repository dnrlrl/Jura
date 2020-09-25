package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.ShopDao;
import model.Customer;
import model.Shop;

public class response_MainAddnum implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String input_add= request.getParameter("input_add");
		request.setAttribute("anum", input_add);
		return "request_mainAddnum";
	}

}
