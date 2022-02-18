<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Language</title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<c:choose>
		<c:when test="${language != null}">
	    	<h4><c:out value="${language.name}"/></h4>
			<h4><c:out value="${language.creator}"/></h4>
			<h4><c:out value="${language.version}"/></h4>
	  	</c:when>
	  	<c:otherwise>
	    	<h4>No language found by that ID.</h4>
	  	</c:otherwise>
  	</c:choose>
  	<a href="/languages/<c:out value="${language.id}"/>/edit">Edit</a>
	<form action="/languages/<c:out value="${language.id}"/>" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
</body>
</html>