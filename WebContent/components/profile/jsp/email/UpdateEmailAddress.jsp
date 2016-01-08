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

<s:form action="/ITOS/UpdateEmailAddressSubmit" method = "POST">
<table>
			<tr>
				<td>EmailAddress </td>
				<td><s:textfield name="emailAddressLinkDetail.emailAddressDetail.emailAddress"
					/></td>
			</tr>
			<tr>
				<td>Type Code </td>
				<td><s:textfield name="emailAddressLinkDetail.typeCode"
				      /></td>
			</tr>
			<tr>
				<td>PrimaryInd </td>
				<td><s:textfield name="emailAddressLinkDetail.primaryInd"
				     /></td>
			</tr>
			 <tr>
				<td>Start Date </td>
				<td><s:textfield name="emailAddressLinkDetail.startDate"
				    /></td>
			</tr>
			<tr>
				<td>End Date </td>
				<td><s:textfield name="emailAddressLinkDetail.endDate"/></td>
			</tr>
			<tr>

				<td><s:submit  type="submit" value="Submit"/><br><br>
				</td>

			</tr>
</table>
        <s:hidden name="emailAddressLinkDetail.emailAddressLinkID"></s:hidden>
        <s:hidden name="emailAddressLinkDetail.versionNo"></s:hidden>
        <s:hidden name="emailAddressLinkDetail.emailAddressDetail.versionNo"></s:hidden>
        <s:hidden name="emailAddressLinkDetail.relatedID"></s:hidden>
        
</s:form>
</body>
</html>