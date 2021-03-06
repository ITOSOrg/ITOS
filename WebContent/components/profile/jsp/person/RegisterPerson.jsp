<%@ page import="java.util.List"%>
<%@ page import="com.company.itos.profile.email.pojo.EmailAddressLinkDetail"%>
<%@ page import="com.company.itos.profile.email.pojo.EmailAddressDetail"%>
<%@ page import="com.company.itos.profile.phone.pojo.PhoneNumberDetail"%>
<%@ page import="com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail"%>
<%@ page import="com.company.itos.profile.person.pojo.PersonDetail"%>
<%@ page import="com.company.itos.profile.person.pojo.UsersDetail"%>
<%@ page import="com.company.itos.profile.address.pojo.AddressLinkDetail"%>
<%@ page import="com.company.itos.profile.address.pojo.AddressDetail"%>
<%@ page import="com.company.itos.profile.personIdentity.pojo.PersonIdentityDetail"%>
<%@ page
	import="com.company.itos.profile.person.servlet.PersonRegistration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link href="jquery-ui\jquery-ui.css" rel="stylesheet"/>
<script src="js\jquery.js" type="text/javascript"></script>
<script src="jquery-ui\jquery-ui.js" type="text/javascript"></script>
<script type="text/javascript">

$(document).ready(function()
		{
	$("#datepicker").datepicker();
	$('#submit').click(function()
			{
		 alert("Submit ?");
			}
	);
		});


