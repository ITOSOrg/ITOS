<%@ page import="com.company.itos.core.userrolelink.pojo.UserRoleLinkDetail"%>
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

UserRoleLinkDetail userRoleLinkDetail = (UserRoleLinkDetail) request.getAttribute("userRoleLinkDetail");
%>
<a href="/ITOS/ListUserRoleLink"> ListUserRoleLink Home</a><br><br>
<form action="/ITOS/ReadUserRoleLink" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">User Name:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th>Record Status:</th>
					<th>VersionNo:</th>
				</tr>
			</thead>
			
			
			
			<tbody>
				<tr>
					<td><%=userRoleLinkDetail.getUsername() %></td>
					<td><%=userRoleLinkDetail.getStartDate() %></td>
					<td><%=userRoleLinkDetail.getEndDate() %></td>
					<td><%=userRoleLinkDetail.getRecordStatus() %></td>
					<td><%=userRoleLinkDetail.getVersionNo()%></td>
				</tr>
				
			</tbody>
		</table>
		</form>

</body>
</html>