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
<form name="Create Properties" action="/ITOS/CreateProperties"
		method="POST">
		<table>
		  <tr>
				<td>Category :</td>
				<td><input type="text" name="category"></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Value :</td>
				<td><input type="text" name="value"></td>
			</tr>
			<tr>
				<td>Type :</td>
				<td><input type="text" name="type"></td>
			</tr>
			<tr>
				<td>Defaul tValue :</td>
				<td><input type="text" name="defaultValue"></td>
			</tr>
			<tr>
				<td>Dynamic :</td>
				<td><input type="text" name="dynamic"></td>
			</tr>
			<tr>

				<td><input  type="submit" value="Submit">
				&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListProperties">Back</a>
				</td>
			</tr>
			
		
		</table>
		</form>
</body>
</html>