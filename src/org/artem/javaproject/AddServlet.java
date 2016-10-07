package org.artem.javaproject;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.artem.javaproject.dto.View;
import org.artem.javaproject.service.AddService;
import org.artem.javaproject.service.LoginService;


/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name, br;
		
		name= request.getParameter("name");
		br= request.getParameter("br");
		LoginService loginService = new LoginService();
		AddService add = new AddService();
		View view= new View();
		boolean result = add.Add_toDatabace(name, br);
		if(result){
		try {
				view = loginService.getNamefromDB();
				request.setAttribute("vieww", view);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("success.jsp");
			//RequestDispatcher dispatcher=  request.getRequestDispatcher("success.jsp");
			//dispatcher.forward(request, response);
			return;
		}
		else{
			response.sendRedirect("success.jsp");
			return;
		}
		
		
	}
	}


