<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h2>Создать поезд</h2>
	<form method="post" action="admin-train-create">
	<input type="text" class="text" name="name" placeholder="Name">
	<input type="date" class="date" name="date_start">
	<input type="date" class="date" name="date_stop">
	<input type="submit" class="btn" value="Создать">
	
	</form>
	</div>
</body>
</html>