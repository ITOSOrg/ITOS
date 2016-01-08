<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('.dateTxt').datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
</script>
</head>
<body>
    <form name="Create KeyServer" action="/ITOS/CreateUserRoleLinkSubmit" method="POST">
        <table>


            <tr>
                <td>User Name :</td>
                <td><s:textfield type="text" name="userRoleLinkDetail.username" /></td>
            </tr>
            <tr>
                <td>End Date</td>
                <td><input type="text" id="datepicker1" class="dateTxt" name="userRoleLinkDetail.endDate" /></td>
            </tr>

            <tr>
                <td>Role :</td>
                <td><s:select list="" name="userRoleLinkDetail.roleID">
                        <option value="9001">Administrator</option>
                        <option value="9002">Employee</option>
                        <option value="9003">Devloper</option>
                    </s:select></td>
            </tr>

            <tr>

                <td><s:submit type="submit" value="Submit" />
            </tr>


        </table>
    </form>
</body>
</html>