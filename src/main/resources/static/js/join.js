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
    let id = $("#inputId").val();
    let result = nullCheck($("inputId").val(), $("#idCheck"), "ID");
    results[0] = result;

    //id가 비어있지 않을 때         //변수에 담김
    $.get("./idCheck?id="+id, function(data){
        console.log(data);
        if(data=='0'){
            $("#inputIdResult").html("사용 가능한 ID입니다.")
        }else{
            $("#inputIdResult").html("사용 불가능한 ID입니다.")
        }

    });
});







//비번 - 2글자 이상
// $("#inputPw").blur(function(){
//     let result = nullCheck($("inputPw").val());

//     if(result){
//         $("pwCheck").html("사용 가능한 비밀번호입니다.")
//     }else {
//         $("pwCheck").html("두 글자 이상 입력하세요.");
//     }
// });
//--------
// $("inputPw").blur(function(){
//     let result = nullCheck($("inputPw").val(), $("#pwCheck"), "PW");
//     results[1] = result;
// });

// $("inputPw").change(function(){
//     $("inputPwCheck").val("");
//     results[2]=false;
//     $("pwReCheck").html("");
// });
//--------
$("intputPw").on({
    blur:function(){
        let result = nullCheck($("inputPw").val(), $("#pwCheck"), "PW");
         results[1] = result;
    },
    change:function(){
        $("inputPwCheck").val("");
        results[2]=false;
         $("pwReCheck").html("");
    }
})






//비번확인 - 2글자 이상, 비번과 동일
$("#inputPwCheck").blur(function(){
    let result = nullCheck($("inputPw").val(), $("inputPwCheck").val());

    if(result){
        $("pwReCheck").html("사용 가능한 비밀번호입니다.")
    }else {
        $("pwReCheck").html("두 글자 이상 입력하세요.");
    }
});

//이름 - 2글자 이상
$("#inputName").blur(function(){
    let result = nullCheck($("inputName").val());

    if(result){
        $("nameCheck").html("사용 가능한 비밀번호입니다.")
    }else {
        $("nameCheck").html("두 글자 이상 입력하세요.");
    }
});

//이메일 - 2글자 이상
$("#inputEmail").blur(function(){
    let result = nullCheck($("inputEmail").val());

    if(result){
        $("emCheck").html("사용 가능한 비밀번호입니다.")
    }else {
        $("emCheck").html("두 글자 이상 입력하세요.");
    }
});


//회원가입 버튼 클릭 시 각 조건 충족여부 확인
$("#joinBtn").click(function(){

    if(results.includes(false)){
        alert("필수 입력 값을 입력해 주세요.")
    }else {
        console.log("success");
        //$("joinForm").submit();
    }




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



$("#test").click(function(){
    let teid="123";
    let tename="bh";

    $.post("test", {
    //파라미터 명 : 변수명
        id:teid,
        name:tename
    }, function(result){
        console.log("result : ", result);

        //문자열을 JSON으로 바꾸기
        result=JSON.parse(result);
        console.log("name : ", result.name);
    });
});


//GET Ajax 요청 테스트
$("#test2").click(function(){
    let teid = "abc";
    $.ajax({
        type:"get",
        URL:"idCheck",
        data:{
            id:teid
        },
        success:function(data){
            console.log("Data : ", data);
        },
        error:function(xhr, status, error){
            console.log("xhr : ", xhr);
            console.log("status : ", status);
            console.log("error : ", error);
        }
    });
});

$("#test3").click(function(){
    let teid = "1234";
    let tename = "kry";
    let tearr = [1, 2, 3];
    $.ajax({
        type:"post",
        URL:"test",
        traditional:true,  //배열 전송
        data:{
            id:teid,
            name:tename
        },
        success:function(result){
            console.log("result : ", result);
        }
    });
});


// Add ---------------------------------------------
let count=3;

$("s1Add").click(function(){
            //문자열로 Element Add
    let add = '<option class="abc" id="ab'+count+'">'+count+'</option>';
    $("#s1").append(add);
    count++;
});