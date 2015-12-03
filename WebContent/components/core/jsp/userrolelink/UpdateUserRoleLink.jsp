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


<form action="/ITOS/UpdateUserRoleLink?userRoleLinkID=<%=userRoleLinkDetail.getUserRoleLinkID() %>&versionNo=<%=userRoleLinkDetail.getVersionNo()%>" method = "POST">
<table>
			
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="username"
				      value = "<%=userRoleLinkDetail.getUsername()%>"></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input type="text" name="startDate"
				      value = "<%=userRoleLinkDetail.getStartDate()%>"></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="text" name="endDate"
				      value = "<%=userRoleLinkDetail.getEndDate()%>"></td>
			</tr>
			
			<tr>

				<td><input  type="submit" value="Submit">
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListUserRoleLink"> ListUserRoleLink Home</a>
				</td>

			</tr>
</table>
</form>
</body>
</html>