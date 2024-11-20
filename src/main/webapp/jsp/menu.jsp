<%@ page import="static by.itclass.constants.AppConst.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="nav-ul">
    <c:choose>
        <c:when test="${empty user}"> <%--возьмем user из сессии--%>
            <li class="nav-li">
                <a href="<%=LOGIN_JSP%>">login</a></li>
            <li class="nav-li">
                <a href="<%=REG_JSP%>">Registration</a></li>
        </c:when>
        <c:otherwise>
            <li class="nav-li float-left">
                <a class="active" href="<%=HOME_JSP%>">Home</a></li>
            <li class="nav-li">
                <a href="<%=LOGOUT_CONTROLLER%>">Logout</a></li>
            <li class="nav-li">
                <a href="<%=SET_PASS_JSP%>">Change Password</a></li>
            <li class="nav-li float-left">
                <a href="<%=TV_CONTROLLER%>">TV</a></li>
        </c:otherwise>
    </c:choose>
</ul>
