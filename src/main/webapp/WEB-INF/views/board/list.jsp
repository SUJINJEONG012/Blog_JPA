<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container cont-height">
<h2 class="border-bottom pb-4">게시판 리스트</h2>
	<div class="album py-5">
		<div class="row row-cols-md-3">

			<c:forEach var="board" items="${boards.content}">
				<div class="col">
					<div class="card shadow-sm">
						<div class="card-body">
							<h4 class="card-title">
							<a href="/board/${board.id}" class="" lang="en">${board.title}</a></h4>
							<!--  <p class="card-text">${board.content}</p>-->
							<p class="card-text" lang="en">${board.createDate }</p>
							<p class="card-text" lang="en">${board.user.username }</p>
							<a href="/board/${board.id}" class="btn btn-dark">상세보기</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

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
<%@ include file="../layout/footer.jsp"%>
