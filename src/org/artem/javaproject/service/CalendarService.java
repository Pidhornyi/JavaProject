package org.artem.javaproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.artem.javaproject.dto.Calendar;
import org.artem.javaproject.dto.Week;

public class CalendarService {
	private GregorianCalendar date;
	
	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	public Calendar getFromDB(int weekk)throws SQLException{
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd");
		Calendar calendar = new Calendar();
		GregorianCalendar calendarG = new GregorianCalendar(1975,4, 31);
		format1.format(calendarG.getTime());

	Connection con;	

	// загрузка драйвера
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loading success! CalendarService");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			//	
				String url = "jdbc:mysql://localhost/work?characterEncoding=utf8";
				String login = "root";
				String password = "qwerty";
				ResultSet rs = null;
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> br = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> week = new ArrayList<String>();
		ArrayList<String> weekofyear = new ArrayList<String>();
		
		try {
			con = DriverManager.getConnection(url, login, password);
			System.out.println("Connected. CalendarService");
			Statement stt = con.createStatement();
			//worker
			String query = "select * from graphics where weekof='" +weekk + "' order by date";
			 rs = stt.executeQuery(query);
			 while (rs.next()) {
				 name.add(rs.getString("name"));
				 br.add(rs.getString("br"));
				 date.add(rs.getString("date"));
				 week.add(rs.getString("dayofweek"));
				 weekofyear.add(rs.getString("weekof"));
			
		}	
			 //
			System.out.println("Disconnected. CalendarService");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		calendar.setName(name);
		calendar.setBr(br);
		calendar.setDate(date);
		calendar.setWeek(week);
		calendar.setWeekofyear(weekofyear);
	
	return calendar;
	
	
	
	}
	
	public Calendar getFromDB2(int weekk)throws SQLException{
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd");
		Calendar calendar = new Calendar();
		GregorianCalendar calendarG = new GregorianCalendar(1975,4, 31);
		format1.format(calendarG.getTime());
		
		
		
		
	Connection con;	

	// загрузка драйвера
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Driver loading success! CalendarService");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			//	
				String url = "jdbc:mysql://localhost/work?characterEncoding=utf8";
				String login = "root";
				String password = "qwerty";
				ResultSet rs = null;
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> br = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> week = new ArrayList<String>();
		ArrayList<String> weekofyear = new ArrayList<String>();
		
		try {
			con = DriverManager.getConnection(url, login, password);
			System.out.println("Connected. CalendarService");
			Statement stt = con.createStatement();
			//worker
			String query = "select * from graphics where weekof='" +weekk + "'";
			 rs = stt.executeQuery(query);
			 while (rs.next()) {
				 name.add(rs.getString("name"));
				 br.add(rs.getString("br"));
				 date.add(rs.getString("date"));
				 week.add(rs.getString("dayofweek"));
				 weekofyear.add(rs.getString("weekof"));
			
		}	
			 //
			System.out.println("Disconnected. CalendarService");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		calendar.setName(name);
		calendar.setBr(br);
		calendar.setDate(date);
		calendar.setWeek(week);
		calendar.setWeekofyear(weekofyear);
	
	return calendar;
	
	
	
	}
	
	public boolean setTemp(int temp){
		//Week week = new Week();
		Connection con;	

		// загрузка драйвера
					try {
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("Driver loading success! CalendarService setTemp");
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					String url = "jdbc:mysql://localhost/work?characterEncoding=utf8";
					String login = "root";
					String password = "qwerty";
					
					try {
						con = DriverManager.getConnection(url, login, password);
						System.out.println("Connected. CalendarService setTemp");
						Statement tt = con.createStatement();
						//worker
						String query0="truncate table temp";
						tt.executeUpdate(query0);
						
						
						String query = "insert into temp (temp) values ('"+temp+"')";
						 tt.executeUpdate(query);
						 //week.setJ2(temp);
						
					}	catch (SQLException e) {
						e.printStackTrace();
					}
		return true;
	}
	
	public String getTemp(){
		Week week = new Week();
		Connection con;	
		String temp=null;
		// загрузка драйвера
					try {
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("Driver loading success! CalendarService getTemp");
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					String url = "jdbc:mysql://localhost/work?characterEncoding=utf8";
					String login = "root";
					String password = "qwerty";
					ResultSet rs;
					
					try {
						con = DriverManager.getConnection(url, login, password);
						System.out.println("Connected. CalendarService getTemp");
						Statement tt = con.createStatement();
						//worker
						String query = "select * from temp";
						
						rs= tt.executeQuery(query);
						while (rs.next()) {
							temp = rs.getString("temp");
							
							week.setJ2(Integer.parseInt(temp));
				            }
						
						
						 
						
					}	catch (SQLException e) {
						e.printStackTrace();
					}
		return temp;
		
	}
	
	public boolean Change(String name, String name1,String date, String date1){
		String nameC =name;
		String name1C=name1;
		String dateC=date;
		String date1C=date1;
		
		Connection con;	
		Statement tt;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loading success! CalendarService Change");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost/work?characterEncoding=utf8";
		String login = "root";
		String password = "qwerty";
		ResultSet rs;
		
		try {
			con = DriverManager.getConnection(url, login, password);
			System.out.println("Connected. CalendarService Change");
			 tt = con.createStatement();
		}
			catch (SQLException e) {
				e.printStackTrace();
			}

			//copy 1
			try {
				
				con = DriverManager.getConnection(url, login, password);
				System.out.println("Connected. CalendarService Change");
				tt = con.createStatement();
			// past1
				
			String setQuery = "update graphics set name='"+name1C+"' where name='"+nameC+"' and date='"+dateC+"'";
			tt.execute(setQuery);
			//past2
			String setQuery1 = "update graphics set name='"+nameC+"' where name='"+name1C+"' and date='"+date1C+"'";
			tt.execute(setQuery1);
			con.close();
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		
			
		
		
		return true;
	}
}
