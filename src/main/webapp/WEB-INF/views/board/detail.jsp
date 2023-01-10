<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container" style="min-height: 450px">

	<div>
		글번호 :<span id="id">${board.id}</span> 작성자 :<span>${board.user.username}</span>
	</div>

	<div class="form-group">

		<h3>${board.title}</h3>
	</div>

	<div class="form-group">${board.content}</div>

	<!-- 댓글 창 만들기 -->
	<div class="card">
		<div class="card-body">
			<textarea class="form-control" rows="1"></textarea>
		</div>
		<div class="card-footer">
			<button class="btn btn-primary">등록</button>
		</div>
	</div>
	<br />
	
	<div class="card">
		<div class="card-header">댓글 리스트</div>
		<ul id="comment--box" class="list-group">
			
			<li id="comment--1" class="list-group-item d-flex justify-content-between">
				<div>댓글내용</div>
				<div class="d-flex">
					<div class="">작성자</div>
					<button class="badge">삭제</button>
				</div>
			</li>

		</ul>
	</div>

	<br /> <br />

	<button onclick="history.back()" class="btn btn-secondary">목록</button>

	<c:if test="${board.user.id == principal.user.id}">
		<a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
		<button id="btn-delete" class="btn btn-danger">삭제</button>
	</c:if>

</div>


<script>
	$('.summernote').summernote({
		tabsize : 2,
		height : 300
	});
</script>


<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
