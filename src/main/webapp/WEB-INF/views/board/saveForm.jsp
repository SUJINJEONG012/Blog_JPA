<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>
<div class="container">
글쓰기화면

<form>
		<div class="form-group">
			<label for="title">Title:</label> <input type="text" 
				class="form-control" placeholder="Enter title" id="title" >
		</div>
		
		
		<div class="form-group">
			<label for="content">Content</label> 
			<textarea class="form-control summernote" rows="5" cols="" id="content"></textarea>
		</div>
		
		<button id="btn-save" class="btn btn-primary">글쓰기</button>
		
	</form>
	
	
</div>
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
    
    
 <script>
      $('.summernote').summernote({
       
        tabsize: 2,
        height: 300
      });
    </script>
    
<%@ include file="../layout/footer.jsp" %>  