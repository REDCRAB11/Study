<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp">
<jsp:param value="비밀번호 변경 실패" name="title"/>
</jsp:include>
<body>
<h1>비밀 번호 변경 성공</h1>	
<h2><a href = "mypage">마이페이지</a></h2>
<h2><a href = "/member/password" > 다시 변경하기 </a></h2>
<h2><a href = "/" > 홈으로  이동 </a></h2>
</body>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>