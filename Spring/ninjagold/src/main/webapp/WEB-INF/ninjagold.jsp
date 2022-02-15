<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Ninja Gold</title>
</head>
<body>
	<div class="maincont">
		<div class="yourgold">
			<p>Your gold: <c:out value="${gold}"/></p>
		</div>
		<div class="box">
			<h1>Farm</h1>
			<h4>(Earn 10-20 gold)</h4>
			<form class="form" action='/process' method='post'>
				<input type="hidden" name="farm" value="true">
				<input class="submit" type="submit" value="Find Gold!">
			</form>
		</div>
		<div class="box">
			<h1>Cave</h1>
			<h4>(Earn 5-10 gold)</h4>
			<form class="form" action='/process' method='post'>
				<input type="hidden" name="cave" value="true">
				<input class="submit" type="submit" value="Find Gold!">
			</form>
		</div>
		<div class="box">
			<h1>House</h1>
			<h4>(Earn 2-5 gold)</h4>
			<form class="form" action='/process' method='post'>
				<input type="hidden" name="house" value="true">
				<input class="submit" type="submit" value="Find Gold!">
			</form>
		</div>
		<div class="box">
			<h1>Casino</h1>
			<h4>(Earn/Take 0-50 gold)</h4>
			<form class="form" action='/process' method='post'>
				<input type="hidden" name="casino" value="true">
				<input class="submit" type="submit" value="Find Gold!">
			</form>
		</div>
		<h1 class="activities">Activities: </h1>
		<div class="log">
			<c:forEach var="message" items="${messages}">
    			<c:out value="${message}"/><br>
    		</c:forEach>
		</div>
	</div>
</body>
</html>