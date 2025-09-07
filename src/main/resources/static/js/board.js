let index = {
	
	
	init: function() {
		
	
		document.getElementById("btn-save").addEventListener("click", ()=>{
			this.save();
		});
	
		$("#btn-update").on("click", () => {
			this.update();
		})

		$("#btn-delete").on("click", () => {
			this.deleteById();
		});
		$("#btn-reply-save").on("click", () => {
			this.replySave();
		});


	},

	/*save: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
			
		};

		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("글쓰기가 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	},
	*/
	/*save: function(){
		let form = $("#boardForm")[0]; //form DOM객체
		let formData = new FormData(form);
		$.ajax({
			type:"POST",
			url:"/api/board",
			data:formData,
			processData: false,
			contentType:false,
			
			success: function(resp){
				alert("글쓰기가 완료되었습니다." );
				location.href = "/";
			},
			error: function(error){
				alert(JSON.stringify(error));
			}
		});
 	},*/
	
	// async로 변환
	save: async function() {
	       const form = document.querySelector("#boardForm");
	       const formData = new FormData(form);

	       try {
	           const response = await fetch("/api/board", {
	               method: "POST",
	               body: formData // content-type은 fetch가 자동으로 multipart/form-data로 설정
	           });

	           if (!response.ok) throw new Error("글쓰기 실패");
	           const data = await response.json();
	           alert("글쓰기가 완료되었습니다.");
	           location.href = "/";
	       } catch (error) {
	           alert(error.message);
	       }
	   },

      

	update: function() {

		let id = $("#id").val(); //아이디값 가져오기
		let form = $("#boardForm")[0]; 
		let formData = new FormData(form);

		/* 여기부분은 데이터만 전달, 이미지를 수정할거면 이건 삭제해도 됌
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};*/

		$.ajax({
			type: "PUT",// 수정
			url: "/api/board/" + id,
			data: formData,
			//설정하지않으면 true값으로 되는데 데이터 폼이나 url 인코딩된 문자열이 아니면 데이터가 제대로 전송되지않거나 오류가 날 수 있음. 
			processData: false,
			contentType: false,
			dataType: "json"
		}).done(function(resp) {
			alert("글수정이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	},

	deleteById: function() {
		let id = $("#id").text();
		$.ajax({
			type: "DELETE",
			url: "/api/board/" + id,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("삭제가 완료되었슴니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	},


	replySave: function() {
		let data = {
			userId: $("#userId").val(),
			boardId: $("#boardId").val(),
			content: $("#reply-content").val()
		};

		console.log(data);

		$.ajax({
			type: "POST",
			url: `/api/board/${data.boardId}/reply`,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("댓글 작성이 정상적으로 등록되었습니다.");
			location.href = `/board/${data.boardId}`;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},

	replyDelete: function(boardId, replyId) {

		$.ajax({
			type: "DELETE",
			url: `/api/board/${boardId}/reply/${replyId}`,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("댓글삭제가 완료되었슴니다.");
			location.href = `/board/${boardId}`;
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});

	},





}

index.init();