<%@ page import="com.company.itos.profile.pojo.PhoneNumberDetail" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% PhoneNumberDetail phoneNumberDetail = (PhoneNumberDetail) request.getAttribute("phoneNumberDetail"); %>

<form name="Update Phone Number" action="/ITOS/UpdatePhoneNumber?phoneNumberLinkID=<%= phoneNumberDetail.getPhoneNumberLinkID() %>&phoneNumberID=<%=phoneNumberDetail.getPhoneNumberID() %> "
		method="POST">
		<table>s
		
		<tr>
		<td> Country Code:</td>
		<td><input type="text" name="countryCode"
		      value="<%=phoneNumberDetail.getCountryCode()%>"></td>
		</tr>
		<tr>
		<td> Area Code:</td>
		<td><input type="text" name="areaCode"
		      value="<%=phoneNumberDetail.getAreaCode()%>"></td>
		</tr>
		<tr>
		<td>Phone Number:</td>
		<td><input type="text" name="phoneNumber"
		     value="<%=phoneNumberDetail.getPhoneNumber()%>"></td>
		</tr>
		<tr>
		<td> Extension:</td>
		<td><input type="text" name="extension"
		     value="<%=phoneNumberDetail.getExtension()%>"></td>
		</tr>
		<tr>
		<td> Type Code:</td>
		<td><input type="text" name="typeCode"
		     value="<%=phoneNumberDetail.getTypeCode()%>"></td>
		</tr>
		<tr>
		<td> PrimaryInd:</td>
		<td><input type="text" name="primaryInd"
		     value="<%=phoneNumberDetail.getPrimaryInd()%>"></td>
		</tr>
		<tr>
		<td> Start Date:</td>
		<td><input type="text" name="startDate"
		     value="<%=phoneNumberDetail.getStartDate()%>"></td>
		</tr>
		
		<tr>
		<td> End Date:</td>
		<td><input type="text" name="endDate"
		      value="<%=phoneNumberDetail.getEndDate()%>"></td>
		</tr>
		<td><input  type="submit" value="Submit">
		
		
		
		</table>
		</form>
</body>
</html>