<%@ page import="com.company.itos.profile.pojo.PhoneNumberDetail"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<PhoneNumberDetail> phoneNumberDetailList = (List<PhoneNumberDetail>) request.getAttribute("phoneNumberDetailList");

Integer relatedID = (Integer) request.getAttribute("relatedID");
%>
<a href="CreatePhoneNumber.jsp?relatedID=<%= relatedID%>">Create</a>
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
					<th colspan=2>Action</th>
				</tr>
			</thead>
			
			<%
				for (int i = 0; i < phoneNumberDetailList.size(); i++) {
					PhoneNumberDetail	 phoneNumberDetail = phoneNumberDetailList.get(i);
			%>
			
			<tbody>
				<tr>
					<td><%=phoneNumberDetail.getCountryCode() %></td>
					<td><%=phoneNumberDetail.getAreaCode() %></td>
					<td><%=phoneNumberDetail.getPhoneNumber() %></td>
					<td><%=phoneNumberDetail.getExtension() %></td>
					<td><%=phoneNumberDetail.getTypeCode() %></td>
					<td><%=phoneNumberDetail.getPrimaryInd()%></td>
					<td><%=phoneNumberDetail.getStartDate()%></td>
					<td><%=phoneNumberDetail.getEndDate()%></td>
					<td><a href="/ITOS/ReadPhoneNumber?phoneNumberID=<%=phoneNumberDetail.getPhoneNumberID()%>&phoneNumberLinkID=<%=phoneNumberDetail.getPhoneNumberLinkID()%>&act=update">Update</a> </td>
				</tr>
			</tbody><br></br>
			<%} %>
		</table>
		</form>
</body>
</html>