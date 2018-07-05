<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form method="post" action="admin-station-update-true" class="container row">
	<input type="hidden" name="id" value="${stationUpdate.getId()}">
	<input type="text" class="form-control col-2 margin-form-control-5" name="name" value="${stationUpdate.getName()}" placeholder="Имя">
	<input type="text" class="form-control col-2 margin-form-control-5" name="country" value="${stationUpdate.getCountry()}" placeholder="Страна">
	<input type="text" class="form-control col-2 margin-form-control-5" name="region" value="${stationUpdate.getRegion()}" placeholder="Регион">
	<input type="submit" class="btn btn-primary col-2 margin-form-control-5" value="Сохранить">
	</form>
</body>
</html>