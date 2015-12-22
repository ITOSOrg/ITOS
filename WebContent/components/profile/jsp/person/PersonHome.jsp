<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">

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
        <h2>Person Detail</h2>
            <div>
        <s:form action="/ITOS/PersonHome" method="post">


                <s:url id="RoleListURL" action="/ITOS/ListRoleForSinglePerson" escapeAmp="false">
                    <s:param name="userRoleLinkDetail.username" value="%{personDetail.username}" />
                </s:url>
                    <s:a href="%{RoleListURL}">Person Role</s:a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    
                <s:url id="LogOutURL" action="/ITOS/PersonLogOut" escapeAmp="false">
                </s:url>
                    <s:a href="%{LogOutURL}">LogOut</s:a>
                    
                    <br><br>

                <table border=1>
                    <thead>
                        <tr>

                            <th>Title :</th>
                            <th>First Name:</th>
                            <th>Middle Name:</th>
                            <th>Last Name:</th>
                            <th>Gender:</th>
                            <th>Date Of Birth:</th>
                            <th>Status:</th>
                            <th>Created By:</th>
                            <th>Created On:</th>
                            <th>Modified By:</th>
                            <th>Modified On:</th>
                            <th>Registration Date:</th>
                            <th>Action</th>
                        </tr>
                    </thead>

                    <tbody>

                        <tr>
                            <td><s:property value="personDetail.title" /></td>
                            <td><s:property value="personDetail.firstName" /></td>
                            <td><s:property value="personDetail.middleName" /></td>
                            <td><s:property value="personDetail.lastName" /></td>
                            <td><s:property value="personDetail.gender" /></td>
                            <td><s:property value="personDetail.dateOfBirth" /></td>
                            <td><s:property value="personDetail.recordStatus" /></td>
                            <td><s:property value="personDetail.createdBy" /></td>
                            <td><s:property value="personDetail.createdOn" /></td>
                            <td><s:property value="personDetail.modifiedBy" /></td>
                            <td><s:property value="personDetail.modifiedOn" /></td>
                            <td><s:property value="personDetail.registrationDate" /></td>

                            <td><s:url var="updatePersonHomeURL" action="/ITOS/ReadPerson" escapeAmp="false">
                                    <s:param name="personDetail.personID" value="%{personDetail.personID}" />
                                    <s:param name="act" value="%{personDetail.updateAction}" />
                                </s:url> <s:a href="%{updatePersonHomeURL}"> Update</s:a></td>

                        </tr>
                    </tbody>
                </table>
            </div>



            <h2>Email Address Detail</h2>
            <div>

                <table border=1>
                    <thead>
                        <tr>
                            <th>EmailAddress:</th>
                            <th>Type Code:</th>
                            <th>PrimaryInd:</th>
                            <th>Start Date:</th>
                            <th>End Date:</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td><s:property
                                    value="personDetail.emailAddressLinkDetail.emailAddressDetail.emailAddress" /></td>
                            <td><s:property value="personDetail.emailAddressLinkDetail.typeCode" /></td>
                            <td><s:property value="personDetail.emailAddressLinkDetail.primaryInd" /></td>
                            <td><s:property value="personDetail.emailAddressLinkDetail.startDate" /></td>
                            <td><s:property value="personDetail.emailAddressLinkDetail.endDate" /></td>
                        </tr>

                    </tbody>
                </table>
            </div>

            <h2>Phone Number Detail</h2>
            <div>

                <table border=1>
                    <thead>
                        <tr>

                            <th>Country Code:</th>
                            <th>Area Code:</th>
                            <th>Phone Number:</th>
                            <th>Extension:</th>
                            <th>Type Code:</th>
                            <th>PrimaryInd:</th>
                            <th>start Date:</th>
                            <th>End Date:</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td><s:property
                                    value="personDetail.phoneNumberLinkDetail.phoneNumberDetail.countryCode" /></td>
                            <td><s:property value="personDetail.phoneNumberLinkDetail.phoneNumberDetail.areaCode" /></td>
                            <td><s:property
                                    value="personDetail.phoneNumberLinkDetail.phoneNumberDetail.phoneNumber" /></td>
                            <td><s:property value="personDetail.phoneNumberLinkDetail.phoneNumberDetail.extension" /></td>
                            <td><s:property value="personDetail.phoneNumberLinkDetail.typeCode" /></td>
                            <td><s:property value="personDetail.phoneNumberLinkDetail.primaryInd" /></td>
                            <td><s:property value="personDetail.phoneNumberLinkDetail.startDate" /></td>
                            <td><s:property value="personDetail.phoneNumberLinkDetail.endDate" /></td>
                        </tr>
                    </tbody>


                </table>

            </div>

            <h2>Person Identity Detail</h2>
            <div>

                <table border=1>
                    <thead>
                        <tr>
                            <th>AlternateID:</th>
                            <th>PrimaryInd:</th>
                            <th>Type Code:</th>
                            <th>Start Date:</th>
                            <th>End Date:</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td><s:property value="personDetail.personIdentityDetail.alternateID" /></td>
                            <td><s:property value="personDetail.personIdentityDetail.primaryInd" /></td>
                            <td><s:property value="personDetail.personIdentityDetail.typeCode" /></td>
                            <td><s:property value="personDetail.personIdentityDetail.startDate" /></td>
                            <td><s:property value="personDetail.personIdentityDetail.endDate" /></td>
                        </tr>
                    </tbody>

                </table>

            </div>
            <h2>Address Detail</h2>
            <div>
                <table border=1>
                    <thead>
                        <tr>

                            <th>StreetOne:</th>
                            <th>StreetTwo:</th>
                            <th>AptUnit:</th>
                            <th>City:</th>
                            <th>County:</th>
                            <th>State:</th>
                            <th>Country:</th>
                            <th>ZipCode:</th>
                            <th>Type Code:</th>
                            <th>PrimaryInd:</th>
                            <th>Start Date:</th>
                            <th>End Date:</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td><s:property value="personDetail.addressLinkDetail.addressDetail.streetOne" /></td>
                            <td><s:property value="personDetail.addressLinkDetail.addressDetail.streetTwo" /></td>
                            <td><s:property value="personDetail.addressLinkDetail.addressDetail.aptUnit" /></td>
                            <td><s:property value="personDetail.addressLinkDetail.addressDetail.city" /></td>
                            <td><s:property value="personDetail.addressLinkDetail.addressDetail.county" /></td>
                            <td><s:property value="personDetail.addressLinkDetail.addressDetail.state" /></td>
                            <td><s:property value="personDetail.addressLinkDetail.addressDetail.country" /></td>
                            <td><s:property value="personDetail.addressLinkDetail.addressDetail.zipCode" /></td>
                            <td><s:property value="personDetail.addressLinkDetail.typeCode" /></td>
                            <td><s:property value="personDetail.addressLinkDetail.primaryInd" /></td>
                            <td><s:property value="personDetail.addressLinkDetail.startDate" /></td>
                            <td><s:property value="personDetail.addressLinkDetail.endDate" /></td>
                        </tr>


                    </tbody>

                </table>

                

                    <br>
                    <input type="submit" value="LogOut">
                    <br>
            </div>
        </s:form>
    </div>


</body>
</html>