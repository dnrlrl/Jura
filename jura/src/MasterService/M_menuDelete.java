package MasterService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenuDao;
public class M_menuDelete implements CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		int m_num = Integer.parseInt(request.getParameter("m_num"));
		String s_id=request.getParameter("s_id");
		
		System.out.println("s_id = "+s_id);
		
		MenuDao md = MenuDao.getInstance();
		int result  = md.delete(m_num);
		request.setAttribute("result", result);
		request.setAttribute("s_id", s_id);
		return "m_menuDelete";
	}
}