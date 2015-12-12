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

	<a href="/ITOS/CreateProperties">Create Properties</a>
	<br>
	<br>

	<s:form action="/ITOS/ListProperties" method="POST">
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
					<th colspan=2>Action</th>
				</tr>
			</thead>

			<s:iterator value="propertiesList" status="stat">

				<tbody>
					<tr>
						<td><s:property value="category" /></td>
						<td><s:property value="name" /></td>
						<td><s:property value="value" /></td>
						<td><s:property value="type" /></td>
						<td><s:property value="defaultValue" /></td>
						<td><s:property value="dynamic" /></td>
						<td><s:property value="createdBy" /></td>
						<td><s:property value="createdOn" /></td>
						<td><s:property value="lastModifiedBy" /></td>
						<td><s:property value="lastModifiedOn" /></td>
						<td><s:url id="readPropertiesURL" action="/ITOS/ReadProperties" escapeAmp="false">
								<s:param name="propertiesDetail.propertyID" value="%{propertyID}"/>
							</s:url>
							<s:a href="%{readPropertiesURL}">View</s:a>
							
							<s:url var="updatePropertiesURL" action="/ITOS/ReadProperties" escapeAmp="false">
								<s:param name="propertiesDetail.propertyID" value="%{propertyID}"/>
								<s:param name="act" value="%{updateAction}"/>
							</s:url>
							<a href="<s:property value="#updatePropertiesURL"/>"> Update</a>
							
						</td>

					</tr>

				</tbody>
			</s:iterator>
		</table>
	</s:form>

</body>
</html>