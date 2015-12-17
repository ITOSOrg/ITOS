<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="/ITOS/ReadUserRoleLink" method = "POST">
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
					<td><s:property value="userRoleLinkDetail.username"/></td>
					<td><s:property value="userRoleLinkDetail.startDate"/></td>
					<td><s:property value="userRoleLinkDetail.endDate"/></td>
					<td><s:property value="userRoleLinkDetail.recordStatus"/></td>
					<td><s:property value="userRoleLinkDetail.versionNo"/></td>
				</tr>
				
			</tbody>
		</table>
		</s:form>

</body>
</html>