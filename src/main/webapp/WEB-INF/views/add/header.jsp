<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 02.07.2019
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <c:choose>
        <c:when test="${empty login}">
            <span style="font-size: large">Witaj</span>
            <button style="float:right"
                    onClick="javascript:document.location.href='/login/register'">Register
            </button>
            <button style="float:right"
                    onClick="javascript:document.location.href='/login/login'">Login
            </button>
        </c:when>
        <c:otherwise>
        <span style="font-size: large">Witaj, <c:out value="${firstName}"/></span>
            <button style="float:right"
                    onClick="javascript:document.location.href='/login/logout'">Logout
            </button>
        </c:otherwise>
    </c:choose>
    <div style="clear: both">
    <br/>
    <a href="<c:url value='/'></c:url>">Strona główna</a><br/>
    <a href="<c:url value='/adm'></c:url>">Administracja</a><br/>
    <a href="<c:url value='/project/all?admin=false'></c:url>">Projekty</a><br/>
    <a href="<c:url value='/task/all?admin=false'></c:url>">Zadania</a><br/>
    <br/>
    <hr>
</header>
