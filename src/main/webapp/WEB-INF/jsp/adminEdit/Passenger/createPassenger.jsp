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
	<h2>Создать пассажира</h2>
	<form method="post" action="admin-passenger-create">
	<input type="text" class="text" name="email" placeholder="Email">
	<input type="text" class="text" name="password" placeholder="Password">
	<input type="text" class="text" name="name" placeholder="Name">
	<input type="text" class="text" name="surname" placeholder="SurName">
	<input type="text" class="text" name="middle_name" placeholder="Middle Name">
	<input type="submit" class="btn" value="Создать">
	
	</form>
	</div>
</body>
</html>