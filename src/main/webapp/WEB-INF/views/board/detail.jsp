<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Detail 📖</title>

	<c:import url="../temp/boot.jsp"></c:import>
<body>

	<h3>Detail Page</h3>
	<h4>Title : ${vo.title}</h4>
	
	<c:forEach items="${vo.qnaFiles}" var="fileVO">
		<img alt="" src="/file/qna/${fileVO.fileName}">
		<a href="/fileDown/qna?fileNum=${fileVO.fileName}">${fileVO.oriName}</a>
	</c:forEach>
	
</body>
</html>