<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	
    <h1 >${dojo.name} Location Ninjas</h1>
   	 		
   	<table class="show_ninjas_table">
		<thead>
			<tr>
				<th>First Name</th>
			    <th>Last Name</th>
			    <th>Age</th>
			</tr>
	    </thead>
		<tbody>
		<c:forEach var="ninja" items="${ninjas}">
			 <tr>
			 	<td>${ninja.firstName}</td>
			    <td>${ninja.lastName}</td>
			    <td>${ninja.age}</td>
			 </tr>
		</c:forEach>
		</tbody>
	</table>		    	
	<a href="/">Home</a>				
</body>
</html>