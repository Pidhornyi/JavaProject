package org.artem.javaproject;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.artem.javaproject.dto.Calendar;
import org.artem.javaproject.dto.Week;
import org.artem.javaproject.service.CalendarService;

/**
 * Servlet implementation class CalendarServlet
 */
@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prof = request.getParameter("prof");
		Calendar calendar2= new Calendar(); 
		int j = calendar2.carrentDate();
		if(prof==null)prof=Integer.toString(j);;
		
		CalendarService serv = new CalendarService();
		serv.setTemp(Integer.parseInt(prof));
		
		System.out.println(Integer.parseInt(prof)  + " из сервлета ");
		
		String name, name1, date, date1;
		name= request.getParameter("name");
		
		name1=request.getParameter("name1");
		
		date=request.getParameter("date");
		date1=request.getParameter("date1");
		if(name==null){
			response.sendRedirect("week.jsp");
			return;
		}
		boolean otv = serv.Change(name, name1, date, date1);
		
		
		response.sendRedirect("week.jsp");
		return;
	}

}
