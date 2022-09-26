<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp">
	<jsp:param value="내가쓴글" name="title"/>
</jsp:include>


<div align ="center">
	<table border = "1" width="400">
		<thead>
		<tr>
				<th >제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>	
			<tbody>
			<tr>
				<td colspan = "1" name="board_title">${boardDto.boardTitle}</td>
				<td colspan = "1" name ="board_writer">${boardDto.boardWriter}</td>
				<td colspan = "1" class ="board_writetime">${boardDto.WriteTime}</td>
				<td colspan = "1" class ="board_read">${boardDto.boardRead}</td>
			</tr>
			</tbody>
		</thead>
	</table>	
</div>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
