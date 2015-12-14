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

<a href="/ITOS/ListKeyServer">Back</a><br><br>
<s:form action="/ITOS/ReadKeyServer" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">Keyset Code:</th>
					<th>NextUniqueId Block:</th>
					<th>Human Readable:</th>
					<th>Annotation:</th>
					<th>Strategy:</th>
					<th>Record Status:</th>
					<th>CreatedBy:</th>
					<th>CreatedOn:</th>
					<th>LastModifiedBy:</th>
					<th>LastModifiedOn:</th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td><s:property value="keyServerDetail.keysetCode"/></td>
					<td><s:property value="keyServerDetail.nextUniqueIdBlock"/></td>
					<td><s:property value="keyServerDetail.humanReadable"/></td>
					<td><s:property value="keyServerDetail.annotation"/></td>
					<td><s:property value="keyServerDetail.strategy"/></td>
					<td><s:property value="keyServerDetail.recordStatus"/></td>
					<td><s:property value="keyServerDetail.createdBy"/></td>
					<td><s:property value="keyServerDetail.createdOn"/></td>
					<td><s:property value="keyServerDetail.lastModifiedBy"/></td>
					<td><s:property value="keyServerDetail.lastModifiedOn"/></td>
				</tr>
				
			</tbody>
		</table>
		</s:form>

</body>
</html>