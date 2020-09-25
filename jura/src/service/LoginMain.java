package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginMain implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String anum =request.getParameter("anum");
		request.setAttribute("anum", anum);
		return "loginMain";
	}

}
