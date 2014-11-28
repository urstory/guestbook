package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessioncount")
public class SessionCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int count = 0;
		HttpSession session = request.getSession();
		Integer countObj 
			= (Integer)session.getAttribute("count");
		if(countObj == null){
			session.setAttribute("count", count);
			countObj 
			= (Integer)session.getAttribute("count");
		}
		countObj = new Integer(countObj.intValue() + 1);
		session.setAttribute("count", countObj);
		
		out.println(countObj);
	}

}
