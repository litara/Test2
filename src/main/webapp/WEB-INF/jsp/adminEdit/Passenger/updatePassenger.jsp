<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form method="post" action="admin-passenger-update-true" class="container row">
	<input type="hidden" name="active" value="${passengerUpdate.getActive()}">
	<input type="hidden" name="id" value="${passengerUpdate.getId()}">
	<input type="text" class="form-control col-2 margin-form-control-5" name="email" value="${passengerUpdate.getEmail() }">
	<input type="hidden" name="password" value="${passengerUpdate.getPassword()}">
	<input type="text" class="form-control col-2 margin-form-control-5" name="name" value="${passengerUpdate.getName()}" placeholder="Имя">
	<input type="text" class="form-control col-2 margin-form-control-5" name="surname" value="${passengerUpdate.getSurname()}" placeholder="Фамилия">
	<input type="text" class="form-control col-2 margin-form-control-5" name="middle_name" value="${passengerUpdate.getMiddle_name()}" placeholder="Отчество">
	<select name="role" class="form-control col-2 margin-form-control-5">
	<c:if test="${passengerUpdate.getRole()=='ADMIN' }">
		<option value="PASSENGER">Пассажир</option>
		<option selected value="ADMIN">Администратор</option>
	</c:if>
	<c:if test="${passengerUpdate.getRole()=='PASSENGER' }">
		<option selected value="PASSENGER">Пассажир</option>
		<option value="ADMIN">Администратор</option>
	</c:if>
	</select>
	<input type="submit" class="btn btn-primary col-2 margin-form-control-5" value="Сохранить">
	
	</form>

</body>
</html>