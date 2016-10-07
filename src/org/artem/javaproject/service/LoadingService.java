package org.artem.javaproject.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;


public class LoadingService {
	static{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loading success! LoadingService");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		
	}
	static HashMap<String,Integer> map = new HashMap<String,Integer>();
	static Connection con;
	static ArrayList iname = new ArrayList();
	static ArrayList idate = new ArrayList();
	static ArrayList ibr = new ArrayList();
	static ArrayList iweek = new ArrayList();
	static ArrayList inumberofweek = new ArrayList();
	static String url = "jdbc:mysql://localhost/work?characterEncoding=utf8";
	static String name = "root";
	static String password = "qwerty";
	public static void GetFromWor(){
		
			ResultSet rs;
			String name1;
			int br;
			try {
				con = DriverManager.getConnection(url, name, password);
				System.out.println("Connected. LoadingService GetFromWor ");
				Statement stt = con.createStatement();
				//worker
				String query = "select * from test";
				 rs = stt.executeQuery(query);
				 while (rs.next()) {
						name1 = rs.getString("name");
						br = rs.getInt("br");
						map.put(name1, br);
						
				
			            }	
				 //
				  System.out.println("Disconnected. LoadingService GetFromWor");
				  con.close();
			    } catch (SQLException e) {
				  e.printStackTrace();
			      }
		
	}
	public boolean manager(){
		LoadingService.GetFromWor();
		
		Calendar calendar = new GregorianCalendar(1975,4, 31);
	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd");
	    
	    Iterator<HashMap.Entry<String, Integer>> iteratorr = map.entrySet().iterator();
	    while (iteratorr.hasNext())
	    {
	    	int daywork = 0;
	    	int dayweek=0;
	    	int daywork1 = 0;
	    	int dayweek1=0;
	    	calendar.set(2016, 4, 22);
	        //получение «пары» элементов
	        HashMap.Entry<String, Integer> pair = iteratorr.next();
	        String key = pair.getKey();            //ключ имя
	        int value = pair.getValue();        //значение бригада
	       
	        ///
	        if(value==1 || value==2){
	        	
	    	//цикл добавления на 365 дней
	    	   for(int i =1; i<365;i++){
	    	     calendar.add(Calendar.DAY_OF_YEAR, 1);
	    	
	    	     if(daywork<=7 && dayweek==0){
	    	
	    	      
	    	       //LoadingService.RT(format1.format(calendar.getTime()),key,value,calendar.get(Calendar.DAY_OF_WEEK));
	    	       iname.add(key);
	    	       ibr.add(value);
	    	       idate.add(format1.format(calendar.getTime()));
	    	       iweek.add(calendar.get(Calendar.DAY_OF_WEEK));
	    	       inumberofweek.add(calendar.get(Calendar.WEEK_OF_YEAR));
	    	       
	    	       }
	    	      daywork++;
	    	      if(dayweek==7){daywork=0; dayweek=0;}
	    	      if(daywork>=7){ dayweek++;}
	    	   }
	        }
	        ///
	        if(value==3 || value==4){
	        	calendar.set(2016, 4, 29);
	        	
	    	//цикл добавления на 365 дней
	    	for(int i =1; i<365;i++){
	    	   calendar.add(Calendar.DAY_OF_YEAR, 1);
	    	   if(daywork1<=7 && dayweek1==0){
	      	    
	    	    // LoadingService.RT(format1.format(calendar.getTime()),key,value,calendar.get(Calendar.DAY_OF_WEEK));
	    	     
	    	       iname.add(key);
	    	       ibr.add(value);
	    	       idate.add(format1.format(calendar.getTime()));
	    	       iweek.add(calendar.get(Calendar.DAY_OF_WEEK));
	    	       inumberofweek.add(calendar.get(Calendar.WEEK_OF_YEAR));
	    	       
	    	   }
	    	   daywork1++;
	    	   if(dayweek1==7){daywork1=0; dayweek1=0;}
	    	   if(daywork1>=7){ dayweek1++;}
	    	   }
	        }	  
	      
	        }
	    
	      try{  LoadingService.RT();
	    System.out.println("Disconnected. LoadingService manager");
		con.close();
		}	      
	    catch (SQLException e) {
		e.printStackTrace();
	}
		
		return true;
	}

	// метод для записи в базу данных
	public static void RT (){
		Connection con;
		int a =1;
	    String qr; 
        String deletebr1 =("delete from graphics where br='1'");
        String deletebr2 =("delete from graphics where br='2'");
        String deletebr3 =("delete from graphics where br='3'");
        String deletebr4 =("delete from graphics where br='4'");
		
		
		try {
			con = DriverManager.getConnection(url, name, password);
		  
			System.out.println("Connected. RT" );
			Statement st = con.createStatement();
			
		    
			st.execute(deletebr1);
			st.execute(deletebr2);
			st.execute(deletebr3);
			st.execute(deletebr4);
			
			for(int i=0; i<iname.size();i++){
				qr=("INSERT INTO graphics (name, br, date, dayofweek, weekof) VALUES( '" + iname.get(i) + "', " +"'" +ibr.get(i) +"' , '"+ idate.get(i) + "','"+ iweek.get(i) +"','" + inumberofweek.get(i)+"')");
				st.addBatch(qr);
				
			}
			st.executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
