<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="css/login.css" rel="stylesheet" />	
<link type="text/css" href="css/smoothness/jquery-ui-1.7.2.custom.html" rel="stylesheet" />	
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/easyTooltip.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
</head>
<body>
<div id="container">
		<div class="logo">
			<a href="#"><img src="assets/logo.png" alt="" /></a>
		</div>
		<div id="box">
			<form action="/springMVC1/user/checkUser" method="POST">
			<p class="main">
				<input name="userName" value="" placeholder="输入用户名"/> 
            </p>
                <p class="main" >
				<input type="password" name="password"  placeholder="输入密码" />	
			</p>
			
            <p >
			  <input type="submit" value="登录" class="login"/>      
              <input type="button" value="注册" class="register" onclick="window.location.href='register.jsp'"/> 
			</p>
			</form>
		</div>
	</div>
</body>
</html>