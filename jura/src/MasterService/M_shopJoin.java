package MasterService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ShopDao;
import model.Shop;

public class M_shopJoin implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		int max = 1024 * 1024 * 10;
		String real = request.getSession().getServletContext().getRealPath("/s_img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, real, max, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String id=mr.getParameter("id");
		String name=mr.getParameter("name");
		int addnum=Integer.parseInt(mr.getParameter("addnum"));
		String address=mr.getParameter("address");
		String tel=mr.getParameter("tel");
		String j_type=mr.getParameter("j_type");
		String n_type=mr.getParameter("n_type");
		String s_del=mr.getParameter("s_del");
		
		String s_img=mr.getFilesystemName("s_img");
		
		Shop shop=new Shop();
		shop.setS_id(id);
		shop.setS_name(name);
		shop.setAdd_num(addnum);
		shop.setS_add(address);
		shop.setS_tel(tel);
		shop.setS_img(s_img);
		shop.setJ_type(j_type);
		shop.setN_type(n_type);
		shop.setS_del(s_del);
		
		ShopDao sd=ShopDao.getInstance();
		
		int result=sd.insert(shop);
		request.setAttribute("result", result);
		return "m_shopJoin";
	}

}
