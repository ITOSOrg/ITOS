<%@ page import="com.company.itos.profile.person.pojo.PersonDetail"%>
<%@ page import="com.company.itos.profile.person.dao.PersonListDAO"%>
<%@ page import="com.company.itos.profile.person.servlet.PersonList"%>
<%@ page import="com.company.itos.profile.person.dao.PersonListDAO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<script>
	$(function() {
		$("#myaccordion").accordion();
	});
</script>
</head>
<body>


<div id="myaccordion">
		<h2>Administrator Home</h2>
		<div>
	
	<s:form action="/ITOS/PersonList" method="post">
	<%
		List<PersonDetail> personDetailList = (List<PersonDetail>) session
			.getAttribute("personDetailList");
	PersonDetail personDetail = null;
	%>
		<table border=1>
			<thead>

				<tr>
					<th align="left">Title:</th>
					<th>First Name:</th>
					<th>Middle Name:</th>
					<th>Last Name:</th>
					<th>Date Of Birth:</th>
					<th>Gender:</th>
					<th>Created By:</th>
					<th align="center">Created On:</th>
					<th align="center">Modified By:</th>
					<th align="center">Modified On:</th>
					<th align="center">Registration Date:</th>
					 
					 
					<th colspan=3>Action</th>
				</tr>
			</thead>

			<%
				for (int i = 0; i < personDetailList.size(); i++) {
						 personDetail = personDetailList.get(i);
			%>
			<tbody>
				<tr>
					<td><%=personDetail.getTitle()%></td>
					<td><%=personDetail.getFirstName()%></td>
					<td><%=personDetail.getMiddleName()%></td>
					<td><%=personDetail.getLastName()%></td>
					<td><%=personDetail.getDateOfBirth()%></td>
					<td><%=personDetail.getGender()%></td>
					<td><%=personDetail.getCreatedBy()%></td>
					<td><%=personDetail.getCreatedOn()%></td>
					<td><%=personDetail.getModifiedBy()%></td>
					<td><%=personDetail.getModifiedOn()%></td>
					<td><%=personDetail.getRegistrationDate()%></td>
					
					
					
					
					<td><a
						href="/ITOS/PersonHome?personID=<%=personDetail.getPersonID()%>">Read</a></td>
					<td><a
						href="/ITOS/PersonHome?personID=<%=personDetail.getPersonID()%>&act=update">Update</a></td>



					<td><a
						href="/ITOS/PersonDelete?personID=<%=personDetail.getPersonID()%>"
						onclick="openpopupwindow()">Delete </a></td>


				</tr>
			</tbody>
			<%
				}
			%>
		<a href="/ITOS/PersonHome?personID=<%=personDetail.getPersonID()%>">Person Home</a><br><br>
			
		</table><br>
			<a href="RegistrationForm.jsp">Add User</a>
			
</s:form>
</div>
</div>		
</body>
</html>