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
<title>Ninja details: <c:out value="${ninja.firstName} ${ninja.lastName}"/></title>
</head>
<body>
	<div class="showCont">
		<h1>
			<c:out value="${ninja.firstName} ${ninja.lastName}"/>
		</h1>
		<h4>
			Age: <c:out value="${ninja.age}"/>
		</h4>
		<h4>
			Dojo: <a href="/dojos/<c:out value="${ninja.dojo.id}"/>">
		    	  	    <c:out value="${ninja.dojo.name}"/>
		    	  </a>
		</h4>
		<div class="showAction">
			<a href="/ninjas/<c:out value="${ninja.id}"/>/edit">Edit</a>
			<form action="/ninjas/<c:out value="${ninja.id}"/>" method="post">
		    	<input type="hidden" name="_method" value="delete">
		    	<input type="submit" value="Delete" class="deleteButton">
			</form>
		</div>
	</div>
	<p class="back">
		<a href="/ninjas">Back to Ninjas</a>
	</p>
</body>
</html>