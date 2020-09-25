package MasterService;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MenuDao;
import model.Menu;

import java.io.File;
import java.io.IOException;

import javax.activation.*;

public class M_menuUpdate implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		int max = 1024 * 1024 * 10;
		String real = request.getSession().getServletContext().getRealPath("/m_img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(request, real, max, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}

		String d = mr.getParameter("action");
		d = d.substring(2);
		int aa = Integer.parseInt(d);
		System.out.println(aa);
		int rec_menu = Integer.parseInt(mr.getParameter("rec_menu"));

		int m_num = Integer.parseInt(mr.getParameter("m_num" + aa));
		String s_id = mr.getParameter("s_id" + aa);
		String m_name = mr.getParameter("m_name" + aa);
		int m_price = Integer.parseInt(mr.getParameter("m_price" + aa));

		String m_img = mr.getFilesystemName("m_img" + aa);
		
		MenuDao md = MenuDao.getInstance();
		if (m_img == null) {
			String mimg = md.getImg(m_num);
			m_img = mimg;
			if (mimg == null || mimg == "d") {
				m_img = "d";
			}
		}


		File file = new File(real + "/" + m_img);

		// String m_img = request.getParameter("m_img" + aa);

		Menu menu = new Menu();
		menu.setM_num(m_num);
		menu.setS_id(s_id);
		menu.setM_name(m_name);
		menu.setM_price(m_price);
		menu.setM_img(m_img);
		menu.setRec_menu("n");
		
		if (rec_menu == aa) {
			int ycount = md.mgetRecCount(s_id);
			menu.setRec_menu("y");
			if (ycount !=0) {
				menu.setRec_menu("y");
				int recnum = md.mgetRecMenu(s_id);
				int r = md.deleteRecMenu(recnum);
			}
		}

		int result = md.update(menu);

		// int result=md.updateRec(m_num);
		// md.update(menu);

		List<Menu> list = md.list(s_id);

		request.setAttribute("list", list);
		request.setAttribute("result", result);
		request.setAttribute("s_id", s_id);

		return "m_menuResult";
	}

}
