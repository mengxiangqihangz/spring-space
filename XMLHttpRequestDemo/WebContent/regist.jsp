<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	var http_request=false;		//ajax核心对象名称
	var flag;			//定义标志位
function checkUser(){
/*------------创建XMLHttpRequest对象。在ajax中主要通过此对象处理发送请求和回应----------  */
 
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
	http_request.onreadystatechange=getResult;  //设置返回结果处理函数,即定义回调函数。
	var url="/XMLHttpRequestDemo/RegistServlet?userName="+name;
	http_request.open("post", url);
	http_request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	http_request.send(null);
	
}
function getResult(){
	if(http_request.readyState==4){			//返回数据完毕
		if(http_request.status==200){		//Http操作正常
			var text=http_request.responseText;		//	声明变量用于接收处理器返回的内容
			if(text=="true"){						
// 				alert("hhhhhhh");
// 				document.getElementById("msg").value="此用户名重复";			//.value用于更新表格中的内容。但是无表格则不行
				flag=false;													//无法正常提交表单
				document.getElementById("msg").innerHTML="此用户名重复"; 	
				//document.getElementById("msg")  获取指定表格的对象
			}else{
				flag=true;													//可以正常提交表单				
				document.getElementById("userName").innerHTML="此用户名可以使用";
			}
			
// 			alert(http_request.responseText);
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
				<td><input type="text" name="userName" id="userName" onblur="checkUser();"><span id="msg"></span>
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