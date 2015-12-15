<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<script>
	$(function() {
		$("#myaccordion").accordion();
	});
</script>

</head>
<body>

<div id="myaccordion">
		<h2>List KeyServer</h2>
		<div>

<a href="/ITOS/CreateKeyServer"> Create KeyServer</a><br><br>

<s:form action="/ITOS/ListKeyServer" method = "POST">
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
			
			<s:iterator value="keyServerList" status="stat">
			
			<tbody>
				<tr>
					<td><s:property value="keysetCode"/></td>
					<td><s:property value="nextUniqueIdBlock"/></td>
					<td><s:property value="humanReadable"/></td>
					<td><s:property value="annotation"/></td>
					<td><s:property value="strategy"/></td>
					<td><s:property value="recordStatus"/></td>
					<td><s:property value="createdBy"/></td>
					<td><s:property value="createdOn"/></td>
					<td><s:property value="lastModifiedBy"/></td>
					<td><s:property value="lastModifiedOn"/></td>
					
					<td><s:url id="ReadKeyServerURL" action="/ITOS/ReadKeyServer" escapeAmp="false">
								<s:param name="keyServerDetail.keysetCode" value="%{keysetCode}"/>
							</s:url>
							<s:a href="%{ReadKeyServerURL}">View</s:a>
							
							<s:url var="UpdateKeyServerURL" action="/ITOS/ReadKeyServer" escapeAmp="false">
								<s:param name="keyServerDetail.keysetCode" value="%{keysetCode}"/>
								<s:param name="act" value="%{updateAction}"/>
							</s:url>
							<s:a href="%{UpdateKeyServerURL}">Update</s:a>
							
						</td>
					
				</tr>
				
			</tbody>
			</s:iterator>
		</table>
		</s:form>
</div>
</div>
</body>
</body>
</html>