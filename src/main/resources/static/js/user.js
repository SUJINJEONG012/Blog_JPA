let index = {
	init: function() {
		$("#btn-save").on("click", () => { //function를 사용하지않은 이유는 this를 바인딩하기 위해서
			this.save();
		});
		
		$("#btn-login").on("click", () => { //function를 사용하지않은 이유는 this를 바인딩하기 위해서
			this.login();
		});
	},
	
	save: function() {
		// alert("user의 svae할수있음 ");
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
		url:"/api/user", //맵핑되는 주소랑 동일
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
		login: function() {
		// alert("user의 svae할수있음 ");
		let data = {
			username:$("#username").val(), //username이 들고있는값을변수에다가 바인딩을 한다. 
			password:$("#password").val(),
			
		};
		
	$.ajax({
		type:"POST",
		url:"/api/user/login", //맵핑되는 주소랑 동일
		data:JSON.stringify(data), 
		contentType:"application/json; charset=utf-8", //body 데이터가 어떤 타입 인지 
		dataType:"json" //요청을 서버로 해서 응답이 왔을 때 기본적으로 모든것이 문자열("json이라면 ?")
		//회원가입 수행 요청 
		}).done(function(resp){
			alert("로그인이 완료되었습니다. ");
			console.log(resp);
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
		
	}
}

index.init();
