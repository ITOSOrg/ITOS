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
        <h2>PersonIdentity Detail</h2>
        <div>

                    <s:url id="CreatePersonIdentityURL" action="/ITOS/CreatePersonIdentity" escapeAmp="false">
                           <!--   <s:param name="personIdentityDetail.personID" value="%{personIdentityDetail.personID}"/> -->
                    </s:url>
                            <s:a href="%{CreatePersonIdentityURL}">Create PersonIdentity</s:a>

<br><br>


<s:form action="/ITOS/ListPersonIdentity" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">AlternateID</th>
					<th>PrimaryInd</th>
					<th>Type Code</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th colspan=3>Action</th>
				</tr>
			</thead>
			
			
             <s:iterator value="personIdentityDetailList" status="stat">
			
			<tbody>
				<tr>
					<td><s:property value="alternateID" /></td>
					<td><s:property value="typeCode" /></td>
					<td><s:property value="primaryInd" /></td>
					<td><s:property value="startDate" /></td>
					<td><s:property value="endDate" /></td>
					
                     <td><s:url id="ReadPersonIdentityURL" action="/ITOS/ReadPersonIdentity" escapeAmp="false">
                                <s:param name="personIdentityDetail.personIdentityID" value="%{personIdentityID}"/>
                            </s:url>
                            <s:a href="%{ReadPersonIdentityURL}">View</s:a>
                            
                            
                            <s:url var="UpdatePersonIdentityURL" action="/ITOS/ReadPersonIdentity" escapeAmp="false">
                                  <s:param name="personIdentityDetail.personIdentityID" value="%{personIdentityID}"/>     
                                  <s:param name="act" value="%{updateAction}"/>
                            </s:url>
                            <s:a href="%{UpdatePersonIdentityURL}">Update</s:a>
                            
                            
                            
                            <s:url var="DeletePersonIdentityURL" action="/ITOS/DeletePersonIdentity" escapeAmp="false">
                                    <s:param name="personIdentityDetail.personIdentityID" value="%{personIdentityID}"/>
                            </s:url>
                            <s:a href="%{DeletePersonIdentityURL}">Delete</s:a>
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