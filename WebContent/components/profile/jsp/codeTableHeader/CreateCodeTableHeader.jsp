<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="Create Code Table Header" action="/ITOS/CreateCodeTableHeader"
		method="POST">
		<table>
		  <tr>
				<td>Table Name :</td>
				<td><input type="text" name="tableName"></td>
			</tr>
			<tr>
				<td> Default Code :</td>
				<td><input type="text" name="defaultCode"></td>
			</tr>
			<tr>

				<td><input  type="submit" value="Submit">

            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a href="/ITOS/ListCodeTableHeader">Back</a>&nbsp</td>
			</tr>
			
		
		</table>
		</form>
</body>
</html>