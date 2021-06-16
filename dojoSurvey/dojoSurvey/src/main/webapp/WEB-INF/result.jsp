<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

 <div class="container">
        <h1>Submitted info</h1>
        <h3>Name:  <c:out value="${name}"/></h3>
        <h3>Dojo Location:  <c:out value="${location}"/></h3>
        <h3>Favorite Language:  <c:out value="${language}"/></h3>
        <p><span style="font-weight: bold;">Comments:</span> <c:out value="${comments}"/> </p>
        <form action="/">
        <input type="submit" value="Go back">
        </form>
    </div>


</body>
</html>