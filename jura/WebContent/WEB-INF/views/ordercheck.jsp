<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="sessionChk.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역 확인</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<script type="text/javascript" src="/jura2/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$('#footer').load('footer.do');
	});
</script>
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

.ordered_form_container {
	padding-top: 74px;
	padding-left: 98px;
	padding-right: 98px;
	padding-bottom: 88px;
	width: 100%;
}

.input_field {
	border: none;
	outline: none;
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

.img_list {
	width: 100%;
	height: 600px;
}

input[type="text"] {
	height: 50px;
	width: 500px !important;
}

.ordered_form {
	margin-top: 52px;
	font-size: 0px;
	width: 100%;
	margin-top: 11px;
}

.view_type img {
	margin: 20px 10px 0 0;
}

.view_type li a {
	display: block;
}

.view_type li a .thumb {
	position: relative;
	display: block;
	height: 100%;
	text-align: center;
	line-height: 100%;
}

.view_type li a .thumb p {
	dispaly: none;
	position: absolute;
	left: 10;
	top: 0;
	width: 100%;
	height: 100%;
	text-align: center;
	line-height: 100%;
}

.view_type ul {
    border: 1px;
    padding-bottom: 30px;
    zoom: 1;
    height: 300px;
    text-align: center;
    width: auto;
    display: table;
    margin-left: auto;
    margin-right: auto;
}

.view_type li {
	float: left;
	width: auto;
	height: auto;
	border: 5px;
	padding: 5px;
	margin-bottom: 10px;
}

.view_type {
	display: table;
	margin-left: auto;
	margin-right: auto;
	table-layout: fixed;
}

.ordered_form_container {
	display: table-cell;
	vertical-align: baseline;
	margin-left: auto;
	margin-right: auto;
} 
</style>

</head>
<jsp:include page="../../com/header2.jsp"></jsp:include>
<body>
	<div class="wrap">
		<h1>주문 내역</h1>
		<div class="view_type">
		<c:set var="index" value="${fn:length(imlist)}"></c:set>
			<div class="ordered_title"></div>
			<div class="ordered_form_container">
				<form action="#" id="ordered_form" class="ordered_form">
					<table>
						<tbody>
							<c:if test="${empty list}">
								주문이력이 없습니다.
							</c:if>
							<c:if test="${not empty list }">
								<c:forEach var="order" items="${list }">
									<c:if test="${order.o_how != null }">
										<c:forEach var="im" begin="0" end="${index}">
											<c:if test="${order.o_num == imlist[im].o_num}">
												<c:set var="va" value="${imlist[im].s_img }"></c:set>
											</c:if>
										</c:forEach>
										<div class="list_area">
											<ul class="img_list" id="p">
												<li><span class="thumb">
												<a href="#" title="img">
													<img alt="" src="${path}/s_img/${va}" width="100" height="100">
												</a></span></li>
												<li class="input"><input type="text"
													value="배달주소 : ${order.o_add }" class="oderadd input_field"
													readonly="readonly"> <input type="text"
													value="결제방법 : ${order.o_how }" class="oderhow input_field"
													readonly="readonly"> <input type="text"
													value="주문날짜 : ${order.o_date }"
													class="oderdate input_field" readonly="readonly"> <input
													type="text" value="주문금액 : ${order.o_price }"
													class="oderprice input_field" readonly="readonly">
													<input type="text" value="주문상태 : ${order.o_sta }"
													class="oderready input_field" readonly="readonly"></li>
											</ul>
										</div>
									</c:if>
								</c:forEach>
								<p>
							</c:if>
						</tbody>
					</table>
				</form>
			</div>
		</div>

	</div>
<div id="footer" style="vertical-align: bottom; width: 100%;"></div>
</body>
</html>