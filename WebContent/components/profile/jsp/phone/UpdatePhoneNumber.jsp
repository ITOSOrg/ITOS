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

<s:form name="Update Phone Number" action="/ITOS/UpdatePhoneNumberSubmit"
		method="POST">
		<table>
		
		<tr>
		<td> Country Code:</td>
		<td><s:textfield name="phoneNumberLinkDetail.phoneNumberDetail.countryCode"
		      /></td>
		</tr>
		<tr>
		<td> Area Code:</td>
		<td><s:textfield name="phoneNumberLinkDetail.phoneNumberDetail.areaCode"
		      /></td>
		</tr>
		<tr>
		<td>Phone Number:</td>
		<td><s:textfield name="phoneNumberLinkDetail.phoneNumberDetail.phoneNumber"
		    /></td>
		</tr>
		<tr>
		<td> Extension:</td>
		<td><s:textfield name="phoneNumberLinkDetail.phoneNumberDetail.extension"
		    /></td>
		</tr>
		<tr>
		<td> Type Code:</td>
		<td><s:textfield name="phoneNumberLinkDetail.typeCode"
		    /></td>
		</tr>
		<tr>
		<td> PrimaryInd:</td>
		<td><s:textfield name="phoneNumberLinkDetail.primaryInd"
		     /></td>
		</tr>
		<tr>
		<td> Start Date:</td>
		<td><s:textfield name="phoneNumberLinkDetail.startDate"
		    /></td>
		</tr>
		
		<tr>
		<td> End Date:</td>
		<td><s:textfield name="phoneNumberLinkDetail.endDate"
		     /></td>
		</tr>
		<td><s:submit  type="submit" value="Submit"/></td>
		</table>
        <s:hidden name="phoneNumberLinkDetail.phoneNumberLinkID"></s:hidden>
        <s:hidden name="phoneNumberLinkDetail.versionNo"></s:hidden>
        <s:hidden name="phoneNumberLinkDetail.phoneNumberDetail.phoneNumberID"></s:hidden>
        <s:hidden name="phoneNumberLinkDetail.phoneNumberDetail.versionNo"></s:hidden>
		</s:form>
</body>
</html>