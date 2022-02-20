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
<title>Create a Book</title>
</head>
<body>
	<div class="header">
		<div class="headerLeft">
			<h1>Add a Book to Your Shelf!</h1>
		</div>
		<div class="headerRight">
			<a href="/books">back to the shelves</a>
		</div>
	</div>
	<div class="createCont">
		<form:form action="/books/create" method="post" modelAttribute="book" class="bookForm">
			<form:errors path="title" class="error" />
			<p>
		        <form:label path="title">Title:</form:label>
		        <form:input path="title" class="bookInput" />
		    </p>
		    <form:errors path="bookAuthor" class="error" />
		    <p>
		        <form:label path="bookAuthor">Author:</form:label>
		        <form:input path="bookAuthor" class="bookInput" />
		    </p>
		    <form:errors path="thoughts" class="error" />
		    <p>
		        <form:label path="thoughts">My Thoughts:</form:label>
		        <form:textarea path="thoughts" class="bookInput" />
		    </p>
		    <form:hidden path="user" value="${userId}" />
		    <input type="submit" value="Submit" class="submit" />
		</form:form>
	</div>
</body>
</html>