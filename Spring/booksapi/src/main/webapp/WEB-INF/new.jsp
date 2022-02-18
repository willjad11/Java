<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>New Book</title>
</head>
<body>
	<form:form action="/books/create" method="post" modelAttribute="book" class="bookForm">
  		<h1>New Book</h1>
		<p>
	        <form:label path="title">Title</form:label>
	        <form:errors path="title" class="error" />
	        <form:input path="title"/>
	    </p>
	    <p>
	        <form:label path="description">Description</form:label>
	        <form:errors path="description" class="error" />
	        <form:textarea path="description"/>
	    </p>
	    <p>
	        <form:label path="language">Language</form:label>
	        <form:errors path="language" class="error" />
	        <form:input path="language"/>
	    </p>
	    <p>
	        <form:label path="numberOfPages">Pages</form:label>
	        <form:errors path="numberOfPages" class="error" />     
	        <form:input type="number" path="numberOfPages"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form>
	<a href="/books">Go back</a>
</body>
</html>