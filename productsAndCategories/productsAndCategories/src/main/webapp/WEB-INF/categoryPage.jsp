<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Category Page</title>

</head>
<body>
<h1 style="margin-bottom: 30px;">${category.name}</h1>
<h3>Products:</h3>
<div class="main_page">

	<div class="left">
		<ul>
			<c:forEach var="product" items="${productsInCat}">
				<li>${product.name}</li>
			</c:forEach>
			
		</ul>
	</div>
	<div class="right">
	
	<form action="/addProductToCat" method="post">
	<input type="hidden" name="categoryId" value="${category.id}"/>
	   <label>Add Product:</label>
	   <select name="productId">
	        <c:forEach items="${allProducts}" var="product">
	            <option value="${product.id}">${product.name}</option>
	        </c:forEach>
	   </select>
	   <input type="submit" value="Add"/>
	   
	</form>
	</div>
</div>
</body>
</html>