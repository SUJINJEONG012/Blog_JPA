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
		<form>
			<input type="hidden" id="userId" value="${principal.user.id}" /> <input
				type="hidden" id="boardId" value="${board.id}" />
			<div class="card-body">
				<textarea id="reply-content" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer">
				<button type="button" id="btn-reply-save" class="btn btn-primary">등록</button>
			</div>
		</form>
	</div>
	<br />

	<div class="card">
		<div class="card-header">댓글 리스트</div>
		<ul id="comment--box" class="list-group">
			<c:forEach var="reply" items="${board.reply}">
				<li id="comment--1"
					class="list-group-item d-flex justify-content-between">
					<div>${reply.content }</div>
					<div class="d-flex">
						<div class="">작성자 ${reply.user.username}</div>
						<button type="button" onClick="index.replyDelete(${board.id}, ${reply.id })" class="badge">삭제</button>
					</div>
				</li>
			</c:forEach>


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
