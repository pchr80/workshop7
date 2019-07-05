<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form modelAttribute="user" method="POST">
    <form:errors path="password" element="div"/>
    Login: <form:input path="login"/><br/>
           <form:errors path="login" element="div"/>
    Password: <form:password path="password"/><br/>
    <input type="submit" value="Login"/>
</form:form>
</body>
</html>
