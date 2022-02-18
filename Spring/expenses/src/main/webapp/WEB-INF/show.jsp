<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Rendering Expenses</title>
</head>
<body>
	<c:choose>
		<c:when test="${expense != null}">
		<h1>Expense Details: </h1>
	    	<h4>Expense Name: <c:out value="${expense.name}"/></h4>
			<h4>Expense Description: <c:out value="${expense.description}"/></h4>
			<h4>Vendor: <c:out value="${expense.vendor}"/></h4>
			<h4>Amount Spent: $<c:out value="${expense.amount}"/></h4>
	  	</c:when>
	  	<c:otherwise>
	    	<h4>No expense found by that ID.</h4>
	  	</c:otherwise>
  	</c:choose>
  	<a href="/expenses">Back</a>
</body>
</html>