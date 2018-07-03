<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Админ</title>
<script src="bootstrap_js/jquery-3.3.1.min.js" defer></script>
<link rel="stylesheet" href="bootstrap_css/bootstrap.min.css">
<script src="bootstrap_js/bootstrap.bundle.min.js" defer></script>
<link rel="stylesheet" href="css/adminpanel.css">
</head>
<body class="body">
	<c:import url="adminNavbar.jsp"></c:import>
	<div class="container">
			<div class="editing">
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