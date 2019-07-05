<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Projekty</title>
</head>
<body>
<%@include file="../add/header.jsp"%>
<c:if test="${admin == 'true'}">
    <%@include file="../admin/header.jsp"%>
</c:if>
<h2>Projekty</h2><hr/>
<c:forEach items="${projects}" var="project">
    ID: ${project.id}<br/>
    Nazwa: ${project.name}<br />
    Identyfikator: ${project.identifier}<br/>
    Data utworzenia: <fmt:formatDate value="${project.dateCreated}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/><br />
    <a href="<c:url value='/task/all?projectId=${project.id}'></c:url>">Zadania</a><br/>
    <a href="<c:url value='/task/form?projectId=${project.id}'></c:url>">Dodaj zadanie</a><br/>
    <a href="<c:url value='/project/project?id=${project.id}'></c:url>">Szczegóły</a><br/>
    <a href="<c:url value='/project/form?id=${project.id}'></c:url>">Edycja</a><br/>
    <hr />
</c:forEach>
<%@include file="../add/footer.jsp"%>
</body>