package guestbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터로 pg를 읽어들인다.
		String strpg = request.getParameter("pg");
		System.out.println("pg :" + strpg);
		int ipg = 1;
		try{
			ipg = Integer.parseInt(strpg); // 형변환
		}catch(Exception e){}
		// pg가 전달되지 않으면 1로 초기화한다
		
		// 데이터베이스에서 pg에 해당하는 목록을 읽어온다.
		
		GuestbookDAO dao = new GuestbookDAO();
		int count = dao.getGuestbookCount();
		// 만약 5개씩 보여준다면 전체 몇 페이지일까?
		int limit = 5;
		int pageCount = count / limit;
		if(count % limit > 0) pageCount++;
		List<Guestbook> list = dao.getGuestbook(ipg);
				
		request.setAttribute("list",list);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", pageCount);
		// 그 결과를 jsp에게 전달한다.
		// /WEB-INF/views/list.jsp 포워딩.
		// 반드시 / 로 시작!!
		String forwardURL = "/WEB-INF/views/list.jsp";
		RequestDispatcher requestDispatcher 
			= request.getRequestDispatcher(forwardURL);
		requestDispatcher.forward(request, response);
	}

}