</script>
</head>
<body bgcolor="	#F4A460">
	<h> Registration Form</h><br><br>


	<form name="Registration" action="/ITOS/PersonRegistration"
		method="POST">
		<fieldset style="width: 1050px; height: 1200px;">
		<table>
			<%
				PersonDetail personDetail = (PersonDetail) request
						.getAttribute("personDetail");

				if (personDetail != null) {

					List<String> errorMessageList = personDetail
							.getErrorMessageList();

					for (int i = 0; i < errorMessageList.size(); i++) {
			%>
			

			<br>
			<font size="3" color="red"> <%
					out.println(errorMessageList.get(i));
				%>
			</font>
			<%
				}
			%>
			<%
			UsersDetail usersDetail = personDetail.getUsersDetail();
			
			EmailAddressLinkDetail emailAddressLinkDetail = personDetail.getEmailAddressLinkDetail();
			EmailAddressDetail emailAddressDetail  = emailAddressLinkDetail.getEmailAddressDetail();
	 
			 PhoneNumberLinkDetail phoneNumberLinkDetail = personDetail.getPhoneNumberLinkDetail();
			PhoneNumberDetail phoneNumberDetail = phoneNumberLinkDetail.getPhoneNumberDetail();
			
			AddressLinkDetail addressLinkDetail = personDetail.getAddressLinkDetail();
			AddressDetail addressDetail = addressLinkDetail.getAddressDetail();
			
			PersonIdentityDetail personIdentityDetail = personDetail.getPersonIdentityDetail();
			%>
			
			<!-- update Person table parameter -->
			
			<tr>
				<td>Title :</td>
				<td><input type="text" name="title" 
				      value="<%=personDetail.getTitle()%>"></td>
			</tr>
			<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstName"
					value="<%=personDetail.getFirstName()%>"></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="middleName"
					value="<%=personDetail.getMiddleName()%>"></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"
					value="<%=personDetail.getLastName()%>"></td>
			</tr>
			
			
			<tr> 
			       <td> Gender:</td>
			       <td><input type="text" name="gender"
			             value="<%=personDetail.getGender()%>">    </td>
			</tr>
			
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="text" name="dateOfBirth"
					value="<%=personDetail.getDateOfBirth()%>"></td>
			</tr>
			
			<!-- update Users table parameter -->
			
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="userName"
					value="<%=usersDetail.getUserName()%>"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password"
					value="<%=usersDetail.getPassword()%>"></td>
			</tr>
			
			<!-- update EmailAddress table parameter -->
			
			<tr>
				<td>Email Address:</td>
				<td><input type="text" name="emailAddress"
					value="<%=emailAddressDetail.getEmailAddress()%>"></td>
			</tr>
			<tr>
				<td>Type Code:</td>
				<td><input type="text" name="typeCode"
					value="<%=emailAddressLinkDetail.getTypeCode()%>"></td>
			</tr>
			<tr>
				<td>PrimaryInd:</td>
				<td><input type="text" name="primaryInd"
					value="<%=emailAddressLinkDetail.getPrimaryInd()%>"></td>
			</tr>
			<tr>
				<td>Start Date:</td>
				<td><input type="text" name="startDate"
					value="<%=emailAddressLinkDetail.getStartDate()%>"></td>
			</tr>
			<tr>
				<td>End Date:</td>
				<td><input type="text" name="endDate"
					value="<%=emailAddressLinkDetail.getEndDate()%>"></td>
			</tr>
			
			<!-- update phoneNumber table parameter -->
			
			<tr>
		<td> Country Code:</td>
		<td><input type="text" name="countryCode"
		       value="<%=phoneNumberDetail.getCountryCode()%>"></td>
		</tr>
		<tr>
		<td> Area Code:</td>
		<td><input type="text" name="areaCode"
		       value="<%=phoneNumberDetail.getAreaCode()%>"></td>
		</tr>
		<tr>
		<td>Phone Number:</td>
		<td><input type="text" name="phoneNumber"
		       value="<%=phoneNumberDetail.getPhoneNumber()%>"></td>
		</tr>
		<tr>
		<td> Extension:</td>
		<td><input type="text" name="extension"
		       value="<%=phoneNumberDetail.getExtension()%>"></td>
		</tr>
		<tr>
		<td> Type Code:</td>
		<td><input type="text" name="typeCode"
		       value="<%=phoneNumberLinkDetail.getTypeCode()%>"></td>
		</tr>
		<tr>
		<td> PrimaryInd:</td>
		<td><input type="text" name="primaryInd"
		       value="<%=phoneNumberLinkDetail.getPrimaryInd()%>"></td>
		</tr>
		<tr>
		<td> Start Date:</td>
		<td><input type="text" name="startDate"
		       value="<%=phoneNumberLinkDetail.getStartDate()%>"></td>
		</tr>
		
		<tr>
		<td> End Date:</td>
		<td><input type="text" name="endDate"
		      value="<%=phoneNumberLinkDetail.getEndDate()%>"></td>
		</tr>
		
		<!-- update Address table parameter -->
		<tr>
				<td>StreetOne:</td>
				<td><input type="text" name="streetOne" maxlength="50"
				     value="<%=addressDetail.getStreetOne()%>"></td>
			</tr>
			
			<tr>
				<td>StreetTwo:</td>
				<td><input type="text" name="streetTwo" maxlength="50"
				    value="<%=addressDetail.getStreetTwo()%>"></td>
			</tr>
			
			<tr>
				<td>AptUnit:</td>
				<td><input type="text" name="aptUnit" maxlength="20"
				      value="<%=addressDetail.getAptUnit()%>"></td>
			</tr>
			
			<tr>
				<td>City:</td>
				<td><input type="text" name="city"
				    value="<%=addressDetail.getCity()%>"></td>
			</tr>
			
			<tr>
				<td>County:</td>
				<td><input type="text" name="county"
				   value="<%=addressDetail.getCounty()%>"></td>
			</tr>
			
			<tr>
				<td>State:</td>
				<td><input type="text" name="state"
				   value="<%=addressDetail.getState()%>"></td>
			</tr>
			
			<tr>
				<td>Country</td>
				<td><input type="text" name="country"
				  value="<%=addressDetail.getCountry()%>"></td>
			</tr>
			
			<tr>
				<td>ZipCode:</td>
				<td><input type="text" name="zipCode"
				  value="<%=addressDetail.getZipCode()%>"></td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><input type="text" name="typeCode"
				   value="<%=addressLinkDetail.getTypeCode()%>"></td>
			</tr>
			<tr>
				<td>PrimaryInd :</td>
				<td><input type="text" name="primaryInd"
				    value="<%=addressLinkDetail.getPrimaryInd()%>"></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input type="text" name="startDate"
				   value="<%=addressLinkDetail.getStartDate()%>"></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="text" name="endDate"
				   value="<%=addressLinkDetail.getEndDate()%>"></td>
			</tr> 
			
			<!-- Update PersonIdentity Table -->
			
			<tr>
				<td>alternateID :</td>
				<td><input type="text" name="alternateID"
					value="<%=personIdentityDetail.getAlternateID()%>"></td>
			</tr>
			<tr>
				<td>PrimaryInd :</td>
				<td><input type="text" name="primaryInd"
				      value = "<%=personIdentityDetail.getPrimaryInd()%>"></td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><input type="text" name="typeCode"
				      value = "<%=personIdentityDetail.getTypeCode()%>"></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input type="text" name="startDate"
				      value = "<%=personIdentityDetail.getStartDate()%>"></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="text" name="endDate"
				      value = "<%=personIdentityDetail.getEndDate()%>"></td>
			</tr>

			<%
				} else {
			%>
			
			<tr>
				<td>Title :</td>
				<td><select name="title">
					<option  value="Mr." >Mr.</option>	
				<option  value="Mrs." >Mrs.</option>	
				<option  value="Miss." >Miss.</option>	
				<option  value="Kumar" >Kumar</option>	
			</select></td>
			</tr>

			<tr>
				<td>First Name :</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Middle Name:</td>
				<td><input type="text" name="middleName"></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			
			
			 <tr>
			<td>Gender</td>
			<td><select name="gender">
				<option  value="GEN0001" >Male</option>	
				<option  value="GEN0002" >Female</option>	
			</select></td>
			
			</tr> 
			
			
			<tr>
				<td>Date Of Birth:</td>
				<td><input   type="text" name="dateOfBirth"></td>
			</tr>
			
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password"></td>
			</tr>
			
			<!-- Enter Email Address Parameter -->
			 
			<tr>
				<td>Email Address:</td>
				<td><input  type="text" name="emailAddress"></td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><select name="typeCode">
					<option  value="Primary" >Primary</option>	
				<option  value="Secondary" >Secondary.</option>	
				<option  value="Persnal" >Persnal</option>	
				<option  value="Business" >Business</option>	
			      </select>
			    </td>
			</tr>
			<tr>
				<td>PrimaryInd :</td>
				<td>
					<input type="radio" name="primaryInd" value="True" checked> True
        			<input type="radio" name="primaryInd" value="False"> False
					<!--  <input type="text" name="primaryInd">-->
				</td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input type="text" name="startDate"></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="text" name="endDate"></td>
			</tr>
			
			<!-- Enter Phone Number Parameter -->
			
			 
			<tr>
		<td> Country Code:</td>
		<td><input type="text" name="countryCode"></td>
		</tr>
		<tr>
		<td> Area Code:</td>
		<td><input type="text" name="areaCode"></td>
		</tr>
		<tr>
		<td>Phone Number:</td>
		<td><input type="text" name="phoneNumber"></td>
		</tr>
		<tr>
		<td> Extension:</td>
		<td><input type="text" name="extension"></td>
		</tr>
		<tr>
		   <td>Type Code :</td>
				<td><select name="typeCode">
					<option  value="Primary" >Primary</option>	
				<option  value="Secondary" >Secondary.</option>	
				<option  value="Persnal" >Persnal</option>	
				<option  value="Business" >Business</option>	
			      </select>
			</td>
		</tr>
		<tr>
		<td> PrimaryInd:</td>
		<td>
			<input type="radio" name="primaryIndP" value="True" checked> True
        	<input type="radio" name="primaryIndP" value="False"> False
		<!-- <input type="text" name="primaryInd"> -->
		</td>
		</tr>
		<tr>
		<td> Start Date:</td>
		<td><input type="text" name="startDate"></td>
		</tr>
		
		<tr>
		<td> End Date:</td>
		<td><input type="text" name="endDate"></td>
		</tr>
			
			<!-- Enter Address table parameter -->
			
		<tr>
				<td>StreetOne:</td>
				<td><input type="text" name="streetOne" maxlength="50"></td>
			</tr>
			
			<tr>
				<td>StreetTwo:</td>
				<td><input type="text" name="streetTwo" maxlength="50"></td>
			</tr>
			
			<tr>
				<td>AptUnit:</td>
				<td><input type="text" name="aptUnit" maxlength="20"></td>
			</tr>
			
			<tr>
				<td>City:</td>
				<td><input type="text" name="city"></td>
			</tr>
			
			<tr>
				<td>County:</td>
				<td><input type="text" name="county"></td>
			</tr>
			
			<tr>
				<td>State:</td>
				<td><select name="state">
				    <option  value="ST0001" >New York</option>	
					<option  value="ST0002" >New Jersy</option>	
					<option  value="ST0003" >Washington DC</option>	
					<option  value="ST0004" >Chicago</option>	
					<option  value="ST0005" >Maryland</option>	
				</select>
				</td>
			</tr>
			
			<tr>
				<td>Country</td>
				<td><input type="text" name="country"></td>
			</tr>
			
			<tr>
				<td>ZipCode:</td>
				<td><input type="text" name="zipCode"></td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><select name="typeCode">
					<option  value="Primary" >Primary</option>	
					<option  value="Secondary" >Secondary.</option>	
					<option  value="Persnal" >Persnal</option>	
					<option  value="Business" >Business</option>	
			        </select>
			    </td>
			</tr>
			<tr>
				<td>PrimaryInd :</td>
				<td>
					<input type="radio" name="primaryIndA" value="True" checked> True
        			<input type="radio" name="primaryIndA" value="False"> False
					<!--  <input type="text" name="primaryInd">-->
				</td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input type="text" name="startDate"></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="text" name="endDate"></td>
			</tr> 
			
			<!-- Insert Person Identity Parameters -->
			
			<tr>
				<td>AlternateID :</td>
				<td><input type="text" name="alternateID"></td>
			</tr>
			<tr>
				<td>PrimaryInd :</td>
				<td>
					<input type="radio" name="primaryIndI" value="True" checked> True
        			<input type="radio" name="primaryIndI" value="False"> False
					<!--  <input type="text" name="primaryInd">-->
				</td>
			</tr>
			<tr>
				<td>Type Code :</td>
				<td><select name="typeCode">
					<option  value="Primary" >Primary</option>	
					<option  value="Secondary" >Secondary</option>	
					<option  value="Persnal" >Persnal</option>	
					<option  value="Business" >Business</option>	
			        </select>
			    </td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><input type="text" name="startDate"></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><input type="text" name="endDate"></td>
			</tr>
			<tr>
				<td>Role :</td>
				<td><select name="roleID">
				    <option  value="9001" >Administrator</option>	
					<option  value="9002" >Employee</option>	
					<option  value="9003" >Devloper</option>	
			        </select>
				</td>
			</tr>
		
			
			<%
				}
			%>
			<tr>

				<td><br><input id="submit" type="submit" value="Submit"></td>

			</tr>

		
		</table>

	</form>
	<form action="/ITOS/PersonLogOut" method="POST">
		<br> <input type="submit" value="Cancel">
	</form>

		</fieldset>

</body>
</html>