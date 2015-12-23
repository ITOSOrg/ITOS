<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link href="jquery-ui\jquery-ui.css" rel="stylesheet" />
<script src="js\jquery.js" type="text/javascript"></script>
<script src="jquery-ui\jquery-ui.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#datepicker").datepicker();
		$('#submit').click(function() {
			alert("Submit ?");
		});
	});
</script>
</head>
<body >
    <h> Registration Form</h>
    <br>
    <br>

    <s:form name="Registration" action="/ITOS/CreateUserSubmit" method="POST">

        <table>

            <!-- Registration Form -->

            <tr>
                <td><s:select list="#{'Mr.':'Mr.', 'Mrs.':'Mrs.','Miss.':'Miss.', 'Kumar':'Kumar'}" name="personDetail.title" label="Title">
                    </s:select></td>
            </tr>

            <tr>
                <td>First Name :</td>
                <td><s:textfield type="text" name="personDetail.firstName" /></td>
            </tr>
            <tr>
                <td>Middle Name:</td>
                <td><s:textfield type="text" name="personDetail.middleName" /></td>
            </tr>

            <tr>
                <td>Last Name:</td>
                <td><s:textfield type="text" name="personDetail.lastName" /></td>
            </tr>


            <tr>
                <td><s:select list="#{'GEN0001':'Male', 'GEN0002':'Female'}" name="personDetail.gender" label="Gender">
                
                    </s:select></td>

            </tr>


            <tr>
                <td>Date Of Birth:</td>
                <td><s:textfield type="text" name="personDetail.dateOfBirth" /></td>
            </tr>

            <tr>
                <td>UserName:</td>
                <td><s:textfield type="text" name="personDetail.userName" /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><s:textfield type="text" name="personDetail.usersDetail.password" /></td>
            </tr>

            <!-- Enter Email Address Parameter -->

            <tr>
                <td>Email Address:</td>
                <td><s:textfield type="text"
                        name="personDetail.emailAddressLinkDetail.emailAddressDetail.emailAddress" /></td>
            </tr>
            <tr>
                <td>
                <s:select list="#{'Primary':'Primary', 'Secondary':'Secondary', 'Persnal':'Persnal', 'Business':'Business'}" name="personDetail.emailAddressLinkDetail.typeCode" label="Type Code">
                
                </s:select></td>
            </tr>
            <tr>
                <td>PrimaryInd :</td>
                <td><s:radio name="personDetail.emailAddressLinkDetail.primaryInd"
                        list="#{'1':'True','0':'false' }" value="1"></s:radio> 
                </td>
            </tr>
            <tr>
                <td>Start Date :</td>
                <td><s:textfield type="text" name="personDetail.emailAddressLinkDetail.startDate" /></td>
            </tr>
            <tr>
                <td>End Date :</td>
                <td><s:textfield type="text" name="personDetail.emailAddressLinkDetail.endDate" /></td>
            </tr>

            <!-- Enter Phone Number Parameter -->


            <tr>
                <td>Country Code:</td>
                <td><s:textfield type="text"
                        name="personDetail.phoneNumberLinkDetail.phoneNumberDetail.countryCode" /></td>
            </tr>
            <tr>
                <td>Area Code:</td>
                <td><s:textfield type="text" name="personDetail.phoneNumberLinkDetail.phoneNumberDetail.areaCode" /></td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td><s:textfield type="text"
                        name="personDetail.phoneNumberLinkDetail.phoneNumberDetail..phoneNumber" /></td>
            </tr>
            <tr>
                <td>Extension:</td>
                <td><s:textfield type="text" name="personDetail.phoneNumberLinkDetail.phoneNumberDetail.extension" /></td>
            </tr>
            <tr>
                <td>
                <s:select list="#{'Primary':'Primary', 'Secondary':'Secondary', 'Persnal':'Persnal', 'Business':'Business'}" name="personDetail.phoneNumberLinkDetail.typeCode" label="Type Code">
               
                    </s:select></td>
            </tr>
            <tr>
                <td>PrimaryInd:</td>
                <td><s:radio name="personDetail.phoneNumberLinkDetail.primaryInd"
                        list="#{'1':'True','0':'false' }" value="1"></s:radio></td>
            </tr>
            <tr>
                <td>Start Date:</td>
                <td><s:textfield type="text" name="personDetail.phoneNumberLinkDetail.startDate" /></td>
            </tr>

            <tr>
                <td>End Date:</td>
                <td><s:textfield type="text" name="personDetail.phoneNumberLinkDetail.endDate" /></td>
            </tr>

            <!-- Enter Address table parameter -->

            <tr>
                <td>StreetOne:</td>
                <td><s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.streetOne"
                        maxlength="50" /></td>
            </tr>

            <tr>
                <td>StreetTwo:</td>
                <td><s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.streetTwo"
                        maxlength="50" /></td>
            </tr>

            <tr>
                <td>AptUnit:</td>
                <td><s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.aptUnit"
                        maxlength="20" /></td>
            </tr>

            <tr>
                <td>City:</td>
                <td><s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.city" /></td>
            </tr>

            <tr>
                <td>County:</td>
                <td><s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.county" /></td>
            </tr>

            <tr>
                <td>
                <s:select list="#{'ST0001':'New York', 'ST0002':'New Jersy', 'ST0003':'Washington', 'ST0004':'Chicago', 'ST0005':'Maryland'}" name="personDetail.addressLinkDetail.addressDetail.state" label="State">
                        <!--  <option value="ST0001">New York</option>
                        <option value="ST0002">New Jersy</option>
                        <option value="ST0003">Washington DC</option>
                        <option value="ST0004">Chicago</option>
                        <option value="ST0005">Maryland</option>-->
                    </s:select></td>
            </tr>

            <tr>
                <td>Country</td>
                <td><s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.country" /></td>
            </tr>

            <tr>
                <td>ZipCode:</td>
                <td><s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.zipCode" /></td>
            </tr>
            <tr>
                <td>
                 <s:select list="#{'Primary':'Primary', 'Secondary':'Secondary', 'Persnal':'Persnal', 'Business':'Business'}" name="personDetail.addressLinkDetail.typeCode" label="Type Code">
                    </s:select></td>
            </tr>
            <tr>
                <td>PrimaryInd :</td>
                <td><s:radio name="personDetail.addressLinkDetail.primaryInd"
                        list="#{'1':'True','0':'false' }" value="1"></s:radio></td>
            </tr>
            <tr>
                <td>Start Date :</td>
                <td><s:textfield type="text" name="personDetail.addressLinkDetail..startDate" /></td>
            </tr>
            <tr>
                <td>End Date :</td>
                <td><s:textfield type="text" name="personDetail.addressLinkDetail.endDate" /></td>
            </tr>

            <!-- Insert Person Identity Parameters -->

            <tr>
                <td>AlternateID :</td>
                <td><s:textfield type="text" name="personDetail.personIdentityDetail.alternateID" /></td>
            </tr>
            <tr>
                <td>PrimaryInd :</td>
                <td><s:radio name="personDetail.personIdentityDetail.primaryInd"
                        list="#{'1':'True','0':'false' }" value="1"></s:radio></td>
            </tr>
            <tr>
                <td>
                <s:select list="#{'Primary':'Primary', 'Secondary':'Secondary', 'Persnal':'Persnal', 'Business':'Business'}" name="personDetail.personIdentityDetail.typeCode" label="Type Code">
                    </s:select></td>
            </tr>
            <tr>
                <td>Start Date :</td>
                <td><s:textfield type="text" name="personDetail.personIdentityDetail.startDate" /></td>
            </tr>
            <tr>
                <td>End Date :</td>
                <td><s:textfield type="text" name="personDetail.personIdentityDetail.endDate" /></td>
            </tr>
            <tr>
                <td>
                <s:select list="#{'9001':'Administrator', '9002':'Employee', '9003':'Devloper'}" name="personDetail.personIdentityDetail.roleID" label="Role">
                       <!--  <option value="9001">Administrator</option>
                        <option value="9002">Employee</option>
                        <option value="9003">Devloper</option> -->
                    </s:select></td>
            </tr>


            <tr>

                <td><br> <s:submit id="submit" type="submit" value="Submit" /></td>

            </tr>


        </table>

    </s:form>

    <s:form action="/ITOS/PersonLogOut" method="POST">
        <br>
        <s:submit type="submit" value="Cancel" />
    </s:form>


</body>
</html>