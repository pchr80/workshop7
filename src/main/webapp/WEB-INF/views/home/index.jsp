<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            font-size: medium;
        }
    </style>
</head>
<body>
<%@include file="../add/header.jsp"%>

<h2>Projekty</h2>
<table>
    <thead>
    <td style="width: 30px">Id</td>
    <td style="width: 200px">Nazwa</td>
    <td style="width: 260px">Opis</td>
    <td style="width: 200px">Uż. (login)</td>
    <td style="width: 200px">Projekt aktywny</td>
    <td style="width: 250px">Data utworzenia</td>
    </thead>
    <c:forEach items="${projects}" var="project">
        <tr>
            <td>${project.id}</td>
            <td>${project.name}</td>
            <td>${project.description}<br />
            <td>${project.users}</td>
            <td>${project.active}</td>
            <td><fmt:formatDate value="${project.dateCreated}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
    </c:forEach>
</table>

<h2>Aktywności</h2>
<table>
    <thead>
    <td style="width: 30px">Id</td>
    <td style="width: 200px">Typ</td>
    <td style="width: 260px">Użytkownik</td>
    <td style="width: 200px">ID projektu</td>
    <td style="width: 200px">ID zadania</td>
    <td style="width: 250px">Data utworzenia</td>
    </thead>
    <c:forEach items="${activities}" var="act">
        <tr>
            <td>${act.id}</td>
            <c:choose>
            <c:when test="${act.actType==1}">
                <td>Utworzenie projektu</td>
            </c:when>
            <c:when test="${act.actType==2}">
                <td>Dodanie zadania do projektu</td>
            </c:when>
            <c:when test="${act.actType==3}">
                <td>Zmiana statusu na zadaniu</td>
            </c:when>
            </c:choose>
            <td>${act.user.login}<br />
            <td>${act.project.id}</td>
            <td>${act.task.id}</td>
            <td><fmt:formatDate value="${act.actDate}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        </tr>
    </c:forEach>
</table>

<%@include file="../add/footer.jsp"%>
</body>
</html>
