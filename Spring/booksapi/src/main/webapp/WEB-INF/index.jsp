<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${bookList != null}">
			<table>
				<tr>
				    <th>ID</th>
				    <th>Title</th>
				    <th>Language</th>
				    <th>Pages</th>
				</tr>
				<c:forEach var="book" items="${bookList}">
					<tr>
		    			<td><c:out value="${book.id}"/></td>
		    			<td><a href="/books/<c:out value='${book.id}'/>"><c:out value="${book.title}"/></a></td>
		    			<td><c:out value="${book.language}"/></td>
		    			<td><c:out value="${book.numberOfPages}"/></td>
		  			</tr>
    			</c:forEach>
			</table>
	  	</c:when>
	  	<c:otherwise>
	    	<h4>No books in database.</h4>
	  	</c:otherwise>
  	</c:choose>
</body>
</html>