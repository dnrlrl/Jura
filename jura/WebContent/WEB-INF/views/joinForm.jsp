<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jura 회원가입</title>
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

	#idck{color:red;}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	function chk(){
		if(frm.password.value!=frm.confirmPass.value){
			alert("암호와 암호확인이 다릅니다");
			frm.password.vaelue="";
			frm.password.focus();
			return false;	
		}
	}
	function idchk(){
		if(!frm.id.value){
			alert("아이디 입력 후에 체크");
			frm.id.focus();
			return false;
		}
		/* window.open('idChk.jsp?id='+frm.id.value,"","width=300 height=300"); */
		$.post('confirmid.do','id='+frm.id.value,function(data){
			$('#idck').html(data);
			alert($(result));
			if($("#idck").val()=="중복된 아이디 입니다."){
				frm.id.value="";
			}
		});
	}
	$(function() {
		$('#disp').load('header.do');
		$('#footer').load('footer.do');
	});
</script>
</head>
<body>
<div id="disp"></div>
<div class="wrap">
<h1>회원가입</h1>
<form action="join.do" method="post" name="frm" onsubmit="return chk()">
<table>
	<tr><th>아이디</th><td><input type="text" name="id" required="required" autofocus="autofocus">
	<div id="idck"></div>
	</td>
	<td><input type="button" name="btn" value="아이디 중복확인" onclick="idchk()">
	<!-- <input type="button" value="아이디 중복" onclick="return confirm()"> -->
	</td></tr>
	<tr><th>암호</th><td colspan="2"><input type="password" name="password" required="required"></td></tr>
	<tr><th>암호확인</th><td colspan="2"><input type="password" name="confirmPass" required="required"></td></tr>
	<tr><th>이름</th><td colspan="2"><input type="text" name="name" required="required"></td></tr>
	<tr><th>주소</th><td colspan="2">
	<select name="addnum">
		<option value="1">상암동,성산 1동,성산 2동,망원 1동,망원 2동</option>
		<option value="2">연남동,서교동,합정동,서강동</option>
		<option value="3">대흥동,신수동,염리동,용강동,아현동,공덕동,도화동</option>
	</select>
	<input type="hidden" ></td></tr>
	<tr><th>상세주소</th><td colspan="2"><input type="text" name="address" required="required"></td></tr>
	<tr><th>전화</th><td colspan="2"><input type="tel" name="tel" required="required" pattern="\d{3}-\d{3,4}-\d{4}" placeholder="xxx-xxx-xxxx" title="전화번호 형식 xxx-xxxx-xxxx-"></td></tr>
	<tr><th colspan="2" align="center"><input type="submit" value="확인">	
</table>
</form>
</div>
<div id="footer"></div>
</body>
</html>