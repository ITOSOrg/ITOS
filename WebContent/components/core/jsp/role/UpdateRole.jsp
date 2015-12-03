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


<form action="/ITOS/UpdateRole?roleID=<%=roleDetail.getRoleID() %>&versionNo=<%=roleDetail.getVersionNo()%>" method = "POST">
<table>
			<tr>
				<td>Role Type :</td>
				<td><input type="text" name="roleType"
					value="<%=roleDetail.getRoleType()%>"></td>
			</tr>
			<tr>
				<td>Workspace :</td>
				<td><input type="text" name="workspace"
				      value = "<%=roleDetail.getWorkspace()%>"></td>
			</tr>
			<tr>
				<td>CreatedBy :</td>
				<td><input type="text" name="createdBy"
				      value = "<%=roleDetail.getCreatedBy()%>"></td>
			</tr>
			<tr>
				<td>LastModifiedBy :</td>
				<td><input type="text" name="lastModifiedBy"
				      value = "<%=roleDetail.getLastModifiedBy()%>"></td>
			</tr>
			
			<tr>

				<td><input  type="submit" value="Submit">
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListRole"> List Role Home</a>
				</td>

			</tr>
</table>
</form>
</body>
</html>