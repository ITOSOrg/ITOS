<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<s:url id="ListEmailAddressURL" action="ITOS/ListEmailAddress" escapeAmp="false">
    <s:param name="emailAddressLinkDetail.relatedID" value="%{personDetail.personID}"/>
</s:url>
<s:a href="%{ListEmailAddressURL}">Email Addresses</s:a><br><br>

<s:url id="ListPhoneNumberURL" action="ITOS/ListPhoneNumber" escapeAmp="false">
    <s:param name="phoneNumberLinkDetail.relatedID" value="%{personDetail.personID}"/>
</s:url>
<s:a href="%{ListPhoneNumberURL}">Phone Numbers</s:a><br><br>

<s:url id="ListPersonIdentityURL" action="ITOS/ListPersonIdentity" escapeAmp="false">
    <s:param name="personIdentityDetail.personID" value="%{personDetail.personID}"/>
</s:url>
<s:a href="%{ListPersonIdentityURL}">Person Identities</s:a><br><br>

<s:url id="ListAddressURL" action="ITOS/ListAddress" escapeAmp="false">
    <s:param name="addressLinkDetail.relatedID" value="%{personDetail.personID}"/>
</s:url>
<s:a href="%{ListAddressURL}">Addresses</s:a><br><br>


<s:a href="PersonList">Person List</s:a><br><br>

<s:a href="SearchPerson">Search Person</s:a><br><br>
<s:a href="ListProperties">Properties</s:a><br><br>
<s:a href="ListKeyServer">KeyServers</s:a><br><br>
<s:a href="ListCodeTable">CodeTables</s:a><br><br>
<s:a href="ListRoles">Roles</s:a><br><br>
</body>
</html>


<%@ page contentType="text/html; charset=UTF-8"%>