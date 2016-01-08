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

    
    
    $(function(){$('.dateTxt').datepicker({
          changeMonth: true,
          changeYear: true
    }); });
</script>
</head>
<body>


<s:form name="Create Person Identity" action="/ITOS/CreatePersonIdentitySubmit"
		method="POST">
		<table>
		  
			<tr>
				<td>AlternateID </td>
				<td><s:textfield type="text" name="personIdentityDetail.alternateID"/></td>
			</tr>
			<tr>
            <td><s:select
                list="#{'Primary':'Primary', 'Secondary':'Secondary', 'Persnal':'Persnal', 'Business':'Business'}"
                name="personIdentityDetail.typeCode" label="Type Code">

            </s:select></td>
        </tr>
		
        <tr>
            <td>PrimaryInd </td>
            <td><s:radio name="personIdentityDetail.primaryInd" list="#{'1':'True','0':'false' }"
                value="1"></s:radio></td>
        </tr>
			<tr>
            <td>Start Date</td>
            <td>
            <input type="text" id="datepicker1" class="dateTxt" name="personIdentityDetail.startDate"  />
            </td>
       </tr>
        <tr>
            <td>End Date</td>
            <td>
            <input type="text" id="datepicker2" class="dateTxt" name="personIdentityDetail.endDate"  />
            </td>
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