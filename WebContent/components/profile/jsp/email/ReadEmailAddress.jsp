<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
    $(function() {
        $("#myaccordion").accordion();
    });
</script>
</head>
<body>
<div id="myaccordion">
        <h2>View Email Address</h2>
        <div>
	<s:form action="/ITOS/ReadEmailAddress" method="POST">
		
		<table border=1>
			<thead>

				<tr>
					<th align="left">EmailAddress:</th>
					<th>Type Code:</th>
					<th>PrimaryInd:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th>Record Status:</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><s:property value="emailAddressLinkDetail.emailAddressDetail.emailAddress" /></td>
					<td><s:property value="emailAddressLinkDetail.typeCode" /></td>
					<td><s:property value="emailAddressLinkDetail.primaryInd" /></td>
					<td><s:property value="emailAddressLinkDetail.startDate" /></td>
					<td><s:property value="emailAddressLinkDetail.endDate" /></td>
					<td><s:property value="emailAddressLinkDetail.emailAddressDetail.recordStatus" /></td>
				</tr>
			</tbody>
		</table>
		
	</s:form>
    </div>
    </div>
</body>
</html>