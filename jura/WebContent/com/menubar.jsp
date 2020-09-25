<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="com/styles.css">
<style type="text/css">
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<script src="com/script.js"></script>
<title></title>
</head>
<body>
<div id="menubar" style="width: 100%">
<form action="c_shopList.do">
		<input type="hidden" name="anum" value="${anum}">
	
	<div id="cssmenu">
		<div id="menu-line" style="width: 136px; left: 75;"></div>
		<div id="menu-button">Menu</div>
		<ul>
			<li><a href="c_shopList.do?n_type=한식&anum=${param.anum}">&nbsp;&nbsp;&nbsp;&nbsp;한식&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
			<li><a href="c_shopList.do?n_type=중식&anum=${param.anum}">&nbsp;&nbsp;&nbsp;&nbsp;중식&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
			<li><a href="c_shopList.do?n_type=일식&anum=${param.anum}">&nbsp;&nbsp;&nbsp;&nbsp;일식&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
			<li><a href="c_shopList.do?n_type=양식&anum=${param.anum}">&nbsp;&nbsp;&nbsp;&nbsp;양식&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
		</ul>
	</div>
</form>
</div>


</body>
</html>