<%@ page import="java.util.List"%>
<%@ page import="com.company.itos.core.role.pojo.RoleDetail"%>
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

List<UserRoleLinkDetail> userRoleLinklist = (List<UserRoleLinkDetail>) request.getAttribute("userRoleLinklist");
%>

<a href="LoginForm.jsp">Project Home</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

<a href="/ITOS/components/core/jsp/userrolelink/CreateUserRoleLink.jsp"> Create UserRoleLink</a><br><br>


<form action="/ITOS/ListUserRoleLink" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">User Name:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th>Record Status:</th>
					<th colspan=3>Action</th>
				</tr>
			</thead>
			
			<%
				for (int i = 0; i < userRoleLinklist.size(); i++) {
					UserRoleLinkDetail userRoleLinkDetail = userRoleLinklist.get(i);
			%>
			
			<tbody>
				<tr>
					<td><%=userRoleLinkDetail.getUsername() %></td>
					<td><%=userRoleLinkDetail.getStartDate() %></td>
					<td><%=userRoleLinkDetail.getEndDate() %></td>
					<td><%=userRoleLinkDetail.getRecordStatus() %></td>
					<td><a href="/ITOS/ReadUserRoleLink?userRoleLinkID=<%=userRoleLinkDetail.getUserRoleLinkID()%>">Read</a></td>
					<td><a href="/ITOS/ReadUserRoleLink?userRoleLinkID=<%=userRoleLinkDetail.getUserRoleLinkID()%>&act=update">Update</a></td>
					<td><a href="/ITOS/DeleteUserRoleLink?userRoleLinkID=<%=userRoleLinkDetail.getUserRoleLinkID()%>">Delete</a></td>
				</tr>
				
			</tbody>
			<%} %>
		</table>
		</form>

</body>
</html>