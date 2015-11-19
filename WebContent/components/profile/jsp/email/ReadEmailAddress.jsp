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
					<th>Record Status:</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=emailAddressDetail.getEmailAddress() %></td>
					<td><%=emailAddressLinkDetail.getTypeCode() %></td>
					<td><%=emailAddressLinkDetail.getPrimaryInd() %></td>
					<td><%=emailAddressLinkDetail.getStartDate() %></td>
					<td><%=emailAddressLinkDetail.getEndDate() %></td>
					<td><%=emailAddressDetail.getRecordStatus() %></td>
				</tr>
			</tbody>
		</table>
				<br><a href="/ITOS/ListEmailAddress?relatedID=<%= emailAddressLinkDetail.getRelatedID() %>">EmailAddressList Home</a></td>
		
	</form>
</body>
</html>