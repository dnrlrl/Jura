package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;

public class LoginAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		CustomerDao cd= CustomerDao.getInstance();
		int anum=0;
		int result =cd.loginChk(id,pass);
		if (result > 0) {
			String ck=cd.checkDelete(id);
			if(ck.equals("y")) {
				result=-1;
				request.setAttribute("result", result);
				return "login";
			}
			HttpSession session =request.getSession();
			session.setAttribute("id", id);
			anum=cd.addnum(id);
		}
		
		else if (result <= 0) {
			request.setAttribute("result", result);
			return "login";
		}
		request.setAttribute("result", result);
		request.setAttribute("anum", anum);
		return "login";
	}

}
