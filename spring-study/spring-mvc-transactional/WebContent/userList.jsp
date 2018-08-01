<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center" width="70%">
<tr>
	<td>用户名</td>
	<td>密码</td>
	<td>年龄</td>
	<td>地址</td>
	<td>&nbsp;&nbsp;</td>
</tr>
<c:forEach items="${list }" var="user">
<tr>
<td>${user.name }</td>
<td>${user.pwd }</td>
<td>${user.age }</td>
<td>${user.addr }</td>
<td><a href="<%= request.getContextPath() %>/edit.do?id=${user.id}">修改</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>