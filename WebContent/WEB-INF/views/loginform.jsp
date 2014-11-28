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

<title>방명록 관리자 로그인</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/jumbotron-narrow.css" rel="stylesheet">

</head>

<body>
	<div class="container">
		<div class="jumbotron" style="height: 350px;">
			<h1 style="margin-bottom: 70px;">관리자 로그인 화면</h1>
			<form method="post" action="login">
				암호 : <input type="password" name="password"> <input
					type="submit" value="확인">
			</form>
		</div>
	</div>
</body>
</html>