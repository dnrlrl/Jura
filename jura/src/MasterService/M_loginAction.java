package MasterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;

public class M_loginAction implements CommandProcess {
	
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pass=request.getParameter("pass");
		CustomerDao cd = CustomerDao.getInstance();
		int result = cd.loginChk(id, pass);
		if (result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id); 
		}
		request.setAttribute("result", result);
		return "m_login";
	}

}
