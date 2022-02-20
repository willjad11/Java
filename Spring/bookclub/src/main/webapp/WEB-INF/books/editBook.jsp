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
<title>Editing <c:out value="${book.title}"/></title>
</head>
<body>
	<div class="header">
		<div class="headerLeft">
			<h1>Change your Entry</h1>
		</div>
		<div class="headerRight">
			<a href="/books">back to the shelves</a>
		</div>
	</div>
	<div class="createCont">
		<form:form action="/books/${book.id}" method="post" modelAttribute="book" class="bookForm">
			<input type="hidden" name="_method" value="put">
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
		    <form:hidden path="borrower" value="${book.borrower.id}" />
		    <input type="submit" value="Submit" class="submit" />
		</form:form>
	</div>
</body>
</html>