<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>My Page</title>
	</head>
<body>
	<h3>My Page</h3>
	<sec:authentication property="Principal" var="user"/>
		<h4>ID : ${user.id} </h4>
		
		<h4>Name : <sec:authentication property="Principal.name"/> </h4>
		<h4>Email : <sec:authentication property="name"/> </h4>
	
</body>
</html>