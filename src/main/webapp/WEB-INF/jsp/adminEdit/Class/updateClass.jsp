<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="admin-class-update-true" class="container">
	<input type="hidden" name="id" value="${classUpdate.getId()}">
	<input type="text" class="text" name="name" value="${classUpdate.getName()}">
	<input type="submit" class="btn" value="Сохранить">
	
	</form>

</body>
</html>