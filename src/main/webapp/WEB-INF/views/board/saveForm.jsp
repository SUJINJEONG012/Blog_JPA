<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">

<form>
		<div class="form-group">
			<label for="title">Title</label> 
			<input type="text" class="form-control" placeholder="Enter title" id="title" >
		</div>
		
		<div class="form-group">
			<label for="content">Content</label> 
			<textarea class="form-control summernote" rows="5" cols="" id="content"></textarea>
		</div>
		
		
	</form>
	
	<button id="btn-save" class="btn btn-primary">글쓰기</button>
		
	
</div>

    
 <script>
      $('.summernote').summernote({
    	  
        tabsize: 2,
        height: 300,
        lang : 'ko-KR',
       /*  toolbar : toolbar, */
       /*  //콜백함수 
        callbacks :{
        	onImageUpload: function(file, editor, welEditable){
        		//파일업로드
        		for(var i = files.length -1; i >= 0; i--){
        			uploadSummernoteImageFile(files[i],this);
        		}
        	}
        }; */
        
       // $(".summernote").summernote(setting);
      });
      
      
     /*  function sendFile(file, editor){
  		var data = new FormData();
  		data.append("file", file);
  		console.log(file);
  		$.ajax({
  			data : data,
  			type : "POST",
  			url : "SummerNoteImageFile",
  			contentType : false,
  			processData : false,
  			success : function(data){
  				console.log(data);
  				console.log(editor);
  				$(editor).summernote("insertImage",data.url);
  			}
  		});
  	}
  */


      
 </script>
    
    
<script src="/js/board.js"></script>    
<%@ include file="../layout/footer.jsp" %>  