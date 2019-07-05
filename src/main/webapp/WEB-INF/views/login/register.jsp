<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form:form modelAttribute="user" method="POST">
    Login: <form:input path="login"/>
           <form:errors path="login" /><br/>
    Password: <form:password path="password"/>
              <form:errors path="password" element="div"/><br/>
    Repeat password: <input type="password" name="password2"/><br/>
    First name: <form:input path="firstName"/>
                <form:errors path="firstName" element="div"/><br/>
    Last name: <form:input path="lastName"/><br/>
               <form:errors path="lastName" element="div"/><br/>
    <input type="submit" value="Register"/>
</form:form>
</body>
</html>
