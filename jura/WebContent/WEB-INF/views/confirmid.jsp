<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<c:if test="${result!=1 }">
	사용가능한 아이디입니다.
</c:if>
<c:if test="${result==1 }">
	중복된 아이디 입니다.
</c:if>
</body>
</html>