package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AddressDao;
import dao.MenuDao;
import dao.OrderListDao;
import dao.OrdersDao;
import model.Menu;
import model.Order_list;
import model.Orders;

public class N_orderPage implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session= request.getSession();
		String c_id=(String)session.getAttribute("id");
		OrdersDao od=OrdersDao.getInstance();
		Orders or=new Orders(); // orders 
		String path = request.getContextPath();
		MenuDao md=MenuDao.getInstance();
		or.setC_id(c_id);
		int ordernum;
		int ck=od.ckdata();
		if(ck==0) {
			ordernum=1;
		}
		else {
			ordernum=od.maxid()+1;
		}
		or.setO_num(ordernum);
		od.insert(or);
		String s_id = request.getParameter("s_id");
		
		OrderListDao olid=OrderListDao.getInstancee();
		Order_list oli=new Order_list();// order_list
		int size=Integer.parseInt(request.getParameter("size"));
		int p=0;
		for(int i=0;i<size;i++) {
			int f=Integer.parseInt(request.getParameter("a"+i));
			if(f!=0) {
				int m_price= Integer.parseInt(request.getParameter("price"+i));
				p+=f*m_price;
				oli.setO_num(ordernum);
				//System.out.println(ordernum);
				oli.setS_id(s_id);
				int m_num= Integer.parseInt(request.getParameter("mn"+i));
				oli.setM_num(m_num);
				String olm_name= request.getParameter("name"+i);
				oli.setOlm_name(olm_name);
				oli.setCount(f);
				int ol_price=Integer.parseInt(request.getParameter("price"+i));
				oli.setOl_price(ol_price);
				olid.insert(oli);
			}
		}
		
		
		List<Order_list> olist=olid.olist(ordernum);
		request.setAttribute("s_id", s_id);
		request.setAttribute("orderlist", olist);
		request.setAttribute("ol_price", p);
		request.setAttribute("c_id", c_id);
		request.setAttribute("ordernum", ordernum);
		int anum=Integer.parseInt(request.getParameter("anum"));
		request.setAttribute("anum", anum);
		AddressDao ad=AddressDao.getInstance();
		String cadd=ad.address(anum);
		request.setAttribute("cadd", cadd);
		// 주소 넘버값말고 옵션 값
		return "n_orderPage";
	}
	}



