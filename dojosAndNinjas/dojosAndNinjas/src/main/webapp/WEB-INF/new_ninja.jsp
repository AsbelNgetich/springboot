<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
 <h2>New Ninja</h2>  
 <%@ page isErrorPage="true" %> 
    <form:form class="add_ninja" action="/ninja" method="POST" modelAttribute="newNinja">
        <form:label path="dojo">Dojo:</form:label>
        <form:select path="dojo">
        	<c:forEach items="${dojos}" var="dojo">
            <option value="${dojo.id}">${dojo.name}</option>
    		</c:forEach>
        </form:select> <br>
        <form:label path="firstName">First Name:</form:label>
        <form:input path="firstName"/> <br>
        <form:errors path="firstName" />
        <form:label path="lastName">Last Name:</form:label>
        <form:input path="lastName"/><br>
        <form:errors path="lastName" />
        <form:label path="age">Age:</form:label>
        <form:input path="age"/><br>
        <form:errors path="age" />
        <input id="submit_btn" type="submit" value="Create">
    </form:form>
    <a href="/dojos">Home</a>

</body>
</html>