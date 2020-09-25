<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 </title>
</head>
<body>
<c:if test="${result >0 }">
	<script type="text/javascript">
	alert("회원탈퇴 되었습니다");
	location.href="main.do";
	</script>
	</c:if>
<c:if test="${result <= 0 }">
	<script type="text/javascript">
	alert("회원탈퇴가 안되었습니다. 다시해주세요");
	history.go(-1);
	</script>
	</c:if>
</body>
</html>