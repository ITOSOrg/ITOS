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


<s:form action="/ITOS/UpdateUserRoleLinkSubmit" method = "POST">
<table>
			
			<tr>
				<td>User Name :</td>
				<td><s:textfield type="text" name="userRoleLinkDetail.username"
				     /></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><s:textfield type="text" name="userRoleLinkDetail.startDate"
				     /></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><s:textfield type="text" name="userRoleLinkDetail.endDate"
				     /></td>
			</tr>
			
			<tr>

				<td><s:submit type="submit" value="Submit"/>
				</td>

			</tr>
</table>
                <s:hidden name="userRoleLinkDetail.userRoleLinkID"></s:hidden> 
                <s:hidden name="userRoleLinkDetail.versionNo"></s:hidden>
</s:form>
</body>
</html>