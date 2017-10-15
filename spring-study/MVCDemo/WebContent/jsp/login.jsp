<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>宜乐购网上商城</title>

    
</head>
<body>
	<form action="${pageContext.request.contextPath}/sys/login" method="post">
		<p>用户名：<input type="text" name="userName"/></p>
		<p>密&nbsp;&nbsp;码：<input type="password" name="userPwd"/></p>
		<p><input type="submit" value="提交"/></p>
	</form>
</body>
</html>