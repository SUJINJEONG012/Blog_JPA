<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container" style="min-height:450px">

<div>
글번호 :<span>${board.id}</span>
작성자 :<span>${board.user.username}</span>
</div>

		<div class="form-group">
			
			<h3>${board.title}</h3>
		</div>
		
		<div class="form-group">
			${board.content}
		</div>
		
	
	
	<button onclick="history.back()" class="btn btn-secondary">목록</button>
	<button id="btn-update" class="btn btn-warning">수정</button>
	<button id="btn-delete" class="btn btn-danger">삭제</button>
		
	
</div>

    
 <script>
      $('.summernote').summernote({
        tabsize: 2,
        height: 300
      });
 </script>
    
    
<script src="/js/board.js"></script>    
<%@ include file="../layout/footer.jsp" %>  