<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Edit Expense</title>
</head>
<body>
	<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense" class="expenseForm">
		<input type="hidden" name="_method" value="put">
  		<h1>Add an Expense:</h1>
		<p>
	        <form:label path="name">Expense Name:</form:label>
	        <form:errors path="name" class="error" />
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="vendor">Vendor:</form:label>
	        <form:errors path="vendor" class="error" />
	        <form:input path="vendor"/>
	    </p>
	    <p>
	        <form:label path="amount">Amount:</form:label>
	        <form:errors path="amount" class="error" />
	        <form:input type="number" path="amount"/>
	    </p>
	    <p>
	        <form:label path="description">Description:</form:label>
	        <form:errors path="description" class="error" />     
	        <form:textarea path="description"/>
	    </p>    
	    <input type="submit" value="Submit"/>
	</form:form>
	<a href="/expenses">Back</a>
</body>
</html>