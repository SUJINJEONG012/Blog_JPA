<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>

<div class="container">

<c:forEach var="board2" items="${boards.content}">
		<div class="card">

			<div class="card-body">

				<h4 class="card-title">${board2.title}</h4>
				<!--  <p class="card-text">${board.content}</p>-->
				<p class="card-text">${board2.createDate }</p>
				<p class="card-text">${board2.user.username }</p>
				<a href="/board/${board2.id}" class="btn btn-dark">상세보기</a>
			</div>
		</div>
	</c:forEach>




	
	
	
</div>
<%@ include file="/layout/footer.jsp"%>
