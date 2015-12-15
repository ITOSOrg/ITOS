<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
		<h2>Create KeyServer</h2>
		<div>

<a href="/ITOS/ListKeyServer">Back</a><br><br>
<s:form name="Create KeyServer" action="/ITOS/CreateKeyServerSubmit"
		method="POST">
		<table>
		  
			<tr>
				<td>Keyset Code :</td>
				<td><s:textfield type="text" name="keyServerDetail.keysetCode"/></td>
			</tr>
			<tr>
				<td>Next UniqueIdBlock :</td>
				<td><s:textfield type="text" name="keyServerDetail.nextUniqueIdBlock"/></td>
			</tr>
			<tr>
				<td>Human Readable :</td>
				<td><s:textfield type="text" name="keyServerDetail.humanReadable"/></td>
			</tr>
			<tr>
				<td>Annotation :</td>
				<td><s:textfield type="text" name="keyServerDetail.annotation"/></td>
			</tr>
			<tr>
				<td>Strategy :</td>
				<td><s:textfield type="text" name="keyServerDetail.strategy"/></td>
			</tr>
			<tr>

				<td><s:textfield  type="submit" value="Submit"/>

			</tr>
			
		
		</table>
		</s:form>
</div>
</div>
</body>
</html>