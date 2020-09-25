<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="sessionChk.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<link rel="stylesheet" href="assets/css/main.css" />
<style type="text/css">


@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);

html, body {
	width: 100%;
	height: 100%;
}

body, p, h1, h3, h4, h5, h6, ul, ol, li, dl, dt, dd, table, th, td, form,
	fieldset, legend, input, textarea, button, select {
	margin: 0;
	padding: 0;
}

body, input, textarea, select, button, table {
	font-family: 'Nanum Gothic', sans-serif;
	font-size: 16px;
}

img, fieldset {
	
	border: 0;
}

ul, ol {
	list-style: none;
}

em, address {
	font-style: normal;
}

a {
	text-decoration: none;
}

.wrap {
	
	width: 80%;
	margin: 0 auto;
	font-family: 'Nanum Gothic', sans-serif;
	margin: 0 auto;
}

.wrap h1 {
	/* padding: 10px 0 4px; */
	border-bottom: 1px solid #aaa;
	text-align: center;
	padding-top: 50px;
	padding-bottom: 30px;
}
div {
	display: block;
	position: relative;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	text-align: center;
	width: 100%;
	margin: auto;
}
</style>
<script type="text/javascript" src="/jura2/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$('#footer').load('footer.do');
	});
</script>
</head>
<jsp:include page="../../com/header2.jsp"></jsp:include>
<body>
<div class="wrap">
<h1>회원정보</h1>
<form action="update.do" name="frm">
<input type="hidden" name="cpass" value="${customer.c_pass }">
<input type="hidden" name="id" value="${customer.c_id }">
<input type="hidden" name="anum" value="${anum}">
	<table align="center">
		<tr><th>아이디</th><td>${customer.c_id }</td><td></td></tr>
		<tr><th>현재암호</th><td><input type="password" name="pass"></td><td></td></tr>
		<tr><th>변경할 암호</th><td><input type="password" name="uppassword"></td><td></td></tr>
		<tr><th>이름</th><td><input type="text" name="name" value="${customer.c_name }"></td><td></td></tr>
		<tr><th>주소</th><td>
	<select name="addnum">
	<c:if test="${customer.add_num==1}">
		<option value="1" selected>상암동,성산 1동,성산 2동,망원 1동,망원 2동</option>
	</c:if>
	<c:if test="${customer.add_num!=1}">
		<option value="1">상암동,성산 1동,성산 2동,망원 1동,망원 2동</option>
	</c:if>
	<c:if test="${customer.add_num==2}">
		<option value="2" selected>연남동,서교동,합정동,서강동</option>
	</c:if>
	<c:if test="${customer.add_num!=2}">
		<option value="2">연남동,서교동,합정동,서강동</option>
	</c:if>
	<c:if test="${customer.add_num==3}">
		<option value="3" selected>대흥동,신수동,염리동,용강동,아현동,공덕동,도화동</option>
	</c:if>
	<c:if test="${customer.add_num!=3}">
		<option value="3">대흥동,신수동,염리동,용강동,아현동,공덕동,도화동</option>
	</c:if>
	</select><td></td>
		<tr><th>주소</th><td><input type="text" name="address" value="${customer.c_address }"></td><td></td></tr>
		<tr><th>전화</th><td><input type="tel" name="tel" required="required" pattern="\d{3}-\d{3,4}-\d{4}" placeholder="xxx-xxx-xxxx" title="전화번호 형식 xxx-xxxx-xxxx-" value="${customer.c_tel }"></td><td></td></tr>
		<tr>
		<td colspan="2" align="right">
		<input type="button" onclick="location.href='ordercheck.do?anum=${anum}'" value="주문내역확인">
		<input type="submit" value="수정">
		<input type="button" onclick="location.href='cusdel.do?c_id=${customer.c_id}'" value="회원탈퇴">
		</td>
		</tr>
	</table>
</form>
</div>
<div id="footer" style="vertical-align:bottom;width:100%;"></div>	
</body>
</html>