package org.artem.javaproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddService {
	private Connection con;
	private String url = "jdbc:mysql://localhost/work?characterEncoding=utf8";
	private	String name = "root";
	private	String password = "qwerty";
	
public boolean Add_toDatabace(String namee, String br){
	String query = "insert into test(name,br) values ('" + namee + "','" + br + "')";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("Driver loading success! AddService");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	try {
		con = DriverManager.getConnection(url, name, password);
		System.out.println("Connected AddService.");
		Statement st = con.createStatement();
		st.executeUpdate(query);
		System.out.println("Disconnected AddService.");
		con.close();
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}
	
	
}

