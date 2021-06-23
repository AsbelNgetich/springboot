<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>
</head>
<body>
<h1>New Category</h1>
<%@ page isErrorPage="true" %> 

<form:form action="/categories" method="post" modelAttribute="newCategory">
	<label style="margin-bottom: 10px;">Name</label>
	<form:input path="name" class="form-control" /> <br>
	<form:errors path="name" class="text-danger" />
	<input type="submit" value="Create"/>
</form:form>


</body>
</html>