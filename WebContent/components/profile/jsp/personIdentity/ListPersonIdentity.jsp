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
<%
List<PersonIdentityDetail> personIdentityDetailList = (List<PersonIdentityDetail>) request.getAttribute("personIdentityDetailList");


Integer personID = (Integer) request.getAttribute("personID");


%>

<a href="/ITOS/PersonHome?personID=<%= personID%>">Person Home</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

<a href="/ITOS/components/profile/jsp/personIdentity/CreatePersonIdentity.jsp?personID=<%= personID%>">Create PersonIdentity</a><br><br>



<form action="/ITOS/ListPersonIdentity" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">AlternateID:</th>
					<th>PrimaryInd:</th>
					<th>Type Code:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th colspan=3>Action</th>
				</tr>
			</thead>
			
			<%
				for (int i = 0; i < personIdentityDetailList.size(); i++) {
					PersonIdentityDetail	 personIdentityDetail = personIdentityDetailList.get(i);
			%>
			
			<tbody>
				<tr>
					<td><%=personIdentityDetail.getAlternateID() %></td>
					<td><%=personIdentityDetail.getTypeCode() %></td>
					<td><%=personIdentityDetail.getPrimaryInd() %></td>
					<td><%=personIdentityDetail.getStartDate() %></td>
					<td><%=personIdentityDetail.getEndDate() %></td>
					<td><a href="/ITOS/ReadPersonIdentity?personIdentityID=<%=personIdentityDetail.getPersonIdentityID()%>">Read</a></td>
				</tr>
				
			</tbody>
			<%} %>
		</table>
		</form>

</body>
</html>