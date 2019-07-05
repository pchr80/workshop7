<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tweet list</title>
</head>
<body>
<h2>Tweets</h2>
<c:forEach items="${tweets}" var="tweet">
    ID: ${tweet.id}<br/>
    Title: ${tweet.title}<br />
    Tweet text: ${tweet.tweetText}<br />
    Created: ${tweet.created}<br />
    <hr />
</c:forEach>
</body>
</html>
