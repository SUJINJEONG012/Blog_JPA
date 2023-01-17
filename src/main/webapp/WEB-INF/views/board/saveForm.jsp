<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container cont-height">

<h2 class="border-bottom pb-4">글쓰기</h2>
<form action="/api/board" method="post" enctype="multipart/form-data">
		
		
		<div class="mb-4 mt-4">
			<label for="title" class="form-label">제목 </label> 
			<input type="text" class="form-control" placeholder="제목을 입력해주세요." id="title" >
		</div>
		
		<div class="mb-4 mt-4">
			<label for="content" class="form-label">내용</label> 
			<textarea class="form-control summernote" rows="5" cols="" id="content"></textarea>
		</div>
		
		<div class="mb-4 mt-4">
			<label for="content" class="form-label">파일첨부</label> 
			<input type="file" class="form-control" placeholder="Enter title" name="file" >

		</div>
        
        
     


        
        
        
	</form>
	
	<button id="btn-save" class="btn btn-dark">글쓰기</button>
		
	
</div>

    
 <script>
      $('.summernote').summernote({  
        tabsize: 2,
        height: 300
      });
     
 </script>
 

<script src="/js/board.js"></script>    
<%@ include file="../layout/footer.jsp" %>  