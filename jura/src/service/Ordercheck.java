package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MenuDao;
import dao.OrderListDao;
import dao.OrdersDao;
import dao.ShopDao;
import model.Orders;
import model.Shop;
import model.Simg;

public class Ordercheck implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		OrdersDao od = OrdersDao.getInstance();
		List<Orders> olist = od.getCusOrd(id);
		int si = olist.size();
		if(si==0) {
		  request.setAttribute("list",olist);
		  return "ordercheck";
		}
		// s_id 찾아 삼매경
		int size = olist.size();
		List<Integer> nlist = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			Orders order = olist.get(i);
			nlist.add(order.getO_num());
		}
		OrderListDao old = OrderListDao.getInstancee();
		List<String> slist = old.getSid(nlist);
		
		ShopDao sd=ShopDao.getInstance();
		List<Shop> imglist=sd.getSimg(slist);
		List<Simg> imlist = new ArrayList<Simg>();
		for(int i=0;i<slist.size();i++) {
			Simg as=new Simg();
			as.setO_num(nlist.get(i));
			as.setS_id(imglist.get(i).getS_id());
			as.setS_img(imglist.get(i).getS_img());
			imlist.add(as);
		}
		request.setAttribute("list", olist);
		request.setAttribute("imlist", imlist);
		//request.setAttribute("imglist", imglist);
		String path = request.getContextPath();
		request.setAttribute("path", path);
		return "ordercheck";
	}

}
