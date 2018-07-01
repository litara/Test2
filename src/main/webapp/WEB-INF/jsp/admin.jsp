<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="bootstrap_js/jquery-3.3.1.min.js" defer></script>
<link rel="stylesheet" href="bootstrap_css/bootstrap.min.css">
<script src="bootstrap_js/bootstrap.bundle.min.js" defer></script>
<link rel="stylesheet" href="css/adminpanel.css">
</head>
<body class="body">
	<c:import url="navbar.jsp"></c:import>
	<div class="container">
		<div class="row">
			<div class="col-3 navigation container-fluid">
				<a class="mybtn btn-dark btn elementPanel" href="admin-passenger">Пассажиры</a>
				<a class="mybtn btn-dark btn elementPanel" href="admin-train">Поезда</a>
				<a class="mybtn btn-dark btn elementPanel" href="admin-station">Станции</a>
				<a class="mybtn btn-dark btn elementPanel" href="admin-way">Пути следования</a>
				<a class="mybtn btn-dark btn elementPanel" href="admin-class">Классы вагона</a>
				<a class="mybtn btn-dark btn elementPanel" href="admin-type">Типы вагона</a>
				<a class="mybtn btn-dark btn elementPanel" href="admin-category">Категории вагона</a>
				<a class="mybtn btn-dark btn elementPanel" href="admin-coach">Вагоны</a>
				<a class="mybtn btn-dark btn elementPanel" href="admin-timetable">Расписание</a>
				<a class="mybtn btn-dark btn elementPanel" href="admin-consist">Составы</a>
				<a class="mybtn btn-dark btn elementPanel" href="admin-place">Места</a>
			</div>
			<div class="col-9 editing">
				<c:if test="${nameOfTable==null}">
					<h6>Поздравляю, вы находитесь в панеле админа.</h6>
				</c:if>
				<c:if test="${nameOfTable != null }">
				<c:import url="adminEdit/${nameOfTable }/create${nameOfTable}.jsp"></c:import>
					<c:if test="${update==true }">
						<c:import url="adminEdit/${nameOfTable }/update${nameOfTable }.jsp"></c:import>
					</c:if>
				<c:import url="adminEdit/${nameOfTable }/table${nameOfTable}.jsp"></c:import>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>