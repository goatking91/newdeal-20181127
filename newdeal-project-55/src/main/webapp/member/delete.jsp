<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<meta http-equiv="Refresh" content="1;url=list">
<title>회원</title>
</head>
<body>
	<h1>회원 탈퇴</h1>
	<c:choose>
		<c:when test="${count == 0 }">
		  <p>해당 회원은 존재하지 않습니다.</p>
		</c:when>
		<c:otherwise>
		  <p>탈퇴했습니다.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>
