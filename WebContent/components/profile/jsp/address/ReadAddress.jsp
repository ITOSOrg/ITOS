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
<form action="/ITOS/ReadAddress" method="POST">

<table border=1>
					<thead>

						<tr>
							<th align="left">StreetOne:</th>
							<th>StreetTwo:</th>
							<th>AptUnit:</th>
							<th>City:</th>
							<th>County:</th>
							<th>State:</th>
							<th>Country:</th>
							<th>ZipCode:</th>
							<th>Type Code:</th>
							<th>PrimaryInd:</th>
							<th>StartDate:</th>
							<th>End Date:</th>
							<th>Record Status:</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><%=addressDetail.getStreetOne()%></td>
							<td><%=addressDetail.getStreetTwo()%></td>
							<td><%=addressDetail.getAptUnit()%></td>
							<td><%=addressDetail.getCity()%></td>
							<td><%=addressDetail.getCounty()%></td>
							<td><%=addressDetail.getState()%></td>
							<td><%=addressDetail.getCountry()%></td>
							<td><%=addressDetail.getZipCode()%></td>
							<td><%=addressLinkDetail.getTypeCode()%></td>
							<td><%=addressLinkDetail.getPrimaryInd()%></td>
							<td><%=addressLinkDetail.getStartDate()%></td>
							<td><%=addressLinkDetail.getEndDate()%></td>
							<td><%=addressLinkDetail.getRecordStatus()%></td>
						</tr>
					</tbody>

<br><a href="/ITOS/ListAddress?relatedID=<%= addressLinkDetail.getRelatedID() %>">AddressList Home</a></td><br><br>
</form>
</body>
</html>