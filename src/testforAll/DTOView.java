package testforAll;

import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.artem.javaproject.dto.View;
import org.artem.javaproject.service.LoadingService;
public class DTOView{
	static ArrayList inumberofweek = new ArrayList();
public static void main(String args[]){
	LoadingService serv = new LoadingService();
	boolean a = serv.manager();
	GregorianCalendar calendar = new GregorianCalendar();
	System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
    SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd");
    calendar.set(2016, 4, 23);
	  inumberofweek.add(calendar.get(Calendar.WEEK_OF_YEAR));
	  System.out.println(inumberofweek.get(0));
}
}
