<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="bootstrap_js/jquery-3.3.1.min.js" defer></script>
<script src="js/admin-passenger.js" defer></script>
</head>
<body>
	<div class="container clearfix">
		<div class="container"><form action="search-admin" method="post" name="form" onsubmit="return false;">
    		<input autocomplete="off" name="search" type="text" class="form-control float-right w-25 margin-form-control-5" id="search" placeholder="Поиск по имени..">
		</form></div>
		<div class="container row">
			<input type="text" id="page" class="form-control col-1 margin-form-control-5" placeholder="Номер страницы" value="1">
			<input type="button" class="btn btn-primary col-1 margin-form-control-5" id="next" value="Перейти..">
		</div>
		<table class="table table-dark margin-form-control-5">
			<thead>
				<tr>
					<th>Email</th>
					<th>Имя</th>
					<th>Фамилия</th>
					<th>Отчество</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach items="${tablePassenger}" var="i" begin="0" end="9">

					<tr>
						<td>${i.getEmail()}</td>
						<td>${i.getName()}</td>
						<td>${i.getSurname() }</td>
						<td>${i.getMiddle_name() }</td>
						<td>
						<form method="POST" action="admin-passenger-del">
							<input type="hidden" name="do" value="del"/>
							<input type="submit" class="btn" value="Удалить">
							<input type="hidden" name="id" value="${i.getId()}"/>
						</form>
						</td>
						<td>
							<form action="admin-passenger-update" method="post">
								<input type="hidden" name="id" value="${i.getId()}">
								<input type="submit" class="btn" value="Изменить">
							</form>
						</td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>