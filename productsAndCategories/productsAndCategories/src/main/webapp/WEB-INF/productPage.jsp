<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
<h1 style="margin-bottom: 30px;">${product.name}</h1>
<h3>Categories:</h3>
<div class="main_page">

	<div class="left">
		<ul>
			<c:forEach var="category" items="${catInProducts}">
				<li>${category.name}</li>
			</c:forEach>
			
		</ul>
	</div>
	<div class="right">
	
	<form action="/addCatToProd" method="post">
	<input type="hidden" name="productId" value="${product.id}"/>
	   <label>Add Category:</label>
	   <select name="categoryId">
	        <c:forEach items="${allCategories}" var="category">
	            <option value="${category.id}">${category.name}</option>
	        </c:forEach>
	   </select>
	   <input type="submit" value="Add"/>
	   
	</form>
	</div>
</div>
</body>

</body>
</html>