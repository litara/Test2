<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<title>Main page</title>

<script src="bootstrap_js/jquery-3.3.1.min.js" defer></script>
<link rel="stylesheet" href="bootstrap_css/bootstrap.min.css">
<script src="bootstrap_js/bootstrap.bundle.min.js" defer></script>
<link rel="stylesheet" href="css/main.css">
</head>
<body class="bodyheight">

	<c:import url="navbar.jsp"></c:import>

	<div class="container">
	<div class="myimage">
		<div style="padding-top: 170px;"></div>
			<div>
			<form method="POST" action="search" class="search row">
				<h2 class="search-content col-lg-2 font-italic">Откуда:</h2>
				<input type="text" name="stationStart" class="search-content form-control col-lg-2">
				<h2 class="search-content col-lg-2 font-italic">Куда:</h2>
				<input type="text" name="stationEnd" class="search-content form-control col-lg-2">
				<input type="date" name="date" class="search-content form-control col-lg-2">
				<input type="submit" class="search-content btn btn-primary col-lg-1" value="Поиск">
			</form>
			</div>
		<div style="padding-bottom: 150px;"></div>
	</div>
	</div>
	<c:if test="${search==true}">
		<c:import url="Edit/search.jsp"></c:import>
	</c:if>
	<div class="container">
		<div class="footer"></div>
	</div>
</body>