<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Here's Your Omikuji!</title>
</head>
<body>
	<div class="omikuji">
		<p>In <c:out value="${number}"/> years, you will live in <c:out value="${cityName}"/> with
		<c:out value="${personName}"/> as your roommate, <c:out value="${personalHobby}"/> for a living.
		The next time you see a <c:out value="${livingThing}"/>, you will have good luck. Also, <c:out value="${niceThing}"/></p>
		<hr />
		<a href="/omikuji">Go back?</a>
	</div>
</body>
</html>