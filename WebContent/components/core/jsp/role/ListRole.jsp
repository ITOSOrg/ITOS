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

List<RoleDetail> roleDetailList = (List<RoleDetail>) request.getAttribute("roleDetailList");
%>

<a href="LoginForm.jsp">Project Home</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

<a href="/ITOS/components/core/jsp/role/CreateRole.jsp"> Create Role</a><br><br>

<form action="/ITOS/ListRole" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">Role Type:</th>
					<th> Workspace:</th>
					<th>Record Status:</th>
					<th>CreatedBy:</th>
					<th>CreatedOn:</th>
					<th>LastModifiedBy:</th>
					<th>LastModifiedOn:</th>
					<th colspan=3>Action</th>
				</tr>
			</thead>
			
			<%
				for (int i = 0; i < roleDetailList.size(); i++) {
					RoleDetail	 roleDetail = roleDetailList.get(i);
			%>
			
			<tbody>
				<tr>
					<td><%=roleDetail.getRoleType() %></td>
					<td><%=roleDetail.getWorkspace() %></td>
					<td><%=roleDetail.getRecordStatus() %></td>
					<td><%=roleDetail.getCreatedBy() %></td>
					<td><%=roleDetail.getCreatedOn() %></td>
					<td><%=roleDetail.getLastModifiedBy() %></td>
					<td><%=roleDetail.getLastModifiedOn() %></td>
					<td><a href="/ITOS/ReadRole?roleID=<%=roleDetail.getRoleID()%>">Read</a></td>
					<td><a href="/ITOS/ReadRole?roleID=<%=roleDetail.getRoleID()%>&act=update">Update</a></td>
					<td><a href="/ITOS/DeleteRole?roleID=<%=roleDetail.getRoleID()%>">Delete</a></td>
				</tr>
				
			</tbody>
			<%} %>
		</table>
		</form>

</body>
</html>