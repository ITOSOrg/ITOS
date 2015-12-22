<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
		<h2>Create Role</h2>
		<div>

<s:form name="Create Role" action="/ITOS/CreateRoleSubmit"
		method="POST">
		<table>
		  
			<tr>
				<td>Role Type :</td>
				<td><s:textfield type="text" name="roleDeatail.roleType"/></td>
			</tr>
			<tr>
				<td>Workspace :</td>
				<td><s:textfield type="text" name="roleDeatail.workspace"/></td>
			</tr>
			
			<tr>

				<td><s:textfield  type="submit" value="Submit"/>
				&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListRoles">Back</a></td>
				
			</tr>
			
		
		</table>
		</s:form>
</div>
</div>
</body>
</html>