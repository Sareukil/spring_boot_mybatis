/**
 * imageFileUpload.js
 */

 $(document).ready(function(){
    $('#audioFileForm').on('submit', function(){
    //폼이 submit 되지 않도록 기본 기능 중단
        event.preventDefault();
        
        // id와 pw값 변수에 저장
        var formData = new FormData($('#audioFileForm')[0]);

        var fileName = $('#uploadFile').val().split("\\").pop();
        
        // 서버에 전송하고 결과 받아서 처리
        $.ajax({
            type:"post",
            url:"allFileUpload",
            enctype:"multipart/form-data",
 			processData:false,
 			contentType:false,
 			data: formData,
            success:function(result){
               if(result == "success"){
                $('#audioBox').html('<audio src="/audio/' + fileName +'" controls>');
                
               }
            },
            error:function(){
                alert("실패");
            },
            complete:function(){
                alert("작업 완료");
            }
        }); // ajax 종료 	
    });// submit 종료
});