<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script>
    // 여기서  form은 필요 없다.
    
       $(function(){
    	   // 시작하자마자 목록이 나온다. 
          loadList();
    	   //form에 submit이벤트를 설정해서 등록 처리 
    	   $(".detail-view").submit(function(e){
    		   e.preventDefault();
    		   
    		   // 등록하기 위한 밑과정
    		   var data = {
    				   no:$("[name=no]").val(),
    				   name:$("[name=name]").val(),
    				   type:$("[name=type]").val(),
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
    	   });
       });
       
       
       //여기서는 밖에서 불러오는 함수들 ! 
       
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
               //먼저 지우고 
               $(".list-view").empty();
               //추가하세요 
               for(var i=0; i<resp.length; i++){
            	   var h3 = $("<h3>").text(resp[i].no + "/" + resp[i].name + "/" + resp[i].type);
            	   $(".list-view").append(h3);
               }
            }
         });   
      }
       
    </script>
<h1>포켓몬스터 관리 페이지</h1>
<form class="detail-view">
	<input type="text" name="no" placeholder="번호">
	<input type="text" name="name" placeholder="이름">
	<input type="text" name="type" placeholder="속성">
	<button type="submit">등록</button>
</form>

<hr>

<div class="list-view">
</div>