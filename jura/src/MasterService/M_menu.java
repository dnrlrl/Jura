package MasterService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenuDao;
import dao.ShopDao;
import model.Menu;
import model.Shop;

public class M_menu implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String sid=request.getParameter("s_id");
		request.setAttribute("sid", sid);
		
		
		ShopDao sd = ShopDao.getInstance();
		
		Shop shop = sd.select(sid);
		
		MenuDao md=MenuDao.getInstance();
		List<Menu> list=md.list(sid);
		request.setAttribute("list", list);
		//Menu m=list.get(0);
		request.setAttribute("shop", shop);
		return "m_menu";
	}

}
