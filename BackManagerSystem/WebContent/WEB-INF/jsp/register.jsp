<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace-ie.min.css" />
		<![endif]-->
		<script src="${pageContext.request.contextPath}/resources/assets/js/ace-extra.min.js"></script>
		<!--[if lt IE 9]>
		<script src="${pageContext.request.contextPath}/resources/assets/js/html5shiv.js"></script>
		<script src="${pageContext.request.contextPath}/resources/assets/js/respond.min.js"></script>
		<![endif]-->
		<script src="${pageContext.request.contextPath}/resources/js/jquery-1.9.1.min.js"></script>        
        <script src="${pageContext.request.contextPath}/resources/assets/layer/layer.js" type="text/javascript"></script>
<title>登陆</title>
</head>

<body class="login-layout">
<div class="logintop">    
    <span>欢迎云联天下后台管理界面平台</span>    
    <ul>
    <li><a href="${pageContext.request.contextPath}/sys/login">登录</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    <div class="loginbody">
<div class="login-container">
	<div class="center">
	<h1>
									<i class="icon-leaf green"></i>
									<span class="orange">云联天下</span>
									<span class="white">后台管理系统</span>
								</h1>
								<h4 class="white">Background Management System</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box widget-box no-border visible">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												管理员注册
											</h4>

											<div class="login_icon"><img src="${pageContext.request.contextPath}/resources/images/login.png" /></div>

											 <form action="${pageContext.request.contextPath}/sys/register" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="登录名"  name="userName" id="userName">
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="密码" name="userPwd" id="pwd">
															<i class="icon-lock"></i>
														</span>
													</label>
													
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="重复密码" name="reuserPwd" id="rpwd" >
															<i class="icon-lock"></i>
														</span>
													</label>
													<h6 style="color:red;">${msg}</h6>
													<div class="space"></div>

													<div class="clearfix">
														<button type="reset" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															重置
														</button>

														<button type="sumbit" class="width-35 pull-right btn btn-sm btn-primary" onclick="check()">
															<i class="icon-key"></i>
															提交
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											 </form> 

											<div class="social-or-login center">
												<span class="bigger-110">通知</span>
											</div>

											<div class="social-login center">
											本网站系统不再对IE8以下浏览器支持，请见谅。
											</div>
										</div><!-- /widget-main -->

										<div class="toolbar clearfix">
											

											
										</div>
									</div><!-- /widget-body -->
								</div><!-- /login-box -->
							</div><!-- /position-relative -->
						</div>
                        </div>
                        <div class="loginbm">版权所有  2016  <a href="www.cloudoh.cn">深圳市云联天下科技有限公司</a> </div><strong></strong>
</body>
</html>
<!-- <script type="text/javascript">
	function check(){
		var name = document.getElementById("userName");
		var first = document.getElementById("pwd");
		var second = document.getElementById("rpwd");
		if(name=="" || name==null){
			pageContext.setAttribute("msg", "用户名不能为空，请输入用户名！");
			return false;
		}else if(first != second){
			pageContext.setAttribute("msg", "输入的两次密码不一致，请重新输入！");
			return false;
		}else{
			$.ajax({
				type : "POST", //提交方式  
				url : "${pageContext.request.contextPath}/sys/register",//路径  
				data : {
					userName : $("#userName").val(),
					userPwd : $("#userPwd").val(),
				},//数据，这里使用的是Json格式进行传输  
				success : function(data) {//返回数据根据结果进行相应的处理  
					if (data == "1") {
						confirm("注册成功，请选择登录！");
						location.reload();
					} else {
						request.setAttribute("msg", "注册的用户名已存在，请重新输入！");
						return false;
					}
				}
			});
		}
		
	}
</script>
 -->