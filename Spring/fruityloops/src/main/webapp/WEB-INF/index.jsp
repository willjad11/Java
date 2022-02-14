<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<title>Fruity Loops</title>
</head>
<body>
	<table>
		<tr>
    		<th>Name</th>
    		<th>Price</th>
  		</tr>
		<c:forEach var="fruit" items="${fruits}">
			<tr>
    			<td><c:out value="${fruit.name}"/></td>
    			<td>$<c:out value="${fruit.price}"/></td>
  			</tr>
    	</c:forEach>
	</table>
	<h1><c:out value="${pear}"/></h1>
</body>
</head>
