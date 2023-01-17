<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container cont-height">
<h2 class="border-bottom pb-4"> 회원가입</h2>
	<form>
	
		<div class="mb-4 mt-4">
			<label for="username" class="form-label">이름</label> <input type="text"
				class="form-input" placeholder="이름을 입력해주세요." id="username" lang="en">
		</div>
		
		<div class="mb-4 mt-4">
			<label for="password" class="form-label">비밀번호 </label> 
			<input type="password"
				class="form-input" placeholder="비밀번호를 입력해주세요." id="password" >
		</div>
		
		<div class="mb-4 mt-4">
			<label for="email" class="form-label" >이메일</label> <input type="email"
				class="form-input" placeholder="이메일을 입력해주세요." id="email" lang="en">
		</div>

	</form>
	
	<button id="btn-save" class="btn btn-dark">회원가입완료 </button>
	

</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>