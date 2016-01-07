<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



    <s:form action="/ITOS/SearchPersonSubmit" method="POST">
        <table>

            <tr>
                <td>First Name</td>
                <td><s:textfield type="text" name="personSearchDetails.personSearchCriteria.firstName" /></td>
            </tr>
            <tr>
                <td>Middle Name</td>
                <td><s:textfield type="text" name="personSearchDetails.personSearchCriteria.middleName" /></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><s:textfield type="text" name="personSearchDetails.personSearchCriteria.lastName" /></td>
            </tr>
            <!--  <tr>
				<td>Date of Birth:</td>
				<td><input type="text" name="dateOfBirth"></td>
			</tr>-->



            <tr>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
        <br>
        <!--</s:form>-->
        <!--<s:form action="/ITOS/SearchPerson" method="POST">-->

        <table border=1>
            <thead>

                <tr>
                    <th>Title</th>
                    <th>First Name</th>
                    <th>Middle Name</th>
                    <th>Last Name</th>
                    <th>Gender</th>
                    <th>Date Of Birth</th>
                </tr>
            </thead>

            <s:iterator value="personSearchResult.personDetailList" status="stat">

                <tbody>
                    <tr>
                        <td><s:property value="title" /></td>
                        <td><s:property value="firstName" /></td>
                        <td><s:property value="middleName" /></td>
                        <td><s:property value="lastName" /></td>
                        <td><s:property value="gender" /></td>
                        <td><s:property value="dateOfBirth" /></td>
                    </tr>
                </tbody>
            </s:iterator>


        </table>
    </s:form>
</body>
</html>