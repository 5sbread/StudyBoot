//계속 사용하는 함수는 따로 파일 만들기
function nullCheck(data, dest, kind){
    console.log(dest);
    
    if(data == null || data==''){
        $(dest).html(kind+" 필수입니다.");
        return false;
    }else {
        $(dest).html("Good");
        return true;
    }
}

function equal(data, checkData){
    if(data == checkData){
        return true;
    }else {
        return false;
    }
}

