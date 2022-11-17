<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>골라서 결제</h1>

<c:forEach var="productDto" items="${list}">
	<div>
		<!-- 체크박스와 수량 입력란을 생성 -->
		<input type="checkbox" class="item-check" data-no="${productDto.no}">
		<input type="number" class="item-qty" data-no="${productDto.no}" value="0">
		${productDto.no} /
		${productDto.name} /
		${productDto.type} /
		${productDto.price} /
		${productDto.made} /
		${productDto.expire} /
	</div>
</c:forEach>

<button class="purchase-btn">구매하기</button>

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	$(function(){
		//목표 : 
		//구매하기 버튼을 누르면 가상의 form을 만들어서 
		//체크된 상품번호와 수량을 채운 뒤 전송
		$(".purchase-btn").click(function(){//구매하기 버튼을 클릭하면
			
			var form = $("<form>").attr("method", "post");
			var count = 0;
			$(".item-check").each(function(){//체크박스 전체를 검색하여
				var checked = $(this).prop("checked");//체크여부를 조사
				if(checked) {//체크가 되어 있다면
					var no = $(this).data("no");//번호는 data-no를 조사
					var qty = $(".item-qty[data-no="+no+"]").val();//수량은 해당 번호의 입력창 조사
					//console.log(no, qty);
					
					var noTag = $("<input>").attr("type", "hidden")
														.attr("name", "data["+count+"].no")
														.val(no);
					var qtyTag = $("<input>").attr("type", "hidden")
														.attr("name", "data["+count+"].qty")
														.val(qty);
					form.append(noTag).append(qtyTag);
					
					count++;
				}
			});
			
			$("body").append(form);
			form.submit();//전송(상황에 따라 처리)
			
		});
		
	});
</script>




