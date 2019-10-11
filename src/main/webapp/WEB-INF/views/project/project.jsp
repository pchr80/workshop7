<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Projekt</title>
</head>
<body>
<%@include file="../add/header.jsp"%>
<c:if test="${admin == 'true'}">
    <%@include file="../admin/header.jsp"%>
</c:if>
<h2>Projekt</h2><hr/>
    ID: ${project.id}<br/>
    Nazwa: ${project.name}<br />
    Identyfikator: ${project.identifier}<br />
    Opis: ${project.description}<br />
    Data utworzenia: <fmt:formatDate value="${project.dateCreated}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/><br />
    Url: ${project.url}<br />
    Projekt aktywny: ${project.active}<br />
    Użytkownicy: ${project.users}<br /><br />
    <a href="<c:url value='/project/form?id=${project.id}'></c:url>">Edycja</a><br />
    <a href="<c:url value='/project/all'></c:url>">Powrót</a>
    <hr />
<%@include file="../add/footer.jsp"%>
</body>