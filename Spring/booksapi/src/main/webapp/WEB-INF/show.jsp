<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Rendering Books</title>
</head>
<body>
	<c:choose>
		<c:when test="${book != null}">
	    	<h1><c:out value="${book.title}"/></h1>
			<h4>Description: <c:out value="${book.description}"/></h4>
			<h4>Language: <c:out value="${book.language}"/></h4>
			<h4>Number of Pages: <c:out value="${book.numberOfPages}"/></h4>
	  	</c:when>
	  	<c:otherwise>
	    	<h4>No book found by that ID.</h4>
	  	</c:otherwise>
  	</c:choose>
  	<a href="/books">Back</a>
</body>
</html>