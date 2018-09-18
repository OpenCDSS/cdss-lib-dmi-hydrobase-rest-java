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

/**
 * This class assits in converting a string to either DateTime or LocalDateTime Object.
 * @author jurentie
 *
 */
public class TimeToolkit {
	
	/**
	 * TimeToolkit used for lazy initialization of a singleton class
	 */
	private static TimeToolkit instance;
	
	public TimeToolkit(){}
	
	/**
	 * Lazy initialization of a singleton class instance
	 * @return instance of TimeToolkit class.
	 */
	public static TimeToolkit getInstance(){
		if(instance == null){
			instance = new TimeToolkit();
		}
		return instance;
	}
	
	//TODO @jurentie not handling time zone 09-08-2018
	/**
	 * Converts a string to DateTime object. 
	 * @param s - date in String format.
	 * @param zoned - if True there is a time zone extension on the end of the date string.
	 * If False there is no time zone extension.
	 * @return DateTime object 
	 */
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
	
	//TODO @jurentie could combine the following two methods into a single
	// method with boolean, similar to toDateTime above. 09-18-2018
	/**
	 * Converts a string with time zone extension to LocalDateTime object
	 * @param s- String format of a date.
	 * @return LocalDateTime object
	 */
	public LocalDateTime timeZonedToLocalDateTime(String s){
		return ZonedDateTime.parse(s, DateTimeFormatter.ISO_DATE_TIME).toLocalDateTime();
	}
	
	/**
	 * Converts a string with no time zone extension to LocalDateTime object
	 * @param s - String format of a date.
	 * @return LocalDateTime object.
	 */
	public LocalDateTime toLocalDateTime(String s){
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
