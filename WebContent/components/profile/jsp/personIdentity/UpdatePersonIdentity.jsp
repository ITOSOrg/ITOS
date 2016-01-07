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
		
<s:form action="/ITOS/UpdatePersonIdentitySubmit" method = "POST">
	
	<table>
			<tr>
				<td>alternateID </td>
				<td><s:textfield name="personIdentityDetail.alternateID"
					/></td>
			</tr>
			<tr>
				<td>PrimaryInd </td>
				<td><s:textfield name="personIdentityDetail.primaryInd"
				     /></td>
			</tr>
			<tr>
				<td>Type Code </td>
				<td><s:textfield name="personIdentityDetail.typeCode"
				      /></td>
			</tr>
			<tr>
				<td>Start Date </td>
				<td><s:textfield name="personIdentityDetail.startDate"
				     /></td>
			</tr>
			<tr>
				<td>End Date </td>
				<td><s:textfield name="personIdentityDetail.endDate"
				   /></td>
			</tr>
			<tr>

				<td><s:submit  type="submit" value="Submit"/><br><br>
				</td>

			</tr>
</table>
	        <s:hidden name="personIdentityDetail.personIdentityID"></s:hidden>
            <s:hidden name="personIdentityDetail.versionNo"></s:hidden>
</s:form>
</body>
</html>