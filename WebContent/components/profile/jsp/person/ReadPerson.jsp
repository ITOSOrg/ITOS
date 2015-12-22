<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
		<h2>Person Detail</h2>
		<div>

			


			<s:form action="/ITOS/PersonHome" method="post">



				<table border=1>
					<thead>
                    <tr>

							<th>Title :</th>
							<th >First Name: </th>
							<th >Middle Name: </th>
							<th >Last Name: </th>
    						<th >Gender: </th>
    						<th >Date Of Birth: </th>
    						<th >Status: </th>
    						<th >Created By:</th>
    						<th >Created On:</th>
    						<th >Modified By:</th>
    						<th >Modified On:</th>
    						<th >Registration Date:</th>
    						
                      </tr>
					</thead>
                    
					<tbody>

						<tr>
                          <td> <s:property value="personDetail.title"/></td>
                           <td><s:property value="personDetail.firstName"/></td>
                           <td><s:property value="personDetail.middleName"/></td>
                           <td><s:property value="personDetail.lastName"/></td>
                           <td><s:property value="personDetail.gender"/></td>
                           <td><s:property value="personDetail.dateOfBirth"/></td>
                           <td><s:property value="personDetail.recordStatus"/></td>
                           <td><s:property value="personDetail.createdBy"/></td>
                           <td><s:property value="personDetail.createdOn"/></td>
                           <td><s:property value="personDetail.modifiedBy"/></td>
                           <td><s:property value="personDetail.modifiedOn"/></td>
                           <td><s:property value="personDetail.registrationDate"/></td>
                           

						</tr>
                        </tbody>
                        </table>
                        </s:form>
                        </div>
                        


		<h2>Email Address Detail</h2>
		<div>

			<s:form action="/ITOS/ReadEmailAddress" method="POST">
				<table border=1>
                <thead>
                <tr>
						<th>EmailAddress: </th>
						<th>Type Code: </th>
						<th>PrimaryInd: </th>
						<th>Start Date: </th>
						<th>End Date: </th>
                 </tr>
                </thead>
                
					<tbody>
                    <tr>
                       <td> <s:property value="emailAddressDetail.emailAddress"/></td>
                       <td> <s:property value="emailAddressLinkDetail.typeCode"/></td>
                         <td> <s:property value="emailAddressLinkDetail.primaryInd"/></td>
                         <td> <s:property value="emailAddressLinkDetail.startDate"/></td>
                        <td>  <s:property value="emailAddressLinkDetail.endDate"/></td>
                        </tr>
                        
                        </tbody>
                        </table>
                        </s:form>
                        </div>

		<h2>Phone Number Detail</h2>
		<div>

			<s:form action="/ITOS/ReadPhoneNumber" method="POST">
				<table border=1>
                <thead>
                <tr>
                
						<th>Country Code: </th>
						<th>Area Code: </th>
						<th>Phone Number: </th>
						<th>Extension: </th>
						<th>Type Code: </th>
						<th>PrimaryInd: </th>
						<th>start Date: </th>
						<th>End Date: </th>
                   </tr>
                </thead>
				
					<tbody>
                    <tr>
                    <td><s:property value="phoneNumberDetail.countryCode"/></td>
                   <td> <s:property value="phoneNumberDetail.areaCode"/></td>
                    <td><s:property value="phoneNumberDetail.phoneNumber"/></td>
                    <td><s:property value="phoneNumberDetail.extension"/></td>
                   <td> <s:property value="phoneNumberLinkDetail.typeCode"/></td>
                    <td><s:property value="phoneNumberLinkDetail.primaryInd"/></td>
                    <td><s:property value="phoneNumberLinkDetail.startDate"/></td>
                    <td><s:property value="phoneNumberLinkDetail.endDate"/></td>
                    </tr>
					</tbody>


				</table>

			</s:form>
		</div>
		
		<h2>Person Identity Detail</h2>
		<div>

			<s:form action="/ITOS/ReadPersonIdentity" method="POST">
				<table border=1>
                <thead>
                <tr>
						<th >AlternateID: </th>
						<th >PrimaryInd: </th>
						<th >Type Code: </th>
						<th >Start Date: </th>
						<th >End Date: </th>
                  </tr>
                </thead>
				
					<tbody>
                    <tr>
                       <td> <s:property value="personIdentityDetail.alternateID"/></td>
                       <td> <s:property value="personIdentityDetail.primaryInd"/></td>
                        <td><s:property value="personIdentityDetail.typeCode"/></td>
                       <td> <s:property value="personIdentityDetail.startDate"/></td>
                       <td> <s:property value="personIdentityDetail.endDate"/></td>
                     </tr>
					</tbody>

					</table>

			</s:form>
		</div>
		<h2>Address Detail</h2>
		<div>
		<s:form action="/ITOS/ReadAddress" method="POST">
		<table border=1>
        <thead>
        <tr>
        
						<th>StreetOne: </th>
						<th>StreetTwo: </th>
						<th>AptUnit: </th>
						<th>City: </th>
						<th>County: </th>
						<th>State: </th>
						<th>Country: </th>
						<th>ZipCode: </th>
						<th>Type Code: </th>
						<th>PrimaryInd: </th>
						<th>Start Date: </th>
						<th>End Date: </th>
                        </tr>
        </thead>
		
		<tbody>
        <tr>
       <td> <s:property value="addressDetail.streetOne"/></td>
       <td> <s:property value="addressDetail.streetTwo"/></td>
       <td> <s:property value="addressDetail.aptUnit"/></td>
        <td><s:property value="addressDetail.city"/></td>
        <td><s:property value="addressDetail.county"/></td>
        <td><s:property value="addressDetail.state"/></td>
        <td><s:property value="addressDetail.country"/></td>
       <td> <s:property value="addressDetail.zipCode"/></td>
        <td><s:property value="addressLinkDetail.typeCode"/></td>
        <td><s:property value="addressLinkDetail.primaryInd"/></td>
        <td><s:property value="addressLinkDetail.startDate"/></td>
       <td> <s:property value="addressLinkDetail.endDate"/></td>
        </tr>
        
						
					</tbody>

				</table>
                </s:form>
		
		
			<s:form action="/ITOS/PersonLogOut" method="POST">
				<br> <input type="submit" value="LogOut">
				<br>
		</div>
		</s:form>
	</div>


</body>
</html>