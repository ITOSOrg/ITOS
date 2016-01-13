<%@ page import="com.company.itos.profile.address.pojo.AddressDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<h2>Address List Workspace</h2>
<div>
<s:url id="CreateAddressURL" action="/ITOS/CreateAddress" escapeAmp="false">

    <s:param name="addressLinkDetail.relatedID" value="%{addressLinkDetail.relatedID}" />

</s:url> <s:a href="%{CreateAddressURL}">Create Address</s:a> <br><br>

<s:form action="/ITOS/ListAddress" method="POST">
    <table border=1>
        <thead>

            <tr>
                <th align="left">StreetOne</th>
                <th>StreetTwo</th>
                <th>AptUnit</th>
                <th>City</th>
                <th>County</th>
                <th>State</th>
                <th>Country</th>
                <th>ZipCode</th>
                <th>StartDate</th>
                <th>End Date</th>
                <th>CreatedBy</th>
                <th>CreatedOn</th>
                <th>LastModified By</th>
                <th>LastModified On</th>
                <th colspan=3>Action</th>
            </tr>
        </thead>



        <s:iterator value="addressLinkDetailList" status="stat">

            <tbody>
                <tr>
                    <td><s:property value="addressDetail.streetOne" /></td>
                    <td><s:property value="addressDetail.streetTwo" /></td>
                    <td><s:property value="addressDetail.aptUnit" /></td>
                    <td><s:property value="addressDetail.city" /></td>
                    <td><s:property value="addressDetail.county" /></td>
                    <td><s:property value="addressDetail.state" /></td>
                    <td><s:property value="addressDetail.country" /></td>
                    <td><s:property value="addressDetail.zipCode" /></td>
                    <td><s:property value="startDate" /></td>
                    <td><s:property value="endDate" /></td>
                    <td><s:property value="auditTrailDtls.createdBy" /></td>
                    <td><s:property value="auditTrailDtls.createdOn" /></td>
                    <td><s:property value="auditTrailDtls.lastModifieddBy" /></td>
                    <td><s:property value="auditTrailDtls.lastModifiedOn" /></td>

                    <td><s:url id="ReadAddressURL" action="/ITOS/ReadAddress" escapeAmp="false">
                        <s:param name="addressDetail.addressID" value="%{addressID}" />
                        <s:param name="addressLinkDetail.addressLinkID" value="%{addressLinkID}" />
                    </s:url> <s:a href="%{ReadAddressURL}">View</s:a> 
                    
                    <s:url var="UpdateAddressURL" action="/ITOS/ReadAddress" escapeAmp="false">
                        <s:param name="addressLinkDetail.addressID" value="%{addressID}" />
                        <s:param name="addressLinkDetail.addressLinkID" value="%{addressLinkID}" />
                        <s:param name="addressLinkDetail.relatedID" value="%{relatedID}" />
                        <s:param name="act" value="%{updateAction}" />
                    </s:url> <s:a href="%{UpdateAddressURL}">Update</s:a> 
                    
                    <s:url var="DeleteAddressURL" action="/ITOS/DeleteAddress" escapeAmp="false">
                        <s:param name="addressDetail.addressID" value="%{addressID}" />
                        <s:param name="addressLinkDetail.addressLinkID" value="%{addressLinkID}" />
                        <s:param name="addressLinkDetail.relatedID" value="%{relatedID}" />
                    </s:url> <s:a href="%{DeleteAddressURL}">Delete</s:a></td>

                </tr>

            </tbody>
        </s:iterator>
    </table>
</s:form></div>
</div>
</body>
</html>