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
<title>Ninjas</title>
</head>
<body>
	<h1 class="indexTitle"><a href="/dojos">Dojos</a> | Ninjas</h1> 
	<c:choose>
		<c:when test="${ninjaList.size() != 0}">
			<table>
				<tr>
				    <th>Name</th>
				    <th>Age</th>
				    <th>Dojo</th>
				    <th>Actions</th>
				</tr>
				<c:forEach var="ninja" items="${ninjaList}">
					<tr>
		    			<td>
		    				<a href="/ninjas/<c:out value="${ninja.id}"/>">
		    					<c:out value="${ninja.firstName}"/> <c:out value="${ninja.lastName}"/>
		    				</a>
		    			</td>
		    			<td>
		    				<c:out value="${ninja.age}"/>
		    			</td>
		    			<td>
		    				<a href="/dojos/<c:out value="${ninja.dojo.id}"/>">
		    					<c:out value="${ninja.dojo.name}"/>
		    				</a>
		    			</td>
		    			<td class="actions">
		    				<a href="/ninjas/<c:out value="${ninja.id}"/>/edit">Edit</a>
		    				<form action="/ninjas/<c:out value="${ninja.id}"/>" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete" class="deleteButton">
							</form>
		    			</td>
		  			</tr>
    			</c:forEach>
			</table>
	  	</c:when>
	  	<c:otherwise>
	    	<h4>No ninjas in database.</h4>
	  	</c:otherwise>
  	</c:choose>
  	<p class="indexCreate">
  		<a href="/ninjas/new">Create Ninja</a>
  	</p>
</body>
</html>