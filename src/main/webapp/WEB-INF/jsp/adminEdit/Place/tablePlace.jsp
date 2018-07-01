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
					<th>Тип|Категория|Класс</th>
					<th>Номер места</th>
					<th>Тип места</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tablePlace}" var="i">

					<tr>
						<td>${i.getCoachPlace().getTypeCategoryClass()}</td>
						<td>${i.getNumber()}</td>
						<td>${i.getType()}</td>
						<td>
						<form method="POST" action="admin-place-del">
							<input type="submit" class="btn" value="Delete">
							<input type="hidden" name="id" value="${i.getId()}"/>
						</form>
						</td>
						<td>
							<form action="admin-place-update" method="post">
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