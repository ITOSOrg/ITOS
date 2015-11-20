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

<form name="Create Address" action="/ITOS/CreateAddress?relatedID=<%= relatedID %>"
		method="POST">
		<table>
		<tr>
				<td>StreetOne:</td>
				<td><input type="text" name="streetOne" maxlength="50"></td>
			</tr>
			
			<tr>
				<td>StreetTwo:</td>
				<td><input type="text" name="streetTwo" maxlength="50"></td>
			</tr>
			
			<tr>
				<td>AptUnit:</td>
				<td><input type="text" name="aptUnit" maxlength="20"></td>
			</tr>
			
			<tr>
				<td>City:</td>
				<td><input type="text" name="city"></td>
			</tr>
			
			<tr>
				<td>County:</td>
				<td><input type="text" name="county"></td>
			</tr>
			
			<tr>
				<td>State:</td>
				<td><input type="text" name="state"></td>
			</tr>
			
			<tr>
				<td>Country</td>
				<td><input type="text" name="country"></td>
			</tr>
			
			<tr>
				<td>ZipCode:</td>
				<td><input type="text" name="zipCode"></td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><input type="text" name="typeCode"></td>
			</tr>
			<tr>
				<td>PrimaryInd :</td>
				<td><input type="text" name="primaryInd"></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input type="text" name="startDate"></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="text" name="endDate"></td>
			</tr> 
			<tr>

				<td><input  type="submit" value="Submit">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/ITOS/ListAddress?relatedID=<%= relatedID %>">AddressList Home</a></td>

			</tr>
		</table>
</body>
</html>