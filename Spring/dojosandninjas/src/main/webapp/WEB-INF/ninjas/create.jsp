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
<title>Create a Ninja</title>
</head>
<body>
	<div class="createCont">
		<h1>Create a Ninja</h1>
		<form:form action="/ninjas/create" method="post" modelAttribute="ninja" class="ninjaForm">
			<p class="form">
		        <form:label path="firstName">First Name:</form:label>
		        <form:errors path="firstName" class="error" />
		        <form:input path="firstName"/>
		    </p>
		    <p class="form">
		        <form:label path="lastName">Last Name:</form:label>
		        <form:errors path="lastName" class="error" />
		        <form:input path="lastName"/>
		    </p>
		    <p class="form">
		        <form:label path="age">Age:</form:label>
		        <form:errors path="age" class="error" />
		        <form:input type="number" path="age"/>
		    </p>
		    <p class="form">
		        <form:label path="dojo">Dojo:</form:label>
		        <form:errors path="dojo" class="error" />
		        <form:select  path="dojo">
		        	<c:forEach var="dojo" items="${dojoList}">
				    	<form:option value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>
				    </c:forEach>
				</form:select>
		    </p>
		    <input type="submit" value="Submit" />
		</form:form>
	</div>
	<p class="back">
		<a href="/ninjas">Back to Ninjas</a>
	</p>
</body>
</html>