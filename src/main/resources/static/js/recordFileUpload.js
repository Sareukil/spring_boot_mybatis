/**
 * recordFileUpload.js
 */

 $(document).ready(function(){
    const recordBtn = document.getElementById("recordBtn");
    const stopBtn = document.getElementById("stopBtn");

    if(navigator.mediaDevices){
        var constraints = {
            audio:true
        }
        let chunks = [];
        
        navigator.mediaDevices.getUserMedia(constraints)
        .then(stream=>{
            const mediaRecorder = new MediaRecorder(stream);

            recordBtn.onclick = ()=>{
                mediaRecorder.start();
                recordBtn.style.background = "red";
                recordBtn.style.color="black";
            }

            stopBtn.onclick = ()=>{
                mediaRecorder.stop();
                recordBtn.style.background = "";
                recordBtn.style.color="";
            }

            mediaRecorder.onstop = e =>{
                const blob = new Blob(chunks,{
                    'type':'audio/mp3 codecs=opus'
                });
                chunks = [];

                const audio = document.createElement('audio');
                audio.src=URL.createObjectURL(blob);

                var num = new Date();
                const clipName = num.getTime() + "_voiceMsg";

                fileUploadFn(blob,clipName);
            }

            mediaRecorder.ondataavailable = e =>{
                chunks.push(e.data);
            }
        }).catch(error =>{
            console.log("오류 발생 :" + error)
        });
    }

    function fileUploadFn(blob, clipName){
        var formData = new FormData();
        formData.append('uploadFile',blob,clipName + ".mp3");


        $.ajax({
            type:"post",
            url:"allFileUpload",
            enctype:"multipart/form-data",
 			processData:false,
 			contentType:false,
 			data: formData,
            success:function(result){
               if(result == "success"){
                $('#audioBox').html('<audio src="/audio/' + clipName +'.mp3" controls>');
                
               }
            },
            error:function(){
                alert("실패");
            },
            complete:function(){
                alert("작업 완료");
            }
        }); // ajax 종료
    }
 })