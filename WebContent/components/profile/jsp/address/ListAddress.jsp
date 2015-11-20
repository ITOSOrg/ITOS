<%@ page import="java.util.List"%>
<%@ page
	import="com.company.itos.profile.address.pojo.AddressLinkDetail"%>
<%@ page import="com.company.itos.profile.address.pojo.AddressDetail"%>
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
		List<AddressLinkDetail> addressLinkDetailList = (List<AddressLinkDetail>) request.getAttribute("addressLinkDetailList");

		Integer relatedID = (Integer) request.getAttribute("relatedID");
	%>
	

	<div id="myaccordion">
		<h2>Address List Workspace</h2>
		<div>

			<a href="/ITOS/PersonHome?personID=<%=relatedID%>">Person Home</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<a href="/ITOS/components/profile/jsp/address/CreateAddress.jsp?relatedID=<%= relatedID%>">Create Address</a><br><br>
			<br>

			<form action="/ITOS/ListAddress" method="POST">
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
							<th>StartDate:</th>
							<th>End Date:</th>
							<th colspan=3>Action</th>
						</tr>
					</thead>

					<%
						for (int i = 0; i < addressLinkDetailList.size(); i++) {
							AddressLinkDetail addressLinkDetail = addressLinkDetailList.get(i);
							AddressDetail addressDetail = addressLinkDetail.getAddressDetail();
					%>

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
							<td><%=addressLinkDetail.getStartDate()%></td>
							<td><%=addressLinkDetail.getEndDate()%></td>
							<td><a
								href="/ITOS/ReadAddress?addressID=<%=addressDetail.getAddressId()%>&addressLinkID=<%=addressLinkDetail.getAddressLinkID()%>&relatedID=<%= relatedID%>&act=update">Update</a>
							</td>
							<td><a
								href="/ITOS/DeleteAddress?addressID=<%=addressDetail.getAddressId()%>&addressLinkID=<%=addressLinkDetail.getAddressLinkID()%>&relatedID=<%=relatedID%>">Delete</a></td>
							<td><a
								href="/ITOS/ReadAddress?addressID=<%=addressDetail.getAddressId()%>&addressLinkID=<%=addressLinkDetail.getAddressLinkID()%>&relatedID=<%= relatedID%>">Read</a>
							</td>
						</tr>

					</tbody>
					<%} %>
				</table>
			</form>
		</div>
	</div>
</body>
</html>