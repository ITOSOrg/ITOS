<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<s:form
		action="/ITOS/PersonUpdate"
		method="POST">

		
		<table>
			<tr>
				<td>Title :</td>
				<td><input type="text" name="personDetail.title"
					></td>
			</tr>

			<tr>
				<td>First Name :</td>
				<td><input type="text" name="personDetail.firstName"
					></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="personDetail.middleName"
					></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="personDetail.lastName"
					></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="text" name="personDetail.gender"
					></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="text" name="personDetail.dateOfBirth"
					></td>
			</tr>

			<tr>

				<td><input type="submit" value="submit">

			</tr>


		</table>

	</s:form>


</body>
</html>