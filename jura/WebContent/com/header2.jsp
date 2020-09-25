<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="assets/css/main.css" />
<style type="text/css">
	a:link { text-decoration: none;}
 	a:visited { text-decoration: none;}
 	a:hover { text-decoration: none;}
 	/* a { font-size: 50px !important; align: center;} */
 	#logo img{ max-height:60px; padding:0; margin-left:40px;vertical-align:middle; text-decoration: none;}
 	
 	#logo { float:left;  font-size: 50px; }
 	#logo_content {background-color:#F8C03D;max-width:100%;vertical-align:middle;height:80px; line-height: 80px;}
	#button {float: right; margin-right: 50px; height: 80px;}
</style>
</head>
<body>
<div id="logo_content">
<a id="logo" href="header2_main.do?anum=${param.anum}"><img alt="" src="/jura2/images/logo.png"><strong>&nbsp;JURA</a>
<span id="button">
<button onclick="location.href='c_infoPage.do?anum=${param.anum}'" class="primary">회원정보</button>
<button onclick="location.href='main.do'">로그아웃</button><p></p>
</span>
</div>
</body>
</html>