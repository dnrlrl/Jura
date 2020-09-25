<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="sessionChk.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제완료</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
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

.view_type li {
	list-style: none;
	padding: 50px;
}

input[type="text"] {
	height: 50px;
	width: 60% !important;
	margin-left: auto;
	margin-right: auto;
}
</style>
<script type="text/javascript" src="/jura2/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$('.footer').load('footer.do');
	});
</script>
<jsp:include page="../../com/header2.jsp"></jsp:include>
<body>
	<div class="wrap">
		<h1>주문 완료</h1>
		<div class="view_type">

			<div id="contact_form_container">

				<form id="contact_form" method="post" action="ordered.do">
					<table>
						<tbody>
							<div class="list_area">
								<ul class="list">
									<li class="text"><input type="text"
										value="총금액 : ${orders.o_price }" class="cost input_field"
										readonly="readonly"> <c:forEach var="odlist"
											items="${orderlist}">
											<input type="hidden" name="c_id" value="${c_id }">
											<input type="hidden" name="anum" value="${anum }">
											<input type="text" value="메뉴명 : ${orders.o_price }"
												class="menuname input_field" readonly="readonly">
											<input type="text" value="수량 : ${count }"
												class="count input_field" readonly="readonly">

										</c:forEach> <input type="text" value="배달 주소 : ${orders.o_add} "
										class="oderadd input_field" readonly="readonly"> <input
										type="text" value="결제 방법 : ${orders.o_how} "
										class="oderhow input_field" readonly="readonly"></li>
								</ul>
							</div>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>

	<div class="footer" style="vertical-align: bottom; width: 100%;"></div>
</body>
</html>