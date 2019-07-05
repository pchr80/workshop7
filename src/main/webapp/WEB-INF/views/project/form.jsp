<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form modelAttribute="project" method="POST">
    <form:hidden path="id"/>
    Nazwa: <form:input path="name" /><br />
    <form:errors path="name" element="div" /><br />
    Opis: <form:textarea cols="60" rows="4" path="description" /><br />
    <form:errors path="description" element="div" /><br />
    Url: <form:input path="url" /><br />
    <form:errors path="url" element="div" /><br />
    Aktywny: <form:checkbox path="active"/><br />
    Użytkownicy: <form:select items="${users}" path="users" itemValue="id" itemLabel="login" multiple="true"/><br />
    <input type="submit" value="Submit"></input>
</form:form>
<%@include file="../add/footer.jsp"%>
</body>
</html>