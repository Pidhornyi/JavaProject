package org.artem.javaproject.dto;

import java.util.GregorianCalendar;

public class TempWeekCalendar {

	public int carrentDate(){
		GregorianCalendar calendarrr = new GregorianCalendar();
		int j = calendarrr.get(GregorianCalendar.WEEK_OF_YEAR);
		return j;
	}
}
