<%@ page import="com.company.itos.profile.phone.pojo.PhoneNumberDetail"%>
<%@ page import="com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<script>
	$(function() {
		$("#myaccordion").accordion();
	});
</script>
</head>
<body>
<%
List<PhoneNumberLinkDetail> phoneNumberLinkDetailList = (List<PhoneNumberLinkDetail>) request.getAttribute("PhoneNumberLinkDetailList");

Integer relatedID = (Integer) request.getAttribute("relatedID");
%>

<div id="myaccordion">
		<h2>Phone Number List Workspace</h2>
		<div>

<a href="/ITOS/PersonHome?personID=<%= relatedID%>">Person Home</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

<a href="/ITOS/components/profile/jsp/phone/CreatePhoneNumber.jsp?relatedID=<%= relatedID%>">Create Phone Number</a>
<form action="/ITOS/ListPhoneNumber" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">Country Code:</th>
					<th>Area Code:</th>
					<th>Phone Number:</th>
					<th>Extension:</th>
					<th>Type Code:</th>
					<th>PrimaryInd:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th colspan=3>Action</th>
				</tr>
			</thead>
			
			<%
				for (int i = 0; i < phoneNumberLinkDetailList.size(); i++) {
					PhoneNumberLinkDetail	 phoneNumberLinkDetail = phoneNumberLinkDetailList.get(i);
					
					PhoneNumberDetail phoneNumberDetail = phoneNumberLinkDetail.getPhoneNumberDetail();
			%>
			
			<tbody>
				<tr>
					<td><%=phoneNumberDetail.getCountryCode() %></td>
					<td><%=phoneNumberDetail.getAreaCode() %></td>
					<td><%=phoneNumberDetail.getPhoneNumber() %></td>
					<td><%=phoneNumberDetail.getExtension() %></td>
					<td><%=phoneNumberLinkDetail.getTypeCode() %></td>
					<td><%=phoneNumberLinkDetail.getPrimaryInd()%></td>
					<td><%=phoneNumberLinkDetail.getStartDate()%></td>
					<td><%=phoneNumberLinkDetail.getEndDate()%></td>
					<td><a href="/ITOS/ReadPhoneNumber?phoneNumberID=<%=phoneNumberDetail.getPhoneNumberID()%>&phoneNumberLinkID=<%=phoneNumberLinkDetail.getPhoneNumberLinkID()%>&act=update">Update</a> </td>
					<td><a href="/ITOS/DeletePhoneNumber?phoneNumberID=<%=phoneNumberDetail.getPhoneNumberID()%>&phoneNumberLinkID=<%=phoneNumberLinkDetail.getPhoneNumberLinkID()%>&relatedID=<%=relatedID%>">Delete</a></td>
					<td><a href="/ITOS/ReadPhoneNumber?phoneNumberID=<%=phoneNumberDetail.getPhoneNumberID()%>&phoneNumberLinkID=<%=phoneNumberLinkDetail.getPhoneNumberLinkID()%>&relatedID=<%=relatedID%>">Read</a></td>
				</tr>
			</tbody><br></br>
			<%} %>
		</table>
		</form>
		</div>
		</div>
</body>
</html>