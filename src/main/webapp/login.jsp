<%--
  Created by IntelliJ IDEA.
  User: robertolago
  Date: 5/31/18
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  include file="/partials/navbar.jsp" %>

<%
    if ("POST".equalsIgnoreCase(request.getMethod()) ) {
        String user = request.getParameter("usernamef");
        String password = request.getParameter("passwordf");
        if (user.equals("admin") && password.equals("password")) {
            response.sendRedirect("profile.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="profile.jsp" method="post">
    UserName:<input type="text" name="usernamef"><br>
    Password:<input type="text" name="passwordf"><br>
    <input type="submit" value="loginuser">
</form>
</body>
</html>
