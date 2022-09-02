<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a 태그</title>
</head>
<body>
		<!--  
		   		a 태그는 사용자에게 다른 페이지로의 연결을 제공한다.
		   			- 태그만 작성하면 어디로 이동해야 할 지 알 수 없다.
		   			- 속성을 추가로 작성하여 알려줘야 할 옵션을 제공한다.
		   				-href는 목적지를 설정할 수 있는 속성이다.
		   				
		   			-같은 서버나 같은 프로젝트의 페이지에 대한 연결은 주소 생략이 가능 
		 -->
		 <a href="https://www.google.com/">구글로 이동</a>
		 
		 <hr>
		 
		 <!--  절대 경로(absolute path) 방식 : 어떤 위치에서든 동일한 위치를 지정(최대한 짧은거 씀) -->
		 <a href="http://localhost:8888/tag/test01">test01로 이동</a>
		 <a href="//localhost:8888/tag/test01">test01로 이동</a>
		 <a href="/tag/test01">test01로 이동</a>
		 
		 <!-- 상대 경로(relative path) 방식 : 현재 파일의 위치에서부터 시작하는 경로 -->
		 <a href="test01">test01로 이동</a> 
		 
</body>
</html>


