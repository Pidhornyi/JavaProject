package org.artem.javaproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.artem.javaproject.dto.User;
import org.artem.javaproject.dto.View;

public class LoginService {
	HashMap<String,String> users = new HashMap<String,String>();
	
	public LoginService(){
		users.put("johndoe", "John Doe");
		users.put("janedoe", "Jane Doe");
		users.put("jguru", "Java Guru");
		users.put("qwerty", "Artem");
		
		
	}
	
	public boolean authenticate(String userId, String password){
		if(password ==null || password.trim() == ""){
			return false;
		}
		else if (userId.equals("q")&& password.equals("1"))return true;
		else if (userId.equals("admin")&& password.equals("71093442"))return true;
		else return false;
	}
	
	public User getUserDetais(String userId){
		User user = new User();
		user.setUserName(users.get(userId));
		user.setUserId(userId);
		return user ;
	}
	
	
	//name
	public View getNamefromDB()throws SQLException{
		View view = new View();
	
		Connection con;		
		HashMap<String,Integer> st = new HashMap<String,Integer>();
		// загрузка драйвера
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver loading success!");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		//	
			String url = "jdbc:mysql://localhost/work?characterEncoding=utf8";
			String name = "root";
			String password = "qwerty";
			ResultSet rs = null;
			String name1 = null;
			int br;
			ArrayList name11 = new ArrayList();
			ArrayList br1 = new ArrayList();
			
			try {
				con = DriverManager.getConnection(url, name, password);
				System.out.println("Connected.");
				Statement stt = con.createStatement();
				//worker
				String query = "select * from test ORDER BY br";
				 rs = stt.executeQuery(query);
				 while (rs.next()) {
					 name11.add(rs.getString("name"));
					 br1.add(rs.getString("br"));
						 
						//st.put(name, br);
						//System.out.println("Name : " + name11 + " BR = " +  br1);
						
				
			}	
				 //
				System.out.println("Disconnected.");
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			view.setName(name11);
			view.setBr(br1);
		
		return view;
	}

}
