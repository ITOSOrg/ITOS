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

CodeTableHeaderDetail codeTableHeaderDetail = (CodeTableHeaderDetail) request.getAttribute("codeTableHeaderDetail");

String tableName = (String) request.getParameter("tableName");

%>
<form action="/ITOS/UpdateCodeTableHeader?tableName=<%=tableName %>" method = "POST">


				
				<table>
			<tr>
				<td>Table Name :</td>
				<td><input type="text" name="tableName"
					value="<%=codeTableHeaderDetail.getTableName()%>"></td>
			</tr>
			<tr>
				<td>Default Code :</td>
				<td><input type="text" name="defaultCode"
				      value = "<%=codeTableHeaderDetail.getDefaultCode()%>"></td>
			</tr>
			<tr>
				<td>Record Status :</td>
				<td><input type="text" name="recordStatus"
				      value = "<%=codeTableHeaderDetail.getRecordStatus()%>"></td>
			</tr>
			<tr>
				<td>Created By :</td>
				<td><input type="text" name="createdBy"
				      value = "<%=codeTableHeaderDetail.getCreatedBy()%>"></td>
			</tr>
			<tr>
				<td>LastModified By :</td>
				<td><input type="text" name="lastModifiedBy"
				      value = "<%=codeTableHeaderDetail.getLastModifiedBy()%>"></td>
			</tr>
			<tr>
				<td>VersionNo :</td>
				<td><input type="text" name="versionNo"
				      value = "<%=codeTableHeaderDetail.getVersionNo()%>"></td>
			</tr>
			<tr>

				<td><input  type="submit" value="Submit">
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListCodeTableHeader">Back</a>
				</td>

			</tr>
</table>
			
		</form>
</body>
</html>