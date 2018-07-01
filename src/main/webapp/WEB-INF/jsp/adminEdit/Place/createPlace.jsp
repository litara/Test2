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
	<form method="post" action="admin-place-create">
	<select name="coach_id">
		<option selected>Выберите тип</option>
	<c:forEach items="${listCoach}" var="i">
		<option value="${i.getId()}">${i.getTypeCategoryClass()}</option>
	</c:forEach>
	</select>
	<input type="text" name="number" placeholder="Номер места">
	<input type="text" name="type" placeholder="Тип места">
	<input type="submit" class="btn" value="Создать">
	</form>
	</div>
</body>
</html>