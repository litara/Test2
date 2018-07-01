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
	<form method="post" action="admin-place-update-true">
	<input type="hidden" name="id" value="${placeUpdate.getId()}">
	<select name="coach_id">
	<option selected value="${placeUpdate.getCoachPlace().getId()}">${placeUpdate.getCoachPlace().getTypeCategoryClass()}</option>
	<c:forEach items="${listCoach}" var="i">
		<c:if test="${placeUpdate.getCoachPlace().getId()!=i.getId() }">
			<option value="${i.getId()}">${i.getTypeCategoryClass()}</option>
		</c:if>
	</c:forEach>
	</select>
	<input type="text" name="number" placeholder="Номер места" value="${placeUpdate.getNumber() }">
	<input type="text" name="type" placeholder="Тип места" value="${placeUpdate.getType()}">
	<input type="submit" class="btn" value="Создать">
	</form>
	</div>
</body>
</html>