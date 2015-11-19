<%@ page import="com.company.itos.profile.pojo.PersonDetail"%>
<%@ page
	import="com.company.itos.profile.email.pojo.EmailAddressLinkDetail"%>
<%@ page import="com.company.itos.profile.email.pojo.EmailAddressDetail"%>
<%@ page import="com.company.itos.profile.phone.pojo.PhoneNumberDetail"%>
<%@ page
	import="com.company.itos.profile.phone.pojo.PhoneNumberLinkDetail"%>
<%@ page import="com.company.itos.profile.dao.PersonRegistrationDAO"%>
<%@ page import="com.company.itos.profile.address.pojo.AddressLinkDetail"%>
<%@ page import="com.company.itos.profile.address.pojo.AddressDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<h2>Person Detail</h2>
		<div>

			<%
				PersonDetail personDetail = (PersonDetail) request.getAttribute("personDetail");

				EmailAddressLinkDetail emailAddressLinkDetail = personDetail.getEmailAddressLinkDetail();
				EmailAddressDetail emailAddressDetail = emailAddressLinkDetail.getEmailAddressDetail();

				PhoneNumberLinkDetail phoneNumberLinkDetail = personDetail.getPhoneNumberLinkDetail();
				PhoneNumberDetail phoneNumberDetail = phoneNumberLinkDetail.getPhoneNumberDetail();
				
				AddressLinkDetail addressLinkDetail = personDetail.getAddressLinkDetail();
				AddressDetail addressDetail = addressLinkDetail.getAddressDetail();

				String name = request.getParameter("firstName");
			%>


			<form action="/ITOS/PersonHome" method="post">


				<font size="3" color="green"> <%
 	out.println("Wellcome\t" + personDetail.getFirstName());
 %>
				</font>


				<table border=1>
					<thead>

						<tr>
							<th align="left">Title :<%=personDetail.getTitle()%></th>

							<th align="left">First Name: <%=personDetail.getFirstName()%></th>

						</tr>
					</thead>
					<tbody>

						<tr>
							<th align="left">Middle Name: <%=personDetail.getMiddleName()%></th>
							<th align="left">Last Name: <%=personDetail.getLastName()%></th>

							<td></td>
						</tr>
					</tbody>

					<tbody>

						<th align="left">Gender: <%=personDetail.getGender()%></th>
						<th align="left">Date Of Birth: <%=personDetail.getDateOfBirth()%></th>


					</tbody>
					<tbody>
						<th align="left">Status: <%=personDetail.getRecordStatus()%></th>
						<th align="left">Created By:<%=personDetail.getCreatedBy()%></th>

					</tbody>
					<tbody>
						<th align="left">Created On:<%=personDetail.getCreatedOn()%></th>
						<th align="left">Modified By:<%=personDetail.getModifiedBy()%></th>
					</tbody>
					<tbody>
						<th align="left">Modified On:<%=personDetail.getModifiedOn()%></th>
						<th align="left">Registration Date:<%=personDetail.getRegistrationDate()%></th>

					</tbody>

					<tbody>

						<th><a
							href="/ITOS/PersonHome?personID=<%=personDetail.getPersonID()%>&act=update">Update</a></th>
						<th><a
							href="/ITOS/PersonList?personID=<%=personDetail.getPersonID()%>">PersonList</a></th>
					</tbody>

				</table>

			</form>
		</div>

		<h2>Email Address Detail</h2>
		<div>

			<form action="/ITOS/ReadEmailAddress" method="POST">
				<table border=1>
					<tbody>
						<th align="left">EmailAddress: <%=emailAddressDetail.getEmailAddress()%></th>
						<th align="left">Type Code: <%=emailAddressLinkDetail.getTypeCode()%></th>
					</tbody>
					<tbody>
						<th align="left">PrimaryInd: <%=emailAddressLinkDetail.getPrimaryInd()%></th>
						<th align="left">Start Date: <%=emailAddressLinkDetail.getStartDate()%></th>
					</tbody>
					<tbody>
						<th align="left">End Date: <%=emailAddressLinkDetail.getEndDate()%></th>
						<!--  <th><a href="/ITOS/ListEmailAddress?personID=<%=personDetail.getPersonID()%>&emailAddressLinkID=<%=emailAddressLinkDetail.getEmailAddressLinkID()%>">
			EmailAddress List</a></th>-->
						<th><a
							href="/ITOS/ListEmailAddress?relatedID=<%=emailAddressLinkDetail.getRelatedID()%>">
								EmailAddress List</a></th>
					</tbody>

				</table>

			</form>
		</div>

		<h2>Phone Number Detail</h2>
		<div>

			<form action="/ITOS/ReadPhoneNumber" method="POST">
				<table border=1>
				<%
				
				%>
					<tbody>
						<th align="left">Country Code: <%=phoneNumberDetail.getCountryCode()%></th>
						<th align="left">Area Code: <%=phoneNumberDetail.getAreaCode()%></th>
					</tbody>
					<tbody>
						<th align="left">Phone Number: <%=phoneNumberDetail.getPhoneNumber()%></th>
						<th align="left">Extension: <%=phoneNumberDetail.getExtension()%></th>
					</tbody>
					<tbody>
						<th align="left">Type Code: <%=phoneNumberLinkDetail.getTypeCode()%></th>
						<th align="left">PrimaryInd: <%=phoneNumberLinkDetail.getPrimaryInd()%></th>


					</tbody>
					<tbody>
						<th align="left">start Date: <%=phoneNumberLinkDetail.getStartDate()%></th>
						<th align="left">End Date: <%=phoneNumberLinkDetail.getEndDate()%></th>
					</tbody>
					<tbody>

						<th><a
							href="/ITOS/ListPhoneNumber?relatedID=<%=phoneNumberLinkDetail.getRelatedID()%>">PhoneNumber
								List</a></th>

					</tbody>

				</table>

			</form>
		</div>
		<h2>Address Detail</h2>
		<div>
		<form action="/ITOS/ReadAddress" method="POST">
		<table border=1>
		
		<tbody>
						<th align="left">StreetOne: <%=addressDetail.getStreetOne()%></th>
						<th align="left">StreetTwo: <%=addressDetail.getStreetTwo()%></th>
					</tbody>
					<tbody>
						<th align="left">AptUnit: <%=addressDetail.getAptUnit()%></th>
						<th align="left">City: <%=addressDetail.getCity()%></th>
					</tbody>
					<tbody>
						<th align="left">County: <%=addressDetail.getCounty()%></th>
						<th align="left">State: <%=addressDetail.getState()%></th>

					</tbody>
					<tbody>
						<th align="left">Country: <%=addressDetail.getCountry()%></th>
						<th align="left">ZipCode: <%=addressDetail.getZipCode()%></th>
					</tbody>
					<tbody>
						<th align="left">Type Code: <%=addressLinkDetail.getTypeCode()%></th>
						<th align="left">PrimaryInd: <%=addressLinkDetail.getPrimaryInd()%></th>
					</tbody>
					<tbody>
						<th align="left">Start Date: <%=addressLinkDetail.getStartDate()%></th>
						<th align="left">End Date: <%=addressLinkDetail.getEndDate()%></th>
					</tbody>
					<tbody>
						<th><a
							href="/ITOS/ListAddress?relatedID=<%=addressLinkDetail.getRelatedID()%>">Address
								List</a></th>

					</tbody>

				</table>
		
		
			<form action="/ITOS/PersonLogOut" method="POST">
				<br> <input type="submit" value="LogOut">
				<br><br> <a href="LoginForm.jsp">Project Home</a>&nbsp&nbsp&nbsp&nbsp&nbsp
				<br>
		</form>
		</div>
		</form>
	</div>


</body>
</html>