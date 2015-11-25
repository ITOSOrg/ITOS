<%@ page import="com.company.itos.profile.codeTable.pojo.CodeTableItemDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% CodeTableItemDetail codeTableItemDetail = (CodeTableItemDetail) request.getAttribute("codeTableItemDetail"); %>
<a href="/ITOS/ReadCodeTableHeader?tableName=<%=codeTableItemDetail.getTableName()%>">Back</a><br><br>

<form action="/ITOS/ReadCodeTableItem" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">Table Name:</th>
					<th>Code:</th>
					<th>Description:</th>
					<th>Annotation:</th>
					<th>Is Enabled:</th>
					<th>Created By:</th>
					<th>Created On:</th>
					<th>LastModified By:</th>
					<th>LastModified On:</th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td><%=codeTableItemDetail.getTableName() %></td>
					<td><%=codeTableItemDetail.getCode() %></td>
					<td><%=codeTableItemDetail.getDescription() %></td>
					<td><%=codeTableItemDetail.getAnnotation() %></td>
					<td><%=codeTableItemDetail.getIsEnabled() %></td>
					<td><%=codeTableItemDetail.getCreatedBy() %></td>
					<td><%=codeTableItemDetail.getCreatedOn() %></td>
					<td><%=codeTableItemDetail.getLastModifiedBy() %></td>
					<td><%=codeTableItemDetail.getLastModifiedOn() %></td>
					
				</tr>
				
			</tbody>
		</table>
		</form>

</body>
</html>