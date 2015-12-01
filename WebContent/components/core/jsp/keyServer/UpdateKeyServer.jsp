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
<%

KeyServerDetail keyServerDetail = (KeyServerDetail) request.getAttribute("keyServerDetail");

%>

<form action="/ITOS/UpdateKeyServer?keysetCode=<%=keyServerDetail.getKeysetCode()%>&versionNo=<%=keyServerDetail.getVersionNo()%>" method = "POST">
<%
System.out.println("VersionNo=" +keyServerDetail.getVersionNo());
%>
	
	<table>
			<tr>
				<td>Keyset Code :</td>
				<td><input type="text" name="keysetCode"
					value="<%=keyServerDetail.getKeysetCode()%>"></td>
			</tr>
			<tr>
				<td>Next UniqueIdBlock :</td>
				<td><input type="text" name="nextUniqueIdBlock"
				      value = "<%=keyServerDetail.getNextUniqueIdBlock()%>"></td>
			</tr>
			<tr>
				<td>Human Readable :</td>
				<td><input type="text" name="humanReadable"
				      value = "<%=keyServerDetail.getHumanReadable()%>"></td>
			</tr>
			<tr>
				<td>Annotation :</td>
				<td><input type="text" name="annotation"
				      value = "<%=keyServerDetail.getAnnotation()%>"></td>
			</tr>
			<tr>
				<td>Strategy :</td>
				<td><input type="text" name="strategy"
				      value = "<%=keyServerDetail.getStrategy()%>"></td>
			</tr>
			<tr>
				<td>Record Status :</td>
				<td><input type="text" name="recordStatus"
				      value = "<%=keyServerDetail.getRecordStatus()%>"></td>
			</tr>
			<tr>
				<td>CreatedBy :</td>
				<td><input type="text" name="createdBy"
				      value = "<%=keyServerDetail.getCreatedBy()%>"></td>
			</tr>
			<tr>
				<td>Last ModifiedBy :</td>
				<td><input type="text" name="lastModifiedBy"
				      value = "<%=keyServerDetail.getLastModifiedBy()%>"></td>
			</tr>
			<tr>

				<td><input  type="submit" value="Submit">
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListKeyServer "> List KeyServer Home</a>
				</td>

			</tr>
</table>
	
</form>
</body>
</html>