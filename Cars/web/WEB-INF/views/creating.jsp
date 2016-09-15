<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form th:action="/add" method="post">
    <div><label>Mark: <input type="text" name="mark"/> </label></div>
    <div><label>Release date: <input type="text" name="releaseDate"/> </label></div>
    <div><input type="submit" value="Submit"/></div>
</form>
</body>
</html>
