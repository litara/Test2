<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
	<div class="container">
	<h1>${date}</h1>
	<table class="table">
			<thead>
				<tr>
					<th>Имя</th>
					<th>Время начала</th>
					<th>Время конца</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${trainResult}" var="i">
				
				
					<tr>
						<td>${i.getName()}</td>
						<c:forEach items="${wayStart }" var="j"><c:if test="${i.getId()==j.getTrain().getId()}"><td>${j.getStart_time()}</td></c:if></c:forEach>
						<c:forEach items="${wayStop }" var="k"><c:if test="${i.getId()==k.getTrain().getId()}"><td>${k.getStart_time()}</td></c:if></c:forEach>
						<td><form method="POST" action="/order">
							<input type="hidden" name="train_id" value="${ i.getId()}">
							<c:if test="${ passenger!=null}">
							<input type="submit" class="btn btn-primary" value="Заказать">
							</c:if>
							<c:if test="${ passenger==null}">
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Заказать</button>
							</c:if>
						</form></td>
						<td><form method="POST" action="/more">
							<input type="hidden" name="train_id" value="${i.getId() }">
							<input type="submit" class="btn btn-primary" value="Подробнее...">
						</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>