<%@ page import="com.company.itos.profile.properties.pojo.PropertiesDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% PropertiesDetail propertiesDetail = (PropertiesDetail) request.getAttribute("propertiesDetail"); 
System.out.println("propertyID=" +propertiesDetail.getPropertyID());
		%>
		<a href="/ITOS/ListProperties">Back</a><br><br>
		
		<form action="/ITOS/ReadProperties?propertyID=<%=propertiesDetail.getPropertyID() %>" method = "POST">
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
					<td><%=propertiesDetail.getCategory() %></td>
					<td><%=propertiesDetail.getName() %></td>
					<td><%=propertiesDetail.getValue() %></td>
					<td><%=propertiesDetail.getType() %></td>
					<td><%=propertiesDetail.getDefaultValue() %></td>
					<td><%=propertiesDetail.getDynamic() %></td>
					<td><%=propertiesDetail.getCreatedBy() %></td>
					<td><%=propertiesDetail.getCreatedOn() %></td>
					<td><%=propertiesDetail.getLastModifiedBy() %></td>
					<td><%=propertiesDetail.getLastModifiedOn() %></td>
					<td><%=propertiesDetail.getVersionNo() %></td>
				</tr>
				
			</tbody>
		</table>
		</form>
		
</body>
</html>