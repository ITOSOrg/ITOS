<%@ page import="com.company.itos.core.codetable.pojo.CodeTableItemDetail"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% CodeTableItemDetail codeTableItemDetail = (CodeTableItemDetail) request.getAttribute("codeTableItemDetail"); 
		%>
		
		<s:form action="/ITOS/UpdateCodeTableItemSubmit" method = "POST">
	
	<table>
			<tr>
				<td>Table Name :</td>
				<td><s:textfield type="text" name="codeTableItemDetail.tableName"
					/></td>
			</tr>
			<tr>
				<td>Code :</td>
				<td><s:textfield type="text" name="codeTableItemDetail.code"
				      /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><s:textfield type="text" name="codeTableItemDetail.description"
				      /></td>
			</tr>
			<tr>
				<td>Annotation :</td>
				<td><s:textfield type="text" name="codeTableItemDetail.annotation"
				      "/></td>
			</tr>
			<tr>
				<td>Is Enabled :</td>
				<td><s:textfield type="text" name="codeTableItemDetail.isEnabled"
				      "/></td>
			</tr>
			<tr>
				<td>Record Status :</td>
				<td><s:textfield type="text" name="codeTableItemDetail.recordStatus"
				      /></td>
			</tr>
			<tr>

						<td><s:submit  type="submit" value="Submit"/>

				</td>

			</tr>
</table>
	
</s:form>
</body>
</html>