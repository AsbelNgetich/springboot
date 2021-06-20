<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
 <h2>New Ninja</h2>  
 <%@ page isErrorPage="true" %> 
    <form:form class="add_ninja" action="#" method="POST">
        <form:label path="dojo">Dojo:</form:label>
        <select name='department_id'>
        
            <option value="department['id']">department['name']</option>
            
        </select>
        <form:label path="firstName">First Name:</form:label>
        <form:input path="firstName"/>
        <form:errors path="firstName" />
        <form:label path="lastName">Last Name:</form:label>
        <form:input path="lastName"/>
        <form:errors path="lastName" />
        <form:label path="age">Age:</form:label>
        <form:input path="age"/>
        <form:errors path="age" />
        <input id="submit_btn" type="submit" value="Create">
    </form:form>
    <a href="/dojos">Home</a>

</body>
</html>