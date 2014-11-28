package guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class GuestbookLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String passwordStr = request.getParameter("password");
		System.out.println("passwordStr :" + passwordStr);
		
		String adminPasswd = "1234";
		// 값을 비교할 때는 equals메소드 사용
		// == 를 사용하는 것이 아니다.
		if(adminPasswd.equals(passwordStr)){
			// 세션에 로그인 정보를 기억한다.
			// 세션에 login이라는 키에 값을 OK로 저장.
			HttpSession session = request.getSession();
			session.setAttribute("login", "OK");
			
			// /list 로 redirect
			response.sendRedirect("list");
		}else{
			response.sendRedirect("loginform?fail");
		}
		

	}

}
