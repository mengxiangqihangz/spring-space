<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link type="text/css" href="css/login.css" rel="stylesheet" />
		<link type="text/css"
			href="css/smoothness/jquery-ui-1.7.2.custom.html" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>

		<script type="text/javascript" src="js/easyTooltip.js"></script>

		<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>


		<script type="text/javascript">
function check(p1, p2) {
	p1V = document.getElementById(p1).value;
	p2V = document.getElementById(p2).value;
	if (p1V != p2V) {
		document.getElementById('hint').innerHTML = '两次输入的密码不一致！';
		document.getElementById(p1).value = '';
		document.getElementById(p2).value = '';
	} else {

		document.getElementById('hint').innerHTML = ' ';
	}
}
function checknull() {
	
	var n = document.getElementById('na').value;
	var p1 = document.getElementById('p1').value;
	var p2 = document.getElementById('p2').value;
	if (n.length==0 || p1.length==0) {
		alert("账号或密码不能为空!");
		return false;
	}
	if(p1!=p2){
		alert("2次密码不同!");
		return false;
	}
}
</script>
	</head>
	<body>
		<div id="container">
			<div class="logo">
				<a href="#"><img src="assets/logo.png" alt="" /> </a>
			</div>
			<div id="box">
				<form action="/fr2u/user/addRegUser" method="POST"
					onsubmit="return checknull()">
					<p class="register">
						<label>
							用  户:
						</label>
						<input name="userName" placeholder="请输入用户名" id="na" />

					</p>

					<p class="register">

						<label>
							密  码:
						</label>
						<input type="password" name="password" id="p1" />
					</p>
					<p class="register">

						<label>
							再确认:
						</label>
						<input type="password" name="age1" id="p2" />
					</p>
					<div id="hint">
					</div>

					<p>
					<input type="submit" value="确认" class="space"/>
					</p>

				</form>
			</div>
		</div>
	</body>
</html>