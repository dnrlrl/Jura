<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jura 메인화면</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<script type="text/javascript" src="/jura2/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$('#disp').load('header.do');
		$('#footer').load('footer.do');
	});
</script>
<style type="text/css">
table {
	border-spacing: 2px;
	border-collapse: separate;
}

p {
	font-size: 30px;
}
.content p { font-size: 23px; }
</style>
</head>
<body class="is-preload">
	<div id="disp"></div>
	<div id="wrapper">
		<!-- Main -->
		<div id="main">
			<div class="inner">
				<header>
					<h1 align="center">
						<br />
					</h1>
					<p></p>
				</header>
				<section class="tiles">
					<article1> <span class="image"> <img
						src="images/dabi_l_jura.png" alt="" />
					</span> <a href="loginForm.do"> <!-- <h2>점심JURA</h2> -->
						<div class="content">
							<p>
								8시~11시 사이<br>메뉴 골라주라
							</p>
						</div>
					</a> </article1>
					<article1> <span class="image"> <!-- <img src="images/d_jura.JPG" alt="" /> -->
						<img src="images/dabi_d_jura.png" alt="" />
					</span> <a href="loginForm.do"> <!-- <h2> </h2> -->
						<div class="content">
							<p>
								18시~21시 사이<br>메뉴 골라주라
							</p>
						</div>
					</a> </article1>
					<article1> <span class="image"> <!-- <img src="images/a_jura.JPG" alt="" /> -->
						<img src="images/dabi_a_jura.png" alt="" />
					</span> <a href="loginForm.do"> <!-- <h2>아무거나JURA</h2> -->
						<div class="content">
							<p>
								묻지도 따지지도 말고<br>메뉴 골라주라
							</p>
						</div>
					</a> </article1>
					<!-- <article class="style1"> -->
					<article>
						<span class="image"> <img src="images/kor.JPG" alt="" />
						</span> <a href="loginForm.do"></a>
					</article>
					<article>
						<span class="image"> <img src="images/chi.JPG" alt="" />
						</span> <a href="loginForm.do"></a>
					</article>
					<article>
						<span class="image"> <img src="images/jpn.JPG" alt="" />
						</span> <a href="loginForm.do"></a>
					</article>
					<article>
						<span class="image"> <img src="images/wes.JPG" alt="" />
						</span> <a href="loginForm.do"></a>
					</article>
				</section>
			</div>
		</div>
	<div id="footer"></div>
	</div>
	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
</body>
</html>