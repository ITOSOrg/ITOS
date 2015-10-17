<%@ page import="java.util.List"%>
<%@ page import="com.company.itos.profile.pojo.PersonDetail"%>
<%@ page
	import="com.company.itos.profile.servlet.PersonRegistration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h> Registration Form</h>


	<form name="Registration" action="/ITOS/PersonRegistration"
		method="POST">
		<table>
			<%
				PersonDetail personDetail = (PersonDetail) request
						.getAttribute("personDetail");

				if (personDetail != null) {

					List<String> errorMessageList = personDetail
							.getErrorMessageList();

					for (int i = 0; i < errorMessageList.size(); i++) {
			%>

			<br>
			<font size="3" color="red"> <%
					out.println(errorMessageList.get(i));
				%>
			</font>
			<%
				}
			%>
			
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
			       <td> Gender:</td>
			       <td><input type="text" name="gender"
			             value="<%=personDetail.getGender()%>">    </td>
			</tr>
			
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="text" name="dateOfBirth"
					value="<%=personDetail.getDateOfBirth()%>"></td>
			</tr>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="userName"
					value="<%=personDetail.getUsersDetail().getUserName()%>"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password"
					value="<%=personDetail.getUsersDetail().getPassword()%>"></td>
			</tr>

			<%
				} else {
			%>

			
			<tr>
				<td>Title :</td>
				<td><input type="text" name="title"></td>
			</tr>

			<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="middleName"></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			
			<tr>
			<td>Gender:</td>
			<td><input type="text" name="gender"></td>
			</tr>
			
			
			<!-- <tr>
			<td>Gender</td>
			<td><select>
				<option value="Male" name="gender">Male</option>	
				<option value="Female" name="gender">Female</option>	
			</select></td>
			
			</tr> -->
			
			
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="text" name="dateOfBirst"></td>
			</tr>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password"></td>
			</tr>

			<!--  
			
			
			<tr> 
			       <td> Age:</td>
			       <td><select name="agevalue">
			       <option value="18">18</option>
			       <option value="19">19</option>
			       <option value="20">20</option>
			       <option value="21">21</option>
			       <option value="22">22</option>
			       <option value="23">23</option>
			       </select></td>
			</tr>
			<tr> 
			       <td>Email:</td>
			       <td><input type="text" name="textmail" ></td>
			</tr>
			<tr> 
			       <td>UserName:</td>
			       <td><input type="text" name="textUserName" ></td>
			</tr>
			<tr> 
			       <td>Password:</td>
			       <td><input type="password" name="textpass" ></td>
			</tr>
			<tr> 
			       <td> Street Name:</td>
			       <td><textarea name="textStreet"></textarea></td>
			</tr>
			<tr> 
			       <td> City:</td>
			       <td><input type="text" name="textCity" ></td>
			</tr>
			<tr> 
			       <td> State:</td>
			       <td><input type="text" name="textState" ></td>
			</tr>-->

			<%
				}
			%>
			<tr>

				<td><input type="submit" value="Submit"></td>

			</tr>

		</table>

	</form>
	<form action="/ITOS/PersonLogOut" method="POST">
		<br> <input type="submit" value="Cancel">
	</form>


</body>
</html>