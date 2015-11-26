<%@ page import="java.util.List"%>
<%@ page import="com.company.itos.core.codetable.pojo.CodeTableHeaderDetail"%>
<%@ page import="com.company.itos.core.codetable.pojo.CodeTableItemDetail"%>

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

CodeTableHeaderDetail codeTableHeaderDetail = (CodeTableHeaderDetail) request.getAttribute("codeTableHeaderDetail");

%>
<a href="/ITOS/ListCodeTableHeader">Back</a>&nbsp<br><br>

<form action="/ITOS/ReadCodeTableHeader" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">Table Name:</th>
					<th>Default Code:</th>
					<th>Created By:</th>
					<th>Created On:</th>
					<th>LastModified By:</th>
					<th>LastModified On:</th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td><%=codeTableHeaderDetail.getTableName() %></td>
					<td><%=codeTableHeaderDetail.getDefaultCode() %></td>
					<td><%=codeTableHeaderDetail.getCreatedBy() %></td>
					<td><%=codeTableHeaderDetail.getCreatedOn() %></td>
					<td><%=codeTableHeaderDetail.getLastModifiedBy() %></td>
					<td><%=codeTableHeaderDetail.getLastModifiedOn() %></td>
					
				</tr>
				
			</tbody>
		</table>
		</form><br><br>
		
		<!-- List of code Table Items -->
		
		<%
		List<CodeTableItemDetail> codeTableItemDetailList = codeTableHeaderDetail.getCodeTableItemDetailList();
		%>
		<a href="/ITOS/components/profile/jsp/codeTableItem/CreatecodeTableItem.jsp?tableName=<%=codeTableHeaderDetail.getTableName()%>">Create Code Table Item</a><br></br>
		<form action="" method = "POST">
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
					<th colspan=3>Action</th>
				</tr>
			</thead>
			
			<%
				for (int i = 0; i < codeTableItemDetailList.size(); i++) {
					CodeTableItemDetail	 codeTableItemDetail = codeTableItemDetailList.get(i);
			%>
			
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
					<td><a href = "/ITOS/ReadCodeTableItem?code=<%=codeTableItemDetail.getCode()%>&tableName=<%=codeTableItemDetail.getTableName()%>">Read</a> </td>
					<td><a href = "/ITOS/ReadCodeTableItem?code=<%=codeTableItemDetail.getCode()%>&tableName=<%=codeTableItemDetail.getTableName()%>&act=update">Update</a> </td>
					<td><a href = "/ITOS/DeleteCodeTableItem?code=<%=codeTableItemDetail.getCode()%>&tableName=<%=codeTableItemDetail.getTableName()%>">Delete</a> </td>
					
				</tr>
				
			</tbody>
			<%} %>
		</table>
		</form>
		
		
		

</body>
</html>