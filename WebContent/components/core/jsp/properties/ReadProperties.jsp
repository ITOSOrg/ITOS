<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<script>
	$(function() {
		$("#myaccordion").accordion();
	});
</script>

</head>
<body>

<div id="myaccordion">
		<h2>View Properties</h2>
		<div>

	<a href="/ITOS/ListProperties">Back</a>
	<br>
	<br>

	<s:form action="/ITOS/ReadProperties" method="POST">
		<table border=1>
			<thead>

				<tr>
					<th align="left">Category:</th>
					<th>Name:</th>
					<th>Value:</th>
					<th>Type:</th>
					<th>Default Value:</th>
					<th>Dynamic:</th>
					<th>CreatedBy:</th>
					<th>CreatedOn:</th>
					<th>LastModified By:</th>
					<th>LastModified On:</th>
					<th>Version Number:</th>
				</tr>
			</thead>



			<tbody>
				<tr>
					<td><s:property value="propertiesDetail.category" /></td>
					<td><s:property value="propertiesDetail.name" /></td>
					<td><s:property value="propertiesDetail.value" /></td>
					<td><s:property value="propertiesDetail.type" /></td>
					<td><s:property value="propertiesDetail.defaultValue" /></td>
					<td><s:property value="propertiesDetail.dynamic" /></td>
					<td><s:property value="propertiesDetail.createdBy" /></td>
					<td><s:property value="propertiesDetail.createdOn" /></td>
					<td><s:property value="propertiesDetail.lastModifiedBy" /></td>
					<td><s:property value="propertiesDetail.lastModifiedOn" /></td>
					<td><s:property value="propertiesDetail.versionNo" /></td>
				</tr>

			</tbody>
		</table>
	</s:form>
</div>
</div>
</body>
</html>