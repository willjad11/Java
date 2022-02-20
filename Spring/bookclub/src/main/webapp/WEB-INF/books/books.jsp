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
<title>Book Club</title>
</head>
<body>
	<div class="header">
		<div class="headerLeft">
			<h1>Welcome, <c:out value="${userName}"/></h1>
			<h4>Books from everyone's shelves</h4>
		</div>
		<div class="headerRight">
			<form action="/logout">
			    <input type="submit" value="Logout" class="logoutButton">
			</form>
			<a href="/books/new">+ Add a book to my shelf!</a>
		</div>
	</div>
	<c:choose>
		<c:when test="${bookList.size() != 0}">
			<table>
				<tr>
				    <th>ID</th>
				    <th>Title</th>
				    <th>Author Name</th>
				    <th>Owner</th>
				    <th>Actions</th>
				</tr>
				<c:forEach var="book" items="${bookList}">
					<c:choose>
						<c:when test="${book.borrower == null || book.user.id == userId}">
							<tr>
								<td>
				    				<c:out value="${book.id}"/>
				    			</td>
				    			<td>
				    				<a href="/books/<c:out value="${book.id}"/>">
				    					<c:out value="${book.title}"/>
				    				</a>
				    			</td>
				    			<td>
				    				<c:out value="${book.bookAuthor}"/>
				    			</td>
				    			<td>
				    				<c:out value="${book.user.userName}"/>
				    			</td>
				    			<td>
				    				<c:choose>
										<c:when test="${book.user.id == userId}">
											<div class="bookActions">
												<a href="/books/${book.id}/edit">Edit</a>
												<form action="/books/<c:out value="${book.id}"/>" method="post">
										    		<input type="hidden" name="_method" value="delete">
										    		<input type="submit" value="Delete" class="deleteButton">
												</form>
											</div>
										</c:when>
										<c:otherwise>
											<form:form action="/books/${book.id}" method="post" modelAttribute="book" class="bookForm">
												<input type="hidden" name="_method" value="put">
												<form:hidden path="title" value="${book.title}" />
												<form:hidden path="bookAuthor" value="${book.bookAuthor}" />
												<form:hidden path="thoughts" value="${book.thoughts}" />
											    <form:hidden path="borrower" value="${userId}" />
											    <input type="submit" value="Borrow" class="borrowButton" />
											</form:form>
										</c:otherwise>
				    				</c:choose>
				    			</td>
				  			</tr>
				  		</c:when>
				  	</c:choose>
    			</c:forEach>
			</table>
	  	</c:when>
	  	<c:otherwise>
	    	<h4>No Books in database.</h4>
	  	</c:otherwise>
  	</c:choose>
  	<c:choose>
		<c:when test="${borrowList.size() != 0}">
			<h1 class="borrowingBooks">Books I'm borrowing: </h1>
			<table>
				<tr>
				    <th>ID</th>
				    <th>Title</th>
				    <th>Author Name</th>
				    <th>Owner</th>
				    <th>Actions</th>
				</tr>
				<c:forEach var="book" items="${borrowList}">
					<tr>
						<td>
		    				<c:out value="${book.id}"/>
		    			</td>
		    			<td>
		    				<a href="/books/<c:out value="${book.id}"/>">
		    					<c:out value="${book.title}"/>
		    				</a>
		    			</td>
		    			<td>
		    				<c:out value="${book.bookAuthor}"/>
		    			</td>
		    			<td>
		    				<c:out value="${book.user.userName}"/>
		    			</td>
		    			<td>
							<form:form action="/books/${book.id}" method="post" modelAttribute="book" class="bookForm">
								<input type="hidden" name="_method" value="put">
								<form:hidden path="title" value="${book.title}" />
								<form:hidden path="bookAuthor" value="${book.bookAuthor}" />
								<form:hidden path="thoughts" value="${book.thoughts}" />
							    <form:hidden path="borrower" value="" />
							    <input type="submit" value="Return" class="submit" />
							</form:form>
		    			</td>
		  			</tr>
    			</c:forEach>
			</table>
	  	</c:when>
  	</c:choose>
</body>
</html>