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
	<h2>Создать станцию</h2>
	<form method="post" action="admin-station-create">
	<input type="text" class="text" name="name" placeholder="Name">
	<input type="text" class="text" name="country" placeholder="Country">
	<input type="text" class="text" name="region" placeholder="Region">
	<input type="submit" class="btn" value="Создать">
	
	</form>
	</div>
</body>
</html>