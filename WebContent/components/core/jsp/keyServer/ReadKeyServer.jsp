<%@ page import="com.company.itos.core.keyserver.pojo.KeyServerDetail"%>
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
<a href="/ITOS/ListKeyServer "> List KeyServer Home</a><br><br>
<%

KeyServerDetail keyServerDetail = (KeyServerDetail) session.getAttribute("keyServerDetail");

%>
<a href="/ITOS/ListKeyServer">Back</a><br><br>
<form action="/ITOS/ReadKeyServer" method = "POST">
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
					<td><%=keyServerDetail.getKeysetCode() %></td>
					<td><%=keyServerDetail.getNextUniqueIdBlock() %></td>
					<td><%=keyServerDetail.getHumanReadable() %></td>
					<td><%=keyServerDetail.getAnnotation() %></td>
					<td><%=keyServerDetail.getStrategy() %></td>
					<td><%=keyServerDetail.getRecordStatus() %></td>
					<td><%=keyServerDetail.getCreatedBy() %></td>
					<td><%=keyServerDetail.getCreatedOn() %></td>
					<td><%=keyServerDetail.getLastModifiedBy() %></td>
					<td><%=keyServerDetail.getLastModifiedOn() %></td>
				</tr>
				
			</tbody>
		</table>
		</form>

</body>
</html>