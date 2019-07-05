<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Użytkownicy</title>
</head>
<body>
<%@include file="../add/header.jsp"%>
<c:if test="${login == \"admin\"}">
    <%@include file="../admin/header.jsp"%>
</c:if>
<h2>Użytkownicy</h2><hr />
<c:forEach items="${users}" var="user">
    ID: ${user.id}<br/>
    Imię: ${user.firstName}<br />
    Nazwisko: ${user.lastName}<br />
    Login: ${user.login}<br /><br />
    <a href="<c:url value='/user/confirmDelete?id=${user.id}'></c:url>">Usuń</a><br/>
    <hr />
</c:forEach>
</body>
</html>