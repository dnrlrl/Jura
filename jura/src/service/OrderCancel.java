package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenuDao;
import dao.OrderListDao;
import dao.OrdersDao;
import dao.ShopDao;
import model.Menu;

public class OrderCancel implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		int onum=Integer.parseInt(request.getParameter("ordernum"));
		OrdersDao od=OrdersDao.getInstance();
		OrderListDao old=OrderListDao.getInstancee();
		int r= old.cancelorder(onum);
		int result=od.cancelorder2(onum);
		String sid=request.getParameter("s_id");
		ShopDao sd=ShopDao.getInstance();
		String sadd=sd.address(sid);
		MenuDao md=MenuDao.getInstance();
		List<Menu> list=md.list(sid);
		
		int anum=Integer.parseInt(request.getParameter("anum"));
		request.setAttribute("sid", sid);
		request.setAttribute("list", list);
		request.setAttribute("sadd", sadd);
		request.setAttribute("anum", anum);
		return "c_menu";
	}

}
