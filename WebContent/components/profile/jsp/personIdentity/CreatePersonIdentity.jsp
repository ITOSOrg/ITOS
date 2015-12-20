<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<s:form name="Create Person Identity" action="/ITOS/CreatePersonIdentitySubmit"
		method="POST">
		<table>
		  
			<tr>
				<td>AlternateID :</td>
				<td><s:textfield type="text" name="PersonIdentityDetail.alternateID"/></td>
			</tr>
			<tr>
				<td>PrimaryInd :</td>
				<td><s:textfield type="text" name="PersonIdentityDetail.primaryInd"/></td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><s:textfield type="text" name="PersonIdentityDetail.typeCode"/></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><s:textfield type="text" name="PersonIdentityDetail.startDate"/></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><s:textfield type="text" name="PersonIdentityDetail.endDate"/></td>
			</tr>
			<tr>

				<td><s:submit  type="submit" value="Submit"/>

			</tr>
			
		
		</table>
    <!--     <s:hidden name="PersonIdentityDetail.personID"></s:hidden> --> 
		</s:form>

</body>
</html>