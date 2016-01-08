<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <a href="/ITOS/ListCodeTableHeader">Back</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp


                            <s:url id="CreatecodeTableItemURL" action="/ITOS/CreatecodeTableItem" escapeAmp="false">
                            </s:url>
                            <s:a href="%{CreatecodeTableItemURL}">Create Code Table Item</s:a>


<s:form action="/ITOS/ListCodeTableItem" method = "POST">
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
			
            <s:iterator value="codeTableItemDetailList" status="stat">
			
			<tbody>
				<tr>
					<td><s:property value="tableName"/></td>
					<td><s:property value="code"/></td>
					<td><s:property value="description"/></td>
					<td><s:property value="annotation"/></td>
					<td><s:property value="isEnabled"/></td>
					<td><s:property value="createdBy"/></td>
					<td><s:property value="createdOn"/></td>
					<td><s:property value="lastModifiedBy"/></td>
					<td><s:property value="lastModifiedOn"/></td>
					
                    <td><s:url id="ReadCodeTableItemURL" action="/ITOS/ReadCodeTableItem" escapeAmp="false">
                                <s:param name="codeTableItemDetail.code" value="%{code}"/>
                            </s:url>
                            <s:a href="%{ReadCodeTableItemURL}">View</s:a>
                            
                            <s:url var="UpdateCodeTableItemURL" action="/ITOS/ReadCodeTableItem" escapeAmp="false">
                                <s:param name="codeTableItemDetail.code" value="%{code}"/>
                                <s:param name="codeTableItemDetail.tableName" value="%{tableName}"/>
                                <s:param name="act" value="%{updateAction}"/>
                            </s:url>
                            <s:a href="%{UpdateCodeTableItemURL}">Update</s:a>
                            
                            <s:url var="DeleteCodeTableItemURL" action="/ITOS/DeleteCodeTableItem" escapeAmp="false">
                                <s:param name="codeTableItemDetail.code" value="%{code}"/>
                                <s:param name="codeTableItemDetail.tableName" value="%{tableName}"/>
                            </s:url>
                            <s:a href="%{DeleteCodeTableItemURL}">Delete</s:a>
                            
                        </td>
					
				</tr>
				
			</tbody>
            </s:iterator>
		</table>
		</s:form><br><br>

</body>
</html>