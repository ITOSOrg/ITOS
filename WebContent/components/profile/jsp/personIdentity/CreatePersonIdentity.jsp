<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
    $(document).ready(function() {
        $("#datepicker").datepicker({
              changeMonth: true,
              changeYear: true
        });
        $('#submit').click(function() {
            alert("Submit ?");
        });
    });
</script>
</head>
<body>


<s:form name="Create Person Identity" action="/ITOS/CreatePersonIdentitySubmit"
		method="POST">
		<table>
		  
			<tr>
				<td>AlternateID :</td>
				<td><s:textfield type="text" name="personIdentityDetail.alternateID"/></td>
			</tr>
			<tr>
            <td><s:select
                list="#{'Primary':'Primary', 'Secondary':'Secondary', 'Persnal':'Persnal', 'Business':'Business'}"
                name="personIdentityDetail.typeCode" label="Type Code">

            </s:select></td>
        </tr>
		
        <tr>
            <td>PrimaryInd :</td>
            <td><s:radio name="personIdentityDetail.primaryInd" list="#{'1':'True','0':'false' }"
                value="1"></s:radio></td>
        </tr>
			<tr>
            <td><sj:datepicker value="" id="datepicker" name="personIdentityDetail.startDate" displayFormat="dd.mm.yy" placeholder="DD/MM/YY"
                label="Start Date:" changeMonth="true" changeYear="true" /></td>
        </tr>
        <tr>
            <td><sj:datepicker value="" id="datepicker" name="personIdentityDetail.endDate" displayFormat="dd.mm.yy" placeholder="DD/MM/YY"
                label="End Date:" changeMonth="true" changeYear="true" /></td>
        </tr>
			<tr>

				<td><s:submit  type="submit" value="Submit"/>
                <s:hidden name="personIdentityDetail.personID" value="%{#parameters['personIdentityDetail.personID']}"/>

			</tr>
			
		
		</table>
    <!--     <s:hidden name="PersonIdentityDetail.personID"></s:hidden> --> 
		</s:form>

</body>
</html>