<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome ${name}.</h1>
    </div>


    <form method="post" action="/login">

        <input type="submit" value="CloseSession" name="close"/>

    </form>

</body>
</html>
