<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container cont-height">
<h2 class="border-bottom pb-4">게시판 상세보기 </h2>
	<div class="my-3 p-3 card bg-body rounded shadow-sm">

		
			<div class="mb-4 ">

				글번호 : <span id="id" lang="en">${board.id}</span> 작성자 : <span
					class="" lang="en">${board.user.username}</span>
			</div>

			<div class="mb-4 pb-4 border-bottom">
				<h3 class="" lang="en">${board.title}</h3>
			</div>

			<div class="mb-4 mt-4" lang="en">${board.content}</div>
			
		
	</div>
	
	<div class="mb-4 mt-4">
    대표이미지 :
    <c:choose>
        <c:when test="${fn:endsWith(board.filename, '.pdf')}">
            <a href="/images/${board.filename}" target="_blank">PDF 보기</a>
        </c:when>
        <c:otherwise>
            <img src="/images/${board.filename}" alt="대표 이미지" style="max-width:200px;">
        </c:otherwise>
    </c:choose>
	</div>


	<!-- 댓글 창 만들기 -->
	<div class="card">
		<form>
			<input type="hidden" id="userId" value="${principal.user.id}" /> <input
				type="hidden" id="boardId" value="${board.id}" />
			<div class="card-body">
				<textarea id="reply-content" class="form-textarea" rows="1"
				
				
					placeholder="댓글을 입력해주세요"></textarea>
			</div>
			<div class="card-footer">
				<button type="button" id="btn-reply-save" class="btn btn-dark">등록</button>
			</div>
		</form>
	</div>
	<br />

	<div class="card">
		<div class="card-header">댓글 리스트</div>
		<ul id="comment--box" class="list-group">
			<c:forEach var="reply" items="${board.reply}">
				<li id="comment--1"
					class="list-group-item d-flex justify-content-between align-items-center ">
					<div class="pe-5" style="width: 75%;">${reply.content }</div>
					<div class="d-flex justify-content-between align-items-center">
						<div class="pe-4">작성자 ${reply.user.username}</div>
						<button type="button"
							onClick="index.replyDelete(${board.id}, ${reply.id })"
							class="btn btn-outline-dark">삭제</button>
					</div>
				</li>
			</c:forEach>


		</ul>
	</div>

	<div class="mb-4 mt-4">
		<button onclick="history.back()" class="btn btn-secondary">목록</button>
		<c:if test="${board.user.id == principal.user.id}">
			<a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
			<button id="btn-delete" class="btn btn-danger">삭제</button>
		</c:if>
	</div>


</div>



<script>
	$('.summernote').summernote({
		tabsize : 2,
		height : 300
	});
</script>


<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
