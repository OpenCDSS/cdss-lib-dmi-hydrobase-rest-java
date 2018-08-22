package cdss.dmi.hydrobase.rest.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import RTi.Util.Time.DateTime;

public class TimeToolkit {
	
	private static TimeToolkit instance;
	
	public TimeToolkit(){}
	
	//Lazy initialization of a singleton class instance
	public static TimeToolkit getInstance(){
		if(instance == null){
			instance = new TimeToolkit();
		}
		return instance;
	}
	
	//TODO @jurentie not handling time zone
	public DateTime toDateTime(String s, boolean zoned){
		if(s == null || s == "" || s == "N/A") return null;
		LocalDateTime ldt;
		if(zoned) ldt = timeZonedToLocalDateTime(s);
		else ldt = toLocalDateTime(s);
		if(ldt == null) return null;
		DateTime date = new DateTime(DateTime.PRECISION_SECOND);
		date.setYear(ldt.getYear());
		date.setMonth(ldt.getMonthValue());
		date.setDay(ldt.getDayOfMonth());
		date.setHour(ldt.getHour());
		date.setMinute(ldt.getMinute());
		date.setSecond(ldt.getSecond());
		return date;
	}
	
	public LocalDateTime timeZonedToLocalDateTime(String s){
		return ZonedDateTime.parse(s, DateTimeFormatter.ISO_DATE_TIME).toLocalDateTime();
	}
	
	public LocalDateTime toLocalDateTime(String s){
		//System.out.println("[TimeToolkit.toLocalDateTime:49] parsed: " + LocalDateTime.parse(s));
		LocalDateTime ldt;
		try{
			ldt = LocalDateTime.parse(s);
		}
		catch(Exception e){
			return null;
		}
		return ldt;
	}

}
