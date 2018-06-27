<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h2>Создать расписание</h2>
	<form method="post" action="admin-timetable-create">
	<select name="way_id">
		<option selected>Выберите станцию:поезд</option>
	<c:forEach items="${listWay}" var="i">
		<option value="${i.getId()}">${i.getStationTrain()}</option>
	</c:forEach>
	</select>
	<input type="date" class="date" name="date">
	<input type="submit" class="btn" value="Создать">
	
	</form>
	</div>
</body>
</html>