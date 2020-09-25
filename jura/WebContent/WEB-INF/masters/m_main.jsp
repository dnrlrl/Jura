<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="m_sessionChk.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 화면</title>
<link rel="stylesheet" href="assets/css/main.css" />
<style type="text/css">
p {
	text-align: center;
	font-size: 35px;
	font-family: fantasy;
	margin-top: 170px;
}
button {
	text-align : center;
	font-size : 22px;
	margin-left: 20px;
	margin-right: 20px;
	font-family: fantasy;
}
</style>
</head>
<body>
	<p> </p>
	<p>JURA &nbsp;&nbsp; 관리자페이지</p>

<p><button onclick="location.href='m_customerList.action'" style="WIDTH: 150pt; HEIGHT: 100pt">회원관리</button>

<button onclick="location.href='m_shopList.action'" style="WIDTH: 150pt; HEIGHT: 100pt">식당관리</button>
<button onclick="location.href='main.do'" style="WIDTH: 150pt; HEIGHT: 100pt">JURA홈</button>

</p>
</body>
</html>