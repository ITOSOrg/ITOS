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

	<s:form action="/ITOS/UpdateCodeTableHeaderSubmit" method="POST">



		<table>

			<tr>
				<td>Default Code :</td>
				<td><s:textfield type="text"
						name="codeTableHeaderDetail.defaultCode" /></td>
			</tr>
			<tr>
				<td>Record Status :</td>
				<td><s:textfield type="text"
						name="codeTableHeaderDetail.recordStatus" /></td>
			</tr>
			<tr>
				<td>Created By :</td>
				<td><s:textfield type="text"
						name="codeTableHeaderDetail.createdBy" /></td>
			</tr>
			<tr>
				<td>LastModified By :</td>
				<td><s:textfield type="text"
						name="codeTableHeaderDetail.lastModifiedBy" /></td>
			</tr>

			<tr>

				<td><s:submit type="submit" value="Submit" /> <s:hidden
						name="codeTableHeaderDetail.tableName" /> <s:hidden
						name="codeTableHeaderDetail.versionNo" /></td>

			</tr>
		</table>

	</s:form>
</body>
</html>