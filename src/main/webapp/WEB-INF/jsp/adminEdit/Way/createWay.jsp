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

</head>
<body>
	<div class="container">
	<form method="post" action="admin-way-create" class="row">
	<select name="station_id" class="form-control col-2 margin-form-control-5">
		<option selected>Выберите станцию</option>
	<c:forEach items="${listStation}" var="stationList">
		<option value="${stationList.getId()}">${stationList.getName()}</option>
	</c:forEach>
	</select>
	<select name="train_id" class="form-control col-2 margin-form-control-5">
		<option selected>Выберите поезд</option>
	<c:forEach items="${listTrain}" var="trainList">
		<option value="${trainList.getId()}">${trainList.getName()}</option>
	</c:forEach>
	</select>
	<input type="time" class="form-control col-2 margin-form-control-5" name="start_time">
	<input type="time" class="form-control col-2 margin-form-control-5" name="end_time">
	<input type="submit" class="btn btn-primary col-2 margin-form-control-5" value="Создать">
	</form>
	</div>
</body>
</html>