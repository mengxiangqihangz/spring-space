<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="resources/img/logo.png"/>
    <title>宜乐购网上商城</title>
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/user/css/default.css" rel="stylesheet">

    <!--[if lt IE 9]>
	<script src="resources/js/html5shiv.min.js"></script>
	<script src="resources/js/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript" src="resources/js/user.js"></script>
</head>
<body onkeydown="on_return();">
<div class="box">
    <br/>
    <h1 class="text-center text-white"><span class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;宜乐购网上商城</h1>
    <div class="login-box">
        <div class="login-title text-center">
            <h1><small>登录</small></h1>
        </div>
        <div class="login-content ">
            <div class="form">
                <form action="sys/login" method="post">
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input type="text" id="userName" name="userName" class="form-control" placeholder="用户名">
                            </div>
                            <span id="userNameErr" style="color: red;"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                <input type="password" id="pwd" name="pwd" class="form-control" placeholder="密码">
                            </div>
                            <span id="userPwdErr" style="color: red;"></span>
                        </div>
                    </div>
                    <div class="form-group form-actions">
                        <div class="col-xs-4 col-xs-offset-4 " style="margin: 0 37%;">
                            <a id="sub" href="#" onclick="validLogin ();" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-off"></span> 登录</a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-6 link">
                            <p class="text-center remove-margin"><small>忘记密码？</small> <a href="javascript:void(0)" ><small>找回</small></a>
                            </p>
                        </div>
                        <div class="col-xs-6 link">
                            <p class="text-center remove-margin"><small>还没注册?</small> <a href="register.html" ><small>注册</small></a>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script src="resources/js/jquery-1.11.3.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script>
    /*Bootlint工具用于对页面中的HTML标签以及Bootstrapclass的使用进行检测
    (function () {
        var s = document.createElement("script");
        s.onload = function () {
            bootlint.showLintReportForCurrentDocument([]);
        };
        s.src = "js/bootlint.js";
        document.body.appendChild(s)
    })();*/
</script>
</body>
</html>