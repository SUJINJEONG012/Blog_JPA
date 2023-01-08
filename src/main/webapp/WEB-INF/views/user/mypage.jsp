<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form>
	
	
	   <!-- 어떤회원이 수정하는지 모르니깐hidden값 넣어주기 -->
	    <input type="hidden" id="id" value="${principal.user.id}" />
	   
		<div class="form-group">
			<label for="username">이름 :</label> <input type="text"			
				class="form-control" value="${principal.user.username}"  id="username" readonly>
		</div>
		
		<div class="form-group">
			<label for=password>비밀번호 </label> <input type="password"
				class="form-control" id="password">
		</div>
		
		
		<div class="form-group">
			<label for="email">이메일 :</label> <input type="email"
				class="form-control" value="${principal.user.email}" id="email">
		</div>

	</form>
	
	<button id="btn-update" class="btn btn-dark">회원정보 수정하기 </button>
	

</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>