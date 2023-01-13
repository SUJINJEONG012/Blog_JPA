<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp"%>

<div class="container">




	   	<c:forEach var="board" items="${boards.content}">
	
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">${board.title}</h4>
				<!--  <p class="card-text">${board.content}</p>-->
				<p class="card-text">${board.createDate }</p>
				<p class="card-text">${board.user.username }</p>
				<a href="/board/${board.id}" class="btn btn-dark">상세보기</a>
			</div>
		</div>
	</c:forEach>
	                                                                                            
	
	
</div>
<%@ include file="./layout/footer.jsp"%>
