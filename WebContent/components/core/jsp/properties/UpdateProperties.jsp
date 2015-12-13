<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<s:form action="/ITOS/UpdatePropertiesSubmit" method="POST">
		<table>
			<tr>
				<td>Category :</td>
				<td><s:textfield name="propertiesDetail.category" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><s:textfield name="propertiesDetail.name" /></td>
			</tr>
			<tr>
				<td>Value :</td>
				<td><s:textfield name="propertiesDetail.value" /></td>
			</tr>
			<tr>
				<td>Type :</td>
				<td><s:textfield name="propertiesDetail.Type" /></td>
			</tr>
			<tr>
				<td>DefaultValue :</td>
				<td><s:textfield name="propertiesDetail.defaultValue" /></td>
			</tr>
			<tr>
				<td>Dynamic :</td>
				<td><s:textfield name="propertiesDetail.dynamic" /></td>
			</tr>
			<tr>
				<td>CreatedBy :</td>
				<td><s:textfield name="propertiesDetail.createdBy" /></td>
			</tr>
			<tr>
				<td>LastModifiedBy :</td>
				<td><s:textfield name="propertiesDetail.lastModifiedBy" /></td>
			</tr>
			<tr>

				<td><s:submit type="submit" value="Submit" />
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListProperties">Back</a><br><br>
				</td>
				<td>
				
				</td>

			</tr>
		</table>
		
		<s:hidden name="propertiesDetail.propertyID"></s:hidden>
		<s:hidden name="propertiesDetail.versionNo"></s:hidden>
		
	</s:form>

</body>
</html>