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

RoleDetail roleDetail = (RoleDetail) request.getAttribute("roleDetail");
%>
<a href="/ITOS/ListRole"> List Role Home</a><br><br>
<form action="/ITOS/ReadRole" method = "POST">
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
					<th>VersionNo:</th>
				</tr>
			</thead>
			
			
			
			<tbody>
				<tr>
					<td><%=roleDetail.getRoleType() %></td>
					<td><%=roleDetail.getWorkspace() %></td>
					<td><%=roleDetail.getRecordStatus() %></td>
					<td><%=roleDetail.getCreatedBy() %></td>
					<td><%=roleDetail.getCreatedOn() %></td>
					<td><%=roleDetail.getLastModifiedBy() %></td>
					<td><%=roleDetail.getLastModifiedOn() %></td>
					<td><%=roleDetail.getVersionNo()%></td>
				</tr>
				
			</tbody>
		</table>
		</form>

</body>
</html>