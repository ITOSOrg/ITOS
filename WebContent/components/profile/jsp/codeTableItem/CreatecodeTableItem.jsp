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
String tableName = (String) request.getParameter("tableName");

%>
<form name="Create Code Table Item" action="/ITOS/CreateCodeTableItem?tableName=<%=tableName %>"
		method="POST">
		<table>
		  
			<tr>
				<td> Code :</td>
				<td><input type="text" name="code"></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>Annotation :</td>
				<td><input type="text" name="annotation"></td>
			</tr>
			<tr>

				<td><input  type="submit" value="Submit">
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ReadCodeTableHeader?tableName=<%=tableName%>">Back</a></td>

			</tr>
			
		
		</table>
		</form>

</body>
</html>