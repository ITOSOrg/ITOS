<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="Create KeyServer" action="/ITOS/CreateKeyServer"
		method="POST">
		<table>
		  
			<tr>
				<td>Keyset Code :</td>
				<td><input type="text" name="keysetCode"></td>
			</tr>
			<tr>
				<td>Next UniqueIdBlock :</td>
				<td><input type="text" name="nextUniqueIdBlock"></td>
			</tr>
			<tr>
				<td>Human Readable :</td>
				<td><input type="text" name="humanReadable"></td>
			</tr>
			<tr>
				<td>Annotation :</td>
				<td><input type="text" name="annotation"></td>
			</tr>
			<tr>
				<td>Strategy :</td>
				<td><input type="text" name="strategy"></td>
			</tr>
			<tr>

				<td><input  type="submit" value="Submit">
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListKeyServer "> List KeyServer Home</a>

			</tr>
			
		
		</table>
		</form>

</body>
</html>