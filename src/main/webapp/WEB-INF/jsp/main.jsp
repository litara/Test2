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
	<div style="padding-top: 125px;"></div>
			<div class="search">
				<h2>От куда:</h2>
				<input type="text">
				<h2>Куда:</h2>
				<input type="text">
			</div>
	<div style="padding-bottom: 125px;"></div>
	</div>
	</div>
</body>