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
String personID = (String) request.getParameter("personID");
System.out.println("personID = " + personID);

%>
<form name="Create Person Identity" action="/ITOS/CreatePersonIdentity?personID=<%= personID %>"
		method="POST">
		<table>
		  
			<tr>
				<td>AlternateID :</td>
				<td><input type="text" name="alternateID"></td>
			</tr>
			<tr>
				<td>PrimaryInd :</td>
				<td><input type="text" name="primaryInd"></td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><input type="text" name="typeCode"></td>
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
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/ITOS/ListPersonIdentity?personID=<%= personID %>">PersonIdentityList Home</a></td>

			</tr>
			
		
		</table>
		</form>

</body>
</html>