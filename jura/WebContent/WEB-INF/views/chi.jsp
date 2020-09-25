<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중식 식당</title>
</head>
<body>
<table>
	<c:if test="${empty list }">
		<tr><th>등록된 식당이 없습니다.</th>
	</c:if>
	<c:if test="${not empty list }">
	<c:forEach var="shop" items="${list }">
			<tr>
				<td rowspan="3" style="width:40%; height: 250px"><a href="c_menu.do?s_id=${shop.s_id}&anum=${anum}">
					<img src="${path }/s_img/${shop.s_img}" width="300"></a>
				</td>
			<td>${shop.s_name }</td>
			</tr>
			<tr>
				<td>${shop.s_add }</td>
			</tr>
			<tr>
				<td>${shop.s_tel }</td>
			</tr>
	</c:forEach>
	</c:if>
</table>
</body>
</html>