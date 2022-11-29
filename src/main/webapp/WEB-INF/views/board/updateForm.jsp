<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">

<form>

 <input type="hideen" id="id" value="${board.id}">
 
		<div class="form-group">
			<!--모델에 데이터를 들고 오니까  -->
			<input type="text" value="${board.title}" class="form-control" placeholder="Enter title" id="title" >
		</div>
	
		<div class="form-group">
		 
			<textarea class="form-control summernote" rows="5" cols="" id="content">${board.content}</textarea>
		</div>
	</form>

	<button id="btn-update" class="btn btn-primary">글 수정하기 </button>
		
	
</div>

    
 <script>
      $('.summernote').summernote({
        tabsize: 2,
        height: 300
      });
 </script>
    
    
<script src="/js/board.js"></script>    
<%@ include file="../layout/footer.jsp" %>  