<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="/ITOS/ListCodeTable">Back</a>
&nbsp
<br>
<br>

<s:form action="/ITOS/ReadCodeTableHeader" method="POST">
	<table border=1>
		<thead>

			<tr>
				<th align="left">Table Name:</th>
				<th>Default Code:</th>
				<th>Created By:</th>
				<th>Created On:</th>
				<th>LastModified By:</th>
				<th>LastModified On:</th>
			</tr>
		</thead>


		<tbody>
			<tr>
				<td><s:property value="codeTableHeaderDetail.tableName" /></td>
				<td><s:property value="codeTableHeaderDetail.defaultCode" /></td>
				<td><s:property value="codeTableHeaderDetail.createdBy" /></td>
				<td><s:property value="codeTableHeaderDetail.createdOn" /></td>
				<td><s:property value="codeTableHeaderDetail.lastModifiedBy" /></td>
				<td><s:property value="codeTableHeaderDetail.lastModifiedOn" /></td>

			</tr>

		</tbody>
	</table>
	<!--</s:form>-->
	<br>
	<br>

	<!-- List of code Table Items -->


	<s:url id="CreatecodeTableItemURL" action="/ITOS/CreatecodeTableItem"
		escapeAmp="false">

		<s:param name="codeTableItemDetail.tableName"
			value="%{codeTableHeaderDetail.tableName}" />

	</s:url>
	<s:a href="%{CreatecodeTableItemURL}">Create Code Table Item</s:a>
	<br>
	<br>
	<!--<s:form action="" method="POST">-->
	<table border=1>
		<thead>

			<tr>
				<th align="left">Table Name:</th>
				<th>Code:</th>
				<th>Description:</th>
				<th>Annotation:</th>
				<th>Is Enabled:</th>
				<th>Created By:</th>
				<th>Created On:</th>
				<th>LastModified By:</th>
				<th>LastModified On:</th>
				<th colspan=3>Action</th>
			</tr>
		</thead>


		<s:iterator value="codeTableHeaderDetail.codeTableItemDetailList"
			status="false">

			<tbody>
				<tr>
					<td><s:property value="tableName" /></td>
					<td><s:property value="code" /></td>
					<td><s:property value="description" /></td>
					<td><s:property value="annotation" /></td>
					<td><s:property value="isEnabled" /></td>
					<td><s:property value="createdBy" /></td>
					<td><s:property value="createdOn" /></td>
					<td><s:property value="lastModifiedBy" /></td>
					<td><s:property value="lastModifiedOn" /></td>

					<td><s:url id="ReadCodeTableItemURL"
						action="/ITOS/ReadCodeTableItem" escapeAmp="false">
						<s:param name="codeTableItemDetail.tableName" value="%{tableName}" />
						<s:param name="codeTableItemDetail.code" value="%{code}" />
					</s:url> <s:a href="%{ReadCodeTableItemURL}">View</s:a> <s:url
						id="UpdateCodeTableItemrURL" action="/ITOS/ReadCodeTableItem"
						escapeAmp="false">
						<s:param name="codeTableItemDetail.tableName" value="%{tableName}" />
						<s:param name="codeTableItemDetail.code" value="%{code}" />
						<s:param name="act" value="%{updateAction}" />
					</s:url> <s:a href="%{UpdateCodeTableItemrURL}">Update</s:a></td>

				</tr>

			</tbody>
		</s:iterator>

	</table>
</s:form>




</body>
</html>