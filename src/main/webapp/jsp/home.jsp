<%@ page import="static by.itclass.constants.AppConst.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>

    <jsp:include page="<%=MENU_JSP%>"></jsp:include>
    <jsp:include page="/jsp/slider/slider.html"></jsp:include>
    <script src="/js/script.js"></script>

</body>
</html>
