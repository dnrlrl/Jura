package MasterService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import model.Customer;



public class M_customerListUpdate implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("c_id");
		String password=request.getParameter("c_pass");
		String name=request.getParameter("c_name");
		int addnum=Integer.parseInt(request.getParameter("addnum"));
		String address=request.getParameter("c_address");
		String tel=request.getParameter("c_tel");
		String del=request.getParameter("del");
		
		Customer cus=new Customer();
		cus.setC_pass(password);
		cus.setC_name(name);
		cus.setAdd_num(addnum);
		cus.setC_tel(tel);
		cus.setC_address(address);
		cus.setDel(del);		
		cus.setC_id(id);
		
		CustomerDao cd=CustomerDao.getInstance();
		int result=cd.update(cus);
		cd.update(cus);
		List<Customer> list=cd.clist();


		request.setAttribute("clist", list);
		request.setAttribute("result", result);		
		return "m_customerList";
	}

}
