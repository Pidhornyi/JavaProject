package org.artem.javaproject;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.artem.javaproject.dto.User;
import org.artem.javaproject.dto.View;
import org.artem.javaproject.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId, password;
		
		//if(request.getParameter("userId")=="" && request.getParameter("password")==""){response.sendRedirect("login.jsp");}
		
		userId= request.getParameter("userId");
		password= request.getParameter("password");
		HttpSession session = request.getSession();
		
		LoginService loginService = new LoginService();
		View view= new View();
		boolean result = loginService.authenticate(userId, password);
		if(result){
			User user = loginService.getUserDetais(userId);
			request.setAttribute("user", user);
			//
				try {
					view = loginService.getNamefromDB();
					request.setAttribute("view", view);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("savedUserName", userId );
			//
			
			//RequestDispatcher dispatcher=  request.getRequestDispatcher("success.jsp");
			//dispatcher.forward(request, response);
			
			response.sendRedirect("calendar.jsp");
			return;
		}
		else{
			response.sendRedirect("login.jsp");
			return;
		}
		
		
	}

}
