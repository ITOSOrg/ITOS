<%@ page import="com.company.itos.profile.pojo.PersonDetail"%>
<%@ page import="com.company.itos.profile.pojo.EmailAddressDetail"%>
<%@ page import="com.company.itos.profile.dao.PersonRegistrationDAO"%>
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
			
		EmailAddressDetail emailAddressDetail = personDetail.getEmailAddressDetail();


			String name = request.getParameter("firstName");
		%>
		<font size="3" color="green"> <%
 	out.println("Wellcome\t" + personDetail.getFirstName());
 %>
		</font>


		<table border=1>
			<thead>

				<tr>
					<th align="left">Title :<%=personDetail.getTitle()%></th>

					<th align="left">First Name: <%=personDetail.getFirstName()%></th>

				</tr>
			</thead>
			<tbody>

				<tr>
					<th align="left">Middle Name: <%=personDetail.getMiddleName()%></th>
					<th align="left">Last Name: <%=personDetail.getLastName()%></th>

					<td></td>
				</tr>
			</tbody>

			<tbody>

				<th align="left">Gender: <%=personDetail.getGender()%></th>
				<th align="left">Date Of Birth: <%=personDetail.getDateOfBirth()%></th>


			</tbody>
			<tbody>
				<th align="left">Status: <%=personDetail.getRecordStatus()%></th>
				<th align="left">Created By:<%=personDetail.getCreatedBy()%></th>

			</tbody>
			<tbody>
				<th align="left">Created On:<%=personDetail.getCreatedOn()%></th>
				<th align="left">Modified By:<%=personDetail.getModifiedBy()%></th>
			</tbody>
			<tbody>
				<th align="left">Modified On:<%=personDetail.getModifiedOn()%></th>
				<th align="left">Registration Date:<%=personDetail.getRegistrationDate()%></th>

			</tbody>

			<tbody>

				<th><a
					href="/ITOS/PersonHome?userName=<%=personDetail.getUserName()%>&act=update">Update</a></th>
				<th><a href="/ITOS/PersonList">PersonList</a></th>
			</tbody>

		</table>
		
	</form><br><br>
	
	<form action="/ITOS/ReadEmailAddress" method = "POST">
	<table border=1>
	<tbody>
	     		<th align="left">EmailAddress: <%=emailAddressDetail.getEmailAddress()%></th>
				<th align="left">Type Code: <%=emailAddressDetail.getTypeCode()%></th>
	</tbody>
	<tbody>
	     		<th align="left">PrimaryInd: <%=emailAddressDetail.getPrimaryInd()%></th>
				<th align="left">Start Date: <%=emailAddressDetail.getStartDate()%></th>
	</tbody>
	<tbody>
	     		<th align="left">End Date: <%=emailAddressDetail.getEndDate()%></th>
		<th><a href="/ITOS/ListEmailAddress?personID=<%=personDetail.getPersonID()%>&emailAddressLinkID=<%=emailAddressDetail.getEmailAddressLinkID()%>">
			EmailAddress List</a></th>
	</tbody>
			
		</table>
		
		<br><a href="LoginForm.jsp">Back</a>&nbsp&nbsp&nbsp&nbsp&nbsp 
	
	</form>
	
	<form action="/ITOS/PersonLogOut" method="POST">
		<br> <input type="submit" value="LogOut">
	</form>
</body>
</html>