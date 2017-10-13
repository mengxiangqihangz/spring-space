<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
	<h1>单个电影</h1>
	<form name="userForm" action="/springMVC1/product/updateProduct" method="post">
		<input type="hidden" name="id" value="${film.id }">
		姓名：<input type="text" name="proName" value="${film.filmID }">
		姓名：<input type="text" name="proName1" value="${film.filmScore }">
		姓名：<input type="text" name="proName2" value="${film.filmSynopsis }">
		姓名：<input type="text" name="proName3" value="${film.filmURL }">
		姓名：<input type="text" name="proName4" value="${film.filmURL1 }">
		年龄：<input type="text" name="proO2" value="${film.filmRank }">
		
		<input type="submit" value="编辑" >
		
		
	
	</form>
	
	
	
</body>
</html>