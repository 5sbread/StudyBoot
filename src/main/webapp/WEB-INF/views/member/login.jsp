<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> 🔐 </title>

    <c:import url="../temp/boot.jsp"></c:import>
</head>

<body>
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-5">
				<div class="my-4 text-center">
					<h1><b>로그인</b></h1>
				</div>
				
				<div>
					<h6>${param.error}</h6>
					<h6>${param.message}</h6>
					<h6>${param.name}</h6>
				</div>
				
				
				<form action="./login" method="post">
				  <div class="mb-3">
				    <label for="ipId" class="form-label">아이디</label>
				    					<!-- 쿠기 값이 있다면 집어넣기 -->
				    <input type="text" value="${cookie.userId.value}" name="id" class="form-control border-primary border-opacity-25" id="ipId">
				  </div>
				  <div class="mb-3">
				    <label for="ipPw" class="form-label">비밀번호</label>
				    <input type="password" name="pw" class="form-control border-primary border-opacity-25" id="ipPw">
				  </div>
				  <div class="mb-3">
				      <input class="form-check-input" type="checkbox" value="" id="rememberId">
					  <label class="form-check-label" for="flexCheckDefault">
					    아이디 기억하기
					  </label>
				  </div>
				  <button type="submit" class="btn btn-outline-primary"> 🔐 로그인 </button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>