<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="admin-passenger-update-true" class="container">
	<input type="hidden" name="active" value="${passengerUpdate.getActive()}">
	<input type="hidden" name="id" value="${passengerUpdate.getId()}">
	<input type="text" class="text" name="email" value="${passengerUpdate.getEmail() }">
	<input type="hidden" name="password" value="${passengerUpdate.getPassword()}">
	<input type="text" class="text" name="name" value="${passengerUpdate.getName()}">
	<input type="text" class="text" name="surname" value="${passengerUpdate.getSurname()}">
	<input type="text" class="text" name="middle_name" value="${passengerUpdate.getMiddle_name()}">
	<select name="role">
	<c:if test="${passengerUpdate.getRole()=='ADMIN' }">
		<option value="PASSENGER">Пассажир</option>
		<option selected value="ADMIN">Администратор</option>
	</c:if>
	<c:if test="${passengerUpdate.getRole()=='PASSENGER' }">
		<option selected value="PASSENGER">Пассажир</option>
		<option value="ADMIN">Администратор</option>
	</c:if>
	</select>
	<input type="submit" class="btn" value="Сохранить">
	
	</form>

</body>
</html>