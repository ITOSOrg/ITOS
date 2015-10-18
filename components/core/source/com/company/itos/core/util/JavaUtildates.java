/**
 * 
 */
package com.company.itos.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author vaish
 *
 */
public class JavaUtildates {
	public static Date stringToDateConversion(String sting) {
		java.util.Date date;
		java.sql.Date sqlDate = null;
		try {
			date = new SimpleDateFormat("MM-dd-yyyy").parse(sting);
			sqlDate = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return sqlDate;

	}

	/**
	 * 
	 * @return
	 */
	public static String getCurrentDateTime() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// get current date time with Date()
		Date date = new Date();
		String crrentDateTime = dateFormat.format(date);
		System.out.println(crrentDateTime);

		/*
		 * //get current date time with Calendar() Calendar cal =
		 * Calendar.getInstance();
		 * System.out.println(dateFormat.format(cal.getTime()));
		 */
		return crrentDateTime;
	}

}
