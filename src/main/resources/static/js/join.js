console.log("join");

//전체선택 체크 시 동의3개 선택됨
$("#all").click(function(e){
    let ch = $(this).prop("checked");
    //all 체크박스 선택 시 true / 선택 해제 시 false
    console.log("all : ", ch);
    
    //ch일 때 class check를 하기
    $(".check").prop("checked", ch);
});

//동의 클릭 여부 콘솔로 확인
$(".check").click(function(){
    //all이 선택되어 있으면 true
    $("#all").prop("checked", true)

    $(".check").each(function(index, item){
        let ch = $(item).prop("checked") 
        
        if(!ch){
            $("#all").prop("checked", false);
            console.log("all : ", ch);
            return false;
        }
    });
});


// 검증 ==========================================
//아이디, 비번, 비번확인, 이름, 이메일
let results = [false, false, false, false, false]

//아이디 - 2글자 이상
$("#inputId").blur(function(){
    //id = id 칸에 입력한 값
    let id = $("#inputId").val();
    //rsult = 
    let result = nullCheck(id, $("#idCheck"), "ID는");
    results[0] = result;

    //ID 중복 확인 Ajax ========================
    //id가 비어있지 않을 때
    if(result){                         //변수에 담김
        $.get("./idCheck?id="+id, function(data){
            console.log("Data : " +data);
            if(data=='1'){
                $("#inputId").val("");
                $("#inputIdResult").html("사용 불가능한 ID입니다.");
                result[0]=false;
            }else{
                $("#inputIdResult").html("사용 가능한 ID입니다.");
                result[0]=true;
            }
        })
    };



//비번 - 2글자 이상
$("intputPw").on({
    blur:function(){
        let result = nullCheck($("inputPw").val(), $("#pwCheck"), "PW");
         results[1] = result;
    },
    change:function(){
        if(result[1]){
            $("inputPwCheck").val("");
            results[2]=false;
            $("pwReCheck").html("비밀번호가 일치하지 않습니다.");
        }
    }
})


//비번확인 - 2글자 이상, 비번과 동일
$("#inputPwCheck").blur(function(){
    let result = equals($("#inputPw").val(), $("#inputPwCheck").val());

    if(result){
        $("#pwReCheck").html("사용 가능한 비밀번호입니다.")
    }else {
        $("#pwReCheck").html("비밀번호가 일치하지 않습니다.");
    }
    results[2]=result;
});


//이름 - 2글자 이상
$("#inputName").blur(function(){
    let result = nullCheck($("inputName").val(), $("#inputNameCheck"), "Name");
    results[3] = result;
});


//이메일 - 2글자 이상
$("#inputEmail").blur(function(){
    let result = nullCheck($("inputEmail").val(), $("#inputEmailCheck"), "Email")
    results[4]=result;
});


//회원가입 버튼 클릭 시 각 조건 충족여부 확인
$("#joinBtn").click(function(){

    if(results.includes(false)){
        alert("필수 입력 값을 입력해 주세요.")
    }else {
        alert("가입하시겠습니까?")
        console.log("success");
        //$("joinForm").submit();
    }
});    




    // let c = true;
    // $.each(results, function(index, item){
    //     //하나라도 false일 때
    //     if(!item){
    //         alert("필수 입력 값을 입력해 주세요.")
    //         c = false;
    //         return c;
    //     }    
    // })

    // //submit event 강제실행
    // //event명(매개변수X);
    // if(c){
    //     $("#joinForm").submit();
    // }
});