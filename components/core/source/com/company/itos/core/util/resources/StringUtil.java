/**
 * 
 */
package com.company.itos.core.util.resources;

/**
 * 
 * @author Rahul
 */
public final class StringUtil {
	
	private static final String kEscapedNewLine = "\\n";
	
	private static final String kEscapedTab = "\\t";
	
	private static final String kEscapedBackSpace = "\\b";
	
	private static final String kEscapedCarriageReturn = "\\r";
	
	private static final String kEscapedFormFeed = "\\f";
	
	private static final String kEscapedBackSlash = "\\\\";
	
	private static final char kPossibleCarriageReturn = 114;
	
	private static final char kPossibleFormFeed = 102;
	
	private static final char kPossibleNewLine = 110;
	
	private static final char kPossibleBackSpace = 98;
	
	private static final char kPossibleTab = 116;
	
	public static String rtrim(String text) {

		return rtrim(text, true);
	}
	
	public static String rtrimSpacesOnly(String text) {

		return rtrim(text, false);
	}
	
	private static String rtrim(String text, boolean lessThanSpaces) {

		if (text == null) {
			return text;
		}
		
		char[] array = text.toCharArray();
		int length = array.length;
		if (length == 0) {
			return text;
		}
		
		char c = array[(length - 1)];
		if (lessThanSpaces) {
			if ((c > ' ') || (c == '\n')) {
				return text;
			}
		} else if (c != ' ') {
			return text;
			
		}
		
		for (int i = length - 2; i >= 0; --i) {
			c = array[i];
			if (lessThanSpaces) {
				if ((c > ' ') || (c == '\n')) {
					return new String(array, 0, i + 1);
				}
			} else if (c != ' ') {
				return new String(array, 0, i + 1);
			}
		}
		
		return "";
	}
	
	/**
	 * 
	 * @param theString
	 * @return
	 */
	public static boolean isNullOrEmpty(String theString) {

		if (theString == null) {
			return true;
		}
		
		return theString.equals("");
	}
	
}
