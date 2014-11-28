package guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")
public class GuestbookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		System.out.println("idStr :" + idStr);
		long id = Long.parseLong(idStr);
		
		
		//세션에 로그인 정보가 있는지 살펴보고
		// 있을 경우에만 id에 해당하는 글을 삭제한다.
		// ctrl + shift + o (영어 오) : 자동 import
		HttpSession session = 
				request.getSession();
		String loginValue =
				(String)session.getAttribute("login");
		if("OK".equals(loginValue)){
			GuestbookDAO dao = new GuestbookDAO();
			dao.deleteGuestbook(id);
		}
		
		response.sendRedirect("list");
	}

	
}
