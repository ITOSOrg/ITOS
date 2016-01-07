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
    
    <s:form name="Read AuditTrail" action="/ITOS/ReadAuditTrail"
        method="POST">
        <table border=1>
            <thead>

                <tr>
                    <th align="left">TableName:</th>
                    <th>OperationType:</th>
                    <th>UserName:</th>
                    <th>TimeEntered:</th>
                    <th>RelatedID:</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><s:property value="auditTrailDetails.tableName" /></td>
                    <td><s:property value="auditTrailDetails.operationType" /></td>
                    <td><s:property value="auditTrailDetails.userName" /></td>
                    <td><s:property value="auditTrailDetails.timeEntered" /></td>
                    <td><s:property value="auditTrailDetails.relatedID" /></td>
                 </tr>
            </tbody>
        
        </s:form>

</body>
</html>