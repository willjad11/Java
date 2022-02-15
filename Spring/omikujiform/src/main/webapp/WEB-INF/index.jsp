<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Send an Omikuji!</title>
</head>
<body>
	<div class="formcont">
		<h3>Send an Omikuji!</h3>
		<form class="form" action='/process' method='post'>

		<div class="error"><c:out value="${noNumber}"/></div>
		<label>Pick any number from 5 to 25:</label>
		<input type="number" name='number'>
		
		<div class="error"><c:out value="${noCityName}"/></div>
		<label>Enter the name of any city:</label>
		<input type='text' name='cityName'>
		
		<div class="error"><c:out value="${noPersonName}"/></div>
		<label>Enter the name of any real person:</label>
		<input type='text' name='personName'>
		
		<div class="error"><c:out value="${noPersonalHobby}"/></div>
		<label>Enter professional endeavor or hobby:</label>
		<input type='text' name='personalHobby'>
		
		<div class="error"><c:out value="${noLivingThing}"/></div>
		<label>Enter any type of living thing:</label>
		<input type='text' name='livingThing'>
		
		<div class="error"><c:out value="${noNiceThing}"/></div>
		<label>Say something nice to someone:</label>
		<textarea name='niceThing'></textarea>
	
	    <input class="submit" type='submit' value='send'>
	    </form>
	</div>
	

	
</body>
</html>