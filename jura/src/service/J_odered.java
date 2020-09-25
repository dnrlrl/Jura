package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderListDao;
import dao.OrdersDao;
import model.Order_list;
import model.Orders;

public class J_odered implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session= request.getSession();
		String c_id=(String)session.getAttribute("id");
		int count=Integer.parseInt(request.getParameter("count"));
		int anum=Integer.parseInt(request.getParameter("anum"));
		int ordernum =Integer.parseInt(request.getParameter("ordernum"));
		int odprice=Integer.parseInt(request.getParameter("ol_price"));
		String c_address= request.getParameter("address");
		String how = request.getParameter("how");
		odprice*=count;
		//oli.setCount(1); update set 해서 count로 바꾸기
		
		 System.out.println("cid"+c_id);
		 System.out.println("수량"+count);
		 System.out.println("주소값"+anum);
		 System.out.println("오더넘"+ordernum);
		 System.out.println("가격"+odprice);
		 System.out.println("주소"+c_address);
		 System.out.println("결제"+how);
		 
		
		  OrderListDao olid=OrderListDao.getInstancee();
		  Order_list oli=new Order_list();// order_list
		  System.out.println(0);
		  oli=olid.juraoli(ordernum,count,odprice);
		  System.out.println(1);
		  
		  List<Order_list> olist=olid.olist(ordernum);
		  System.out.println(2);
		  
		  request.setAttribute("orderlist", olist);
		  
		  OrdersDao od=OrdersDao.getInstance(); 
		  Orders orders = new Orders();
		  orders.setC_id(c_id); 
		  orders.setO_add(c_address); 
		  orders.setO_how(how);
		  orders.setO_price(odprice*count); 
		  orders.setO_num(ordernum);
		  
		  int result=od.maxid(ordernum); 
		  System.out.println(3);
		  od.orderUpdate(orders);
		  System.out.println(4);
		  
		request.setAttribute("orders", orders);
		request.setAttribute("anum", anum);
		request.setAttribute("c_id", c_id);
		
		request.setAttribute("ods", od);
		request.setAttribute("count", count);
		return "j_ordered";
	}

}
