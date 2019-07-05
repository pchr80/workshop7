<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Status</title>
</head>
<body>
<%@include file="../add/header.jsp"%>
<c:if test="${login == 'admin'}">
    <%@include file="../admin/header.jsp"%>
</c:if>
<h2>Status</h2><hr />
<c:forEach items="${stats}" var="stat">
    ID: ${stat.id}<br/>
    Nazwa: ${stat.name}<br />
    Kolejność sortowania: ${stat.sortOrder}<br />
    Aktywny: ${stat.active}<br />
    <br />
    <a href="<c:url value='/status/form?id=${stat.id}'></c:url>">Edycja</a><br/>
    <a href="<c:url value='/status/confirmDelete?id=${stat.id}'></c:url>">Usuń</a><br/>
    <hr />
</c:forEach>
</body>