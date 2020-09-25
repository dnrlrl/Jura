package MasterService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShopDao;
import model.Shop;


public class M_ShopList implements CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		ShopDao sd = ShopDao.getInstance();
		List<Shop> slist = sd.slist();
		request.setAttribute("slist", slist);
		return "m_shopList";
	}

}
