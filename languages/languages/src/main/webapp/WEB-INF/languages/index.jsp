<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Languages</title>
</head>
<body>
<%@ page isErrorPage="true" %> 

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${languages}" var="language">
        <tr>
            <td><c:out value="${language.name}"/></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.currentVersion}"/></td>
            <td><form:form action="/languages/${language.id }" method= "DELETE">
              <input type="hidden" name="_method" value="delete">
   			 <input type="submit" value="delete" />
			</form:form>
			<a href="languages/${language.id}/edit ">edit</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
 <form:form class="add_language" action="/languages" method="post" modelAttribute="language">
        <form:label path="name">Name:</form:label>
        <form:input path="name"/>
        <form:errors path="name" />
        <form:label path="creator">Creator:</form:label>
        <form:input path="creator"/>
        <form:errors path="creator" />
        <form:label path="currentVersion">Version:</form:label>
        <form:input path="currentVersion"/>
        <form:errors path="currentVersion" />
        <input id="submit_btn" type="submit" value="Submit">

    </form:form>
</body>
</html>