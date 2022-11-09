<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	$(function(){
		var judge = {
			emailValid : false,
		};
		//목표 : 확인 버튼을 누르면 이메일 발송 컨트롤러로 비동기 요청
		$(".send-btn").click(function(){
			var email = $("[name=memberEmail]").val();
			if(email.length == 0) return;
			
			var btn = $(this);
			btn.prop("disabled", true);
			
			$.ajax({
				url:"${pageContext.request.contextPath}/async2",
				method:"post",
				data:{who:email},
				success:function() {
					//성공했다면 메일은 전송되었다고 볼 수 있다
					console.log("메일 전송 완료");
					btn.prop("disabled", false);
					
					//인증번호 입력창을 사용자에게 보여줘야 한다
					//(1) 만들든가 (2) 숨겨놨다 보여주든가
					
					var div = $("<div>");
					var input = $("<input>");
					var button = $("<button>").attr("type", "button").text("검사");
					
					//button을 클릭하면 input에 있는 인증번호와 이메일을 사용해서 검사요청
					button.click(function(){
						var serial = input.val();
						if(serial.length != 6) return;
						
						$.ajax({
							url:"${pageContext.request.contextPath}/async3",
							method:"post",
							data:{
								who:email,
								serial:serial
							},
							success:function(resp){
								//console.log(resp);
								//resp가 true면 이메일 인증이 성공한 것
								//결과를 외부에 저장하고 더이상 인증버튼을 못누르게 해야한다
								judge.emailValid = resp;
								btn.prop("disabled", true);
							}
						});
					});
					div.append(input).append(button);
					$(".cert").html(div);
				}
			});
		});
		
		//form이 전송될 때 판정객체(judge)의 상태가 어떤지 출력
		$(".join-form").submit(function(){
			console.log(judge);
			return false;
		});
	});
</script>  


<h1>[나나드림]회원가입</h1>

<!-- 이 form은 회원가입을 위한 폼이다 -->
<form class="join-form">
	이메일 : <input type="text" name="memberEmail">
	<button class="send-btn" type="button">확인</button>
	<div class="cert"></div>
	
	<button type="submit">가입</button>
</form>