<%@ page import="com.company.itos.profile.phone.pojo.PhoneNumberDetail" %>
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
<s:form action="/ITOS/ReadEmailAddress" method="POST">

<table border=1>
			<thead>

				<tr>
					<th align="left">Country Code:</th>
					<th>Area Code:</th>
					<th>Phone Number:</th>
					<th>Extension:</th>
					<th>Type Code:</th>
					<th>PrimaryInd:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th>Record Status:</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><s:property value="phoneNumberLinkDetail.phoneNumberDetail.countryCode" /></td>
					<td><s:property value="phoneNumberLinkDetail.phoneNumberDetail.areaCode" /></td>
					<td><s:property value="phoneNumberLinkDetail.phoneNumberDetail.phoneNumber" /></td>
					<td><s:property value="phoneNumberLinkDetail.phoneNumberDetail.extension" /></td>
					<td><s:property value="phoneNumberLinkDetail.typeCode" /></td>
					<td><s:property value="phoneNumberLinkDetail.primaryInd" /></td>
					<td><s:property value="phoneNumberLinkDetail.startDate" /></td>
					<td><s:property value="phoneNumberLinkDetail.endDate" /></td>
					<td><s:property value="phoneNumberLinkDetail.phoneNumberDetail.recordStatus" /></td>
				</tr>
			</tbody>
		</table>
</s:form>
</body>
</html>