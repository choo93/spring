<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
</head>
<body>

	<!-- model 객체에 담은 것은 바로 key값으로 사용됨 -->
	<%-- 
	ModelAndView view = new ModelAndView();
	ex) model.addObject("mem",m);
	-> 사용시 ${mem.name} --%>

	<!-- request로 써도 됨 -->
	<h3>회원 정보</h3>
	<form action="mUpdate.do" method="post">
		아이디 : <input type="text" name="userId" value="${mem.userId }" readonly><br>
		비밀번호 : <input type="password" name="userPw" value="${mem.userPw }"> <br>
		비밀번호 확인 : <input type="password" name="userPw_re" value="${mem.userPw }"> <br>
		이름 : <input type="text" name="userName" value="${mem.userName }" readonly><br>
		폰번호 : <input type="text" name="userPhone" value="${mem.userPhone }"><br> 
		<input type="submit" value="회원정보 변경">
	</form>
	<button onclick="back();">뒤로 가기</button>
	<script type="text/javascript">
		function back(){
			location.href = "/index.jsp";
		}
	</script>

</body>
</html>