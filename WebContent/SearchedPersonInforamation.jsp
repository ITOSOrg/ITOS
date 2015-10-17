<%@ page import="com.company.itos.profile.pojo.PersonSearchCriteria"%>
<%@ page import="com.company.itos.profile.pojo.PersonSearchResult"%>
<%@	page import="java.util.List"%>
<%@ page
	import="com.company.itos.profile.pojo.PersonSearchDetails"%>
<%@ page import="com.company.itos.profile.pojo.PersonDetail"%>
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
		PersonSearchDetails personSearchDetails = (PersonSearchDetails) request
				.getAttribute("personSearchDetails");
	
		PersonSearchCriteria  personSearchCriteria = personSearchDetails.getPersonSearchCriteria();
		
		
	%>

	<form action="/ITOS/SearchPerson" method="POST">
		<table>
		<font size="3" color="red"><%
		
		if(personSearchCriteria!=null){
			if(personSearchDetails.getErrorMessage()!=null && !personSearchDetails.getErrorMessage().equals("")){
				out.println(personSearchDetails.getErrorMessage());
			}
			
		
		%></font>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName" value="<%=personSearchCriteria.getFirstName()%>"></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="middleName" value="<%=personSearchCriteria.getMiddleName()%>"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" value="<%=personSearchCriteria.getLastName()%>"></td>
			</tr>
			<!--  <tr>
				<td>Date of Birth:</td>
				<td><input type="text" name="dateOfBirth"></td>
			</tr>-->
			
			<%
			} else{
				
				
		%>
		<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="middleName" ></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" ></td>
			</tr>
			
			<%
			}
			%>
			
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<form action="/ITOS/SearchPerson" method="POST">

		<table border=1>
			<thead>

				<tr>
					<th>PersonID:</th>
					<th>RefrenceNumber:</th>
					<th>First Name:</th>
					<th>Middle Name:</th>
					<th>Last Name:</th>
				</tr>
			</thead>
			<%
				if (personSearchDetails != null) {
					PersonSearchResult personSearchResult = personSearchDetails
							.getPersonSearchResult();

					List<PersonDetail> personDetailList = personSearchResult
							.getPersonDetailList();

					long numberOfPerson = personSearchResult.getNumberOfPerson();

					if (numberOfPerson > 0) {
						for (int i = 0; i < personDetailList.size(); i++) {
							PersonDetail personDetail = personDetailList.get(i);
			%>

			<tbody>
				<tr>
					<td><%=personDetail.getPersonID()%></td>
					<td><%=personDetail.getRefrenceNumber()%></td>
					<td><%=personDetail.getFirstName()%></td>
					<td><%=personDetail.getMiddleName()%></td>
					<td><%=personDetail.getLastName()%></td>
				</tr>
			</tbody>

			<%
				}
					}
				}
			%>
		</table>
	</form>
</body>
</html>