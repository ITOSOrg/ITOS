<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="Create Email Address" action="/ITOS/CreateEmailAddress"
		method="POST">
		<table>
		  <tr>
				<td>Email Address :</td>
				<td><input type="text" name="emailAddress"></td>
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

				<td><input  type="submit" value="Submit"></td>

			</tr>
			
		
		</table>
		</form>

</body>
</html>