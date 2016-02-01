<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function() {
		$('.dateTxt').datepicker({
			changeMonth : true,
			changeYear : true
		});
	});

	/* $(document).ready(function() {
		$(this).datepicker({
			  changeMonth: true,
			  changeYear: true
		});
		$('#submit').click(function() {
			alert("Submit ?");
		});
	}); */
</script>

</head>

<body>
<br>
<br>

         <h1 class="well">Registration Form</h1>
    <div class="container" style="border: thin solid black">
         <br>
            <h2>Person Detail</h2>
            <br>
        <s:form class="form-inline" name="Registration" action="/ITOS/CreateUserSubmit" method="POST" role="form" theme="bootstrap">
            <div class="form-group">

                <label>Name:</label>
                <s:select list="#{'Mr.':'Mr.', 'Mrs.':'Mrs.','Miss.':'Miss.', 'Kumar':'Kumar'}"
                    name="personDetail.title" placeholder="Title" class="form-control">
                </s:select> 
                <!-- <input type="email" class="form-control" id="email" placeholder="Enter email">-->
            </div>
            
            <div class="form-group">
            <s:textfield type="text" name="personDetail.firstName"  placeholder="FirstName" class="form-control" />
            </div>
            
            
            <div class="form-group">
            <s:textfield type="text" name="personDetail.middleName" placeholder="MiddleName"
                        class="form-control" />
                        </div>
                
                <div class="form-group">
                    <s:textfield type="text" name="personDetail.lastName" placeholder="LastName" class="form-control" />
            </div>
            <br>
            <br>
            <div class="form-group">
            <label>Gender:</label>
            <s:select list="#{'GEN0001':'Male', 'GEN0002':'Female'}" name="personDetail.gender" ></s:select>
        </div>
            <s:iterator value="%{codeTableItemList}" status="stat">
            <s:select label="Gender" cssClass="textfield" headerKey="-1" headerValue="Select" list="codeTableItemList"
                name="Gender" class="form-control"  />
        </s:iterator>
        
        
       <div class="form-group">
            <label>DateOfBirth:</label>
            <input type="text" id="datepicker1" class="dateTxt" name="personDetail.dateOfBirth" />
        </div>
        <br>
        <br>
        
        <div class="form-group">
            <label>UserName:</label>
            <s:textfield type="text" name="personDetail.usersDetail.userName" placeholder="UserName" class="form-control"/>
        </div>
        
        <div class="form-group">
            <label>Password:</label>
            <s:textfield type="text" name="personDetail.usersDetail.password" placeholder="Password" class="form-control"/>
        </div>
        <br>
        <br>
        
         <!-- Enter Email Address Parameter -->
         
        <div class="form-group">
            <label>Email Address:</label>
            <s:textfield type="text" name="personDetail.emailAddressLinkDetail.emailAddressDetail.emailAddress"
                    class="form-control" />
        </div>
        <div class="form-group">
            <label>Type Code:</label>
            <s:select
                    list="#{'Primary':'Primary', 'Secondary':'Secondary', 'Persnal':'Persnal', 'Business':'Business'}"
                    name="personDetail.emailAddressLinkDetail.typeCode" class="form-control">

                </s:select>
        </div>
        <div class="form-group">
            <label>PrimaryInd:</label>
           <s:radio name="personDetail.emailAddressLinkDetail.primaryInd" list="#{'1':'True','0':'false' }"
                    value="1" ></s:radio>
         </div>
         <br>
         <br>
        <div class="form-group">
            <label>Start Date:</label>
           <input type="text" id="datepicker2" class="dateTxt"
                name="personDetail.emailAddressLinkDetail.startDate" />
        </div>
        <div class="form-group">
            <label>End Date:</label>
           <input type="text" id="datepicker3" class="dateTxt"
                name="personDetail.emailAddressLinkDetail.endDate" />
        </div>
        <br>
        <br>
        
         <!-- Enter Phone Number Parameter -->
         
        <div class="form-group">
            <label>Country Code:</label>
           <s:textfield type="text" name="personDetail.phoneNumberLinkDetail.phoneNumberDetail.countryCode" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Area Code:</label>
           <s:textfield type="text" name="personDetail.phoneNumberLinkDetail.phoneNumberDetail.areaCode" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Phone Number:</label>
           <s:textfield type="text" name="personDetail.phoneNumberLinkDetail.phoneNumberDetail.phoneNumber" class="form-control"/>
        </div>
        <br>
        <br>
        <div class="form-group">
            <label>Extension</label>
           <s:textfield type="text" name="personDetail.phoneNumberLinkDetail.phoneNumberDetail.extension" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Type Code</label>
           <s:select
                    list="#{'Primary':'Primary', 'Secondary':'Secondary', 'Persnal':'Persnal', 'Business':'Business'}"
                    name="personDetail.phoneNumberLinkDetail.typeCode" class="form-control">

                </s:select>
        </div>
        <div class="form-group">
            <label>PrimaryInd</label>
           <s:radio name="personDetail.phoneNumberLinkDetail.primaryInd" list="#{'1':'True','0':'false' }"
                    value="1"></s:radio>
        </div>
        <br>
        <br>
        <div class="form-group">
            <label>Start Date</label>
           <input type="text" id="datepicker4" class="dateTxt"
                name="personDetail.phoneNumberLinkDetail.startDate" />
        </div>
        <div class="form-group">
            <label>End Date</label>
           <input type="text" id="datepicker5" class="dateTxt"
                name="personDetail.phoneNumberLinkDetail.endDate" />
        </div>
            <br>
            <br>
            
             <!-- Enter Address table parameter -->
            
        <div class="form-group">
            <label>StreetOne</label>
           <s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.streetOne"
                    maxlength="50" class="form-control" />
        </div>
        <div class="form-group">
            <label>StreetTwo</label>
           <s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.streetTwo"
                    maxlength="50" class="form-control" />
        </div>
        <div class="form-group">
            <label>AptUnit</label>
          <s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.aptUnit" maxlength="20" class="form-control" />
        </div>
        <br>
        <br>
        <div class="form-group">
            <label>City</label>
          <s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.city" class="form-control" />
        </div>
        <div class="form-group">
            <label>County</label>
         <s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.county" class="form-control" />
        </div>
        <div class="form-group">
            <label>State</label>
         <s:select
                    list="#{'ST0001':'New York', 'ST0002':'New Jersy', 'ST0003':'Washington', 'ST0004':'Chicago', 'ST0005':'Maryland'}"
                    name="personDetail.addressLinkDetail.addressDetail.state" class="form-control">
                   
                </s:select>
        </div>
        <br>
        <br>
            
        <div class="form-group">
            <label>Country</label>
        <s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.country" class="form-control" />
        </div>
        <div class="form-group">
            <label>ZipCode</label>
       <s:textfield type="text" name="personDetail.addressLinkDetail.addressDetail.zipCode" class="form-control" />
        </div>
        <div class="form-group">
            <label>Type Code</label>
       <s:select
                    list="#{'Primary':'Primary', 'Secondary':'Secondary', 'Persnal':'Persnal', 'Business':'Business'}"
                    name="personDetail.addressLinkDetail.typeCode" class="form-control" >
                </s:select>
        </div>
        <br>
        <br>
        <div class="form-group">
            <label>PrimaryInd</label>
       <s:radio name="personDetail.addressLinkDetail.primaryInd" list="#{'1':'True','0':'false' }"
                    value="1"></s:radio>
        </div>
        <div class="form-group">
            <label>Start Date</label>
       <input type="text" id="datepicker6" class="dateTxt" name="personDetail.addressLinkDetail.startDate" />
        </div>
        <div class="form-group">
            <label>End Date</label>
      <input type="text" id="datepicker7" class="dateTxt" name="personDetail.addressLinkDetail.endDate" />
        </div>
        <br>
        <br>
        
         <!-- Insert Person Identity Parameters -->
        
        <div class="form-group">
            <label>AlternateID</label>
      <s:textfield type="text" name="personDetail.personIdentityDetail.alternateID" class="form-control"/>
        </div>
        <div class="form-group">
            <label>PrimaryInd</label>
     <s:radio name="personDetail.personIdentityDetail.primaryInd" list="#{'1':'True','0':'false' }"
                    value="1"></s:radio>
        </div>
        <div class="form-group">
            <label>Type Code</label>
     <s:select list="#{'Primary':'Primary', 'Secondary':'Secondary', 'Persnal':'Persnal', 'Business':'Business'}"
                    name="personDetail.personIdentityDetail.typeCode" class="form-control">
                </s:select>
        </div>
            <br>
            <br>
        <div class="form-group">
            <label>Start Date</label>
            <input type="text" id="datepicker8" class="dateTxt"
                name="personDetail.personIdentityDetail.startDate" />
        </div>
        <div class="form-group">
            <label>End Date</label>
            <input type="text" id="datepicker9" class="dateTxt"
                name="personDetail.personIdentityDetail.endDate" />
        </div>
        <div class="form-group">
            <label>Role</label>
            <s:select list="#{'9001':'Administrator', '9002':'Employee', '9003':'Devloper'}"
                    name="personDetail.roleDetail.roleID" class="form-control">
                </s:select>
        </div>
            
            <br>
            <br>
            <s:submit type="submit" id="submit" value="Submit" class="btn btn-primary"/>
            <div class="checkbox">
                <label><input type="checkbox"> Remember me</label>
            </div>
        </s:form>
    
     <s:form action="/ITOS/PersonLogOut" method="POST">
        <br>
        <s:submit type="submit" value="Cancel" class="btn btn-primary"/>
    </s:form>
    </div>



</body>
</html>