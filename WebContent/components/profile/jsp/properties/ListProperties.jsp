<%@ page import="java.util.List"%>
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
<%
List<PropertiesDetail> propertiesList = (List<PropertiesDetail>) request.getAttribute("propertiesList");

Integer relatedID = (Integer) request.getAttribute("relatedID");

%>
 <a href="LoginForm.jsp">Project Home</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="/ITOS/components/profile/jsp/properties/CreateProperties.jsp">Create Properties</a><br><br>

<form action="/ITOS/ListProperties" method = "POST">
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
			
			<%
				for (int i = 0; i < propertiesList.size(); i++) {
					PropertiesDetail	 propertiesDetail = propertiesList.get(i);
			%>
			
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
					<td><a  href="/ITOS/ReadProperties?propertyID=<%=propertiesDetail.getPropertyID()%>">Read</a></td>
					<td><a  href="/ITOS/ReadProperties?propertyID=<%=propertiesDetail.getPropertyID()%>&act=update">Update</a></td>
				</tr>
				
			</tbody>
			<%} %>
		</table>
		</form>

</body>
</html>