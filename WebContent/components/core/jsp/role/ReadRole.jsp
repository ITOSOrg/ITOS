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

<a href="/ITOS/ListRoles">Back</a>
<s:form action="/ITOS/ReadRole" method = "POST">
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
					<td><s:property value="roleDetail.roleType"/></td>
					<td><s:property value="roleDetail.workspace"/></td>
					<td><s:property value="roleDetail.recordStatus"/></td>
					<td><s:property value="roleDetail.createdBy"/></td>
					<td><s:property value="roleDetail.createdOn"/></td>
					<td><s:property value="roleDetail.lastModifiedBy"/></td>
					<td><s:property value="roleDetail.lastModifiedOn"/></td>
					<td><s:property value="roleDetail.versionNo" /></td>
				</tr>
				
			</tbody>
		</table>
		</s:form>

</body>
</html>