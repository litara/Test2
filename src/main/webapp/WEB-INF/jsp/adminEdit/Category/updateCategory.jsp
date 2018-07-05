<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form method="post" action="admin-category-update-true" class="container row">
	<input type="hidden" name="id" value="${categoryUpdate.getId()}">
	<input type="text" class="form-control col-2 margin-form-control-5" name="name" value="${categoryUpdate.getName()}" placeholder="Имя">
	<input type="submit" class="btn btn-primary col-2 margin-form-control-5" value="Сохранить">
	</form>
</body>
</html>