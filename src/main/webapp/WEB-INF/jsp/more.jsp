<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<script src="bootstrap_js/jquery-3.3.1.min.js" defer></script>
<link rel="stylesheet" href="bootstrap_css/bootstrap.min.css">
<script src="bootstrap_js/bootstrap.bundle.min.js" defer></script>
<link rel="stylesheet" href="css/main.css">
<title>${train.getName()}</title>
</head>
<body class="bodyheight">
<c:import url="navbar.jsp"></c:import>
<div class="container">
	<h1>${train.getName() }</h1>
	<h1>Путь поезда</h1>
	<table class="table">
	<thead>
				<tr>
					<th>Имя cтанции</th>
					<th>Время прибытия</th>
					<th>Время отбытия</th>
				</tr>
	</thead>
	<tbody>
				<c:forEach items="${ways}" var="i">
				
				
					<tr>
						<td>${i.getStation().getName()}</td>
						<td>${i.getStart_time()}</td>
						<td>${i.getEnd_time()}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
</div>
</body>
</html>