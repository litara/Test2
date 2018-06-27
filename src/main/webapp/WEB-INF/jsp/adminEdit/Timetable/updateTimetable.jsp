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
	<form method="post" action="admin-timetable-update-true" class="container">
	<input type="hidden" name="id" value="${timetableUpdate.getId()}">
	<select name="way_id">
	<option selected value="${timetableUpdate.getWay().getId() }">${ timetableUpdate.getWay().getStationTrain()}</option>
	<c:forEach items="${ listWay}" var="i">
		<c:if test="${i.getId()!=timetableUpdate.getWay().getId()}">
			<option value="${i.getId()}">${i.getStationTrain()}</option>
		</c:if>
	</c:forEach>
	</select>
	<fmt:formatDate pattern="yyyy-MM-dd" value="${timetableUpdate.getDate()}" type="date" var="date"/>
	<input type="date" class="date" name="date" value="<c:out value="${date}"/>">
	<input type="submit" class="btn" value="Сохранить">
	
	</form>

</body>
</html>