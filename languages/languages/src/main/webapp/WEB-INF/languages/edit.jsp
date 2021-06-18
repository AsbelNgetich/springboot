<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
 
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
 <div class="edit_header">
        
       <a href="/languages">Delete</a> <a href="/languages">Dashboard</a>
 </div>
    
    <form:form class="edit_language" action="/languages/${language.id}" modelAttribute="language" method="PUT">
        <input type="hidden" name="_method" value="put">
        <form:label path="name">Name:</form:label>
        <form:input path="name" value="${language.name}" />
        <form:label path="creator">Creator:</form:label>
        <form:input path="creator" value="${language.creator}" />
        <form:label path="currentVersion">Version:</form:label>
        <form:input path="currentVersion" value="${language.currentVersion}"/>
        <div >
             <input id="submit_btn" type="submit" value="Update">
             
        </div>

    </form:form>
    


</body>
</html>