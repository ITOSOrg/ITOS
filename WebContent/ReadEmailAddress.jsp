<%@ page import="com.company.itos.profile.pojo.EmailAddressDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/ITOS/ReadEmailAddress" method="POST">
		<% EmailAddressDetail emailAddressDetail = (EmailAddressDetail) request.getAttribute("emailAddressDetail"); %>
		<table border=1>
			<thead>

				<tr>
					<th align="left">EmailAddress:</th>
					<th>Type Code:</th>
					<th>PrimaryInd:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th colspan=3>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=emailAddressDetail.getEmailAddress() %></td>
					<td><%=emailAddressDetail.getTypeCode() %></td>
					<td><%=emailAddressDetail.getPrimaryInd() %></td>
					<td><%=emailAddressDetail.getStartDate() %></td>
					<td><%=emailAddressDetail.getEndDate() %></td>
					<td><a href="/ITOS/ReadEmailAddress?emailAddressID=<%=emailAddressDetail.getEmailAddressID()%>&emailAddressLinkID=<%=emailAddressDetail.getEmailAddressLinkID()%>&act=update">Update</a> </td>
					<td><a href="/ITOS/DeleteEmailAddress?emailAddressID=<%=emailAddressDetail.getEmailAddressID()%>&emailAddressLinkID=<%=emailAddressDetail.getEmailAddressLinkID()%>">Delete</a></td>
					<td><a href="CreateEmailAddress.jsp">Create</a></td>
				</tr>
			</tbody>
		</table>
		
	</form>
</body>
</html>