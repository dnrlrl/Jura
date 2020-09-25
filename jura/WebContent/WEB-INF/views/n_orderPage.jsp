<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="sessionChk.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제하기</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
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
	height: 70%;
}

.wrap h1 {
	/* padding: 10px 0 4px; */
	border-bottom: 1px solid #aaa;
	text-align: center;
	padding-top: 50px;
	padding-bottom: 30px;
}

</style>
<script type="text/javascript" src="/jura2/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$('.footer').load('footer.do');
	});
</script>
<script type="text/javascript">
	var f= 0;
	function ckeck(){
		if(frm.address.value==null||frm.address.value==""){
			alert("주소를 적어주세요");
			return false;
		}
		if(frm.how.value==null||frm.how.value==""){
			alert("결제 방법을 선택해주세요");
			return false;
		}
	}
</script>
</head>
<jsp:include page="../../com/header2.jsp"></jsp:include>
<body>

<div class="wrap">
<h1>결제 확인</h1>
<form action="ordered.do" name="frm" method="post" onsubmit="return ckeck()">
<input type="hidden" name="ordernum" value="${ordernum }">
<input type="hidden" name="orderlist" value="${orderlist }">
<input type="hidden" name="ol_price" value="${ol_price }">
<input type="hidden" name="anum" value="${anum }">
<%-- <div style="text-align: center;">
<img src="${path }/m_img/${m_img}" width="300">
</div> --%>
<table>
	<c:forEach var="odlist" items="${orderlist}">
	<input type="hidden" name="c_id" value="${c_id }">
	<!-- o_num값 hidden -->
		<tr><td>메뉴명 : &nbsp;  ${odlist.olm_name}</td><td>수량: ${odlist.count }</td></tr>
	</c:forEach>
	<!--  &nbsp;  띄어쓰기 -->
	<tr><td>총금액 : &nbsp;  ${ol_price}</td></tr>
	<tr><td>주문 주소 : &nbsp; ${cadd } </td><td><input type="text" name="address"></td></tr>
	<tr><td><input type="radio" name="how" id="n1" value="현금" style="display: none;">
		<label for="n1">현금</label>
		<input type="radio" name="how" id="n2" value="카드" style="display: none;">
		<label for="n2">카드</label></td>
		<td><input type="submit" value="결제" >
		<input type="button" value="취소" onclick="location.href='ordercancel.do?ordernum=${ordernum}&anum=${anum }&s_id=${s_id }'"></td></tr>
</table>
</form>
	</div>
	<div class="footer" style="vertical-align: bottom; width:100%;"></div>
</body>
</html>