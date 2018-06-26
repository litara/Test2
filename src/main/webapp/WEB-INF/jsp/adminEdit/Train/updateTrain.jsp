<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="admin-train-update-true" class="container">
	<input type="hidden" name="id" value="${trainUpdate.getId()}">
	<input type="text" name="name" value="${trainUpdate.getName()}">
	<fmt:formatDate pattern="yyyy-MM-dd" value="${trainUpdate.getDate_start()}" type="date" var="date_start"/>
	<fmt:formatDate value="${trainUpdate.getDate_stop()}" pattern="yyyy-MM-dd" type="date" var="date_stop"/>
	<input type="date" class="date" name="date_start" value="<c:out value="${date_start}"/>">
	<input type="date" class="date" name="date_stop" value="<c:out value="${date_stop}"/>">
	<input type="submit" class="btn" value="Сохранить">
	
	</form>

</body>
</html>