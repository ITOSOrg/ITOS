<%@ page import="com.company.itos.core.properties.pojo.PropertiesDetail"%>
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
PropertiesDetail propertiesDetail = (PropertiesDetail) request.getAttribute("propertiesDetail"); 

%>

<form action="/ITOS/UpdateProperties?propertyID=<%=propertiesDetail.getPropertyID() %>&versionNo=<%=propertiesDetail.getVersionNo()%>" method = "POST">
<table>
			<tr>
				<td>Category :</td>
				<td><input type="text" name="category"
					value="<%=propertiesDetail.getCategory()%>"></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"
				      value = "<%=propertiesDetail.getName()%>"></td>
			</tr>
			<tr>
				<td>Value :</td>
				<td><input type="text" name="value"
				      value = "<%=propertiesDetail.getValue()%>"></td>
			</tr>
			<tr>
				<td>Type :</td>
				<td><input type="text" name="Type"
				      value = "<%=propertiesDetail.getType()%>"></td>
			</tr>
			<tr>
				<td>DefaultValue :</td>
				<td><input type="text" name="defaultValue"
				      value = "<%=propertiesDetail.getDefaultValue()%>"></td>
			</tr>
			<tr>
				<td>Dynamic :</td>
				<td><input type="text" name="dynamic"
				      value = "<%=propertiesDetail.getDynamic()%>"></td>
			</tr>
			<tr>
				<td>CreatedBy :</td>
				<td><input type="text" name="createdBy"
				      value = "<%=propertiesDetail.getCreatedBy()%>"></td>
			</tr>
			<tr>
				<td>LastModifiedBy :</td>
				<td><input type="text" name="lastModifiedBy"
				      value = "<%=propertiesDetail.getLastModifiedBy()%>"></td>
			</tr>
			<tr>

				<td><input  type="submit" value="Submit">
				&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListProperties">Back</a>
				</td>

			</tr>
</table>
</form>

</body>
</html>