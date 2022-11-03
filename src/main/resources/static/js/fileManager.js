
//파일 갯수 지정하는 변수
let count = 0;

// function setCount(c){
//     if(c<1 || c>5){
//         c=1;
//     }
//     count=c;
// }

$("#fileAddBtn").click(function(){
    if(flag){
        let size = $("#fileAddBody").attr("data-file-size");
        if(size==undefined){
            size=0;
        }
        count=size;
        flag = false;
    };

    if(count<5){
        let add = '<div class="mb-3">';
        add = add + '<label for="contents" class="form-label">File</label><br>';
        add = add + '<input type="file" name="files"></input>';
        add = add + '<button type="button" class="del">❌</div>';
        add = add + '</div>';

        $("#fileAddBody").append(add);
        count++;
    }else {
        alert("파일은 최대 5개까지 등록할 수 있습니다.");
    }
});

// 삭제 버튼
$("#fileAddBody").on("click",".del", function(){
    console.log("del");
    $(this).parent().remove();
    count--;
});


//==================================================
//글 수정시 첨부파일 삭제
let flag = true;
$(".deleteFile").click(function(){
    //DB, HDD에서 파일 삭제
    let check = confirm("삭제");
    
    if(flag){
        let size = $("#fileAddBody").attr("size");
        count=size;
        flag = false;
    };

    if(check){
        let fileNum = $(this).attr("data-file-num");
        console.log("fileNum = ", fileNum);
        
        $.ajax({
            type:"POST",
            URL:"fileDelete",
            data:{
                fileNum:fileNum
            },
            success:function(result){
                console.log("result : ", result);
                count--;
            },
            error:function(){
                console.log("error");
            }
        });
    }
});

