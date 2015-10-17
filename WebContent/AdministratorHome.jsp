<%@ page import="com.company.itos.profile.pojo.PersonDetail"%>
<%@ page import="com.company.itos.profile.dao.PersonListDAO"%>
<%@ page import="com.company.itos.profile.servlet.PersonList"%>
<%@ page import="com.company.itos.profile.dao.PersonListDAO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	
	<form action="/ITOS/PersonList" method="post">
	<%
		List<PersonDetail> personDetailList = (List<PersonDetail>) request
			.getAttribute("personDetailList");
	%>
		<table border=1>
			<thead>

				<tr>
					<th align="left">PersonID:</th>
					<th>RefrenceNumber:</th>
					<th>First Name:</th>
					<th>Middle Name:</th>
					<th>Last Name:</th>
					<th>Created By:</th>
					<th align="center">Created On:</th>
					<th align="center">Modified By:</th>
					<th align="center">Modified On:</th>
					<th colspan=3>Action</th>
				</tr>
			</thead>

			<%
				for (int i = 0; i < personDetailList.size(); i++) {
						PersonDetail personDetail = personDetailList.get(i);
			%>
			<tbody>
				<tr>
					<td><%=personDetail.getPersonID()%></td>
					<td><%=personDetail.getRefrenceNumber()%></td>
					<td><%=personDetail.getFirstName()%></td>
					<td><%=personDetail.getMiddleName()%></td>
					<td><%=personDetail.getLastName()%></td>
					<td><%=personDetail.getCreatedBy()%></td>
					<td><%=personDetail.getCreatedOn()%></td>
					<td><%=personDetail.getModifiedBy()%></td>
					<td><%=personDetail.getModifiedOn()%></td>
					<td><a
						href="/ITOS/PersonHome?userName=<%=personDetail.getUserName()%>">Read</a></td>
					<td><a
						href="/ITOS/PersonHome?userName=<%=personDetail.getUserName()%>&act=update&versionNo=<%=personDetail.getVersionNo()%>	">Update</a></td>



					<td><a
						href="/ITOS/PersonDelete?refrenceNumber=<%=personDetail.getRefrenceNumber()%>"
						onclick="openpopupwindow()">Delete </a></td>


				</tr>
			</tbody>
			<%
				}
			%>
			<a href="RegistrationForm.jsp">Add User</a>
			&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/SearchPerson">Search</a>
			
		</table>
		<a href="LoginForm.jsp">Back</a>
</form>		
</body>
</html>