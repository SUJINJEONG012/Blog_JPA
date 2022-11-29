<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>

<div class="container">

	<c:forEach var="board" items="${boards.content}">
		<div class="card">

			<div class="card-body">

				<h4 class="card-title">${board.title}</h4>
				<p class="card-text">${board.content}</p>
				<p class="card-text">${board.createDate }</p>
				<p class="card-text">${board.user.username }</p>

				<a href="/board/${board.id}" class="btn btn-dark">상세보기</a>
			</div>
		</div>
	</c:forEach>


<!-- 페이징처리  -->
	<ul class="pagination justify-content-center">
	
	
		<c:choose>
			<c:when test="${boards.first}">
				<li class="page-item disabled"><a class="page-link"
					href="?page=${boards.number-1}">이전</a></li>
			</c:when>

			<c:otherwise>
				<li class="page-item"><a class="page-link"
					href="?page=${boards.number-1}">이전</a></li>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${boards.last}">
				<li class="page-item disabled"><a class="page-link"
					href="?page=${boards.number+1}">다음</a></li>
			</c:when>

			<c:otherwise>
			
			<li class="page-item"><a class="page-link"
					href="?page=${boards.number+1}">다음</a></li>
				
			</c:otherwise>
		</c:choose>
	
	</ul>
	
	

</div>
<%@ include file="layout/footer.jsp"%>
