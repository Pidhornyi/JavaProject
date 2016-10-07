package org.artem.javaproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteService {
	private Connection con;
	private String url = "jdbc:mysql://localhost/work?characterEncoding=utf8";
	private	String name = "root";
	private	String password = "qwerty";
	
public boolean Dell_toDatabace(String namee){
	String query = "delete from test where name='" + namee + "'";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("Driver loading success! DeleteService Dell_toDatabace ");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	try {
		con = DriverManager.getConnection(url, name, password);
		System.out.println("Connected. DeleteService Dell_toDatabace");
		Statement st = con.createStatement();
		st.executeUpdate(query);
		System.out.println("Disconnected. DeleteService Dell_toDatabace");
		con.close();
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}
}
