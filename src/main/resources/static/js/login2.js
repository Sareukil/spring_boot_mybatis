/**
 * login.js
 */

 $(document).ready(function(){
 	$('#frmLogin').on('submit', function(){ 	
 		event.preventDefault();
 		
 		// id와 pw값 변수에 저장
 		var userId = $('#user_id').val();
 		var userPw = $('#user_pw').val();
 		
 		// 서버에 전송하고 결과 받아서 처리
 		$.ajax({
 			type:"post",
 			url:"login",
 			data: {"id":userId,
 			            "pw":userPw},
 			dataType:'text',
 			success:function(result){
 				if(result == "success"){
 					alert("로그인 성공\n상품 조회 화면으로 이동합니다.");
 					location.href="/mybatis/product/productListAll";
 				}else{
 					alert("로그인 실패");
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
 