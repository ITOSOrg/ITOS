<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
	$(function() {
		$("#myaccordion").accordion();
	});
</script>

</head>
<body>

<div id="myaccordion">
		<h2>Update Role</h2>
		<div>

<s:form action="/ITOS/UpdatePersonRoleSubmit" method = "POST">
<table>
			<tr>
				<td>Role Type :</td>
				<td><s:textfield type="text" name="roleDetail.roleType"
					/></td>
			</tr>
			<tr>
				<td>Workspace :</td>
				<td><s:textfield type="text" name="roleDetail.workspace"
				      /></td>
			</tr>
			<tr>
				<td>CreatedBy :</td>
				<td><s:textfield type="text" name="roleDetail.createdBy"
				      /></td>
			</tr>
			<tr>
				<td>LastModifiedBy :</td>
				<td><s:textfield type="text" name="roleDetail.lastModifiedBy"
				      /></td>
			</tr>
			
			<tr>

				<td><s:textfield  type="submit" value="Submit"/>
				<s:hidden name="roleDetail.roleID"></s:hidden> 
				<s:hidden name="roleDetail.versionNo"></s:hidden>
				<s:hidden name="roleDetail.userRoleLinkDetail.username"></s:hidden>
                <!--<s:hidden name="userRoleLinkDetail.username" value="%{#parameters['roleDetail.userRoleLinkDetail.username']}"/>-->
				</td>

			</tr>
</table>
</s:form>
</div>
</div>
</body>
</html>