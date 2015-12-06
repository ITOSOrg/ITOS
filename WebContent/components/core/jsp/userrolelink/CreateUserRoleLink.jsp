<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="Create KeyServer" action="/ITOS/CreateUserRoleLink"
		method="POST">
		<table>
		  
			
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input type="text" name="startDate"></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="text" name="endDate"></td>
			</tr>
			
			<tr>
				<td>Role :</td>
				<td><select name="roleID">
				    <option  value="9001" >Administrator</option>	
					<option  value="9002" >Employee</option>	
					<option  value="9003" >Devloper</option>	
			        </select>
				</td>
			</tr>
			
			<tr>

				<td><input  type="submit" value="Submit">
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListUserRoleLink"> ListUserRoleLink Home</a><br><br>

			</tr>
			
		
		</table>
		</form>
</body>
</html>