package org.artem.javaproject.dto;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Calendar {
	private ArrayList<String> name;
	private ArrayList<String> br;
	private ArrayList<String> date;
	private ArrayList<String> week;
	private ArrayList<String> weekofyear;



	public String getWeekofyear(int i) {
		return weekofyear.get(i);
	}
	public void setWeekofyear(ArrayList<String> weekofyear) {
		this.weekofyear = weekofyear;
	}
	public String getName(int i) {
		return  name.get(i);
	}
	public void setName(ArrayList<String> name) {
		this.name = name;
	}
	public String getBr(int i) {
		return br.get(i);
	}
	public void setBr(ArrayList<String> br) {
		this.br = br;
	}
	
	public String getDate(int i) {
		return  date.get(i);
	}
	public void setDate(ArrayList<String> date) {
		this.date = date;
	}
	public String getWeek(int i) {
		return  week.get(i);
	}
	public void setWeek(ArrayList<String> week) {
		this.week = week;
	}
	
public int carrentDate(){
	GregorianCalendar calendarrr = new GregorianCalendar();
	int j = calendarrr.get(GregorianCalendar.WEEK_OF_YEAR);
	System.out.println(j);
	return j;
}
	
	public int size(){
		return this.name.size();
	}
}
