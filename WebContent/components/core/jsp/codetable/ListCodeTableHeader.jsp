<%@ page import="java.util.List"%>
<%@ page import="com.company.itos.core.codetable.pojo.CodeTableHeaderDetail"%>

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

List<CodeTableHeaderDetail> codeTableHeaderList = (List<CodeTableHeaderDetail>) request.getAttribute("codeTableHeaderList");

%>
			 <a href="LoginForm.jsp">Project Home</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<a href="/ITOS/components/profile/jsp/codeTableHeader/CreateCodeTableHeader.jsp">Create Code Table </a><br><br>

<form action="/ITOS/ListCodeTableHeader" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">Table Name:</th>
					<th>Default Code:</th>
					<th>Created By:</th>
					<th>Created On:</th>
					<th>LastModified By:</th>
					<th>LastModified On:</th>
					<th colspan=3>Action</th>
				</tr>
			</thead>
			
			<%
				for (int i = 0; i < codeTableHeaderList.size(); i++) {
					CodeTableHeaderDetail	 codeTableHeaderDetail = codeTableHeaderList.get(i);
			%>
			
			<tbody>
				<tr>
					<td><%=codeTableHeaderDetail.getTableName() %></td>
					<td><%=codeTableHeaderDetail.getDefaultCode() %></td>
					<td><%=codeTableHeaderDetail.getCreatedBy() %></td>
					<td><%=codeTableHeaderDetail.getCreatedOn() %></td>
					<td><%=codeTableHeaderDetail.getLastModifiedBy() %></td>
					<td><%=codeTableHeaderDetail.getLastModifiedOn() %></td>
					<td><a href = "/ITOS/ReadCodeTableHeader?tableName=<%=codeTableHeaderDetail.getTableName()%>">Read</a> </td>
					<td><a href = "/ITOS/ReadCodeTableHeader?tableName=<%=codeTableHeaderDetail.getTableName()%>&act=update">Update</a> </td>
					<td><a href = "/ITOS/DeleteCodeTableHeader?defaultCode=<%=codeTableHeaderDetail.getDefaultCode()%>">Delete</a> </td>
					
				</tr>
				
			</tbody>
			<%} %>
		</table>
		</form>

</body>
</html>