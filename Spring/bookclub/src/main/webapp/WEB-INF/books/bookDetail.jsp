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
<title><c:out value="${book.title}"/></title>
</head>
<body>
	<div class="header">
		<div class="headerLeft">
			<h1><c:out value="${book.title}"/></h1>
		</div>
		<div class="headerRight">
			<a href="/books">back to the shelves</a>
		</div>
	</div>
	<div class="bookDetail">
		<c:choose>
			<c:when test="${book.user.id == userId}">
				<h2>
					<span class="bookDetailUsername">You</span> read <span class="bookDetailTitle"><c:out value="${book.title}"/></span> by <span class="bookDetailAuthor"><c:out value="${book.bookAuthor}"/></span>
				</h2>
				<h2>Here are your thoughts: </h2>
		  	</c:when>
		  	<c:otherwise>
		  		<h2>
		  			<span class="bookDetailUsername"><c:out value="${book.user.userName}"/></span> read <span class="bookDetailTitle"><c:out value="${book.title}"/></span> by <span class="bookDetailAuthor"><c:out value="${book.bookAuthor}"/></span>
		  		</h2>
		  		<h2>Here are <c:out value="${book.user.userName}"/>'s thoughts: </h2>
		  	</c:otherwise>
	  	</c:choose>
	  	<hr>
	  	<c:out value="${book.thoughts}"/>
	  	<hr>
	  	<c:choose>
			<c:when test="${book.user.id == userId}">
				<div class="bookActions">
					<a href="/books/${book.id}/edit">Edit</a>
					<form action="/books/<c:out value="${book.id}"/>" method="post">
			    		<input type="hidden" name="_method" value="delete">
			    		<input type="submit" value="Delete" class="deleteButton">
					</form>
				</div>
			</c:when>
		</c:choose>
	</div>
</body>
</html>