<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Zadania</title>
</head>
<body>
<%@include file="../add/header.jsp"%>
<c:if test="${admin == 'true'}">
    <%@include file="../admin/header.jsp"%>
</c:if>
<h2>Zadania</h2><hr />
<c:forEach items="${tasks}" var="task">
    ID: ${task.id}<br/>
    ID projektu: ${task.project.id}<br/>
    Temat: ${task.subject}<br />
    Opis: ${task.description}<br />
    Użytkownik: ${task.user.login}<br />
    Status: ${task.status.name}<br />
    Priorytet: ${task.priority.name}<br />
    <a href="<c:url value='/task/form?id=${task.id}'></c:url>">Edycja</a><br/>
    <a href="<c:url value='/task/confirmDelete?id=${task.id}'></c:url>">Usuń</a><br/>
    <hr />
</c:forEach>
</body>
</html>