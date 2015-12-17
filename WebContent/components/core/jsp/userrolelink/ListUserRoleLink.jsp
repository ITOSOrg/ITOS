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

                        <s:url id="CreateUserRoleLinkURL" action="/ITOS/CreateUserRoleLink" escapeAmp="false">
                        </s:url>
                        <s:a href="%{CreateUserRoleLinkURL}">View</s:a>


<s:form action="/ITOS/ListUserRoleLink" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">User Name:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th>Record Status:</th>
					<th colspan=3>Action</th>
				</tr>
			</thead>
			
		            <s:iterator value="userRoleLinklist" status="stat">
			
			<tbody>
				<tr>
					<td><s:property value="username"/></td>
					<td><s:property value="startDate"/></td>
					<td><s:property value="endDate"/></td>
					<td><s:property value="recordStatus"/></td>
					
                    <td>    <s:url id="ReadUserRoleLinkURL" action="/ITOS/ReadUserRoleLink" escapeAmp="false">
                                <s:param name="userRoleLinkDetail.userRoleLinkID" value="%{userRoleLinkID}"/>
                            </s:url>
                            <s:a href="%{ReadUserRoleLinkURL}">View</s:a>
                            
                            <s:url var="UpdateUserRoleLinkURL" action="/ITOS/ReadUserRoleLink" escapeAmp="false">
                                <s:param name="userRoleLinkDetail.userRoleLinkID" value="%{userRoleLinkID}"/>
                                <s:param name="act" value="%{updateAction}"/>
                            </s:url>
                            <s:a href="%{UpdateUserRoleLinkURL}">Update</s:a>
                            
                            <s:url id="DeleteUserRoleLinkURL" action="/ITOS/DeleteUserRoleLink" escapeAmp="false">
                                <s:param name="userRoleLinkDetail.userRoleLinkID" value="%{userRoleLinkID}"/>
                            </s:url>
                            <s:a href="%{DeleteUserRoleLinkURL}">Delete</s:a>
                            
                        </td>
                    
                    
				</tr>
				
			</tbody>
            </s:iterator>
		</table>
		</s:form>

</body>
</html>