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
	<form method="post" action="admin-coach-create">
	<select name="type_coach_id">
		<option selected>Выберите тип</option>
	<c:forEach items="${listType}" var="i">
		<option value="${i.getId()}">${i.getName()}</option>
	</c:forEach>
	</select>
	<select name="category_coach_id">
		<option selected>Выберите категорию</option>
	<c:forEach items="${listCategory}" var="i">
		<option value="${i.getId()}">${i.getName()}</option>
	</c:forEach>
	</select>
	<select name="class_coach_id">
		<option selected>Выберите класс</option>
	<c:forEach items="${listClass}" var="i">
		<option value="${i.getId()}">${i.getName()}</option>
	</c:forEach>
	</select>
	<select name="station_id">
		<option selected>Выберите станцию</option>
	<c:forEach items="${listStation}" var="i">
		<option value="${i.getId()}">${i.getName()}</option>
	</c:forEach>
	</select>
	<input type="submit" class="btn" value="Создать">
	</form>
	</div>
</body>
</html>