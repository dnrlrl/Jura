package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AddressDao;
import dao.MenuDao;
import dao.OrderListDao;
import dao.OrdersDao;
import dao.ShopDao;
import model.Menu;
import model.Order_list;
import model.Orders;
import model.Shop;

public class J_orderPage implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//주라타입 노멀타입 정해서 가게 가져오기
		
		String jtype=request.getParameter("jtype");
		int anum=Integer.parseInt(request.getParameter("anum"));
		
		String path = request.getContextPath();
		
		ShopDao sd=ShopDao.getInstance();
		List<Shop> list;
		if(jtype.equals("all")) {
			list=sd.alljuralist(anum);
		}
		else
			list=sd.juralist(jtype,anum);
		int size=list.size();
		int ranlist=(int) (Math.random()*(size));
		Shop shop=list.get(ranlist);
		
		//주문 테이블 생성하기
		HttpSession session= request.getSession();
		String c_id=(String)session.getAttribute("id");
		OrdersDao od=OrdersDao.getInstance();
		Orders or=new Orders(); // orders 
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
		//String s_id = request.getParameter("s_id");
		OrderListDao olid=OrderListDao.getInstancee();
		Order_list oli=new Order_list();// order_list
		String sid=shop.getS_id();
		int menuNum=md.getRecMenu(sid);
		Menu menu=md.getRecMenuinfo(menuNum);
		
		oli.setO_num(ordernum);
		oli.setS_id(sid);
		oli.setM_num(menu.getM_num());
		oli.setOlm_name(menu.getM_name());
		oli.setCount(1);
		oli.setOl_price(menu.getM_price());
		olid.insert(oli);
		
		List<Order_list> olist=olid.olist(ordernum);
		request.setAttribute("orderlist", olist);
		request.setAttribute("ol_price", menu.getM_price());
		request.setAttribute("c_id", c_id);
		request.setAttribute("ordernum", ordernum);
		//List<Orders> oders= od.getCusOrd(c_id);.
		
		
		request.setAttribute("path", path);
		request.setAttribute("m_img", menu.getM_img());
		request.setAttribute("anum", anum);
		AddressDao ad=AddressDao.getInstance();
		String cadd=ad.address(anum);
		request.setAttribute("cadd", cadd);
		return "j_orderPage";
	}

}
