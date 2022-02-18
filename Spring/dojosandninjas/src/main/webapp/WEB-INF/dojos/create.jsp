<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Create a Dojo</title>
</head>
<body>
	<div class="createCont">
		<h1>Create a dojo</h1>
		<form:form action="/dojos/create" method="post" modelAttribute="dojo" class="dojoForm">
			<p class="form">
		        <form:label path="name">Name:</form:label>
		        <form:errors path="name" class="error" />
		        <form:input path="name"/>
		    </p>
		    <p class="form">
		        <form:label path="location">Location:</form:label>
		        <form:errors path="location" class="error" />
		        <form:input path="location"/>
		    </p>
		    <input type="submit" value="Submit"/>
		</form:form>
	</div>
	<p class="back">
		<a href="/dojos">Back to Dojos</a>
	</p>
</body>
</html>