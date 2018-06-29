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
	<h2>Создать состав</h2>
	<form method="post" action="admin-consist-create">
	<select name="train_id">
		<option selected>Выберите поезд</option>
	<c:forEach items="${listTrain}" var="trainConsist">
		<option value="${trainConsist.getId()}">${trainConsist.getName()}</option>
	</c:forEach>
	</select>
	<select name="coach_id">
		<option selected>Выберите вагон</option>
			<c:forEach items="${listCoach}" var="coachConsist">
				<option value="${coachConsist.getId() }">${coachConsist.getTypeCategoryClass()}</option>
			</c:forEach>
	</select>
	<input type="text" class="text" name="number_in_consist">
	<select name="station_id_start">
		<option selected>От станции</option>
			<c:forEach items="${listStationStart}" var="stationStartConsist">
				<option value="${stationStartConsist.getId() }">${stationStartConsist.getName()}</option>
			</c:forEach>
	</select>
	<select name="station_id_end">
		<option selected>До станции</option>
			<c:forEach items="${listStationEnd}" var="stationEndConsist">
				<option value="${stationEndConsist.getId() }">${stationEndConsist.getName()}</option>
			</c:forEach>
	</select>
	<input type="submit" class="btn" value="Создать">
	</form>
	</div>
</body>
</html>