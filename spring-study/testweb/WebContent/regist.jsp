<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var http_request=false;
function checkUser(){
	if(window.XMLHttpRequest){//非IE浏览器
		http_request=new XMLHttpRequest();
	}else if(window.ActiveXObject){//IE浏览器
		try{
			http_request=new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
				http_request=new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){}
		}
	}
	if(!http_request){
		alert("无法创建XMLHttpRequest对象！");
		return false;
	}
	var name=document.getElementById("userName").value;
	http_request.onreadystatechange=getResult;//设置返回结果处理函数
	var url="/testweb/RegistServlet?userName="+name;
	http_request.open("post", url);
	http_request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
	http_request.send(null);
	
}
function getResult(){
	if(http_request.readyState==4){
		if(http_request.status==200){
			alert(http_request.responseText);
		}else{
			alert("请求服务器发生错误");
		}
	}
}
</script>
</head>
<body>
	<form action="" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="userName" id="userName" onblur="checkUser();">
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="pwd" id="pwd">
				</td>
			</tr>
			<tr>
				<td>重复密码</td>
				<td><input type="text" name="pwd2" id="pwd2">
				</td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" id="name">
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phone" id="phone">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>