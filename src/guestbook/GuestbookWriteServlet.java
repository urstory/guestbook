package guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class GuestbookWriteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //name="name"
		 //name="content"
		request.setCharacterEncoding("utf-8");
		String nameStr = request.getParameter("name");
		String contentStr = request.getParameter("content");
		String ip = request.getRemoteAddr();
		System.out.println("name :" + nameStr);
		System.out.println("content :" + contentStr);
		System.out.println("ip :" + ip);
		// database에 저장
		Guestbook guestbook = new Guestbook();
		guestbook.setName(nameStr);
		guestbook.setContent(contentStr);
		guestbook.setIp(ip);
		GuestbookDAO dao = new GuestbookDAO();
		dao.addGuestbook(guestbook);
		
		// /list 로 redirect
		response.sendRedirect("list");
	}

}
