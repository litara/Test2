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
	<form method="post" action="admin-consist-update-true" class="container">
	<input type="hidden" name="id" value="${consistUpdate.getId()}">
	<select name="train_id">
	<option selected value="${consistUpdate.getTrainConsist().getId() }">${ consistUpdate.getTrainConsist().getName()}</option>
		<c:forEach items="${ listTrain}" var="train">
			<c:if test="${train.getId()!=consistUpdate.getTrainConsist().getId()}">
				<option value="${train.getId()}">${train.getName()}</option>
			</c:if>
		</c:forEach>
	</select>
	<select name="coach_id">
	<option selected value="${consistUpdate.getCoachConsist().getId()}">${consistUpdate.getCoachConsist().getTypeCategoryClass()}</option>
		<c:forEach items="${listCoach}" var="coach">
			<c:if test="${coach.getId()!=consistUpdate.getCoachConsist().getId()}">
				<option value="${coach.getId()}">${coach.getTypeCategoryClass()}</option>
			</c:if>
		</c:forEach>
	</select>
	<input type="text" class="text" name="number_in_consist" value="${consistUpdate.getNumber_in_consist()}">
	<select name="station_id_start">
	<option selected value="${consistUpdate.getStationConsistStart().getId()}">${consistUpdate.getStationConsistStart().getName()}</option>
		<c:forEach items = "${listStationStart}" var="stationStart">
			<c:if test="${stationStart.getId()!=consistUpdate.getStationConsistStart().getId()}">
				<option value="${stationStart.getId()}">${stationStart.getName()}</option>
			</c:if>
		</c:forEach>
	</select>
	
	<select name="station_id_end">
	<option selected value="${consistUpdate.getStationConsistEnd().getId()}">${consistUpdate.getStationConsistEnd().getName()}</option>
		<c:forEach items = "${listStationEnd}" var="stationEnd">
			<c:if test="${stationEnd.getId()!=consistUpdate.getStationConsistEnd().getId()}">
				<option value="${stationEnd.getId()}">${stationEnd.getName()}</option>
			</c:if>
		</c:forEach>
	</select>
	<input type="submit" class="btn" value="Сохранить">
	
	</form>

</body>
</html>