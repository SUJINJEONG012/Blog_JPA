let index = {
	init: function() {
		$("#btn-save").on("click", () => { //function를 사용하지않은 이유는 this를 바인딩하기 위해서
			this.save();
		});
		//회원정보 수정하기 
		$("#btn-update").on("click", ()=>{
			this.update();
		})
		
	},
	
	save: function() {
		// alert("user의 save 할수있음 ");
		let data = {
			username:$("#username").val(), //username이 들고있는값을변수에다가 바인딩을 한다. 
			password:$("#password").val(),
			email:$("#email").val()
		};
		//console.log(data);
		
		
		//ajax호출시 default가 비동기호출 
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경해서 insert 요청
		$.ajax({
		type:"POST",
		url:"/auth/joinProc", //맵핑되는 주소랑 동일
		data:JSON.stringify(data), 
		contentType:"application/json; charset=utf-8", //body 데이터가 어떤 타입 인지 
		dataType:"json" //요청을 서버로 해서 응답이 왔을 때 기본적으로 모든것이 문자열("json이라면 ?")
		//회원가입 수행 요청 
		}).done(function(resp){
			alert("회원가입이 완료되었습니다. ");
			console.log(resp);
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
		
	},	
	
	
	update : function(){
		/*
		username은 수정 안 할거니까 username 없이,
		hidden으로 넣어준 아이디와 비밀번호와 이메일만 받으면 된다.
		*/ 
	
		let data = {
			id : $("#id").val(), //어떤회원이 수정했는지 확인하기 위해서
			username: $("#username").val(),
			password: $("#password").val(), //패스워드받
			email: $("#email").val() //이메일받기
		};
		$.ajax({
			type:"PUT",
			url:"/user",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp){
			console.log("dd????")
			alert("회원수정이 완료되었습니다.");
			location.href="/"
		}).fail(function(error){
			alert(JSON.stringify(error))
		})	
	},
	
}

index.init();
