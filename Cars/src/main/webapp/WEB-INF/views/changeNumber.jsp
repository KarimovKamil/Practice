<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change numberplate</title>
</head>
<body>
<form th:action="/changeOwner" method="post">
    <div><label>Id: <input type="int" name="id"/> </label></div>
    <div><label>New numberplate: <input type="text" name="numberplate"/> </label></div>
    <div><input type="submit" value="Submit"/></div>
</form>
</body>
</html>