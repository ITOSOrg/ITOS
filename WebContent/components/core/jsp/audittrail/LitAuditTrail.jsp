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
        <h2>Create AuditTrail</h2>
        <div>
        
        <a href="/ITOS/CreateAuditTrail">Create AuditTrail</a><br><br>
    
    <s:form name="List AuditTrail" action="/ITOS/ListAuditTrail"
        method="POST">
        <table border=1>
            <thead>

                <tr>
                    <th align="left">TableName</th>
                    <th>OperationType</th>
                    <th>UserName</th>
                    <th>TimeEntered</th>
                    <th>RelatedID</th>
                    <th colspan="3">Action</th>
                </tr>
            </thead>
            <s:iterator value="auditTrailDetailList" status="stat">
            <tbody>
                <tr>
                    <td><s:property value="tableName" /></td>
                    <td><s:property value="operationType" /></td>
                    <td><s:property value="userName" /></td>
                    <td><s:property value="timeEntered" /></td>
                    <td><s:property value="relatedID" /></td>
                    <td><s:url id="ReadAuditTrailURL" action="/ITOS/ReadAuditTrail" escapeAmp="false">
                                <s:param name="auditTrailDetails.auditTrailID" value="%{auditTrailID}"/>
                            </s:url>
                            <s:a href="%{ReadAuditTrailURL}">View</s:a>
                            
                            <s:url var="updateAuditTrailURL" action="/ITOS/ReadAuditTrail" escapeAmp="false">
                                <s:param name="auditTrailDetails.auditTrailID" value="%{auditTrailID}"/>
                                <s:param name="act" value="%{updateAction}"/>
                            </s:url>
                            <s:a href="%{updateAuditTrailURL}">Update</s:a>
                            
                            <s:url var="deleteAuditTrailURL" action="/ITOS/DeleteAuditTrail" escapeAmp="false">
                                <s:param name="auditTrailDetails.auditTrailID" value="%{auditTrailID}"/>
                            </s:url>
                            <s:a href="%{deleteAuditTrailURL}">Delete</s:a>
                            
                        </td>
                 </tr>
            </tbody>
            </s:iterator>
        
</table>
</s:form>
</div>
</div>
</body>
</html>