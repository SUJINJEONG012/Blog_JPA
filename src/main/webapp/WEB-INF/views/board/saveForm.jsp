<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>

<div class="container cont-height">

<h2 class="border-bottom pb-4">글쓰기</h2>
<form action="/api/board" method="post" enctype="multipart/form-data" id="boardForm">
		
		
		<div class="mb-4 mt-4">
			<label for="title" class="form-label">제목 </label> 
			<input type="text" class="form-control" placeholder="제목을 입력해주세요." id="title" name="title" >
		</div>
		
		<div class="mb-4 mt-4">
			<label for="content" class="form-label">내용</label> 
			<textarea class="form-control summernote" rows="5" cols="" id="content" name="content"></textarea>
		</div>
		
		<div class="mb-4 mt-4">
			<label for="file" class="form-label">파일첨부</label> 
			<input type="file" class="form-control" placeholder="Enter title" id="file" name="file" >
		</div>
	
       
	
	</form>
		
	<button id="btn-save" class="btn btn-dark">글쓰기</button>
		
	
</div>

    
 <script>
<<<<<<< HEAD
     /*  $('.summernote').summernote({  
        tabsize: 2,
        height: 300
      }); */
      $(function(){
    	  $('.summernote').summernote({ 
    	    placeholder: '내용',
    	    tabsize: 2,
    	    focus: true,
    	    callbacks:{
    	      // onImageUpload를 통해 이미지 업로드시 동작 개조 가능
    	      // 개조하지 않으면 Base64로 이미지가 전환돼서 img태그로 바뀐뒤 본문에 추가된다.
    	      onImageUpload: function(files){
    	        sendFile(files[0], this);
    	      }
    	    }
    	  });
    	});
      
      function sendFile(file, editor){
    	  data = new FormData()
    	  data.append("img", file)
    	  // id 'img'로 file form 데이터 추가
    	  $.ajax({
    	    data: data,
    	    type: "POST",
    	    // 이미지 처리를 할 url
    	    url: "/api/board",
    	    cache: false,
    	    contentType: false,
    	    // multer-s3를 활용하므로 multipart/form-data형태로 넘겨줘야 한다.
    	    enctype: "multipart/form-data",
    	    processData: false,
    	    success: function (response) {
    	      var imgurl = $('<img>').attr({
    	        'src': response,
    	        // json형태로 반환되는 주소.
    	        'crossorigin': 'anonymous',
    	        // crossorigin attr을 삽입하지 않으면 CORS에러가 난다!
    	    });
    	      $("#summernote").summernote("insertNode", imgurl[0]);
    	      // insertNode는 html tag를 summernote 내부에 삽입해주는 기능.
    	    },
    	  })
    	}


     $('.summernote').summernote({  
        tabsize: 2,
        height: 300
      }); 
    
 </script>
 

<script src="/js/board.js"></script>    
<%@ include file="../layout/footer.jsp" %>  