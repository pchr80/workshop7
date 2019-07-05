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
    <h1>Admin</h1>
    <a href="<c:url value='/project/all?admin=true'></c:url>">Projekty</a>&nbsp;&nbsp;
    <a href="<c:url value='/project/form?admin=true'></c:url>">Nowy projekt</a>&nbsp;&nbsp;
    <a href="<c:url value='/user/all'></c:url>">Użytkownicy</a>&nbsp;&nbsp;
    <a href="<c:url value='/user/register'></c:url>">Nowy użytkownik</a>&nbsp;&nbsp;
    <a href="<c:url value='/status/all'></c:url>">Statusy</a>&nbsp;&nbsp;
    <a href="<c:url value='/status/form'></c:url>">Nowy status</a>&nbsp;&nbsp;
    <a href="<c:url value='/priority/all'></c:url>">Priorytety</a>&nbsp;&nbsp;
    <a href="<c:url value='/priority/form'></c:url>">Nowy priorytet</a><br/><hr/>
</header>
