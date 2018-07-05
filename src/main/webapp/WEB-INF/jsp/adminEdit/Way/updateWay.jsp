   <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form method="post" action="admin-way-update-true" class="container row">
	<input type="hidden" name="id" value="${wayUpdate.getId()}">
	<select name="station_id" class="form-control col-2 margin-form-control-5">
	<option selected value="${wayUpdate.getStation().getId() }">${ wayUpdate.getStation().getName()}</option>
	<c:forEach items="${ listStation}" var="station">
		<c:if test="${station.getId()!=wayUpdate.getStation().getId()}">
			<option value="${station.getId()}">${station.getName()}</option>
		</c:if>
	</c:forEach>
	</select>
	<select name="train_id" class="form-control col-2 margin-form-control-5">
	<option selected value="${wayUpdate.getTrain().getId() }">${ wayUpdate.getTrain().getName()}</option>
		<c:forEach items="${ listTrain}" var="train">
			<c:if test="${train.getId()!=wayUpdate.getTrain().getId()}">
				<option value="${train.getId()}">${train.getName()}</option>
			</c:if>
		</c:forEach>
	</select>
	<input type="time" class="form-control col-2 margin-form-control-5" name="start_time" value="${wayUpdate.getStart_time() }">
	<input type="time" class="form-control col-2 margin-form-control-5" name="end_time" value="${wayUpdate.getEnd_time() }">
	<input type="submit" class="btn btn-primary col-2 margin-form-control-5" value="Сохранить">
	</form>
</body>
</html>