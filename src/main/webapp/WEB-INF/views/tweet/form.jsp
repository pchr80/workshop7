<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tweet form</title>
</head>
<body>
<h2>Tweet</h2>
<form:form modelAttribute="tweet" method="POST">
    <form:hidden path="id"/>
    Title: <form:input path="title" /><br />
    <form:errors path="title" element="div" />
    Tweet text: <form:input path="tweetText" /><br />
    <form:errors path="tweetText" element="div" />
    Created: <form:input type = "date"  path="created" /><br />
    <form:errors path="created" element="div" />
    User: <form:select items="${users}" path="user.id" itemValue="id" itemLabel="firstName" /><br /> <!-- itemValue="id" itemLabel="fullName" multiple="true"-->
    <input type="submit" value="Submit"></input>
</form:form>
</body>
</html>