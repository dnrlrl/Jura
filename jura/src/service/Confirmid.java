package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;

public class Confirmid implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		CustomerDao cd=CustomerDao.getInstance();
		int result=cd.checkid(id);
		request.setAttribute("result", result);
		//if(result>=1) {
		//	msg="중복된 아이디 입니다.";
		//}
		//else {
		//	msg="사용가능한 아이디입니다.";
		//}
		//request.setAttribute("msg", msg);
		return "confirmid";
	}

}
