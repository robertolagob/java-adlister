<%--
  Created by IntelliJ IDEA.
  User: robertolago
  Date: 6/4/18
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <table>
        <c:forEach var="ad" items="${ads}" >
        <tr>
            <td>${ad.title}</td>
            <td>${ad.description}</td>
        </tr>
        </c:forEach>
        </table>
    </div>
</body>
</html>
