<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>Basic Table</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Поезд</th>
					<th>Тип|Класс|Категория вагона</th>
					<th>Номер в составе</th>
					<th>От станции</th>
					<th>До станции</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tableConsist}" var="i">

					<tr>
						<td>${i.getTrainConsist().getName()}</td>
						<td>${i.getCoachConsist().getTypeCategoryClass()}</td>
						<td>${i.getNumber_in_consist()}</td>
						<td>${i.getStationConsistStart().getName()}</td>
						<td>${i.getStationConsistEnd().getName()}</td>
						<td>
						<form method="POST" action="admin-consist-del">
							<input type="submit" class="btn" value="Delete">
							<input type="hidden" name="id" value="${i.getId()}"/>
						</form>
						</td>
						<td>
							<form action="admin-consist-update" method="post">
								<input type="hidden" name="id" value="${i.getId()}">
								<input type="submit" class="btn" value="Update">
							</form>
						</td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>