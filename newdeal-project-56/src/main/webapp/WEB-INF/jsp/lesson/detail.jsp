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
	<h1>수업 상세정보</h1>
	
	<form action="update" method="post">
		<table border='1'>
		  <tr>
        <th>번호</th>
        <td><input type="text" name="no" value="${lesson.no }" readonly></td>
      </tr>
			<tr>
			  <th>수업명</th>
			  <td><input type="text" name="title" value="${lesson.title }" readonly></td>
			</tr>
			<tr>
			  <th>설명</th>
			  <td><textarea name="contents" rows="4" cols="50">${lesson.contents }</textarea></td>
			</tr>
			<tr>
			  <th>기간</th>
			  <td>
				  <input type="date" name="startDate" value="${lesson.startDate }">
		      ~
		      <input type="date" name="endDate" value="${lesson.endDate }">
			  </td>
			</tr>
			<tr>
	      <th>총수업시간</th>
	      <td><input type="text" name="totalHours" value="${lesson.totalHours }"></td>
	    </tr>
	    <tr>
	      <th>일수업시간</th>
	      <td><input type="text" name="dayHours" value="${lesson.dayHours }"></td>
	    </tr>
	    <tr>
	      <th></th>
	      <td>
	        <button>변경</button>
	        <button type="button" onclick="remove();">삭제</button>
	      </td>
	    </tr>
		</table>
	</form>
	<script>
		function remove() {
		  location.href = "delete?no=${lesson.no}"
		}
	</script>
</body>
</html>
	