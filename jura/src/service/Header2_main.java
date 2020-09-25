package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;

public class Header2_main implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		 String id=(String)session.getAttribute("id");
		 CustomerDao cd=CustomerDao.getInstance();
		int anum=Integer.parseInt(request.getParameter("anum"));
		//System.out.println(anum);
		request.setAttribute("anum", anum);
	
		return "loginMain";
	}

}
