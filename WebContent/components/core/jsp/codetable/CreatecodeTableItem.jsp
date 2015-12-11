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
<%
String tableName = (String) request.getParameter("tableName");
System.out.println("tableName=" +tableName);

%>
<s:form name="Create Code Table Item" action="/ITOS/CreateCodeTableItemSubmit"
		method="POST">
		<table>
		  
			<tr>
				<td> Code :</td>
				<td><s:textfield type="text" name="codeTableItemDetail.code"/></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><s:textfield type="text" name="codeTableItemDetail.description"/></td>
			</tr>
			<tr>
				<td>Annotation :</td>
				<td><s:textfield type="text" name="codeTableItemDetail.annotation"/></td>
			</tr>
			<tr>

				<td><s:submit  type="submit" value="Submit"/>
				<s:hidden name="codeTableItemDetail.tableName" value="%{tableName}"/>
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ReadCodeTableHeader?tableName=<%=tableName%>">Back</a></td>

			</tr>
			
		
		</table>
		</s:form>

</body>
</html>