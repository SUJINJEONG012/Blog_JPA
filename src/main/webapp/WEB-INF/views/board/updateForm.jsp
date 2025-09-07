<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container cont-height">
<h2 class="border-bottom pb-4"> 게시판 글 수정</h2>

	<form>
		<input type="hidden" id="id" value="${board.id}">

		<div class="mb-4 mt-4">
			<!--모델에 데이터를 들고 오니까  -->
			<label for="username" class="form-label" lang="ko">제목</label>
			<input type="text" value="${board.title}" class="form-control"
				placeholder="Enter title" id="title">
		</div>

		<div class="mb-4 mt-4">
		    <label for="username" class="form-label" lang="ko"> 내용</label>
			<textarea class="form-input summernote" rows="5" cols=""
				id="content">${board.content}</textarea>
		</div>
		
		<!--파일 업로드 -->
		<div class="mb-4 mt-4">
			<label for="file" class="form-label">파일첨부</label>
			<input type="file" class="form-control" placeholder="Enter title" id="title" name="file">
		</div>
	</form>
	<button id="btn-update" class="btn btn-dark">글 수정하기</button>
</div>


<script>
	$('.summernote').summernote({
		tabsize : 2,
		height : 300
	});
</script>


<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>
