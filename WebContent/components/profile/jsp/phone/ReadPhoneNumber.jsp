<%@ page import="com.company.itos.profile.phone.pojo.PhoneNumberDetail" %>
<%@ page import="com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail" %>
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
<% PhoneNumberLinkDetail phoneNumberLinkDetail = (PhoneNumberLinkDetail) request.getAttribute("phoneNumberLinkDetail"); 
 	PhoneNumberDetail phoneNumberDetail = phoneNumberLinkDetail.getPhoneNumberDetail();

%>

<table border=1>
			<thead>

				<tr>
					<th align="left">Country Code:</th>
					<th>Area Code:</th>
					<th>Phone Number:</th>
					<th>Extension:</th>
					<th>Type Code:</th>
					<th>PrimaryInd:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th>Record Status:</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=phoneNumberDetail.getCountryCode() %></td>
					<td><%=phoneNumberDetail.getAreaCode() %></td>
					<td><%=phoneNumberDetail.getPhoneNumber() %></td>
					<td><%=phoneNumberDetail.getExtension() %></td>
					<td><%=phoneNumberLinkDetail.getTypeCode() %></td>
					<td><%=phoneNumberLinkDetail.getPrimaryInd() %></td>
					<td><%=phoneNumberLinkDetail.getStartDate() %></td>
					<td><%=phoneNumberLinkDetail.getEndDate() %></td>
					<td><%=phoneNumberDetail.getRecordStatus() %></td>
				</tr>
			</tbody>
		</table>
		<br><a href="/ITOS/ListPhoneNumber?relatedID=<%= phoneNumberLinkDetail.getRelatedID() %>">PhoneNumberList Home</a></td>
</form>
</body>
</html>