<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Priorytet</title>
</head>
<body>
<%@include file="../add/header.jsp"%>
<c:if test="${login == 'admin'}">
    <%@include file="../admin/header.jsp"%>
</c:if>
<h2>Priorytet</h2>
<form:form modelAttribute="priority" method="POST">
    <form:hidden path="id"/>
    Nazwa: <form:input path="name" /><br />
    <form:errors path="name" element="div" /><br />
    Aktywny: <form:checkbox path="active"/><br /><br />
    <input type="submit" value="Submit"></input>
</form:form>
<%@include file="../add/footer.jsp"%>
</body>
</html>