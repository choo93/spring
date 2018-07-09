<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕</h1>
	<c:choose>
		<c:when test="${sessionScope.member == null }">
			<form action="/login.do">
				ID : <input type="text" name="userId"><br> PW : <input
					type="password" name="userPw"><br> <input
					type="submit" value="로그인">
			</form>
			<a href="/enrollPage.do">회원 가입</a>
		</c:when>
		<c:otherwise>
			<h1>[${sessionScope.member.userId }]님 환영합니다.</h1><br>
			<a href="/logout.do">로그아웃</a><br>
			<a href="/myInfo.do">마이페이지</a><br>
			<a href="/delete.do">회원 탈퇴</a>
			<c:if test="${sessionScope.member.userId=='admin' }">
				<br><a href="/showAll.do">회원 전체 조회</a>
			</c:if>
		</c:otherwise>
	</c:choose>

</body>
</html>