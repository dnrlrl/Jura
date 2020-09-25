<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="sessionChk.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jura 메인화면</title>
<link rel="stylesheet" href="assets/css/main.css" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />

<style type="text/css">
	table { border-spacing: 2px;
  			border-collapse: separate;
  			}		
	p { 
	font-size: 30px;
	}
	.k {
	width: 50px;
	cursor: pointer;
	}
	.content p { font-size: 23px; }
  
</style>
<script type="text/javascript" src="/jura2/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$('#footer').load('footer.do');
	});
</script>
</head>
<body class="is-preload">
<jsp:include page="../../com/header2.jsp"></jsp:include>
<div id="disp"></div>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<div class="container add"
					style="padding-top: 20px; padding-bottom: 20px;" align="center">
					<div class="row" style="display: block; width: 500px;"
						align="center">
						<form id="select_add" action="request_mainAddnum.do"
							onclick="return chk()">
							<div class="input_add" align="center">
							<div style="height: 30px;"></div>
								<select name="input_add" onchange="sort(this.form)">
									<option value="1" <c:if test="${param.anum==1 }">selected</c:if>>상암동,성산
										1동,성산 2동,망원 1동,망원 2동</option>
									<option value="2" <c:if test="${param.anum==2 }">selected</c:if>>연남동,서교동,합정동,서강동</option>
									<option value="3" <c:if test="${param.anum==3 }">selected</c:if>>대흥동,신수동,염리동,용강동,아현동,공덕동,도화동</option>
								</select> <span><button type="submit" class="primary"
										style="margin-top: 15px;">주소변경</button></span>

							</div>
						</form>
					</div>
				</div>
				<!-- Main -->
					<div id="main">
						<div class="inner">
							<header>
								<h6 align="center"><br/></h6>
								<p></p>
							</header>
							<section class="tiles">
								<article1>
									<span class="image">
										<img src="images/dabi_l_jura.png" alt="" />
									</span>
									<a href="j_orderPage.do?anum=${param.anum}&jtype=브런치">
										<!-- <h2>점심JURA</h2> -->
										<div class="content">
											<p>8시~11시 사이<br>메뉴 골라주라</p>
										</div>
									</a>
								</article1>
								<article1>
									<span class="image">
										<!-- <img src="images/d_jura.JPG" alt="" /> -->
										<img src="images/dabi_d_jura.png" alt="" />
									</span>
									<a href="j_orderPage.do?anum=${param.anum}&jtype=디너">
										<!-- <h2> </h2> -->
										<div class="content">
											<p>18시~21시 사이<br>메뉴 골라주라</p>
										</div>
									</a>
								</article1>
								<article1>
									<span class="image">
										<!-- <img src="images/a_jura.JPG" alt="" /> -->
										<img src="images/dabi_a_jura.png" alt="" />
									</span>
									<a href="j_orderPage.do?anum=${param.anum}&jtype=all">
										<!-- <h2>아무거나JURA</h2> -->
										<div class="content">
											<p>묻지도 따지지도 말고<br>메뉴 골라주라</p>
										</div>
									</a>
								</article1>
								<!-- <article class="style1"> -->
								<article>
									<span class="image">
										<img src="images/kor.JPG" alt="" />
									</span>
									<a href="c_shopList.do?n_type=한식&anum=${param.anum}">
									</a>
								</article>
								<article>
									<span class="image">
										<img src="images/chi.JPG" alt="" />
									</span>
									<a href="c_shopList.do?n_type=중식&anum=${param.anum}">
									</a>
								</article>
								<article>
									<span class="image">
										<img src="images/jpn.JPG" alt="" />
									</span>
									<a href="c_shopList.do?n_type=일식&anum=${param.anum}">
									</a>
								</article>
								<article>
									<span class="image">
										<img src="images/wes.JPG" alt="" />
									</span>
									<a href="c_shopList.do?n_type=양식&anum=${param.anum}">
									</a>
								</article>
							</section>
						</div>
					</div>
				<!-- Footer -->
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