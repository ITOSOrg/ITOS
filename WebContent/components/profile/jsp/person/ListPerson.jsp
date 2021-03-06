<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
	$(function() {
		$("#myaccordion").accordion();
	});
	
	
	
</script>
</head>
<body>


<div id="myaccordion">
		<h2>Person List</h2>
		<div>
	
	<s:form action="/ITOS/PersonList" method="post">
	
		<table border=1>
			<thead>

				<tr>
					<th align="left">Title</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Last Name</th>
					<th>Date Of Birth</th>
					<th>Gender</th>
					<th>Created By</th>
					<th align="center">Created On</th>
					<th align="center">LastModified By</th>
					<th align="center">LastModified On</th>
					<th align="center">Registration Date</th>
					 
					 
					<th colspan=3>Action</th>
				</tr>
			</thead>

			
            <s:iterator value="personDetailList" status="stat">
            
			<tbody>
				<tr>
					<td><s:property value="title"/></td>
					<td><s:property value="firstName" /></td>
					<td><s:property value="middleName" /></td>
					<td><s:property value="lastName" /></td>
					<td><s:property value="dateOfBirth" /></td>
					<td><s:property value="gender" /></td>
					<td><s:property value="auditTrailDtls.createdBy" /></td>
					<td><s:property value="auditTrailDtls.createdOn" /></td>
					<td><s:property value="auditTrailDtls.lastModifieddBy" /></td>
					<td><s:property value="auditTrailDtls.lastModifiedOn" /></td>
					<td><s:property value="registrationDate" /></td>
					
					<td>
                    
                    <s:url id="ReadPersonHomeURL" action="/ITOS/ReadPerson" escapeAmp="false">
                                <s:param name="personDetail.personID" value="%{personID}"/>
                            </s:url>
                            <s:a href="%{ReadPersonHomeURL}">View</s:a>
                            
                            <s:url var="updatePersonHomeURL" action="/ITOS/ReadPerson" escapeAmp="false">
                                <s:param name="personDetail.personID" value="%{personID}"/>
                                <s:param name="act" value="%{updateAction}"/>
                            </s:url>
                            <s:a href="%{updatePersonHomeURL}">Update</s:a>
                            
                            <s:url id="PersonDeleteURL" action="/ITOS/PersonDelete" escapeAmp="false">
                                <s:param name="personDetail.personID" value="%{personID}"/>
                            </s:url>
                            <s:a href=  "%{PersonDeleteURL}" onclick="return confirm('Are you sure you want to Remove?');" >Delete</s:a>
                    
                    </td>

				</tr>
			</tbody>
			</s:iterator>
			
		</table><br>
                            <s:url id="CreateUserURL" action="/ITOS/CreateUser" escapeAmp="false">
                            </s:url>
                            <s:a href="%{CreateUserURL}">Add User</s:a>
			
</s:form>
</div>
</div>		
</body>
</html>