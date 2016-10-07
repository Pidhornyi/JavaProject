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
import org.artem.javaproject.service.DeleteService;
import org.artem.javaproject.service.LoginService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name;
		
		name= request.getParameter("name");
	
		LoginService loginService = new LoginService();
		View view= new View();
		DeleteService add = new DeleteService();
		boolean result = add.Dell_toDatabace(name);
		if(result){
			//RequestDispatcher dispatcher=  request.getRequestDispatcher("success.jsp");
			//dispatcher.forward(request, response);
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


