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
	<form method="post" action="admin-train-update-true" class="container row">
	<input type="hidden" name="id" value="${trainUpdate.getId()}">
	<input type="text" class="form-control col-2 margin-form-control-5" name="name" value="${trainUpdate.getName()}" placeholder="Имя">
	<fmt:formatDate pattern="yyyy-MM-dd" value="${trainUpdate.getDate_start()}" type="date" var="date_start"/>
	<fmt:formatDate value="${trainUpdate.getDate_stop()}" pattern="yyyy-MM-dd" type="date" var="date_stop"/>
	<input type="date" class="form-control col-2 margin-form-control-5" name="date_start" value="<c:out value="${date_start}"/>">
	<input type="date" class="form-control col-2 margin-form-control-5" name="date_stop" value="<c:out value="${date_stop}"/>">
	<input type="submit" class="btn btn-primary col-2 margin-form-control-5" value="Сохранить">
	
	</form>

</body>
</html>