<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Index 🐱</title>

	<c:import url="./temp/boot.jsp"></c:import>
	<link href="/css/test.css" rel="stylesheet">
	<script defer src="/js/test.js"></script>
</head>

<body>
	<h1>=O.O=</h1>
	<h2><spring:message code="hi"></spring:message> </h2>
	<h2><spring:message code="test" text="Code가 없을 때 나오는 기본 메세지"></spring:message> </h2>
	<h3><spring:message code="hi" var="h"></spring:message></h3>
	<h4>${h}</h4>
	
	<!-- Security 사용 전 -->
	<%-- <div>
		<!-- <!-- MemberController에서 member로 설정했기 때문에 --> -->
		<c:choose>
			<c:when test="${not empty member}">
				<a href="./memeber/logout">Logout</a>
				<h3>${member.name}님 환영합니다!🎃 현재 로그인 중인 아이디는 ${member.id}입니다.</h3>
				<h4><spring:message code="welcome" arguments="${member.name}"></spring:message> </h4>
				<h4><spring:message code="welcome2" arguments="${member.id},${member.name}" argumentSeparator=","></spring:message></h4>
			</c:when>
			<c:otherwise>
				<a href="./member/login">Longin</a>
				<a href="./member/join">Join</a>
			</c:otherwise>
		</c:choose>
	</div> --%>
	
	<div>
		<!-- 로그인 성공 -->
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="Principal" var="member"/>
			<a href="./memeber/logout">Logout</a>
			<h3>${member.name}님 환영합니다!🎃 현재 로그인 중인 아이디는 ${member.id}입니다.</h3>
			<h4><spring:message code="welcome" arguments="${member.name}"></spring:message> </h4>
			<h4><spring:message code="welcome2" arguments="${member.id},${member.name}" argumentSeparator=","></spring:message></h4>
			
			<sec:authorize access="hasRole('ADMIN')">
				<a href="/admin">🍩 Admin</a>
			</sec:authorize>
		</sec:authorize>
		
		<!-- 로그인 전 -->
		<sec:authorize access="!isAuthenticated()">
			<a href="./member/login">  Longin</a>
			<a href="./member/join">Join</a>
		</sec:authorize>
	</div>
	
	
	
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

	<button id="btn">=O.O=</button>
	<br><br>
	<button class="btns">(=O.O=)9</button>
	<button class="btns">6(=O.O=)9</button>
	<button class="btns">6(=O.O=)</button>

	<!-- 부모 영역(div) 안 자식 영역을 클릭했을 때 이벤트 -->
	<div id="test">

	</div>

</body>
</html>