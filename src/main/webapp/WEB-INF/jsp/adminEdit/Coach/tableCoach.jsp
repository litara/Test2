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
					<th>Тип</th>
					<th>Категория</th>
					<th>Класс</th>
					<th>Станция владелец</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tableCoach}" var="i">

					<tr>
						<td>${i.getType().getName()}</td>
						<td>${i.getCategory().getName() }</td>
						<td>${i.getClassCoach().getName() }</td>
						<td>${i.getStationOrder().getName() }</td>
						<td>
						<form method="POST" action="admin-coach-del">
							<input type="submit" class="btn" value="Delete">
							<input type="hidden" name="id" value="${i.getId()}"/>
						</form>
						</td>
						<td>
							<form action="admin-coach-update" method="post">
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