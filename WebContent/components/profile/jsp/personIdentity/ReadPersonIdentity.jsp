<%@ page import="com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail"%>
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
<% PersonIdentityDetail personIdentityDetail = (PersonIdentityDetail) request.getAttribute("personIdentityDetail"); 
		%>

		<br><a href="/ITOS/ListPersonIdentity?personID=<%= personIdentityDetail.getPersonID() %>">PersonIdentityList Home</a></td><br><br>
<form action="/ITOS/ReadPersonIdentity" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">AlternateID:</th>
					<th>PrimaryInd:</th>
					<th>Type Code:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th>Record Status:</th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td><%=personIdentityDetail.getAlternateID() %></td>
					<td><%=personIdentityDetail.getTypeCode() %></td>
					<td><%=personIdentityDetail.getPrimaryInd() %></td>
					<td><%=personIdentityDetail.getStartDate() %></td>
					<td><%=personIdentityDetail.getEndDate() %></td>
					<td><%=personIdentityDetail.getRecordStatus() %></td>
				</tr>
				
			</tbody>
		</table>
		</form>

</body>
</html>