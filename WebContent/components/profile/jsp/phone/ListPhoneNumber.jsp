<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<script>
	$(function() {
		$("#myaccordion").accordion();
	});
</script>
</head>
<body>


<div id="myaccordion">
		<h2>Phone Number List Workspace</h2>
		<div>


<a href="/ITOS/CreatePhoneNumber">Create Phone Number</a>
<s:form action="/ITOS/ListPhoneNumber" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">Country Code:</th>
					<th>Area Code:</th>
					<th>Phone Number:</th>
					<th>Extension:</th>
					<th>Type Code:</th>
					<th>PrimaryInd:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th colspan=3>Action</th>
				</tr>
			</thead>
			
            <s:iterator value="phoneNumberLinkDetailList" status="stat">
			
			<tbody>
				<tr>
					<td><s:property value="phoneNumberDetail.countryCode" /></td>
					<td><s:property value="phoneNumberDetail.areaCode" /></td>
					<td><s:property value="phoneNumberDetail.phoneNumber" /></td>
					<td><s:property value="phoneNumberDetail.extension" /></td>
					<td><s:property value="typeCode" /></td>
					<td><s:property value="primaryInd" /></td>
					<td><s:property value="startDate" /></td>
					<td><s:property value="endDate" /></td>
                    
                    <td><s:url id="ReadPhoneNumberURL" action="/ITOS/ReadPhoneNumber" escapeAmp="false">
                                <s:param name="phoneNumberLinkDetail.phoneNumberLinkID" value="%{phoneNumberLinkID}"/>
                            </s:url>
                            <s:a href="%{ReadPhoneNumberURL}">View</s:a>
                            
                            <s:url var="UpdatePhoneNumberURL" action="/ITOS/ReadPhoneNumber" escapeAmp="false">
                                <s:param name="phoneNumberLinkDetail.phoneNumberLinkID" value="%{phoneNumberLinkID}"/>
                                <s:param name="act" value="%{updateAction}"/>
                            </s:url>
                            <s:a href="%{UpdatePhoneNumberURL}">Update</s:a>
                            
                            
                            <s:url var="DeletePhoneNumberURL" action="/ITOS/DeletePhoneNumber" escapeAmp="false">
                                <s:param name="phoneNumberLinkDetail.phoneNumberLinkID" value="%{phoneNumberLinkID}"/>
                            </s:url>
                            <s:a href="%{DeletePhoneNumberURL}">Delete</s:a>
                            
                        </td>
                    
					
				</tr>
			</tbody><br></br>
            </s:iterator>
		</table>
		</s:form>
		</div>
		</div>
</body>
</html>