<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form th:th:action="/add" method="post">

    <div><label>Id: <input type="text" name="id"/> </label></div>
    <div><label>Mark: <input type="text" name="mark"/> </label></div>
    <div><label>Numberplate: <input type="text" name="numberplate"/> </label></div>
    <div><label>Release Date: <input type="text" name="releaseDate"/> </label></div>
    <div><label>Owner: <input type="text" name="owner"/> </label></div>
    <div><input type="submit" value="Submit"/></div>

</form>
</body>
</html>
