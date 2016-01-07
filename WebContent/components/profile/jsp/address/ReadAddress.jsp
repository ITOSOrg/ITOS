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

<s:form action="/ITOS/ReadAddress" method="POST">

<table border=1>
					<thead>

						<tr>
							<th align="left">StreetOne</th>
							<th>StreetTwo</th>
							<th>AptUnit</th>
							<th>City</th>
							<th>County</th>
							<th>State</th>
							<th>Country</th>
							<th>ZipCode</th>
							<th>Type Code</th>
							<th>PrimaryInd</th>
							<th>StartDate</th>
							<th>End Date</th>
							<th>Record Status</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><s:property value="addressLinkDetail.addressDetail.streetOne" /></td>
							<td><s:property value="addressLinkDetail.addressDetail.streetTwo" /></td>
							<td><s:property value="addressLinkDetail.addressDetail.aptUnit" /></td>
							<td><s:property value="addressLinkDetail.addressDetail.city" /></td>
							<td><s:property value="addressLinkDetail.addressDetail.county" /></td>
							<td><s:property value="addressLinkDetail.addressDetail.state" /></td>
							<td><s:property value="addressLinkDetail.addressDetail.country" /></td>
							<td><s:property value="addressLinkDetail.addressDetail.zipCode" /></td>
							<td><s:property value="addressLinkDetail.typeCode" /></td>
							<td><s:property value="addressLinkDetail.primaryInd" /></td>
							<td><s:property value="addressLinkDetail.startDate" /></td>
							<td><s:property value="addressLinkDetail.endDate" /></td>
							<td><s:property value="addressLinkDetail.recordStatus" /></td>
						</tr>
					</tbody>

</s:form>
</body>
</html>