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


<a href="/ITOS/CreateRole"> Create Role</a><br><br>

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
			
			
			<s:iterator value="roleDetailList" status="stat">
			
			<tbody>
				<tr>
					<td><s:property value="roleType"/></td>
					<td><s:property value="workspace"/></td>
					<td><s:property value="recordStatus"/></td>
					<td><s:property value="createdBy"/></td>
					<td><s:property value="createdOn"/></td>
					<td><s:property value="lastModifiedBy"/></td>
					<td><s:property value="lastModifiedOn"/></td>
					
					<td>	<s:url id="ReadRoleURL" action="/ITOS/ReadRole" escapeAmp="false">
								<s:param name="roleDetail.roleID" value="%{roleID}"/>
							</s:url>
							<s:a href="%{ReadRoleURL}">View</s:a>
							
							<s:url var="UpdateRoleURL" action="/ITOS/ReadRole" escapeAmp="false">
								<s:param name="roleDetail.roleID" value="%{roleID}"/>
								<s:param name="act" value="%{updateAction}"/>
							</s:url>
							<s:a href="%{UpdateRoleURL}">Update</s:a>
							
							<s:url id="DeleteRoleURL" action="/ITOS/DeleteRole" escapeAmp="false">
								<s:param name="roleDetail.roleID" value="%{roleID}"/>
							</s:url>
							<s:a href="%{DeleteRoleURL}">Delete</s:a>
							
						</td>
					
				</tr>
				
			</tbody>
			</s:iterator>
		</table>
		</form>

</body>
</html>