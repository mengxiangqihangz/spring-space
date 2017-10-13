<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat,model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="su" uri="/showUser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="js/jquery-3.0.0.js"></script>
<script type="text/javascript">
	/* var http_request = false;
	function getXmlHttpRequest() {
		if (window.XMLHttpRequest) {//非IE浏览器
			http_request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {//IE浏览器
			try {
				http_request = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					http_request = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}
		if (!http_request) {
			alert("无法创建XMLHttpRequest对象！");
			return false;
		} 
	}

	function login() {
		getXmlHttpRequest();
		var name = document.getElementById("userName").value;
		var pwd = document.getElementById("pwd").value;
		http_request.onreadystatechange = getResult;//设置返回结果处理函数
		var url = "/testweb/WebServlet?userName=" + name+"&pwd="+pwd;
		http_request.open("post", url);
		http_request.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded")
		http_request.send(null);
	}
	function getResult() {
		if (http_request.readyState == 4) {
			if (http_request.status == 200) {
				var aaa = document.getElementById("login");
				alert(http_request.responseText);
			} else {
				alert(http_request.status);
				alert("请求服务器发生错误");
			}

		}
	} */

	function login() {
		var name = $('#userName').val();
		var pwd = $('#pwd').val();
		/* $.get('/testweb/WebServlet?userName=" + name+"&pwd="+pwd',function(data,status){
			if(status==200){}
				alert(data);
			}
		}); */
		/* 	$.post('/testweb/WebServlet',{userName:name,pwd:pwd},function(){
				if(status==200){}
				alert(data);
			}
			}); */

		$.ajax({
			cache : "false",
			type : "post",
			url : "/PostComment.jsp",
			data : "ID=" + id + "&name=" + commName,
			success : function(msg) {
				if (msg == "OK") {
					alert("发表成功！");
				} else if (msg == "Error") {
					alert("添加失败！");
				}
			}
		});
	}
</script>
</head>
<body>
	<form action="" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" id="userName" name="userName"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" id="pwd" name="pwd"></td>
			</tr>
			<tr>
				<td><input type="button" value="提交" onclick="login();"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
	<a href="regist.jsp">注册</a>

</body>
</html>