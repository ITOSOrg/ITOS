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

<s:form name="Create Email Address" action="/ITOS/CreateEmailAddressSubmit"
		method="POST">
		<table>
		  <tr>
				<td>Email Address :</td>
				<td><s:textfield type="text" name="emailAddressLinkDetail.emailAddressDetail.emailAddress"/></td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><s:textfield type="text" name="emailAddressLinkDetail.typeCode"/></td>
			</tr>
			<tr>
				<td>PrimaryInd :</td>
				<td><s:textfield type="text" name="emailAddressLinkDetail.primaryInd"/></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><s:textfield type="text" name="emailAddressLinkDetail.startDate"/></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><s:textfield type="text" name="emailAddressLinkDetail.endDate"/></td>
			</tr>
			<tr>

				<td><s:submit  type="submit" value="Submit"/>
                </td>
			</tr>
			
		
		</table>
		</s:form>

</body>
</html>