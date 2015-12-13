<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<s:a href="PersonList">Person List</s:a><br><br>

<s:url id="ListEmailAddressURL" action="ITOS/ListEmailAddress" escapeAmp="false">

<s:param name="emailAddressLinkDetail.relatedID" value="%{personDetail.personID}"/>

</s:url>
<s:a href="%{ListEmailAddressURL}">new Email Addresses</s:a><br><br>

<s:a href="ListEmailAddress">Email Addresses</s:a><br><br>
<s:a href="ListPhoneNumber">Phone Numbers</s:a><br><br>
<s:a href="ListPersonIdentity">Person Identities</s:a><br><br>
<s:a href="ListAddress">Addresses</s:a><br><br>
<s:a href="SearchPerson">Search Person</s:a><br><br>
<s:a href="ListProperties">Properties</s:a><br><br>
<s:a href="ListKeyServer">KeyServers</s:a><br><br>
<s:a href="ListCodeTable">CodeTables</s:a><br><br>
<s:a href="ListRoles">Roles</s:a><br><br>

</body>
</html>


<%@ page contentType="text/html; charset=UTF-8"%>