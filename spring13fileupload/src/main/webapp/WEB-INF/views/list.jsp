<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="attachmentDto" items="${list}">
	<h1>
		<img width="50" height="50" src="download?attachmentNo=${attachmentDto.attachmentNo}">
	
		[${attachmentDto.attachmentType}]
		
		<a href="download?attachmentNo=${attachmentDto.attachmentNo}"> 
		${attachmentDto.attachmentName}
		</a>
		
		(${attachmentDto.attachmentSize} bytes)
	</h1>
</c:forEach>