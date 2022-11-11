<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script>
    // 여기서  form은 필요 없다.
    // 포켓몬3 원페이지에 수정/등록 구현 
    
       $(function(){ 
    	   // 시작하자마자 목록이 나온다. 
          loadList();
    	   
    	   // 수정 버튼 클릭 이벤트 
    	   $(".edit-btn").click(function(){
    		   var no = $("[name=no]").val();
    		   var name = $("[name=name]").val();
    		   var type = $("[name=type]").val();
    		   
    		   editData(no,name,type);
    		   
    		   // 입력창 값 초기화 넣어도 되고 안넣어도 되고 
	   		   $("[name=no]").val();
	 		   $("[name=name]").val();
	 		   $("[name=type]").val();
    	   });
    	   
    	   //form에 submit이벤트를 설정해서 등록 처리 
    	   $(".detail-view").submit(function(e){
    		   e.preventDefault();
    			
    		   var no = $("[name=no]").val();
    		   var name = $("[name=name]").val();
    		   var type = $("[name=type]").val();
    		   //검사
    		   saveData(no, name, type);
    		   
    		   //입력창 값 초기화 
    		    $("[name=no]").val();
    		   $("[name=name]").val();
    		   $("[name=type]").val();
    	   });
       });
       
       
       //여기서는 밖에서 불러오는 함수들 ! 
       
       //수정 함수 
       function editData(no, name, type){
    	   var data = {
				   no:no,
				   name:name,
				   type:type
		   }
    	   $.ajax({
			   url:"http://localhost:8888/rest/pocketmon",
			   method:"put",
			   contentType:"application/json",
			   data: JSON.stringify(data),
			   success:function(){
				   //추가한 포켓몬 페이지를 보여줌 
				   loadList();
			   }
		   });
       }
       
       //등록 함수 
       function saveData(no, name, type){
		   var data = {
				   no:no,
				   name:name,
				   type:type
		   }
		   
		   $.ajax({
			   url:"http://localhost:8888/rest/pocketmon",
			   method:"post",
			   contentType:"application/json",
			   data: JSON.stringify(data),
			   success:function(){
				   //추가한 포켓몬 페이지를 보여줌 
				   loadList();
			   }
		   });
       }
    
     //목록을 불러오는 함수
   	function loadList(){
   		$.ajax({
   			url:"http://localhost:8888/rest/pocketmon",
   			method:"get",
   			success:function(resp){
   				$(".list-view").empty();
   				for(var i=0; i < resp.length; i++){
   					var h3 = $("<h3>").text(
   						resp[i].no+"/"+resp[i].name+"/"+resp[i].type
   					)
   					//?
   					.attr("data-no", resp[i].no)
   					.attr("data-name",resp[i].name)
   					.attr("data-type", resp[i].type);
   					
   					// 클릭했을 때 정보가 inpu안에 들어가야 한다. 
   					h3.click(function(){
   						$("[name=no]").val($(this).data("no"));
   						$("[name=name]").val($(this).data("name"));
   						$("[name=type]").val($(this).data("type"));
   					});
   					$(".list-view").append(h3);
   				}
   			}
   		});
   	}
       
    </script>
<h1>포켓몬스터 관리 페이3</h1>
<form class="detail-view">
	<input type="text" name="no" placeholder="번호">
	<input type="text" name="name" placeholder="이름">
	<input type="text" name="type" placeholder="속성">
	<button type="button" class="edit-btn">수정</button>
	<button type="submit">등록</button>
</form>

<hr>

<div class="list-view">
</div>