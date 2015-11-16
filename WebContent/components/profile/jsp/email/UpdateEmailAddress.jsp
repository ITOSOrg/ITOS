<%@ page import="com.company.itos.profile.email.pojo.EmailAddressDetail" %>
<%@ page import="com.company.itos.profile.email.pojo.EmailAddressLinkDetail" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% EmailAddressLinkDetail emailAddressLinkDetail = (EmailAddressLinkDetail) request.getAttribute("emailAddressLinkDetail"); 

EmailAddressDetail emailAddressDetail = emailAddressLinkDetail.getEmailAddressDetail();

%>

<form action="/ITOS/UpdateEmailAddress?emailAddressLinkID=<%=emailAddressLinkDetail.getEmailAddressLinkID() %>&versionNo=<%=emailAddressLinkDetail.getVersionNo()%>&versionNo=<%=emailAddressDetail.getVersionNo()%>&emailAddressID=<%=emailAddressDetail.getEmailAddressID() %>" method = "POST">
<table>
			<tr>
				<td>EmailAddress :</td>
				<td><input type="text" name="emailAddress"
					value="<%=emailAddressDetail.getEmailAddress()%>"></td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><input type="text" name="typeCode"
				      value = "<%=emailAddressLinkDetail.getTypeCode()%>"></td>
			</tr>
			<tr>
				<td>PrimaryInd :</td>
				<td><input type="text" name="primaryInd"
				      value = "<%=emailAddressLinkDetail.getPrimaryInd()%>"></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input type="text" name="startDate"
				      value = "<%=emailAddressLinkDetail.getStartDate()%>"></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="text" name="endDate"
				      value = "<%=emailAddressLinkDetail.getEndDate()%>"></td>
			</tr>
			<tr>

				<td><input  type="submit" value="Submit">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/ITOS/ListEmailAddress?relatedID=<%=emailAddressLinkDetail.getRelatedID()%>">Back</a>
				</td>

			</tr>
</table>
</form>
</body>
</html>