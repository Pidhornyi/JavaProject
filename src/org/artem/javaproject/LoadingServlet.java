package org.artem.javaproject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.artem.javaproject.service.LoadingService;

/**
 * Servlet implementation class LoadingServlet
 */
@WebServlet("/LoadingServlet")
public class LoadingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoadingService loading = new LoadingService();
		boolean j=false;
		j=loading.manager();
		if(j==true){
			response.sendRedirect("success.jsp");
			return;
		}else response.sendRedirect("login.jsp");
		return; 
	}

}
