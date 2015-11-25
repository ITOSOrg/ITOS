<%@ page import="com.company.itos.profile.codeTable.pojo.CodeTableItemDetail"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% CodeTableItemDetail codeTableItemDetail = (CodeTableItemDetail) request.getAttribute("codeTableItemDetail"); 
		%>
		
		<form action="/ITOS/UpdateCodeTableItem?code=<%=codeTableItemDetail.getCode()%>&versionNo=<%=codeTableItemDetail.getVersionNo()%>" method = "POST">
	
	<table>
			<tr>
				<td>Table Name :</td>
				<td><input type="text" name="tableName"
					value="<%=codeTableItemDetail.getTableName()%>"></td>
			</tr>
			<tr>
				<td>Code :</td>
				<td><input type="text" name="code"
				      value = "<%=codeTableItemDetail.getCode()%>"></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><input type="text" name="description"
				      value = "<%=codeTableItemDetail.getDescription()%>"></td>
			</tr>
			<tr>
				<td>Annotation :</td>
				<td><input type="text" name="annotation"
				      value = "<%=codeTableItemDetail.getAnnotation()%>"></td>
			</tr>
			<tr>
				<td>Is Enabled :</td>
				<td><input type="text" name="isEnabled"
				      value = "<%=codeTableItemDetail.getIsEnabled()%>"></td>
			</tr>
			<tr>
				<td>Record Status :</td>
				<td><input type="text" name="recordStatus"
				      value = "<%=codeTableItemDetail.getRecordStatus()%>"></td>
			</tr>
			<tr>

				<td><input  type="submit" value="Submit">
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListCodeTableItem">Back</a>
				</td>

			</tr>
</table>
	
</form>
</body>
</html>