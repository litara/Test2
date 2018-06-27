   <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="admin-coach-update-true" class="container">
	<input type="hidden" name="id" value="${coachUpdate.getId()}">
	<select name="type_coach_id">
	<option selected value="${coachUpdate.getType().getId() }">${ coachUpdate.getType().getName()}</option>
	<c:forEach items="${ listType}" var="type">
		<c:if test="${type.getId()!=coachUpdate.getType().getId()}">
			<option value="${type.getId()}">${type.getName()}</option>
		</c:if>
	</c:forEach>
	</select>
	<select name="category_coach_id">
	<option selected value="${coachUpdate.getCategory().getId() }">${ coachUpdate.getCategory().getName()}</option>
		<c:forEach items="${ listCategory}" var="category">
			<c:if test="${category.getId()!=coachUpdate.getCategory().getId()}">
				<option value="${category.getId()}">${category.getName()}</option>
			</c:if>
		</c:forEach>
	</select>
	<select name="class_coach_id">
	<option selected value="${coachUpdate.getClassCoach().getId() }">${ coachUpdate.getClassCoach().getName()}</option>
		<c:forEach items="${ listClass}" var="classCoach">
			<c:if test="${classCoach.getId()!=coachUpdate.getClassCoach().getId()}">
				<option value="${classCoach.getId()}">${classCoach.getName()}</option>
			</c:if>
		</c:forEach>
	</select>
	<select name="station_id">
	<option selected value="${coachUpdate.getStationOrder().getId() }">${ coachUpdate.getStationOrder().getName()}</option>
		<c:forEach items="${ listStation}" var="station">
			<c:if test="${station.getId()!=coachUpdate.getStationOrder().getId()}">
				<option value="${station.getId()}">${station.getName()}</option>
			</c:if>
		</c:forEach>
	</select>
	<input type="submit" class="btn" value="Сохранить">
	</form>

</body>
</html>