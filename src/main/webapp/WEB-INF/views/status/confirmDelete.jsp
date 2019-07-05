<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuń status</title>
</head>
<body>
	<h5>Czy na pewno chcesz usunąć status o id ${param.id}?</h5>
	<button onClick="javascript:location.href='delete?id=${param.id}'">OK</button>
	<button onClick="javascript:location.href='all'">Cancel</button>
</body>
</html>