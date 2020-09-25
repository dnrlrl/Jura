<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Jura 로그인 화면</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" type="text/css" href="assets/style.css" />
<script type="text/javascript" src="/jura2/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$('#disp').load('header.do');
		$('#footer').load('footer.do');
	});
</script>
<style type="text/css">
	table {
		margin: 0 0 2em 0;
		width: 50%;
		margin:auto;
		text-align:center;
	}
}
</style>
</head>
<body>
<div id="disp"></div>
<section class="main">
				<form class="form-4" action="login.do" method="post">
				    <h1>로그인</h1>
				    <p>
				        <label for="login">Username or email</label>
				        <input type="text" name="id" placeholder="Username or email" required="required" autofocus="autofocus">
				    </p>
				    <p>
				        <label for="password">Password</label>
				        <input type="password" name="pass" placeholder="Password" required="required"> 
				    </p>

				    <p>
				        <input type="submit" name="submit" value="로그인">
				    </p>       
				</form>​
			</section>

	<div id="footer"></div>
</body>
</html>