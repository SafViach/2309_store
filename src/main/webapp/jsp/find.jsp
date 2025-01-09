<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static by.itclass.constants.AppConst.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="center-find-div">
    <div class="find-div"></div>
    <form action="<%=FIND_CONTROLLER%>">
        <input type="text" name="<%=FIND_PARAM%>" placeholder="Find">
        <input type="submit" value="goFind" placeholder="goFind">
    </form>
</div>
<c:choose>
    <c:when test="${not empty message}">
        <h1 class="error">${message}</h1>
    </c:when>
    <c:otherwise>
        <c:forEach var="find" items="${find}">
            <div class="result-find">
                <h1>Результат поиска: </h1>
                <ul>
                    <li><h1>${find.vendor}:${find.model}</h1></li>
                </ul>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>

