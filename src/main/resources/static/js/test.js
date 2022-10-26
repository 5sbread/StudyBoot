console.log("start");

$("#btn").click(function(){
    console.log("button")
});

//const btns = document.getElementsByClassName("btns");
//const btns = document.querySelectorAll("btns");

// 반복문 안 돌려도 여러개에 기능 가능
$(".btns").click(function(){
    console.log("btns")
});

//위임
                    //id=btn2로 이벤트를 전달
$("#test").on("click", "#btn2", function(){
    console.log("test")
});