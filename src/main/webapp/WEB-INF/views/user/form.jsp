<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Użytkownik</title>
</head>
<body>
<%@include file="../add/header.jsp"%>
<h2>Użytkownik</h2>
<form:form modelAttribute="user" method="POST">
    <!--  <form:hidden path="id" />  -->
    Login: <form:input path="login" /><br/>
    <form:errors path="login" element="div" />
    Imię: <form:input path="firstName" /><br/>
    <form:errors path="firstName" element="div" />
    Nazwisko: <form:input path="lastName" /><br/>
    <form:errors path="lastName" element="div" />
    <form:hidden path="password"/>
    <input type="submit" value="Submitgit add ."></input><br/><br/>
    <a href="<c:url value='/user/all'></c:url>">Powrót</a>
</form:form>
<%@include file="../add/footer.jsp"%>
</body>
</html>