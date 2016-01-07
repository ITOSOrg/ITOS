<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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



<div id="myaccordion">
		<h2>Email Address List </h2>
		<div>
        
      <s:url var="CreateEmailAddressURL" action="/ITOS/CreateEmailAddress" escapeAmp="false">
             <s:param name="emailAddressLinkDetail.relatedID" value="%{emailAddressLinkDetail.relatedID}"/>
      </s:url>
             <s:a href="%{CreateEmailAddressURL}">Create Email Address</s:a><br><br>


<s:form action="/ITOS/ListEmailAddress" method = "POST">
<table border=1>
			<thead>

				<tr>
					<th align="left">EmailAddress</th>
					<th>Type Code</th>
					<th>PrimaryInd</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th colspan=3>Action</th>
				</tr>
			</thead>
			
			
                    <s:iterator value="emailAddressLinkDetailList" status="stat">
			
			<tbody>
				<tr>
					<td><s:property value="emailAddressDetail.emailAddress" /></td>
					<td><s:property value="typeCode" /></td>
					<td><s:property value="primaryInd" /></td>
					<td><s:property value="startDate" /></td>
					<td><s:property value="endDate" /></td>
					
                    <td><s:url id="ReadEmailAddressURL" action="/ITOS/ReadEmailAddress" escapeAmp="false">
                                <s:param name="emailAddressDetail.emailAddressID" value="%{emailAddressID}"/>
                                <s:param name="emailAddressLinkDetail.emailAddressLinkID" value="%{emailAddressLinkID}"/>
                            </s:url>
                            <s:a href="%{ReadEmailAddressURL}">View</s:a>
                            
                            
                            <s:url var="UpdateEmailAddressURL" action="/ITOS/ReadEmailAddress" escapeAmp="false">
                                <s:param name="emailAddressDetail.emailAddressID" value="%{emailAddressID}"/>
                                <s:param name="emailAddressLinkDetail.emailAddressLinkID" value="%{emailAddressLinkID}"/>
                                <s:param name="act" value="%{updateAction}"/>
                            </s:url>
                            <s:a href="%{UpdateEmailAddressURL}">Update</s:a>
                            
                            
                            
                            <s:url var="DeleteEmailAddressURL" action="/ITOS/DeleteEmailAddress" escapeAmp="false">
                                <s:param name="emailAddressLinkDetail.emailAddressID" value="%{emailAddressID}"/>
                                <s:param name="emailAddressLinkDetail.emailAddressLinkID" value="%{emailAddressLinkID}"/>
                                <s:param name="emailAddressLinkDetail.relatedID" value="%{relatedID}"/>
                            </s:url>
                            <s:a href="%{DeleteEmailAddressURL}">Delete</s:a>
                        </td>
                    
				</tr>
				
			</tbody>
            </s:iterator>
		</table>
		</s:form>
		</div>
		</div>
</body>
</html>