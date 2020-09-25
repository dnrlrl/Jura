<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check(menu) {
		location.href=menu+".co";
	}
</script></head><body>
<table>
<tr><th>메뉴</th></tr>
<tr><th><button onclick="check('home')">홈</button></th></tr>
<tr><th><button onclick="check('newItem')">신상품</button></th></tr>
<tr><th><button onclick="check('bestItem')">인기상품</button></th></tr>
</table>
</body>
</html>