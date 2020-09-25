package MasterService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import model.Customer;






public class M_customerList implements CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		CustomerDao cd = CustomerDao.getInstance();
		List<Customer> clist =cd.clist();
		request.setAttribute("clist", clist);
		return "m_customerList";
	}

}
