package guestbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginform")
public class GuestbookLoginformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardURL = "/WEB-INF/views/loginform.jsp";
		RequestDispatcher requestDispatcher 
			= request.getRequestDispatcher(forwardURL);
		requestDispatcher.forward(request, response);		
	}

}
