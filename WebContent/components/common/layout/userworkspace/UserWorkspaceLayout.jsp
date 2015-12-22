<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height: 100%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

</head>
<body style="height: 100%;">
	<table width="100%"  height="100%" border="1" cellpadding="2" cellspacing="2" align="top">
		<tr>
			<td height="15%" colspan="2"><tiles:insertAttribute name="header" />
			</td>
		</tr>
		<tr>
			<td width="10%" valign="top" ><tiles:insertAttribute name="menu" /></td>
			<td width="90%" valign="top"><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr>
			<td height="5%" colspan="2"><tiles:insertAttribute name="footer" />
			</td>
		</tr>
	</table>
</body>
</html>