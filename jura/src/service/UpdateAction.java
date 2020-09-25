package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.CustomerDao;
import model.Customer;

public class UpdateAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String nowpass=request.getParameter("pass");
		String password="";
		password=request.getParameter("uppassword");
		if(password.equals("")) {
			password=nowpass;
		}
		String name=request.getParameter("name");
		int addnum=Integer.parseInt(request.getParameter("addnum"));
		String address=request.getParameter("address");
		String tel=request.getParameter("tel");
		Customer cus=new Customer();
		CustomerDao cd=CustomerDao.getInstance();
		String pck=cd.pscheck(id);
		int result=0;
		if(!pck.equals(nowpass)) {
			result=-1;
			request.setAttribute("result", result);
			return "update";
		}
		cus.setC_id(id);
		cus.setC_name(name);
		cus.setAdd_num(addnum);
		cus.setC_address(address);
		cus.setC_tel(tel);
		cus.setC_pass(password);
		result=cd.update(cus);
		int anum=Integer.parseInt(request.getParameter("anum"));
		System.out.println(anum);
		request.setAttribute("anum", anum);
		request.setAttribute("result", result);
		return "update";
	}

}
