<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="포켓몬 등록" name="title"/>
</jsp:include>

<form action="insert" method="post">
<div class="container-300 mt-40">
	<div class="row center">
		<h1>포켓몬 등록</h1>
	</div>
	<div class="row center">
		<input class="input w-100" type="number" name="no" required placeholder="몬스터 번호" autocomplete="off">
	</div>
	<div class="row center">
		<input class="input w-100" type="text" name="name" required placeholder="몬스터 이름" autocomplete="off">
	</div>
	<div class="row center">
		<input class="input w-100" type="text" name="type" required placeholder="몬스터 속성" autocomplete="off">
	</div>
	<div class="row center">
		<button class="btn btn-positive w-100" type="submit">등록</button>
	</div>
</div>
</form>

	 <br><br>
	 <br><br>
	 <br><br>
	


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>