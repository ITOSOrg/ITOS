<%@ page import="com.company.itos.profile.email.pojo.EmailAddressDetail"%>
<%@ page import="com.company.itos.profile.email.pojo.EmailAddressLinkDetail"%>
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


<%
List<EmailAddressLinkDetail> emailAddressLinkDetailList = (List<EmailAddressLinkDetail>) request.getAttribute("emailAddressLinkDetailList");


Integer relatedID = (Integer) request.getAttribute("relatedID");


%>
			<a href="/ITOS/PersonHome?personID=<%= relatedID%>">Person Home</a><br><br>

<a href="/ITOS/components/profile/jsp/email/CreateEmailAddress.jsp?relatedID=<%= relatedID%>">Create Email Address</a><br>
<form action="/ITOS/ListEmailAddress" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">EmailAddress:</th>
					<th>Type Code:</th>
					<th>PrimaryInd:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th colspan=2>Action</th>
				</tr>
			</thead>
			
			<%
				for (int i = 0; i < emailAddressLinkDetailList.size(); i++) {
					EmailAddressLinkDetail	 emailAddressLinkDetail = emailAddressLinkDetailList.get(i);
 					EmailAddressDetail emailAddressDetail =  emailAddressLinkDetail.getEmailAddressDetail();
			%>
			
			<tbody>
				<tr>
					<td><%=emailAddressDetail.getEmailAddress() %></td>
					<td><%=emailAddressLinkDetail.getTypeCode() %></td>
					<td><%=emailAddressLinkDetail.getPrimaryInd() %></td>
					<td><%=emailAddressLinkDetail.getStartDate() %></td>
					<td><%=emailAddressLinkDetail.getEndDate() %></td>
					<td><a href="/ITOS/ReadEmailAddress?emailAddressID=<%=emailAddressDetail.getEmailAddressID()%>&emailAddressLinkID=<%=emailAddressLinkDetail.getEmailAddressLinkID()%>&act=update">Update</a> </td>
					<td><a href="/ITOS/DeleteEmailAddress?emailAddressID=<%=emailAddressDetail.getEmailAddressID()%>&emailAddressLinkID=<%=emailAddressLinkDetail.getEmailAddressLinkID()%>&relatedID=<%= relatedID%>">Delete</a></td>
				</tr>
				
			</tbody>
			<%} %>
		</table>
		</form>
</body>
</html>