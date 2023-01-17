<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container cont-height">

    <h2 class="border-bottom pb-4"> 회원정보</h2>
	
	
	<form>
	   <!-- 어떤회원이 수정하는지 모르니깐hidden값 넣어주기 -->
	    <input type="hidden" id="id" value="${principal.user.id}" />
	   
		<div class="mb-4 mt-4">
			<label for="username" class="form-label">이름 </label> <input type="text"			
				class="form-input" value="${principal.user.username}" id="username" lang="en" readonly>
		</div>
		
		<div class="mb-4 mt-4">
			<label for="password" class="form-label">비밀번호 </label> 
			<input type="password"
				class="form-input" id="password">
		</div>
		
		
		<div class="mb-4 mt-4">
			<label for="email">이메일 :</label> <input type="email"
				class="form-input" value="${principal.user.email}" id="email" lang="en">
		</div>

	</form>
	
	<button id="btn-update" class="btn btn-dark">회원정보 수정하기 </button>
	

</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>