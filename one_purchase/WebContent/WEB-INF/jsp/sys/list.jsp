<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="page" uri="/WEB-INF/tld/page.tld"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/img/logo.png" />
<title>宜乐购网上商城</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/mmss.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" />
<!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/resources/js/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>
    <![endif]-->
<style>
</style>

</head>
<body>
	<header>
		<div class="container-fluid navbar-fixed-top bg-primary">
			<ul class="nav navbar-nav  left">
				<li class="text-white h4">&nbsp;&nbsp;&nbsp;&nbsp;<span
					class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;<b>宜乐购网上商城</b>
				</li>
			</ul>
			<ul class="nav navbar-nav nav-pills right ">
				<li class="bg-warning "><a href="#"><span
						class="glyphicon glyphicon-tasks"></span><span class="badge">1</span></a>
				</li>
				<li class="bg-success"><a href="#"><span
						class="glyphicon glyphicon-envelope"></span><span class="badge">2</span></a>
				</li>
				<li class="bg-danger"><a href="#"><span
						class="glyphicon glyphicon-bell"></span></a></li>
				<li class="bg-info dropdown"><a class="dropdown-toggle"
					href="#" data-toggle="dropdown"> <span
						class="glyphicon glyphicon-user"></span>&nbsp;<span>系统管理员</span><span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu dropdown-menu-right">
						<li class="text-center"><a href="#"><span
								class="text-primary">账号设置</span></a></li>
						<li class="text-center"><a href="#"><span
								class="text-primary">消息设置</span></a></li>
						<li class="text-center"><a href="#"><span
								class="text-primary">帮助中心</span></a></li>
						<li class="divider"><a href="#"></a></li>
						<li class="text-center"><a
							href="${pageContext.request.contextPath}/login.jsp"><span
								class="text-primary">退出</span></a></li>
					</ul></li>
			</ul>
		</div>
	</header>

	<section>
		<%@include file="../leftMenu.jsp"%>
		<!--左侧导航结束-->
		y
		<!----------------------------------------------------------------------------------------------------->
		<!--右侧内容开始-->
		<div class="col-xs-10">
			<br />
			<ol class="breadcrumb">
				<li><a href="index.html"><span
						class="glyphicon glyphicon-home"></span>&nbsp;后台首页</a></li>
				<li class="active">系统管理 - 用户管理</li>
			</ol>
			<div class="input-group line left">
				<span class="input-group-addon" id="basic-addon2"><span
					class="glyphicon glyphicon-search"></span></span> <input type="text"
					class="form-control" id="key" name="key" placeholder="输入关键字搜索"
					aria-describedby="basic-addon2">
			</div>
			<a href="#" class=" btn btn-primary "><span id="queryda"
				class="glyphicon glyphicon-search" onclick="fineda();">查询</span></a> <a
				href="#" class=" btn btn-primary "><span
				class="glyphicon glyphicon-download">删除</span></a> <a href="#"
				class="btn btn-primary btn-sm" id="add" onclick="addUser();">添加</a>
			<a href="#" class="btn btn-primary btn-sm" id="sdu"
				onclick="searchDelUser();">查询被删员工</a> <br /> <br />
			<table class="table table-bordered table-striped text-center bg-info">
				<thead>
					<tr class="info">
						<th class="text-center">用户编码</th>
						<th class="text-center">用户名</th>
						<th class="text-center">性别</th>
						<th class="text-center">年龄</th>
						<th class="text-center">身份证</th>
						<th class="text-center">电子邮箱</th>
						<th class="text-center">手机</th>
						<th class="text-center">固话</th>
						<th class="text-center">职位</th>
						<th class="text-center">账号状态</th>
						<th class="text-center">用户账号</th>
						<th class="text-center">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.data}" var="user" varStatus="index">
						<tr>
							<td>${user.userId }</td>
							<td>${user.userName }</td>
							<td><c:choose>
									<c:when test="${user.sex == '1'}">男</c:when>
									<c:when test="${user.sex == '-1'}">人妖</c:when>
									<c:otherwise>女</c:otherwise>
								</c:choose></td>
							<td>${user.age }</td>
							<td>${user.cardId }</td>
							<td>${user.email }</td>
							<td>${user.mobile }</td>
							<td>${user.tel }</td>
							<td>${user.postName }</td>
							<td><c:choose>
									<c:when test="${user.status == '1'}">可用</c:when>
									<c:when test="${user.status == '0'}">禁用</c:when>
								</c:choose></td>
							<td>${user.account }</td>
							<td>
								 <c:choose>
									<c:when test="${user.visitable == '0' }">
										<a href="#" class="btn btn-primary btn-sm"
											onclick="recover (${user.userId});">恢复</a>
									</c:when>
									<c:otherwise>
										<a href="#" class="btn btn-primary btn-sm"
											onclick="editUser (${user.userId});">编辑</a>
										<a href="#" class="btn btn-primary btn-sm"
											onclick="delUser(${user.userId });">删除</a>
							</td>
							</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<page:PageTag key="${key}"  pageNo="${page.pageNo }" pageSize="${page.pageSize }"
				pageUrl="${pageContext.request.contextPath}/sys/user/search"
				pageLast="${page.totalPage }" />
		</div>
		<!--右侧内容结束-->


		<!-- Modal begin-->
		<!--添加-->
		<div class="modal fade" id="addUser" tabindex="-1" role="dialog"
			aria-labelledby="addUser">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="addUser">新增用户信息</h4>
					</div>
					<div class="modal-body">
						<form id="addForm" class="form-horizontal" role="form">
							<!-- 隐藏域，目的是做编辑操作的时候需要使用到 -->
							<!-- 							<INPUT TYPE="HIDDEN" NAME="ID" VALUE="" />  -->
							<input type="hidden" name="userId" value="" />
							<div class="form-group">
								<label for="userName" class="col-sm-4 control-label">用户名</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" name="userName"
										placeholder="请输入用户名">
								</div>
							</div>
							<div class="form-group">
								<label for="sex" class="col-sm-4 control-label">性别</label>
								<div class="col-sm-8">
									<input type="radio" checked="checked" name="sex" value="1" />男
									&nbsp;&nbsp; <input type="radio" name="sex" value="0" />女
								</div> 
							</div>
							<div class="form-group">
								<label for="cardId" class="col-sm-4 control-label">身份证号</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="cardId"
										name="cardId" placeholder="请输入身份证号">
								</div>
							</div>
							<div class="form-group">
								<label for="email" class="col-sm-4 control-label">邮箱</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="email" name="email"
										placeholder="请输入邮箱">
								</div>
							</div>
							<div class="form-group">
								<label for="mobile" class="col-sm-4 control-label">手机号码</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="mobile"
										name="mobile" placeholder="请输入手机号码">
								</div>
							</div>
							<div class="form-group">
								<label for="tel" class="col-sm-4 control-label">固定电话</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="tel" name="tel"
										placeholder="请输入固定电话">
								</div>
							</div>
							<div class="form-group">
								<label for="status" class="col-sm-4 control-label">用户状态</label>
								<div class="col-sm-8">
									<input type="radio" checked="checked" name="status" value="1" />启用
									&nbsp;&nbsp; <input type="radio" name="status" value="0" />禁用
								</div>
							</div>
							<div class="form-group">
								<label for="postId" class="col-sm-4 control-label">职位</label>
								<div class="col-sm-8">
									<select class="form-control" id="postId" name="postId">
										<c:forEach items="${post}" var="post" varStatus="index">
											<option value="${post.roleId }">${post.roleName }</option>
										</c:forEach>
									</select>

								</div>
							</div>
							<div class="form-group">
								<label for="account" class="col-sm-4 control-label">登陆账号</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="account"
										name="account" placeholder="请输入登陆账号">
								</div>
							</div>
							<div class="form-group">
								<label for="pwd" class="col-sm-4 control-label">登陆密码</label>
								<div class="col-sm-8">
									<input type="text" readonly="readonly" class="form-control"
										value="123456" id="pwd" name="pwd">
								</div>
							</div>
							<input type="hidden" name="visitable" value="1" />
						</form>
					</div>
					<div class="modal-footer">
						<button type="reset" class="btn btn-default btn-sm"
							data-dismiss="modal">取消</button>
						<button type="button" id="saveUserBtn"
							class="btn btn-primary btn-sm">保存</button>
					</div>
				</div>
			</div>
		</div>
		<!--Modal end-->
	</section>

	<footer class="bg-primary navbar-fixed-bottom">
		<p class="text-center text-white">版权所有&copy;ZLYG</p>
	</footer>

	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

	<script>
    // 新增用户信息
    $("#saveUserBtn").click (function () {
    	if($(".modal-title").text() =="编辑用户信息"){
    		$.post("${pageContext.request.contextPath}/sys/user/edit"
    			,$("#addForm").serialize(),
    			   function(data){
    			     if (data=='1'){ 
    			    	 alert('编辑成功');
    			    	 location.reload(true);
    			     }else{
    			    	 alert("编辑失败");
    			     }
    		});
   		 }else{
    		$.post("${pageContext.request.contextPath}/sys/user/add"
    			,$("#addForm").serialize(),
    			   function(data){
    			     if (data=='1'){
    			    	 alert('添加成功');
    			    	 document.location.href = "${pageContext.request.contextPath }/sys/user/list"
    			     }else{
    			    	 alert("添加失败");
    			     }
    	 });
    }
    });
    
 

    
    

    // 新增用户信息
    function addUser() {
    	// 网页中在标签中设置属性data-toggle="modal" data-target="#addUser"来切换模态框
    	$(".modal-title").text ("新增用户信息");
    	$('#addUser').modal('toggle');// 手动切换模态框
    	// 清空一些不必要的信息
    	$("#addForm [name='userId']").val('');
    	$("#addForm [name='userName']").val('');
    	$("#addForm [name='sex'][value="+1+"]").attr("checked","checked");
    	$("#addForm [name='cardId']").val('');
    	$("#addForm [name='email']").val('');
    	$("#addForm [name='mobile']").val('');
    	$("#addForm [name='tel']").val('');
    	$("#addForm [name='status'][value="+1+"]").attr("checked","checked");
    	$("#addForm [name='postId']").val('1003');
    	$("#addForm [name='account']").val('');
    	$("#addForm [name='pwd']").val(data.pwd);
    	$("#addForm [name='visitable']").val('');
    };
    
    // 编辑用户信息
    function editUser (Id) {
    	$(".modal-title").text ("编辑用户信息");
    	$('#addUser').modal('toggle');

    	$.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/sys/user/get/"+Id,
            dataType: "json",
            success: function(data){
            	console.log(data);
            	//$.parseJSON(jsonstr);jQuery.parseJSON(jsonstr),可以将json字符串转换成json对象 jQuery插件支持的转换方式
            	//JSON.parse(jsonstr); //可以将json字符串转换成json对象 JSON.stringify(jsonobj); //可以将json对象转换成json对符串 (Firefox，chrome，opera，safari，ie9，ie8)
            	//alert(JSON.stringify(data));
            	// 为表单元素赋值
            	$("#addForm [name='userId']").val(data.userId);
            	$("#addForm [name='userName']").val(data.userName);
            	$("#addForm [name='sex'][value="+data.sex+"]").attr("checked","checked");
            	$("#addForm [name='cardId']").val(data.cardId);
            	$("#addForm [name='email']").val(data.email);
            	$("#addForm [name='mobile']").val(data.mobile);
            	$("#addForm [name='tel']").val(data.tel);
            	$("#addForm [name='status'][value="+data.status+"]").attr("checked","checked");
            	$("#addForm [name='postId']").val(data.postId);
            	$("#addForm [name='account']").val(data.account);
            	$("#addForm [name='pwd']").val(data.pwd);
            	$("#addForm [name='visitable']").val(data.visitable);
                     }
        });
    };
   
    // 删除用户信息
    function delUser (Id) {
		if (confirm("你确定要删除么?")) {
			$.post("${pageContext.request.contextPath}/sys/user/delete",{userId:Id},
	    			   function(data){
	    			     	if (data=='1'){
	    			    		 alert('删除成功');
	    			    		 document.location.href = "${pageContext.request.contextPath }/sys/user/list";
	    			     	}else{
	    			    		 alert("删除失败");
	    			     	}
	    		});
		};
	};
    // 恢复用户信息
    function recover (Id) {
		if (confirm("你确定要恢复么?")) {
			$.post("${pageContext.request.contextPath}/sys/user/recover",{userId:Id},
	    			   function(data){
	    			     	if (data=='1'){
	    			    		 alert('恢复成功');
	    			    		 document.location.href = "${pageContext.request.contextPath }/sys/user/list";
	    			     	}else{
	    			    		 alert("恢复失败");
	    			     	}
	    		});
		};
	};

	 function fineda(){
	
		 document.location.href = "${pageContext.request.contextPath }/sys/user/search?key="+document.getElementById('key').value;
	} 

	function searchDelUser(){
		document.location.href="${pageContext.request.contextPath }/sys/user/searchDelUser";
	}
	
	
	
</script>
</body>
</html>