<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新用户注册</title>
<script src="resource/js/jquery-3.0.0.min.js"></script>
<script type="text/javascript">

function commit(){
	var method= "${method}";
	alert(method);
	if(method=="edit"){
		var id=$('#id').val();
		var name=$('#name').val();
		alert(name);
		var pwd=$('#pwd').val();
		var age=$('#age').val();
		var addr=$('#addr').val();
		document.location.href="<%= request.getContextPath() %>/update.do?id="+id+"&name="+name+"&pwd="+pwd+"&age="+age+"&addr="+addr;
	}else{
		document.userForm.submit();
	}
}
</script>
</head>
<body>
<form method="post" action="<%= request.getContextPath() %>/regist.do" name="userForm">
	<table>
		<tr>			
			<td>用户名
				<input type="hidden" id="method" name="method" value="${method }">
				<input type="hidden" id="id" name="id" value="${user.id }">
			</td>
			<td><input type="text" id="name" name="name" value="${user.name }"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="text" id="pwd" name="pwd"  value="${user.pwd }"></td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text" id="age" name="age" value="${user.age }"></td>
		</tr>
		<tr>
			<td>地址</td>
			<td><input type="text" id="addr" name="addr" value="${user.addr }"></td>
		</tr>
		<tr>
				<td>
					<input type="reset" value="重置">
				</td>
				<td>
					<input type="button" value="提交" onclick="commit();">
				</td>
			</tr>
	</table>
</form>
</body>
</html>