package MasterService;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MenuDao;
import dao.ShopDao;
import model.Shop;


public class M_shopListUpdate implements CommandProcess {

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
		
		String id=mr.getParameter("s_id");
		String name=mr.getParameter("s_name");
		int addnum=Integer.parseInt(mr.getParameter("addnum"));
		String address=mr.getParameter("s_address");
		String tel=mr.getParameter("s_tel");
		String s_img=mr.getFilesystemName("s_img");
		String j_type=mr.getParameter("j_type");
		String n_type=mr.getParameter("n_type");
		String s_del=mr.getParameter("s_del");
		
		File file = new File(real + "/" + s_img);
		System.out.println(s_img);
		ShopDao sd = ShopDao.getInstance();
		if (s_img == null) {
			// 기존에 저장되어있던 s_img 확인용
			String simg = sd.getS_img(id);
			System.out.println(simg);
			s_img = simg;
			/*
			 * if (simg == null || simg == "d") { s_img = "d"; }
			 */
		}

		
		Shop shop = new Shop();
		shop.setS_name(name);
		shop.setAdd_num(addnum);
		shop.setS_tel(tel);
		shop.setS_add(address);
		shop.setS_img(s_img);
		shop.setJ_type(j_type);
		shop.setN_type(n_type);
		shop.setS_del(s_del);
		shop.setS_id(id);
		
		int result=sd.update(shop);
		sd.update(shop);
		List<Shop> list=sd.slist();
		
		
		request.setAttribute("slist", list);
		request.setAttribute("result", result);	
		return "m_shopListResult";
	}

}
