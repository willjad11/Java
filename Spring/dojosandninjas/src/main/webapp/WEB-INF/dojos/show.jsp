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
<title>Dojo details: <c:out value="${dojo.name}"/></title>
</head>
<body>
	<div class="showCont">
		<h1>
			<c:out value="${dojo.name}"/>
		</h1>
		<h4>
			Location: <c:out value="${dojo.location}"/>
		</h4>
		<h4>Ninjas: </h4>
		<c:choose>
			<c:when test="${dojo.ninjas.size() != 0}">
				<table class="showDojoTable">
					<tr>
					    <th>Name</th>
					    <th>Age</th>
					</tr>
					<c:forEach var="ninja" items="${dojo.ninjas}">
						<tr>
							<td>
								<a href="/ninjas/${ninja.id}">
									<c:out value="${ninja.firstName} ${ninja.lastName}"/>
								</a>
							</td>
							<td>
								<c:out value="${ninja.age}"/>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
   				<i>No ninjas currently assigned</i>
   			</c:otherwise>
   		</c:choose>
		<div class="showAction">
			<a href="/books/<c:out value="${book.id}"/>/edit">Edit</a>
			<form action="/books/<c:out value="${book.id}"/>" method="post">
		    	<input type="hidden" name="_method" value="delete">
		    	<input type="submit" value="Delete" class="deleteButton">
			</form>
		</div>
	</div>
	<p class="back">
		<a href="/dojos">Back to Dojos</a>
	</p>
</body>
</html>