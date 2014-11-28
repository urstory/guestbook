<%@page import="java.util.List"%>
<%@page import="guestbook.Guestbook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>방명록 글쓰기</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script>
$(document).ready(function() {  
	$("input#name").focus();  
	
	$("form#guestbookForm").bind("submit", function () {  
		if ($("input#name").val().trim() == "") {  
			   alert("이름을 입력해 주세요.");  
			   $("input#name").focus();  
			   return false;  
		}  		

		if ($("input#content").val().trim() == "") {  
			   alert("내용을 입력해 주세요.");  
			   $("input#content").focus();  
			   return false;  
		}  		

		return true;
	});
});
</script>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/jumbotron-narrow.css" rel="stylesheet">

</head>

<body>
	<div class="container">
		<div class="header">
			<ul class="nav nav-pills pull-right">
				<li class="active"><a href="/list">Home</a></li>
				<c:if test="${sessionScope.login != 'OK' }">
				<li><a href="/loginform">로그인</a></li>
				</c:if>
				<c:if test="${sessionScope.login == 'OK' }">
				<li><a href="/logout">로그아웃</a></li>
				</c:if>
			</ul>
			<h3 class="text-muted">Guestbook</h3>
		</div>
		
	  <div class="jumbotron">
        <h1 style="margin-bottom: 30px;">글을 남겨주세요.</h1>
			<form method="post" action="write" id="guestbookForm">
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
					이름
				</div>
				<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
					<input type="text" name="name" class="form-control" id="name">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
					내용
				</div>	
				<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
				<textarea name="content" rows="6" class="form-control" id="content"></textarea>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-offset-9 col-md-offset-9 col-sm-offset-9 col-lg-3 col-md-3 col-sm-3 col-xs-12" style="margin-top: 20px;">
					<input type="submit" value="확인" class="btn btn-default">
				</div>
			</div>
			</form>
		</div>
		
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-bottom: 30px;">
		count : ${count} , page수 : ${pageCount }
			</div>
		</div>


		
<c:forEach items="${list}" var="guest">
<div class="panel panel-default">
	 <div class="panel-body">
		<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="margin-bottom: 30px;">
					작성자 : ${guest.name }
						<c:if test="${sessionScope.login == 'OK' }">
						<a href="delete?id=${guest.id}">삭제</a>
						</c:if>
					</div>
		</div>			
		<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<pre style="padding-top: 30px;padding-bottom: 30px;padding-left: 10px;padding-right: 10px;">${guest.content }</pre>
					</div>
		</div>
		<div class="row" style="margin-top: 20px;">
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
					등록 ip : ${guest.ip }
					</div>
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
					작성일 : ${guest.createDate }
					</div>
		</div>
	</div>
</div>

<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<br>
			</div>
</div>
</c:forEach>

<!-- page -->
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-10 col-sm-offset-2 col-lg-8 col-lg-offset-4">
				<c:url var="firstUrl" value="/list?pg=1" />
				<c:url var="lastUrl" value="/list?pg=${pageCount}" />
				<c:url var="prevUrl" value="/list?pg=${currentIndex - 1}" />
				<c:url var="nextUrl" value="/list?pg=${currentIndex + 1}" />
				<ul class="pagination">
					<c:choose>
						<c:when test="${currentIndex == 1}">
							<li class="disabled"><a href="#">&lt;&lt;</a></li>
							<li class="disabled"><a href="#">&lt;</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${firstUrl}">&lt;&lt;</a></li>
							<li><a href="${prevUrl}">&lt;</a></li>
						</c:otherwise>
					</c:choose>
					<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
						<c:url var="pageUrl" value="/list?pg=${i}" />
						<c:choose>
							<c:when test="${i == currentIndex}">
								<li class="active"><a href="${pageUrl}"><c:out
											value="${i}" /></a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${currentIndex == pageCount}">
							<li class="disabled"><a href="#">&gt;</a></li>
							<li class="disabled"><a href="#">&gt;&gt;</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${nextUrl}">&gt;</a></li>
							<li><a href="${lastUrl}">&gt;&gt;</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
	<!-- 끝. -->
	</div>
</body>
</html>