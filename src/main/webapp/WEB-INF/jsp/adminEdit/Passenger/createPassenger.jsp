<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="container">
	<form method="post" class="row" action="admin-passenger-create">
	<input type="text" class="form-control col-2 margin-form-control-5" name="email" placeholder="Email">
	<input type="password" class="form-control col-2 margin-form-control-5" name="password" placeholder="Пароль">
	<input type="text" class="form-control col-2 margin-form-control-5" name="name" placeholder="Имя">
	<input type="text" class="form-control col-2 margin-form-control-5" name="surname" placeholder="Фамилия">
	<input type="text" class="form-control col-2 margin-form-control-5" name="middle_name" placeholder="Отчество">
	<input type="submit" class="btn btn-primary col-1 margin-form-control-5" value="Создать">
	
	</form>
	</div>
</body>
</html>