<%@ page import="com.company.itos.profile.address.pojo.AddressLinkDetail"%>
<%@ page import="com.company.itos.profile.address.pojo.AddressDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% AddressLinkDetail addressLinkDetail = (AddressLinkDetail) request.getAttribute("addressLinkDetail"); 

   AddressDetail addressDetail = addressLinkDetail.getAddressDetail();

%>

<form action="/ITOS/UpdateAddress?addressLinkID=<%=addressLinkDetail.getAddressLinkID() %>&versionNo=<%=addressLinkDetail.getVersionNo()%>&versionNo=<%=addressDetail.getVersionNo()%>&addressId=<%=addressDetail.getAddressId() %>" method = "POST">
<table>
			<tr>
				<td>StreetOne :</td>
				<td><input type="text" name="streetOne"
					value="<%=addressDetail.getStreetOne()%>"></td>
			</tr>
			<tr>
				<td>StreetTwo :</td>
				<td><input type="text" name="streetTwo"
				      value = "<%=addressDetail.getStreetTwo()%>"></td>
			</tr>
			<tr>
				<td>Apartment Unit :</td>
				<td><input type="text" name="aptUnit"
				      value = "<%=addressDetail.getAptUnit()%>"></td>
			</tr>
			<tr>
				<td>City :</td>
				<td><input type="text" name="city"
				      value = "<%=addressDetail.getCity()%>"></td>
			</tr>
			<tr>
				<td>County :</td>
				<td><input type="text" name="county"
				      value = "<%=addressDetail.getCounty()%>"></td>
			</tr>
			<tr>
				<td>State :</td>
				<td><input type="text" name="state"
				      value = "<%=addressDetail.getState()%>"></td>
			</tr>
			<tr>
				<td>Country :</td>
				<td><input type="text" name="country"
				      value = "<%=addressDetail.getCountry()%>"></td>
			</tr>
			<tr>
				<td>ZipCode :</td>
				<td><input type="text" name="zipCode"
				      value = "<%=addressDetail.getZipCode()%>"></td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><input type="text" name="typeCode"
				      value = "<%=addressLinkDetail.getTypeCode()%>"></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input type="text" name="startDate"
				      value = "<%=addressLinkDetail.getStartDate()%>"></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="text" name="endDate"
				      value = "<%=addressLinkDetail.getEndDate()%>"></td>
			</tr>
			<tr>

				<td><input  type="submit" value="Submit"><br><br>
				<a href="/ITOS/ListEmailAddress?relatedID=<%=addressLinkDetail.getRelatedID()%>">EmailAddressList Home</a>
				</td>

			</tr>
</table>
</form>

</body>
</html>