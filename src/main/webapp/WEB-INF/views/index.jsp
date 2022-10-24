<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index 🐱</title>

<c:import url="./temp/boot.jsp"></c:import>
<link href="/css/test.css" rel="stylesheet">

</head>
<body>
	<h1>Index page</h1>
	<img src="./images/syl_4.jpg" id="id1">
	<br>
	<br>
	<a href="./qna/list">QNA</a>
	
	<div>
		<img alt="" src="/file/qna/75aaf265-c34f-4ed6-a881-1d152e806b18_아이유.jpg">
		<a href="/fileDown/qna?fileNum=2">Down</a>
	</div>

	<div>
		<img alt="" src="/file/qna/75aaf265-c34f-4ed6-a881-1d152e806b18_아이유.jpg">
		<a href="/fileDown/notice?fileNum=2">Down</a>
	</div>	


</body>
</html>