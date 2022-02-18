<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Languages</title>
</head>
<body>
	<c:choose>
		<c:when test="${languageList != null}">
			<table>
				<tr>
				    <th>Name</th>
				    <th>Creator</th>
				    <th>Version</th>
				    <th>Actions</th>
				</tr>
				<c:forEach var="language" items="${languageList}">
					<tr>
		    			<td><a href="/languages/<c:out value="${language.id}"/>"><c:out value="${language.name}"/></a></td>
		    			<td><c:out value="${language.creator}"/></td>
		    			<td><c:out value="${language.version}"/></td>
		    			<td class="actions">
		    				<a href="/languages/<c:out value="${language.id}"/>/edit">Edit</a>
		    				<form action="/languages/<c:out value="${language.id}"/>" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete">
							</form>
		    			</td>
		  			</tr>
    			</c:forEach>
			</table>
	  	</c:when>
	  	<c:otherwise>
	    	<h4>No languages in database.</h4>
	  	</c:otherwise>
  	</c:choose>
  	<form:form action="/languages/create" method="post" modelAttribute="language" class="languageForm">
		<p>
	        <form:label path="name">Name:</form:label>
	        <form:errors path="name" class="error" />
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Creator:</form:label>
	        <form:errors path="creator" class="error" />
	        <form:input path="creator"/>
	    </p>
	    <p>
	        <form:label path="version">Version:</form:label>
	        <form:errors path="version" class="error" />
	        <form:input path="version"/>
	    </p> 
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>