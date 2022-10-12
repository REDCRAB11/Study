<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="포켓몬 상세 정보" name="title"/>
</jsp:include>

<style>
	ul.list {
		list-style:none;
		padding:0;
		margin:0;
		border:1px solid gray;
		font-size:20px;
	}
	ul.list > li {
		border:1px solid gray;
		padding:0.5em;
	}
	ul.list > li:hover {
		color:#d63031;
	}
</style>

<div class="container-400">
	<div class="row center">
		<h1>몬스터 상세 정보</h1>
	</div>
	<div class="row left">
		<!-- list 태그 -->
		<ul class="list">
			<li>번호 : ${dto.no}</li>
			<li>이름 : ${dto.name}</li>
			<li>속성 : ${dto.type}</li>
		</ul>
	</div>
	
	<div class="row center">
		<a class="btn btn-positive" href="insert">등록</a>
		<a class="btn btn-neutral" href="list">목록</a>
		<a class="btn btn-negative" href="edit?no=${dto.no}">수정</a>
		<a class="btn btn-negative" href="delete?no=${dto.no}">삭제</a>
	</div>
	
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>