<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String relatedID = (String) request.getParameter("relatedID");
System.out.println("relatedID = " + relatedID);

%>
<form name="Create Phone Number" action="/ITOS/CreatePhoneNumber?relatedID=<%= relatedID %>"
		method="POST">
		<table>
		
		<tr>
		<td> Country Code:</td>
		<td><input type="text" name="countryCode"></td>
		</tr>
		<tr>
		<td> Area Code:</td>
		<td><input type="text" name="areaCode"></td>
		</tr>
		<tr>
		<td>Phone Number:</td>
		<td><input type="text" name="phoneNumber"></td>
		</tr>
		<tr>
		<td> Extension:</td>
		<td><input type="text" name="extension"></td>
		</tr>
		<tr>
		<td> Type Code:</td>
		<td><input type="text" name="typeCode"></td>
		</tr>
		<tr>
		<td> PrimaryInd:</td>
		<td><input type="text" name="primaryInd"></td>
		</tr>
		<tr>
		<td> Start Date:</td>
		<td><input type="text" name="startDate"></td>
		</tr>
		
		<tr>
		<td> End Date:</td>
		<td><input type="text" name="endDate"></td>
		</tr>
		<tr>
		<td><input  type="submit" value="Submit"></td>
		</tr>
		</table>
		</form>
</body>
</html>