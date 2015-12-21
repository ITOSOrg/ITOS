<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <s:form name="Create Address" action="/Profile/CreateAddressSubmit" method="POST">
        
        <table>
            
            <tr>
                <td>StreetOne:</td>
                <td><s:textfield type="text" name="addressLinkDetail.addressDetail.streetOne" maxlength="50" /></td>
            </tr>

            <tr>
                <td>StreetTwo:</td>
                <td><s:textfield type="text" name="addressLinkDetail.addressDetail.streetTwo" maxlength="50" /></td>
            </tr>

            <tr>
                <td>AptUnit:</td>
                <td><s:textfield type="text" name="addressLinkDetail.addressDetail.aptUnit" maxlength="20" /></td>
            </tr>

            <tr>
                <td>City:</td>
                <td><s:textfield type="text" name="addressLinkDetail.addressDetail.city" /></td>
            </tr>

            <tr>
                <td>County:</td>
                <td><s:textfield type="text" name="addressLinkDetail.addressDetail.county" /></td>
            </tr>

            <tr>
                <td>State:</td>
                <td><s:textfield type="text" name="addressLinkDetail.addressDetail.state" /></td>
            </tr>

            <tr>
                <td>Country</td>
                <td><s:textfield type="text" name="addressLinkDetail.addressDetail.country" /></td>
            </tr>

            <tr>
                <td>ZipCode:</td>
                <td><s:textfield type="text" name="addressLinkDetail.addressDetail.zipCode" /></td>
            </tr>
            <tr>
                <td>Type Code :</td>
                <td><s:textfield type="text" name="addressLinkDetail.typeCode" /></td>
            </tr>
            <tr>
                <td>PrimaryInd :</td>
                <td><s:textfield type="text" name="addressLinkDetail.primaryInd" /></td>
            </tr>
            
            <tr>

                <td><s:submit type="submit" value="Submit" />
                <s:hidden name="addressLinkDetail.relatedID" value="%{#addressLinkDetail.relatedID}"/>
                
            </tr>
            
        </table>
        
    </s:form>
    
</body>
</html>