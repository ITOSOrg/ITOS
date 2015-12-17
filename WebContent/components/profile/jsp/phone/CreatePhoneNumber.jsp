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

<s:form name="Create Phone Number" action="/ITOS/CreatePhoneNumberSubmit"
		method="POST">
		<table>
		
		<tr>
		<td> Country Code:</td>
		<td><s:textfield type="text" name="PhoneNumberDetail.countryCode"/></td>
		</tr>
		<tr>
		<td> Area Code:</td>
		<td><s:textfield type="text" name="PhoneNumberDetail.areaCode"/></td>
		</tr>
		<tr>
		<td>Phone Number:</td>
		<td><s:textfield type="text" name="PhoneNumberDetail.phoneNumber"/></td>
		</tr>
		<tr>
		<td> Extension:</td>
		<td><s:textfield type="text" name="PhoneNumberDetail.extension"/></td>
		</tr>
		<tr>
		<td> Type Code:</td>
		<td><s:textfield type="text" name="PhoneNumberLinkDetail.typeCode"/></td>
		</tr>
		<tr>
		<td> PrimaryInd:</td>
		<td><s:textfield type="text" name="PhoneNumberLinkDetail.primaryInd"/></td>
		</tr>
		<tr>
		<td> Start Date:</td>
		<td><s:textfield type="text" name="PhoneNumberLinkDetail.startDate"/></td>
		</tr>
		
		<tr>
		<td> End Date:</td>
		<td><s:textfield type="text" name="PhoneNumberLinkDetail.endDate"/></td>
		</tr>
		<tr>
		<td><s:submit  type="submit" value="Submit"/>
		</tr>
		</table>
		</s:form>
</body>
</html>