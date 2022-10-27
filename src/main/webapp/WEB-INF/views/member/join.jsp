<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> 📥 </title>

    <c:import url="../temp/boot.jsp"></c:import>
    <script defer src="/js/join.js"></script>
    <script defer src="/js/util.js"></script>
</head>

<body>
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-7">
                <div class="my-4 text-center">
                    <h1><b>회원 가입</b></h1>
                </div>
                
                <!-- 정보 입력 -->
                <form action="./join" method="post" id="joinForm">
                    <div class="my-4">
                        <label for="inputId" class="form-label"><b>아이디</b></label>
                        <input type="text" name="id" class="form-control border-primary border-opacity-25" id="inputId" placeholder="아이디를 입력해주세요">
                        <div class="text-danger" id="idCheck"></div>
                    </div>
                    
                    <div class="my-4"> 
                        <label for="inputPw" class="form-label"><b>비밀번호</b></label>
                        <input type="password" name="pw" class="form-control border-primary border-opacity-25" id="inputPw" placeholder="비밀번호를 입력해주세요">
                        <div class="text-danger" id="pwCheck"></div>
                    </div>

                    <div class="my-4"> 
                        <label for="inputPwCheck" class="form-label"><b>비밀번호 확인</b></label>
                        <input type="password" class="form-control border-primary border-opacity-25" id="inputPwCheck" placeholder="비밀번호를 입력해주세요">
                        <div class="text-danger" id="pwReCheck"></div>
                    </div>
                    
                    <div class="mb-4">
                        <label for="inputName" class="form-label"><b>이름</b></label>
                        <input type="text" name="name" class="form-control border-primary border-opacity-25" id="inputName" placeholder="이름을 입력해주세요">
                        <div class="text-danger" id="nameCheck"></div>
                    </div>
                    
                    <div class="mb-4">
                        <label for="inputEmail" class="form-label"><b>이메일</b></label>
                        <input type="text" name="email" class="form-control border-primary border-opacity-25" id="inputEmail" placeholder="이메일을 입력해주세요">
                        <div class="text-danger" id="emCheck"></div>
                    </div>


                    <!-- 약관 동의 -->
                    <div class="mb-4">
                        <div>
                            ✅ 전체 선택 <input type="checkbox" id="all">
                        </div>
                
                        <div>
                            1️⃣ 동의 <input type="checkbox" class="check" name="" id="">
                            <div>
                                약관
                            </div>
                        </div>
                
                        <div>
                            2️⃣ 동의 <input type="checkbox" class="check" name="" id="">
                            <div>
                                약관
                            </div>
                        </div>
                
                        <div>
                            3️⃣ 동의 <input type="checkbox" class="check" name="" id="">
                            <div>
                                약관
                            </div>
                        </div>
                    </div>

                    <!-- 회원가입 버튼 -->
                    <div class="d-grid gap-2 mt-3">
                        <button type="button" class="btn btn-outline-primary" id="joinBtn"><b>📥 회원가입</b></button>
                    </div>
                </form>
                
                <!-- Post tag -->
                <div>
                	<button id="test" type="button">Post Test</button>
                	<button id="test2" type="button">Ajax Get Test</button>
                	<button id="test3" type="button">Ajax Post Test</button>
                </div>
                
                <div>
                	<select id="s1">
                		<option>1</option>
                		<option>2</option>
                	</select>
                	<button type="button" id="s1Add">Add</button>
                </div>
                
            </div>
        </div>
    </div>

</body>
</html>