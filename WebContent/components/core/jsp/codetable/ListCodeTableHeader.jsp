<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <a href="/ITOS/CreateCodeTableHeader">Create CodeTable </a>
    <br>
    <br>

    <s:form action="/ITOS/ListCodeTableHeader" method="POST">
        <table border=1>
            <thead>

                <tr>
                    <th align="left">Table Name:</th>
                    <th>Default Code:</th>
                    <th>Created By:</th>
                    <th>Created On:</th>
                    <th>LastModified By:</th>
                    <th>LastModified On:</th>
                    <th colspan=3>Action</th>
                </tr>
            </thead>


            <s:iterator value="codeTableHeaderList" status="stat">

                <tbody>
                    <tr>
                        <td><s:property value="tableName" /></td>
                        <td><s:property value="defaultCode" /></td>
                        <td><s:property value="createdBy" /></td>
                        <td><s:property value="createdOn" /></td>
                        <td><s:property value="lastModifiedBy" /></td>
                        <td><s:property value="lastModifiedOn" /></td>
                        <td>
                        <td><s:url id="ReadCodeTableHeaderURL" action="/ITOS/ReadCodeTableHeader" escapeAmp="false">
                                <s:param name="codeTableHeaderDetail.tableName" value="%{tableName}" />
                            </s:url> <s:a href="%{ReadCodeTableHeaderURL}">View</s:a> <s:url id="UpdateCodeTableHeaderURL"
                                action="/ITOS/ReadCodeTableHeader" escapeAmp="false">
                                <s:param name="codeTableHeaderDetail.tableName" value="%{tableName}" />
                                <s:param name="act" value="%{updateAction}" />
                            </s:url> <s:a href="%{UpdateCodeTableHeaderURL}">Update</s:a></td>


                    </tr>

                </tbody>
            </s:iterator>
        </table>
    </s:form>

</body>
</html>