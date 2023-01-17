<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container cont-height">
<h2 class="border-bottom pb-4">로그인</h2>
	<form action="/auth/loginProc" method="post">
		
		
		<div class="mb-4 mt-4">
            <label for="username" class="form-label" lang="ko">사용자 이름</label>
            <input type="text" class="form-input" id="username" placeholder="Enter username" name="username" value="" lang="en">
        </div>
        
        
		
		
		<div class="mb-4 mt-4">
			<label for="password" class="form-label" lang="ko">비밀번호</label> 
			<input type="password"
				class="form-input" placeholder="Enter password" name="password" value="" lang="en">
		</div>
		
		<!-- <div class="form-group form-check">
			<label class="form-check-label"> <input name="remember"
				class="form-check-input" type="checkbox"> Remember me
			</label>
		</div> -->
		
	
		
		<div class="btn-wrap d-flex">
        <button class="black-button me-2" id="btn-login" type="submit">로그인</button>
        <div> 
        <a href="https://kauth.kakao.com/oauth/authorize?client_id=c90bfc7a8183f140bc7ddd9aa5ac4134&redirect_uri=http://localhost:8010/auth/kakao/callback&response_type=code">
        <img src="/images/kakao_login_button.png" alt="kakao login button" style="width:50%">
        </a>
		</div>
      
        </div>
        
        
		
	</form>

</div>
<!-- <script src="/js/user.js"></script> -->
<%@ include file="../layout/footer.jsp"%><head>
