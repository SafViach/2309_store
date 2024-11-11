<%@ page import="static by.itclass.constants.AppConst.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="form-box">
        <h2>Login</h2>
        <form method="post" name="<%=LOGIN_CONTROLLER%>">
            <input type="text" name="<%=LOGIN_PARAM%>" placeholder="Login" required>
            <input type="password" name="<%=PASS_PARAM%>" placeholder="Password" required>
            <input type="submit" value="Login">
        </form>
        <c:if test="${not empty message}">
            <h2 class="error">${message}</h2>
        </c:if>
    </div>
</body>
</html>