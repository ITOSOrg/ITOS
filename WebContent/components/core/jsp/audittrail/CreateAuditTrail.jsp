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
    
    <s:form name="Create AuditTrail" action="/ITOS/CreateAuditTrailSubmit"
        method="POST">
        
        <table>
            <tr>
                <td>TableName :</td>
                <td><s:textfield type="text" name="auditTrailDetails.tableName" /></td>
            </tr>
            <tr>
                <td>OperationType :</td>
                <td><s:textfield type="text" name="auditTrailDetails.operationType"/></td>
            </tr>
            <tr>
                <td>UserName :</td>
                <td><s:textfield type="text" name="auditTrailDetails.userName"/></td>
            </tr>
            <tr>
                <td>RelatedID :</td>
                <td><s:textfield type="text" name="auditTrailDetails.relatedID"/></td>
            </tr>
            
            <tr>

                <td><s:submit type="submit" value="Submit"/>
            </tr>

        </table>
    </s:form>
</div>
</div>
        
</body>
</html>