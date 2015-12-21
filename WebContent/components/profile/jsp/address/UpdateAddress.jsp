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


<s:form action="/ITOS/UpdateAddressSubmit" method = "POST">
<table>
			<tr>
				<td>StreetOne :</td>
				<td><s:textfield name="addressLinkDetail.addressDetail.streetOne"
					/></td>
			</tr>
			<tr>
				<td>StreetTwo :</td>
				<td><s:textfield name="addressLinkDetail.addressDetail.streetTwo"
				      /></td>
			</tr>
			<tr>
				<td>Apartment Unit :</td>
				<td><s:textfield name="addressLinkDetail.addressDetail.aptUnit"
				      /></td>
			</tr>
			<tr>
				<td>City :</td>
				<td><s:textfield name="addressLinkDetail.addressDetail.city"
				      /></td>
			</tr>
			<tr>
				<td>County :</td>
				<td><s:textfield name="addressLinkDetail.addressDetail.county"
				      /></td>
			</tr>
			<tr>
				<td>State :</td>
				<td><s:textfield name="addressLinkDetail.addressDetail.state"
				    /></td>
			</tr>
			<tr>
				<td>Country :</td>
				<td><s:textfield name="addressLinkDetail.addressDetail.country"
				      /></td>
			</tr>
			<tr>
				<td>ZipCode :</td>
				<td><s:textfield name="addressLinkDetail.addressDetail.zipCode"
				     /></td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><s:textfield name="addressLinkDetail.typeCode"
				     /></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><s:textfield name="addressLinkDetail.startDate"
				    /></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><s:textfield name="addressLinkDetail.endDate"
				      /></td>
			</tr>
			<tr>

				<td><s:submit  type="submit" value="Submit"/><br><br>
				</td>

			</tr>
</table>
             <s:hidden name="addressLinkDetail.addressLinkID"></s:hidden>
        <s:hidden name="addressLinkDetail.versionNo"></s:hidden>
        <s:hidden name="addressLinkDetail.addressDetail.versionNo"></s:hidden>
</s:form>

</body>
</html>