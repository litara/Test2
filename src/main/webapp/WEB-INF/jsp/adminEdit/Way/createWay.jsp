<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.litara.Test2.model.Station"%>
<%@page import="java.util.List"%>
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
	<h2>Создать путь</h2>
	<form method="post" action="admin-way-create">
	<select name="station_id">
		<option selected>Выберите станцию</option>
	<c:forEach items="${listStation}" var="stationList">
		<option value="${stationList.getId()}">${stationList.getName()}</option>
	</c:forEach>
	</select>
	<select name="train_id">
		<option selected>Выберите поезд</option>
	<c:forEach items="${listTrain}" var="trainList">
		<option value="${trainList.getId()}">${trainList.getName()}</option>
	</c:forEach>
	</select>
	<input type="time" class="time" name="start_time">
	<input type="time" class="time" name="end_time">
	<input type="submit" class="btn" value="Создать">
	</form>
	</div>
</body>
</html>