package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderListDao;
import dao.OrdersDao;
import model.Order_list;
import model.Orders;

public class Ordered implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session= request.getSession();
		String c_id=(String)session.getAttribute("id");
		int anum=Integer.parseInt(request.getParameter("anum"));
		int ordernum =Integer.parseInt(request.getParameter("ordernum"));
		int odprice=Integer.parseInt(request.getParameter("ol_price"));
		String c_address= request.getParameter("address");
		String how = request.getParameter("how");
		
		OrderListDao olid=OrderListDao.getInstancee();
		Order_list oli=new Order_list();// order_list
		List<Order_list> olist=olid.olist(ordernum);
		request.setAttribute("orderlist", olist);
		
		OrdersDao od=OrdersDao.getInstance();
		Orders orders = new Orders();
		orders.setC_id(c_id);
		orders.setO_add(c_address);
		orders.setO_how(how);
		orders.setO_price(odprice);
		orders.setO_num(ordernum);
		
		int result=od.maxid(ordernum);
		od.orderUpdate(orders);
		//List<Orders> list=od.ouplist();
		
		//List<Shop> list=sd.list(n,an);
		//String c_id=request.getParameter("c_id");
		// o_num 값으로 orderlist select olist.어쩌구..
		//List<Orders> list=sd.list(c_id);
		//String olm_name=request.getParameter("olm_name")
		
		request.setAttribute("orders", orders);
		request.setAttribute("anum", anum);
		request.setAttribute("c_id", c_id);
		//request.setAttribute("orderlist", olist);
		request.setAttribute("ods", od);
		return "ordered";
	}

}
