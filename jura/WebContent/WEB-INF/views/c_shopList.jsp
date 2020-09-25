<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="sessionChk.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
@charset "UTF-8";

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
}
</style>
<link rel="stylesheet" href="assets/css/main.css" />
<script type="text/javascript" src="/jura2/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$('#footer').load('footer.do');
	});
</script>
<title>식당 종류</title>
</head>
	<jsp:include page="../../com/header2.jsp"></jsp:include>
	<jsp:include page="../../com/menubar.jsp"></jsp:include>
<body>
	<div class="wrap">
	<form action="c_shopList.do">
		<input type="hidden" name="anum" value="${anum}">
		<table>
			<tr>
				<td><jsp:include page="${type}.jsp">
						<jsp:param name="list" value="${list}" />
						<jsp:param name="anum" value="${anum}" />
					</jsp:include></td>
			</tr>
		</table>
	</form>
		
</div>
<div id="footer" style="vertical-align: bottom; width:100%;"></div>
</body>
</html>