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

<s:url id="ReadCodeTableItemURL" action="/ITOS/ReadCodeTableHeader" escapeAmp="false">
								<s:param name="codeTableHeaderDetail.tableName" value="%{codeTableItemDetail.tableName}"/>
					</s:url>
							
					<s:a href="%{ReadCodeTableItemURL}">Back New</s:a>


<s:form action="/ITOS/ReadCodeTableItem" method = "POST">
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
					<td><s:property value="codeTableItemDetail.tableName"/></td>
					<td><s:property value="codeTableItemDetail.code"/></td>
					<td><s:property value="codeTableItemDetail.description"/></td>
					<td><s:property value="codeTableItemDetail.annotation"/></td>
					<td><s:property value="codeTableItemDetail.isEnabled"/></td>
					<td><s:property value="codeTableItemDetail.createdBy"/></td>
					<td><s:property value="codeTableItemDetail.createdOn"/></td>
					<td><s:property value="codeTableItemDetail.lastModifiedBy"/></td>
					<td><s:property value="codeTableItemDetail.lastModifiedOn"/></td>
					
				</tr>
				
			</tbody>
		</table>
		</s:form>

</body>
</html>