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
<title>Dojos</title>
</head>
<body>
	<h1 class="indexTitle">Dojos | <a href="/ninjas">Ninjas</a></h1> 
	<c:choose>
		<c:when test="${dojoList.size() != 0}">
			<table>
				<tr>
				    <th>Name</th>
				    <th>Location</th>
				    <th>Roster</th>
				    <th>Actions</th>
				</tr>
				<c:forEach var="dojo" items="${dojoList}">
					<tr>
		    			<td>
		    				<a href="/dojos/<c:out value="${dojo.id}"/>">
		    					<c:out value="${dojo.name}"/>
		    				</a>
		    			</td>
		    			<td>
		    				<c:out value="${dojo.location}"/>
		    			</td>
		    			<td class="roster">
		    				<c:choose>
								<c:when test="${dojo.ninjas.size() != 0}">
				    				<c:forEach var="ninja" items="${dojo.ninjas}">
				    					<p class="ninja">
				    						<a href="/ninjas/${ninja.id}">
				    							<c:out value="${ninja.firstName} ${ninja.lastName},"/>
				    						</a>
				    					</p>
				    				</c:forEach>
				    			</c:when>
				    			<c:otherwise>
				    				<i>No ninjas currently assigned</i>
				    			</c:otherwise>
				    		</c:choose>
		    			</td>
		    			<td class="actions">
		    				<a href="/dojos/<c:out value="${dojo.id}"/>/edit">Edit</a>
		    				<form action="/dojos/<c:out value="${dojo.id}"/>" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete" class="deleteButton">
							</form>
		    			</td>
		  			</tr>
    			</c:forEach>
			</table>
	  	</c:when>
	  	<c:otherwise>
	    	<h4>No Dojos in database.</h4>
	  	</c:otherwise>
  	</c:choose>
  	<p class="indexCreate">
  		<a href="/dojos/new">Create Dojo</a>
  	</p>
</body>
</html>