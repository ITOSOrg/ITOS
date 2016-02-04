<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<h> LOGIN PAGE </h>
<br>
<body>

	<s:form action="/ITOS/PersonLogin" method="POST">

		<table border="1">
			<!--   <fieldset style="width: 400px;height: 400px">-->

			<tr>
				<td>USERNAME:</td>
				<td><s:textfield type="text" name="usersDetail.userName" /></td>
			</tr>
			<tr>
				<td>PASSWORD:</td>
				<td><s:textfield type="password" name="usersDetail.password" /></td>
			</tr>
			<s:submit type="submit" name="submit" value="Login" />
		</table>

		<br>
		<a href="/ITOS/components/profile/jsp/person/Trial.jsp">New User</a> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<br>
		<br>

		<a href="ListProperties">Properties</a>
		<br>
		<br>
	</s:form>
</body>
</html>