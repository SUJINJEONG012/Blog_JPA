<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- 로그인이 됐다면 -->
<sec:authorize access="isAuthenticated()">
<!-- 로그인이 됐다면 -->
<sec:authentication property="principal" var="principal"/>
</sec:authorize>



<!DOCTYPE html>
<html lang="en">
<head>
<title>스프링부트JPA BLOG만들기</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">


<!--인터프리터 언어  자바스크립트는  -->

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

</head>


<body>



	<header>

		<nav class="navbar navbar-expand-md bg-dark navbar-dark">
			<a class="navbar-brand" href="/">Angela</a>
			
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">

				<c:choose>
					<c:when test="${empty principal}">
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link"
								href="/auth/loginForm">로그인</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/auth/joinForm">회원가입</a></li>
						</ul>
					</c:when>

					<c:otherwise>
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link"
								href="/board/form">글쓰기</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/user/form">회원정보</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/logout">로그아웃</a></li>
						</ul>
					</c:otherwise>
					
				</c:choose>



			</div>
		</nav>
	</header>