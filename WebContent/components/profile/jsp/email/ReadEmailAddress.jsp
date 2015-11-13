<%@ page import="com.company.itos.profile.email.pojo.EmailAddressDetail"%>
<%@ page import="com.company.itos.profile.email.pojo.EmailAddressLinkDetail"%>
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
		<% EmailAddressLinkDetail emailAddressLinkDetail = (EmailAddressLinkDetail) request.getAttribute("emailAddressLinkDetail"); 
		EmailAddressDetail emailAddressDetail = emailAddressLinkDetail.getEmailAddressDetail();
		%>
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
					<td><%=emailAddressLinkDetail.getTypeCode() %></td>
					<td><%=emailAddressLinkDetail.getPrimaryInd() %></td>
					<td><%=emailAddressLinkDetail.getStartDate() %></td>
					<td><%=emailAddressLinkDetail.getEndDate() %></td>
					<td><a href="/ITOS/ReadEmailAddress?emailAddressID=<%=emailAddressDetail.getEmailAddressID()%>&emailAddressLinkID=<%=emailAddressLinkDetail.getEmailAddressLinkID()%>&act=update">Update</a> </td>
					<td><a href="/ITOS/DeleteEmailAddress?emailAddressID=<%=emailAddressDetail.getEmailAddressID()%>&emailAddressLinkID=<%=emailAddressLinkDetail.getEmailAddressLinkID()%>">Delete</a></td>
					<td><a href="/components/profile/jsp/email/CreateEmailAddress.jsp">Create</a></td>
				</tr>
			</tbody>
		</table>
		
	</form>
</body>
</html>