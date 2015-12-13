<%@ page import="com.company.itos.profile.email.pojo.EmailAddressDetail"%>
<%@ page import="com.company.itos.profile.email.pojo.EmailAddressLinkDetail"%>
<%@ page import="java.util.List"%>
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

<script src="http://www.jqueryscript.net/tags.php?/Modal/"></script>

<script>
	$(function() {
		$("#myaccordion").accordion();
	});
</script>
<script type="text/javascript">
  $(document).ready(function() {
    $("#dialog").dialog({
      autoOpen: false,
      modal: true
    });
  });
  $(".confirmLink").click(function(e) {
	    e.preventDefault();
	    var targetUrl = $(this).attr("href");

	    $("#dialog").dialog({
	      buttons : {
	        "Confirm" : function() {
	          window.location.href = targetUrl;
	        },
	        "Cancel" : function() {
	          $(this).dialog("close");
	        }
	      }
	    });

	    $("#dialog").dialog("open");
	  });
  </script>
</head>
<body>


<%
List<EmailAddressLinkDetail> emailAddressLinkDetailList = (List<EmailAddressLinkDetail>) session.getAttribute("emailAddressLinkDetailList");


Integer relatedID = (Integer) request.getAttribute("relatedID");


%>
<div id="myaccordion">
		<h2>Email Address List Workspace</h2>
		<div>
			<a href="/ITOS/PersonHome?personID=<%= relatedID%>">Person Home</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

<a href="/ITOS/components/profile/jsp/email/CreateEmailAddress.jsp?relatedID=<%= relatedID%>">Create Email Address</a><br><br>



<form action="/ITOS/ListEmailAddress" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">EmailAddress:</th>
					<th>Type Code:</th>
					<th>PrimaryInd:</th>
					<th>Start Date:</th>
					<th>End Date:</th>
					<th colspan=3>Action</th>
				</tr>
			</thead>
			
			<%
				for (int i = 0; i < emailAddressLinkDetailList.size(); i++) {
					EmailAddressLinkDetail	 emailAddressLinkDetail = emailAddressLinkDetailList.get(i);
 					EmailAddressDetail emailAddressDetail =  emailAddressLinkDetail.getEmailAddressDetail();
			%>
			
			<tbody>
				<tr>
					<td><%=emailAddressDetail.getEmailAddress() %></td>
					<td><%=emailAddressLinkDetail.getTypeCode() %></td>
					<td><%=emailAddressLinkDetail.getPrimaryInd() %></td>
					<td><%=emailAddressLinkDetail.getStartDate() %></td>
					<td><%=emailAddressLinkDetail.getEndDate() %></td>
					<td><a  href="/ITOS/ReadEmailAddress?emailAddressID=<%=emailAddressDetail.getEmailAddressID()%>&emailAddressLinkID=<%=emailAddressLinkDetail.getEmailAddressLinkID()%>&relatedID=<%= relatedID%>">Read</a></td>
					<td><a href="/ITOS/ReadEmailAddress?emailAddressID=<%=emailAddressDetail.getEmailAddressID()%>&emailAddressLinkID=<%=emailAddressLinkDetail.getEmailAddressLinkID()%>&act=update">Update</a> </td>
					<td><a class="js-open-modal" href="/ITOS/DeleteEmailAddress?emailAddressID=<%=emailAddressDetail.getEmailAddressID()%>&emailAddressLinkID=<%=emailAddressLinkDetail.getEmailAddressLinkID()%>&relatedID=<%= relatedID%>">Delete</a></td>
				</tr>
				
			</tbody>
			<%} %>
		</table>
		</form>
		</div>
		</div>
</body>
</html>