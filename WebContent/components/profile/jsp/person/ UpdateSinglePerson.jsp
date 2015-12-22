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
		action="/ITOS/UpdateSinglePersonSubmit"
		method="POST">

		
		<table>
			<tr>
				<td>Title :</td>
				<td><s:textfield name="personDetail.title"
					/></td>
			</tr>

			<tr>
				<td>First Name :</td>
				<td><s:textfield name="personDetail.firstName"
					/></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><s:textfield name="personDetail.middleName"
					/></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><s:textfield name="personDetail.lastName"
					/></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><s:textfield name="personDetail.gender"
					/></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><s:textfield name="personDetail.dateOfBirth"
					/></td>
			</tr>

			<tr>

				<td><s:submit type="submit" value="submit"/>
                <s:hidden name="personDetail.personID"></s:hidden>
                <s:hidden name="personDetail.versionNo"></s:hidden>

			</tr>


		</table>

	</s:form>


</body>
</html>