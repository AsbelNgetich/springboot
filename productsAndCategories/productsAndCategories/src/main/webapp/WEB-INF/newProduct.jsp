<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
<h1>New Product</h1>
<%@ page isErrorPage="true" %> 
<form:form action="/products" method="post" modelAttribute="newProduct">
	<label>Name</label>
	<form:input path="name" class="form-control" /> <br>
	<form:errors path="name" class="text-danger" />
	<label>Description</label>
    <form:input path="description" class="form-control" /> <br>
	<form:errors path="description" class="text-danger" />
    <label>Price</label>
    <form:input path="price" class="form-control" /> <br>
	<form:errors path="price" class="text-danger" />
	<input type="submit" value="Create"/>
</form:form>


</body>
</html>