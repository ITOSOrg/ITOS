<%@ page import="com.company.itos.profile.pojo.PersonDetail"%>
<%@ page
	import="com.company.itos.profile.dao.PersonRegistrationDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
	<form action="/ITOS/PersonHome" method="post">


		<%
			PersonDetail personDetail = (PersonDetail) request.getAttribute("personDetail");
		%>

		<%
			String name = request.getParameter("firstName");
		%>
		<font size="3" color="green">
			<%
				out.println("Wellcome\t" + personDetail.getFirstName());
			%>
		</font>


		<table border=1>
			<thead>

				<tr>
					<th align="left">PersonID: <%=personDetail.getPersonID()%></th>

					<th align="left">RefrenceNumber: <%=personDetail.getRefrenceNumber()%></th>

				</tr>
			</thead>
			<tbody>

				<tr>
					<th align="left">First Name: <%=personDetail.getFirstName()%></th>
					<th align="left">Middle Name: <%=personDetail.getMiddleName()%></th>

					<td></td>
				</tr>
			</tbody>

			<tbody>

				<th align="left">Last Name: <%=personDetail.getLastName()%></th>
				<th align="left">Status: <%=personDetail.getRecordStatus()%></th>


			</tbody>
			<tbody>
				<th align="left">Created By:<%=personDetail.getCreatedBy()%></th>
				<th align="left">Modified By:<%=personDetail.getModifiedBy()%></th>

			</tbody>
			<tbody>
			<th align="left">Date Of Birth:<%=personDetail.getDateOfBirth() %></th>
			<th align="left">Created On:<%=personDetail.getCreatedOn() %></th>
			</tbody>
			<tbody>
			<th align="left"> Modified On:<%=personDetail.getModifiedOn() %></th>
			</tbody>
			<tbody>

				<th><a
					href="/ITOS/PersonHome?userName=<%=personDetail.getUserName()%>&act=update">Update</a></th>
				<th><a href="/ITOS/PersonList">PersonList</a></th>
			</tbody>

		</table>
		<a href="LoginForm.jsp">Back</a>&nbsp&nbsp&nbsp&nbsp&nbsp
	</form>
	<form action="/ITOS/PersonLogOut" method="POST">
		<br> <input type="submit" value="LogOut">
	</form>
</body>
</html>