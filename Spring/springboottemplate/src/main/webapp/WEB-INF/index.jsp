<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>First JSP</title>
</head>
<body>
    <h1>Hello World!</h1>
    <c:out value="${2+2}"/>
	<h1>Fruit of the Day</h1>
	<h2>
		<c:out value="${fruit}"/>
	</h2>
</body>
</head>
