/**
 * 
 */
package com.company.itos.core.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * @author vaish
 *
 */
public  class JavaUtildates {
	public static Date stringToDateConversion(String sting)
	{
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

}
