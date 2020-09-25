package MasterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class M_insertForm implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String s_id = request.getParameter("s_id");
		
		request.setAttribute("s_id", s_id);
		
		return "m_insertForm";
	}

}
