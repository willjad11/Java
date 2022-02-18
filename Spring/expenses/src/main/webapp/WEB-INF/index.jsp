<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Expenses</title>
</head>
<body>
	<c:choose>
		<c:when test="${expenseList != null}">
			<table>
				<tr>
				    <th>Expense</th>
				    <th>Vendor</th>
				    <th>Amount</th>
				    <th>Actions</th>
				</tr>
				<c:forEach var="expense" items="${expenseList}">
					<tr>
		    			<td><a href="/expenses/<c:out value="${expense.id}"/>"><c:out value="${expense.name}"/></a></td>
		    			<td><c:out value="${expense.vendor}"/></td>
		    			<td>$<c:out value="${expense.amount}"/></td>
		    			<td class="actions">
		    				<a href="/expenses/<c:out value="${expense.id}"/>/edit">Edit</a>
		    				<form action="/expenses/<c:out value="${expense.id}"/>" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete">
							</form>
		    			</td>
		  			</tr>
    			</c:forEach>
			</table>
	  	</c:when>
	  	<c:otherwise>
	    	<h4>No expenses in database.</h4>
	  	</c:otherwise>
  	</c:choose>
  	<form:form action="/expenses/create" method="post" modelAttribute="expense" class="expenseForm">
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
</body>
</html>