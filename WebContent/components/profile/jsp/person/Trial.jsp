<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</head>
<body>
<h1 class="well">Registration Form</h1>
    <div class="container" style="border: thin solid black">
         <br>
            <h2>Person Detail</h2>
            <br>
        <s:form class="form-inline" name="Registration" action="/ITOS/CreateTrailPersonSubmit" method="POST" role="form" theme="bootstrap" validate="true">
            <div class="form-group">

                <label>Name:</label>
                <s:select list="#{'Mr.':'Mr.', 'Mrs.':'Mrs.','Miss.':'Miss.', 'Kumar':'Kumar'}"
                    name="personDetail.title" placeholder="Title" class="form-control">
                </s:select> 
                <!-- <input type="email" class="form-control" id="email" placeholder="Enter email">-->
            </div>
            
            <div class="form-group">
            <s:textfield type="text" name="personDetail.firstName"  placeholder="FirstName" class="form-control" />
            </div>
            <br>
            <br>
            <s:submit type="submit" id="submit" value="Submit" class="btn btn-primary"/>
            <div class="checkbox">
                <label><input type="checkbox"> Remember me</label>
            </div>
    </s:form>
    </div>
</body>
</html>