<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>수업</title>
</head>
<body>
  <jsp:include page="../header.jsp"></jsp:include>
	<h1>수업 등록</h1>
	
	<form action="add" method="post">
		<table border='1'>
			<tr>
			<tr>
        <th>수업명</th>
        <td><input type="text" name="title"></td>
      </tr>
			<tr>
			  <th>수업내용</th>
			  <td><textarea name="contents" rows="4" cols="50"></textarea></td>
			</tr>
	    <tr>
        <th>기간</th>
        <td><input type="date" name="startDate">~<input type="date" name="endDate"></td>
      </tr>
      <tr>
        <th>총수업시간</th>
        <td><input type="text" name="totalHours"></td>
      </tr>
      <tr>
        <th>일수업시간</th>
        <td><input type="text" name="dayHours"></td>
      </tr>
      <tr>
        <th>회원번호</th>
        <td><input type="text" name="memberNo"></td>
      </tr>
      <tr>
        <th></th>
        <td>
          <button>등록</button>
          <button type="button" onclick="location.href='list'">취소</button>
        </td>
      </tr>
		</table>
	</form>
</body>
</html>
	