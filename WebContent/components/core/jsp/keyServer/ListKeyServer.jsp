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
<a href="/ITOS/CreateKeyServer"> Create KeyServer</a><br><br>
<%

List<KeyServerDetail> keyServerList = (List<KeyServerDetail>) session.getAttribute("keyServerList");

%>

<form action="/ITOS/ListKeyServer" method = "POST">
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
					<th colspan=3>Action</th>
				</tr>
			</thead>
			
			<%
				for (int i = 0; i < keyServerList.size(); i++) {
					KeyServerDetail	 keyServerDetail = keyServerList.get(i);
			%>
			
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
					<td><a href="/ITOS/ReadKeyServer?keysetCode=<%=keyServerDetail.getKeysetCode()%>">Read</a> </td>
					<td><a href="/ITOS/ReadKeyServer?keysetCode=<%=keyServerDetail.getKeysetCode()%>&act=update">Update</a> </td>
				</tr>
				
			</tbody>
			<%} %>
		</table>
		</form>

</body>
</body>
</html>