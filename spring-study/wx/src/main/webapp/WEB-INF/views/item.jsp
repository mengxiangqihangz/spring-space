<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详情</title>
</head>
<body>
	获取成功：${user.name}
	<br>
	<table style = "border:solid blue 1px">
		<c:forEach items="${list}" var="users">
			<tr>
				<td align="center">${users.id}</td>
				<td align="center">${users.name}</td>
				<td align="center">${users.age}</td>
				<td align="center">${users.sex}</td>
				<td align="center">${users.mobile}</td>
				<!-- 自定义标签 -->
			</tr>

		</c:forEach>
	</table>
	<br>

</body>
</html>