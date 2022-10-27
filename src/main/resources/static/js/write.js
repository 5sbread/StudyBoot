
let count = 1;

$("#fileAddBtn").click(function(){

    if(count<6){
        let add = '<div class="mb-3">';
        add = add + '<label for="contents" class="form-label">File'+count+'</label><br>';
        add = add + '<input type="file" name="files"></input>';
        add = add + '<button type="button" class="del">❌</div>';
        add = add + '</div>';

        $(".fileAddBody").append(add);
        count++;
    }else {
        alert("파일은 최대 5개까지 등록할 수 있습니다.");
    }
});

// 삭제 버튼
$(".fileAddBody").on("click",".del", function(){
    console.log("del");
    $(this).parent().remove();
    count--;
});

//글 수정시 첨부파일 삭제
$(".deleteFile").click(function(){
    //DB, HDD에서 파일 삭제
    let check = confirm("삭제");

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
            },
            error:function(){
                console.log("error");
            }
        });
    }
});

