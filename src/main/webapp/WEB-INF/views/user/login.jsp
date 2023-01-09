<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">username:</label> <input type="text" 
				class="form-control" placeholder="Enter username" name="username" >
		</div>
		
		
		<div class="form-group">
			<label for="password">password</label> <input type="password"
				class="form-control" placeholder="Enter password" name="password">
		</div>
		
		<!-- <div class="form-group form-check">
			<label class="form-check-label"> <input name="remember"
				class="form-check-input" type="checkbox"> Remember me
			</label>
		</div> -->
		
		<button id="btn-login" class="btn btn-primary">로그인 </button>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=c90bfc7a8183f140bc7ddd9aa5ac4134&redirect_uri=http://localhost:8010/auth/kakao/callback&response_type=code"><img src="/images/kakao_login_button.png" alt="kakao login button"></a>
		
	</form>

</div>
<!-- <script src="/js/user.js"></script> -->
<%@ include file="../layout/footer.jsp"%><head>
