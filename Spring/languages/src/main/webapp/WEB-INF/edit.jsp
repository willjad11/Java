<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Edit Language</title>
</head>
<body>
	<div class="buttons">
		<a href="/languages">Dashboard</a>
		<form action="/languages/<c:out value="${language.id}"/>" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
	</div>
	<form:form action="/languages/${language.id}" method="post" modelAttribute="language" class="languageForm">
		<input type="hidden" name="_method" value="put">
		<p>
	        <form:label path="name">Name:</form:label>
	        <form:errors path="name" class="error" />
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Creator:</form:label>
	        <form:errors path="creator" class="error" />
	        <form:input path="creator"/>
	    </p>
	    <p>
	        <form:label path="version">Version:</form:label>
	        <form:errors path="version" class="error" />
	        <form:input path="version"/>
	    </p>  
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>