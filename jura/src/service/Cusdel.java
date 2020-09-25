package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;

public class Cusdel implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("c_id");
		CustomerDao cd=CustomerDao.getInstance();
		int result=cd.delete(id);
		request.setAttribute("result", result);
		return "cusdelete";
	}

}
