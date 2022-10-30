<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
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
                <form:form modelAttribute="memberVO" action="./join" method="post" id="joinForm">
                    <div class="my-4">
                        <label for="inputId" class="form-label"><b>아이디</b></label>
                        <form:input path="id" cssClass="form-control border-primary border-opacity-25" id="inputId"/>
                        <form:errors path="id" id="inputIdResult"></form:errors>
                        <div class="text-danger" id="idCheck"></div>
                    </div>
                    
                    <div class="my-4"> 
                        <label for="inputPw" class="form-label"><b>비밀번호</b></label>
                        <form:password path="pw" cssClass="form-control border-primary border-opacity-25" id="inputPw"/>
                        <form:errors path="pw"></form:errors>
                        <div class="text-danger" id="pwCheck"></div>
                    </div>

                    <div class="my-4"> 
                        <label for="inputPwCheck" class="form-label"><b>비밀번호 확인</b></label>
                        <form:password path="pwCheck" cssClass="form-control border-primary border-opacity-25" id="inputPwCheck"/>
                        <form:errors path="pwCheck"></form:errors>
                        <div class="text-danger" id="pwReCheck"></div>
                    </div>
                    
                    <div class="mb-4">
                        <label for="inputName" class="form-label"><b>이름</b></label>
                        <form:password path="name" cssClass="form-control border-primary border-opacity-25" id="inputname"/>
                        <form:errors path="name"></form:errors>
                        <div class="text-danger" id="nameCheck"></div>
                    </div>
                    
                    <div class="mb-4">
                        <label for="inputEmail" class="form-label"><b>이메일</b></label>
                        <form:input path="email" cssClass="form-control border-primary border-opacity-25" id="inputEmail"/>
                        <form:errors path="email"></form:errors>
                        <div class="text-danger" id="emailCheck"></div>
                    </div>
                    
                    <div class="mb-4">
                        <label for="inputAge" class="form-label"><b>나이</b></label>
                        <form:input path="age" cssClass="form-control border-primary border-opacity-25" id="inputAge"/>
                        <form:errors path="age"></form:errors>
                        <div class="text-danger" id="ageCheck"></div>
                    </div>
                    
                    <div class="mb-4">
                        <label for="inputEmail" class="form-label"><b>생일</b></label>
                        <form:input path="birth" cssClass="form-control border-primary border-opacity-25" id="inputBirth
                        "/>
                        <form:errors path="birth"></form:errors>
                        <div class="text-danger" id="birthCheck"></div>
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
                </form:form>
            </div>
        </div>
    </div>

</body>
</html>