<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Zadanie</title>
</head>
<body>
<%@include file="../add/header.jsp"%>
<c:if test="${admin == 'true'}">
    <%@include file="../admin/header.jsp"%>
</c:if>
<h2>Zadanie</h2>
<form:form modelAttribute="task" method="POST">
    <form:hidden path="id"/>
    Temat: <form:input path="subject" /><br />
    <form:errors path="subject" element="div" />
    Opis: <form:input path="description" /><br />
    <form:errors path="description" element="div" />
    Status: <form:select items="${stats}" path="status.id" itemValue="id" itemLabel="name"/><br />
    <form:errors path="status" element="div" />
    Priorytet: <form:select items="${priors}" path="priority.id" itemValue="id" itemLabel="name"/><br />
    <form:errors path="priority" element="div" />
    Użytkownik: <form:select items="${users}" path="user.id" itemValue="id" itemLabel="login"/><br />  <!-- itemValue="id" itemLabel="fullName" multiple="true"-->
    <form:errors path="user" element="div" />
    Projekt: <form:select items="${projects}" path="project.id" itemValue="id" itemLabel="name"/><br />
    <form:errors path="project" element="div" />
    <br />
    <input type="submit" value="Zapisz"></input>
</form:form>
<%@include file="../add/footer.jsp"%>
</body>
</html>