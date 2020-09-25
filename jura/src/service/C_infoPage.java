package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import model.Customer;

public class C_infoPage implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session= request.getSession();
		String id=(String)session.getAttribute("id");
		int anum=Integer.parseInt(request.getParameter("anum"));
		CustomerDao cd=CustomerDao.getInstance();
		Customer customer= cd.select(id);
		request.setAttribute("customer", customer);
		request.setAttribute("anum", anum);
		return "c_infoPage";
	}

}
