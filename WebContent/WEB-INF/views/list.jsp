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

<title>Narrow Jumbotron Template for Bootstrap</title>

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
        <h1>글을 남겨주세요.</h1>
			<form method="post" action="write">
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
					이름
				</div>
				<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
					<input type="text" name="name" class="form-control">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
					내용
				</div>	
				<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
				<textarea name="content" rows="6" class="form-control"></textarea>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-offset-9 col-md-offset-9 col-sm-offset-9 col-lg-3 col-md-3 col-sm-3 col-xs-12">
					<input type="submit" value="확인" class="btn btn-default">
				</div>
			</div>
			</form>
		</div>
		
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		count : ${count} , page수 : ${pageCount }
			</div>
		</div>


		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

<c:forEach items="${list}" var="guest">
<c:if test="${sessionScope.login == 'OK' }">
<a href="delete?id=${guest.id}">삭제</a>
</c:if>
${guest.id } - ${guest.name } <br>
		<pre>
${guest.content }
</pre>
${guest.ip }<br>
${guest.createDate }
</c:forEach>
			</div>
		</div>

	<!-- 끝. -->
	</div>
</body>
</html>