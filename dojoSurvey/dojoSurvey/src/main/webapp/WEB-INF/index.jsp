<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
   <div class="container">
        <form method="POST" action="/result" >
            <div class="info">
               <label for="name">Your name: </label>
               <input type="text" name="name" id="">
            </div>
            <div class="info">
                <label for="location">Dojo Location:</label>
                <select name="location">
                    <option value="SanJose">San Jose</option>
                    <option value="Chicago">Chicago</option>
                    <option value="Seattle">Seattle</option>
                </select>
            </div>
            <div class="info">
                <label for="language">Favorite Language:</label>
                <select name="language">
                    <option value="JavaScript">JavaScript</option>
                    <option value="C#">C#</option>
                    <option value="Java">Java</option>
                    <option value="C++">C++</option>
                    <option value="Python">Python</option>
                </select>
            </div>
            <div class="comments_section">
                <label for="textarea">Comment (optional) </label>
                <textarea id="comments" name="comments"></textarea>
            </div>
            <div id="submit_button">
                <input type="submit" value="Button">
            </div>

        </form>
    </div>


</body>
</html>