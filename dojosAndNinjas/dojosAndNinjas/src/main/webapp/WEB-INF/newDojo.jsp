<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body>
<h1>New Dojo</h1>
<%@ page isErrorPage="true" %> 

<form:form action="/dojo" method = "post" modelAttribute = "newDojo">
  <div class="form-group">
    <form:label path="name">Name: </form:label>
    <form:input path="name" class="form-control" /> 
    <form:errors path="name" />
    <input type="submit" value="Create"/>
  </div>
</form:form>



</body>
</html>