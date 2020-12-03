<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>join 페이지</h1>
<hr>
<form action="/joinProc" method="post">
	<input type="text" name="username" placeholder="아이디"/><br/><br/>
	<input type="password" name="password" placeholder="비밀번호"/><br/><br/>
	<input type="email" name="email" placeholder="이메일"/><br/><br/>
	<button>회원가입</button>
</form>
</body>
</html>