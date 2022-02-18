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
<title>Editing <c:out value="${dojo.name}"/></title>
</head>
<body>
	<div class="editCont">
		<h1>Editing <c:out value="${dojo.name}"/></h1>
		<form:form action="/dojos/${dojo.id}" method="post" modelAttribute="dojo" class="dojoForm">
			<input type="hidden" name="_method" value="put">
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
		<div class="editDelete">
			<form action="/dojos/<c:out value="${dojo.id}"/>" method="post">
		    	<input type="hidden" name="_method" value="delete">
		    	<input type="submit" value="Delete" class="deleteButton">
			</form>
		</div>
	</div>
	<p class="back">
		<a href="/dojos">Back to Dojos</a>
	</p>
</body>
</html>