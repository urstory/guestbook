package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/applicationcount")
public class ApplicationCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int count = 0;
		ServletContext application = request.getServletContext();
		Integer countObj 
			= (Integer)application.getAttribute("count");
		if(countObj == null){
			application.setAttribute("count", count);
			countObj 
			= (Integer)application.getAttribute("count");
		}
		countObj = new Integer(countObj.intValue() + 1);
		application.setAttribute("count", countObj);
		
		out.println(countObj);
	}

}
