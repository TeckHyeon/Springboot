package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBHandler;
import db.MemberVo;

@WebServlet("/regmem")
public class RegMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// 1. 값을 받는다 
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		// 2. 처리한다
		MemberVo vo = new MemberVo(name, phone);
		DBHandler db = new DBHandler();
		db.insert(vo);
		
		// 3. 출력한다.
		String loc = "list.jsp";
		response.sendRedirect(loc);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		int mid = Integer.parseInt(request.getParameter("mid"));
		MemberVo vo = new MemberVo();
		vo.setMid(mid);
		vo.setName(name);
		vo.setPhone(phone);
		DBHandler db = new DBHandler();
		db.update(vo);
		String loc = "list.jsp";
		response.sendRedirect(loc);
	}

}
