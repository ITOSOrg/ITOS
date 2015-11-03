<%@ page import="com.company.itos.profile.pojo.EmailAddressDetail"%>
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
List<EmailAddressDetail> emailAddressDetailList = (List<EmailAddressDetail>) request.getAttribute("emailAddressDetailList");

Integer relatedID = (Integer) request.getAttribute("relatedID");


%>

<a href="/ITOS/components/profile/jsp/email/CreateEmailAddress.jsp?relatedID=<%= relatedID%>">Create</a>
<form action="/ITOS/ListEmailAddress" method = "POST">
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
			
			<%
				for (int i = 0; i < emailAddressDetailList.size(); i++) {
					EmailAddressDetail	 emailAddressDetail = emailAddressDetailList.get(i);
			%>
			
			<tbody>
				<tr>
					<td><%=emailAddressDetail.getEmailAddress() %></td>
					<td><%=emailAddressDetail.getTypeCode() %></td>
					<td><%=emailAddressDetail.getPrimaryInd() %></td>
					<td><%=emailAddressDetail.getStartDate() %></td>
					<td><%=emailAddressDetail.getEndDate() %></td>
					<td><a href="/ITOS/ReadEmailAddress?emailAddressID=<%=emailAddressDetail.getEmailAddressID()%>&emailAddressLinkID=<%=emailAddressDetail.getEmailAddressLinkID()%>&act=update">Update</a> </td>
					<td><a href="/ITOS/DeleteEmailAddress?emailAddressID=<%=emailAddressDetail.getEmailAddressID()%>&emailAddressLinkID=<%=emailAddressDetail.getEmailAddressLinkID()%>">Delete</a></td>
					<td><a href="/ITOS/components/profile/jsp/email/CreateEmailAddress.jsp?relatedID=<%=emailAddressDetail.getRelatedID()%>">Create</a></td>
				</tr>
			</tbody><br></br>
			<%} %>
		</table>
		</form>
</body>
</html>