<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="sessionChk.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴선택</title>
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
}

.wrap h1 {
	/* padding: 10px 0 4px; */
	
	border-bottom: 1px solid #aaa;
	text-align: center;
	padding-top: 50px;
	padding-bottom: 30px;
}
input[type="number"]{
	width:100px !important;
}

.manu_content{
	padding: 40px;
}
.od_button_content{
	display: table;
	MARGIN-LEFT: AUTO;
    MARGIN-RIGHT: AUTO;
    padding-top:25px;
    table-layout: fixed;
}
.od_button{
display: table-cell;
vertical-align: baseline;
margin-left: auto;
margin-right: auto;
}
</style>
<script type="text/javascript" src="/jura2/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$('#footer').load('footer.do');
	});
</script>
<script type="text/javascript">
	function go(){
		var len=document.frm.size.value;
		var f=0;
		for(var i=0;i<len;i++){
			var n = '#a'+i;
			var c=$(n).val();
			if(c!=0)
				f=1;
		}
		if(f==0){
			alert("메뉴를 하나 이상 주문해주세요");
			return false;
		}
	}
</script>
</head>
<jsp:include page="../../com/header2.jsp"></jsp:include>
<body>
<div class="wrap">
<h1 align="center">메뉴</h1>
<c:if test="${empty list }">
		<tr><th>등록된 메뉴가 없습니다.</th>
</c:if>
<div class="manu_content">
<form action="N_orderPage.do" name="frm" method="post" onsubmit="return go()">
	<table>
		<c:if test="${not empty list }">
		<input type="hidden" name="s_id" value="${list[0].s_id }">
		<input type="hidden" name="size" value="${fn:length(list)}">
		<input type="hidden" name="anum" value="${anum}">
		<c:forEach var="menu" items="${list }" varStatus="sta">
					<input type="hidden" name="mn${sta.index }" value="${menu.m_num}">
			<input type="hidden" name="price${sta.index}" value="${menu.m_price }">
			<input type="hidden" name="name${sta.index}" value="${menu.m_name }">
				<tr><td><img alt="" src="${path }/m_img/${menu.m_img }" width="350" height="300"></td>
				<td>${menu.m_name } </td>
				<td>${menu.m_price }</td>
				<td><input type="number" min="0" id="a${sta.index}" name="a${sta.index}" value="0"></td>
				</tr>
		</c:forEach>
		</c:if>
		<tr><th><td>주소: ${sadd }</td></th></tr>
	</table>
	<p></p>
		<div class="od_button_content">
		<div class="od_button">
		<input type="submit" value="주문" >
		</div>
		</div>

</form>
	</div>
	</div>
<div id="footer" style="vertical-align: bottom; width:100%;"></div>
</body>
</html>