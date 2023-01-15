<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container">

<form enctype="multipart/form-data">
		<div class="form-group">
			<label for="title">Title</label> 
			<input type="text" class="form-control" placeholder="Enter title" id="title" >
		</div>
		
		<div class="form-group">
			<label for="content">Content</label> 
			<textarea class="form-control summernote" rows="5" cols="" id="content"></textarea>
		</div>
		
		<div>
            <input type="file" th:field="*{file}" class="form-control">
        </div>
        
        <div class="form-group">
           <label for="content_file">첨부 이미지</label>
           <input type="file" id="upload_file" class="form-control" accept="image/*" />
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
<<<<<<< HEAD
  
=======
      
      
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


      
>>>>>>> 2aa5cb3... 썸머노트 이미지 인코딩변경할려다가 대표이미지로 메인에 뿌려주기
 </script>
    
      <script>
        $(document).ready(function(){
            var errorMessage = [[${errorMessage}]];
            if(errorMessage != null){
                alert(errorMessage);
            }

            bindDomEvent();

        });

        function bindDomEvent(){
            $(".custom-file-input").on("change", function() {
                var fileName = $(this).val().split("\\").pop();  //이미지 파일명
                var fileExt = fileName.substring(fileName.lastIndexOf(".")+1); // 확장자 추출
                fileExt = fileExt.toLowerCase(); //소문자 변환

                if(fileExt != "jpg" && fileExt != "jpeg" && fileExt != "gif" && fileExt != "png" && fileExt != "bmp"){
                    alert("이미지 파일만 등록이 가능합니다.");
                    return;
                }

                $(this).siblings(".custom-file-label").html(fileName);
            });
        }

    </script>
    
    
<script src="/js/board.js"></script>    
<%@ include file="../layout/footer.jsp" %>  