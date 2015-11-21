<%@ page import="com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% PersonIdentityDetail personIdentityDetail = (PersonIdentityDetail) request.getAttribute("personIdentityDetail"); 
		%>
		
	<br><a href="/ITOS/ListPersonIdentity?personID=<%=personIdentityDetail.getPersonID()%>">PersonIdentityList Home</a></td><br><br>
<form action="/ITOS/UpdatePersonIdentity?personIdentityID=<%=personIdentityDetail.getPersonIdentityID()%>&versionNo=<%=personIdentityDetail.getVersionNo()%>" method = "POST">
	
	<table>
			<tr>
				<td>alternateID :</td>
				<td><input type="text" name="alternateID"
					value="<%=personIdentityDetail.getAlternateID()%>"></td>
			</tr>
			<tr>
				<td>PrimaryInd :</td>
				<td><input type="text" name="primaryInd"
				      value = "<%=personIdentityDetail.getPrimaryInd()%>"></td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><input type="text" name="typeCode"
				      value = "<%=personIdentityDetail.getTypeCode()%>"></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input type="text" name="startDate"
				      value = "<%=personIdentityDetail.getStartDate()%>"></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="text" name="endDate"
				      value = "<%=personIdentityDetail.getEndDate()%>"></td>
			</tr>
			<tr>

				<td><input  type="submit" value="Submit"><br><br>
				</td>

			</tr>
</table>
	
</form>
</body>
</html>