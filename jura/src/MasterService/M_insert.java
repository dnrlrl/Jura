package MasterService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MenuDao;
import model.Menu;

public class M_insert implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		int max = 1024 * 1024 * 10;
		String real = request.getSession().getServletContext().getRealPath("/m_img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, real, max, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int m_num=Integer.parseInt(mr.getParameter("m_num"));
		String s_id=mr.getParameter("s_id");
		String m_name=mr.getParameter("m_name");
		int m_price=Integer.parseInt(mr.getParameter("m_price"));
		String rec_menu=mr.getParameter("rec_menu");

		String m_img=mr.getFilesystemName("m_img");
		
		if (m_img == null) {
			m_img = "d";
		}
		
		Menu menu = new Menu();
		menu.setS_id(s_id);
		menu.setM_name(m_name);
		menu.setM_price(m_price);
		menu.setM_img(m_img);
		menu.setRec_menu(rec_menu);
		
		MenuDao md=MenuDao.getInstance();
		
		int result=md.insert(menu);
		request.setAttribute("result", result);
		request.setAttribute("s_id", s_id);
		
		return "m_insert";
	}

}
