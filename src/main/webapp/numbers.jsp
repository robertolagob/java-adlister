<%--
  Created by IntelliJ IDEA.
  User: robertolago
  Date: 6/2/18
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Enter two numbers</h1>
<form action="/numbers" method="post">
    Number X:<input type="number" name="x"><br>
    Number Y:<input type="number" name="y"><br>
    <input type="submit" value="Add" name="calculus">
    <input type="submit" value="multiply" name="calculus">
</form>
</body>
</html>
