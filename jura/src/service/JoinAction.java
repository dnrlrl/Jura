package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import model.Customer;

public class JoinAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		int addnum=Integer.parseInt(request.getParameter("addnum"));
		String address=request.getParameter("address");
		String tel=request.getParameter("tel");
		Customer customer=new Customer();
		customer.setC_id(id);
		customer.setC_pass(password);
		customer.setC_name(name);
		customer.setAdd_num(addnum);
		customer.setC_address(address);
		customer.setC_tel(tel);
		CustomerDao cd=CustomerDao.getInstance();
		int result=cd.insert(customer);
		request.setAttribute("result", result);
		return "join";
	}

}
