<%@ page import="static by.itclass.constants.AppConst.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/css/styles.css">
    <title>Orders</title>
</head>
<body>
    <h2>Hello ${user.name}</h2>
    <jsp:include page="<%=MENU_JSP%>"/>
    <c:choose>
        <c:when test="${not empty orders}">
            <h2>Yours orders:</h2>
            <c:forEach var="order" items="${orders}">
                <div class="order-list-container">
                    <h3>${order.date} , number: ${order.id} , address: ${order.address}</h3>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>Ypu have no orders</p>
        </c:otherwise>
    </c:choose>

</body>
</html>
