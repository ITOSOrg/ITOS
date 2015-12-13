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
<a href="/ITOS/ListCodeTable">Back</a><br><br>
<s:form name="Create Code Table Header" action="/ITOS/CreateCodeTableHeaderSubmit"
		method="POST">
		<table>
		  <tr>
				<td>Table Name :</td>
				<td><s:textfield type="text" name="codeTableHeaderDetail.tableName"/></td>
			</tr>
			<tr>
				<td> Default Code :</td>
				<td><s:textfield type="text" name="codeTableHeaderDetail.defaultCode"/></td>
			</tr>
			<tr>

				<td><s:submit  type="submit" value="Submit"/>

			</tr>
			
		
		</table>
		</s:form>
</body>
</html>