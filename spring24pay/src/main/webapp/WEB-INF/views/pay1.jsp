<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>직접 입력해서 결제</h1>

<form action="pay1" method="post">
	상품명 : <input type="text" name="item_name" required><br><br>
	구매금액 : <input type="number" name="total_amount" required><br><br>
	<button type="submit">구매하기</button>
</form>