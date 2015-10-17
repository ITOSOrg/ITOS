<%@ page import="java.util.List"%>
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
		PersonDetail personDetail = (PersonDetail) request
				.getAttribute("personDetail");
	%>
	<form
		action="/ITOS/PersonUpdate?userName=<%=personDetail.getUserName()%>&versionNo=<%=personDetail.getVersionNo()%>"
		method="POST">

		<%
			if (personDetail != null) {
				List<String> errorMessageList = personDetail
						.getErrorMessageList();
				for (int i = 0; i < errorMessageList.size(); i++) {
		%>
		<br> <font size="3" color="red"> <%
				out.println(errorMessageList.get(i));
			%>
		</font>
		<%
			}
			}
		%>

		<table>
			<tr>
				<td>Title :</td>
				<td><input type="text" name="title"
					value="<%=personDetail.getTitle()%>"></td>
			</tr>

			<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstName"
					value="<%=personDetail.getFirstName()%>"></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="middleName"
					value="<%=personDetail.getMiddleName()%>"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"
					value="<%=personDetail.getLastName()%>"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="text" name="gender"
					value="<%=personDetail.getGender()%>"></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="text" name="dateOfBirth"
					value="<%=personDetail.getDateOfBirth()%>"></td>
			</tr>

			<tr>

				<td><input type="submit" value="submit">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="LoginForm.jsp">Back</a></td>

			</tr>


		</table>

	</form>


</body>
</html>