<%@ page import="com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail"%>
<%@ page import="java.util.List"%>
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


<s:form action="/ITOS/ReadPersonIdentity" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">AlternateID:</th>
					<th>PrimaryInd:</th>
					<th>Type Code:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th>Record Status:</th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td><s:property value="personIdentityDetail.alternateID" /></td>
					<td><s:property value="personIdentityDetail.typeCode" /></td>
					<td><s:property value="personIdentityDetail.primaryInd" /></td>
					<td><s:property value="personIdentityDetail.startDate" /></td>
					<td><s:property value="personIdentityDetail.endDate" /></td>
					<td><s:property value="personIdentityDetail.recordStatus" /></td>
				</tr>
				
			</tbody>
		</table>
		</s:form>

</body>
</html>