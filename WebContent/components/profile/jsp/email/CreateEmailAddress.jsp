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

<s:form name="Create Email Address" action="/ITOS/CreateEmailAddressSubmit"
		method="POST">
		<table>
		  <tr>
				<td>Email Address </td>
				<td><s:textfield type="text" name="emailAddressLinkDetail.emailAddressDetail.emailAddress"/></td>
			</tr>
			<tr>
            <td><s:select
                list="#{'Primary':'Primary', 'Secondary':'Secondary', 'Persnal':'Persnal', 'Business':'Business'}"
                name="emailAddressLinkDetail.typeCode" label="Type Code">

            </s:select></td>
        </tr>
		
        <tr>
            <td>PrimaryInd </td>
            <td><s:radio name="emailAddressLinkDetail.primaryInd" list="#{'1':'True','0':'false' }"
                value="1"></s:radio></td>
        </tr>
			
			<tr>

				<td><s:submit  type="submit" value="Submit"/>
                <s:hidden name="emailAddressLinkDetail.relatedID" value="%{#parameters['emailAddressLinkDetail.relatedID']}"/>
                </td>
			</tr>
			
		
		</table>
		</s:form>

</body>
</html>