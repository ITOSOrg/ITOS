<%@page language="java" contentType="text/html; charset=ISO-8859-1"
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
		<h2>Create Properties</h2>
		<div>
	
	<s:form name="Create Properties" action="/ITOS/CreatePropertiesSubmit"
		method="POST">
		<table>
			<tr>
				<td>Category :</td>
				<td><s:textfield type="text" name="propertiesDetail.category" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><s:textfield type="text" name="propertiesDetail.name"/></td>
			</tr>
			<tr>
				<td>Value :</td>
				<td><s:textfield type="text" name="propertiesDetail.value"/></td>
			</tr>
			<tr>
				<td>Type :</td>
				<td><s:textfield type="text" name="propertiesDetail.type"/></td>
			</tr>
			<tr>
				<td>Default Value :</td>
				<td><s:textfield type="text" name="propertiesDetail.defaultValue"/></td>
			</tr>
			<tr>
				<td>Dynamic :</td>
				<td><s:textfield type="text" name="propertiesDetail.dynamic"/></td>
			</tr>
			<tr>

				<td><s:submit type="submit" value="Submit"/>
					&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListProperties">Back</a></td><br><br>
			</tr>


		</table>
	</s:form>
</div>
</div>
</body>
</html>