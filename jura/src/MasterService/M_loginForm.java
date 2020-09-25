package MasterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class M_loginForm implements CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		return "m_loginForm";
	}

}
