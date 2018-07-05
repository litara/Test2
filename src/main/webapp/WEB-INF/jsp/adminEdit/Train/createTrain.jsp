<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="container">
	<form method="post" class="row" action="admin-train-create">
	<input type="text" class="form-control col-2 margin-form-control-5" name="name" placeholder="Имя поезда">
	<input type="date" class="form-control col-2 margin-form-control-5" name="date_start">
	<input type="date" class="form-control col-2 margin-form-control-5" name="date_stop">
	<input type="submit" class="btn btn-primary col-2 margin-form-control-5" value="Создать">
	</form>
	</div>
</body>
</html>