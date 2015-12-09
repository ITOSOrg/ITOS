<%@	page import="java.util.List"%>
<%@	page import="com.company.itos.profile.person.servlet.PersonLogin"%>
<%@	page import="com.company.itos.profile.person.pojo.UsersDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<h> LOGIN PAGE </h>
<br>
<body>

	<form action="/ITOS/PersonLogin" method="POST">


		<fieldset style="width: 400px">
			<table align="center">
				<%
					UsersDetail usersDetail = (UsersDetail) request
							.getAttribute("usersDetail");

					if (null != usersDetail) {
						List<String>errorMessageList=usersDetail.getErrorMessageList();
						for(int	i=0;i<errorMessageList.size();i++)
						{%>
				<br>
				<font size="3" color="red"> <% out.println(errorMessageList.get(i));%>
				</font>

				<% }
				%>
				<br>
				<br>USERNAME:
				<input type="text" name="userName"></input>
				<br>
				<br> PASSWORD:
				<input type="password" name="password"></input>
				<br>

				<%
					} else {
				%>
				<br>
				<br>USERNAME:
				<input type="text" name="userName"></input>
				<br>
				<br> PASSWORD:
				<input type="password" name="password"></input>


				<%
					}
				%>
				<br>
				<br>
				<input type="submit" name="submit" value="Login"></input> &nbsp&nbsp
				<a href="/ITOS/components/profile/jsp/person/RegisterPerson.jsp">New User</a> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<a href="/ITOS/SearchPerson">Search</a>
				
				<br><br><a href="/ITOS/ListCodeTableHeader">Code Table </a>
				
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListProperties"> Properties </a>
			
				<br><br><a href="/ITOS/ListKeyServer"> KeyServer</a>
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListRole"> Roles</a><br><br>
				<a href="/ITOS/ListUserRoleLink"> UserRoleLink</a>
				

			</table>
	</form>
</body>
</html>