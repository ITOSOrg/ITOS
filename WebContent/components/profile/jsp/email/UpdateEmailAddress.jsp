<%@ page import="com.company.itos.profile.pojo.EmailAddressDetail" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% EmailAddressDetail emailAddressDetail = (EmailAddressDetail) request.getAttribute("emailAddressDetail"); %>
<form action="/ITOS/UpdateEmailAddress?emailAddressLinkID=<%=emailAddressDetail.getEmailAddressLinkID() %>&emailAddressID=<%=emailAddressDetail.getEmailAddressID() %>&versionNo=<%=emailAddressDetail.getVersionNo()%>" method = "POST">
<table>
			<tr>
				<td>EmailAddress :</td>
				<td><input type="text" name="emailAddress"
					value="<%=emailAddressDetail.getEmailAddress()%>"></td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><input type="text" name="typeCode"
				      value = "<%=emailAddressDetail.getTypeCode()%>"></td>
			</tr>
			<tr>
				<td>PrimaryInd :</td>
				<td><input type="text" name="primaryInd"
				      value = "<%=emailAddressDetail.getPrimaryInd()%>"></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input type="text" name="startDate"
				      value = "<%=emailAddressDetail.getStartDate()%>"></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="text" name="endDate"
				      value = "<%=emailAddressDetail.getEndDate()%>"></td>
			</tr>
			<tr>

				<td><input  type="submit" value="Submit">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/ITOS/ListEmailAddress??relatedID=<%=emailAddressDetail.getRelatedID()%>">Back</a>
				</td>

			</tr>
</table>
</form>
</body>
</html>