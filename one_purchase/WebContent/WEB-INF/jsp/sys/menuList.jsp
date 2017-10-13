<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" uri="/WEB-INF/tld/page.tld" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/logo.png"/>
    <title>宜乐购网上商城</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mmss.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"/>
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
            <li class="text-white h4">
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;<b>宜乐购网上商城</b>
            </li>
        </ul>
        <ul class="nav navbar-nav nav-pills right ">
            <li class="bg-warning ">
                <a href="#"><span class="glyphicon glyphicon-tasks"></span><span class="badge">1</span></a>
            </li>
            <li class="bg-success">
                <a href="#"><span class="glyphicon glyphicon-envelope"></span><span class="badge">2</span></a>
            </li>
            <li class="bg-danger">
                <a href="#"><span class="glyphicon glyphicon-bell"></span></a>
            </li>
            <li class="bg-info dropdown">
                <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user"></span>&nbsp;<span>系统管理员</span><span class="caret"></span>
                </a>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li class="text-center"><a href="#"><span class="text-primary">账号设置</span></a></li>
                    <li class="text-center"><a href="#"><span class="text-primary">消息设置</span></a></li>
                    <li class="text-center"><a href="#"><span class="text-primary">帮助中心</span></a></li>
                    <li class="divider"><a href="#"></a></li>
                    <li class="text-center"><a href="login.html"><span class="text-primary">退出</span></a></li>
                </ul>
            </li>
        </ul>
    </div>
</header>

<section >
			<%@include file="../leftMenu.jsp" %>
            <!--左侧导航结束-->
            <!----------------------------------------------------------------------------------------------------->
            <!--右侧内容开始-->
            <div class="col-xs-10">
                <br/>
                <ol class="breadcrumb">
                    <li><a href="index.html"><span class="glyphicon glyphicon-home"></span>&nbsp;后台首页</a></li>
                    <li class="active">系统管理 - 菜单管理</li>
                </ol>
                <div class="input-group line left">
                    <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-search"></span></span>
                    <input type="text" class="form-control" id="key" name="key" placeholder="输入关键字搜索" aria-describedby="basic-addon2">
                </div>
                <select class="form-control line left">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
                
                <a href="#" class=" btn btn-primary"  ><span id="find"   class="glyphicon glyphicon-search">查询</span></a>
                <a href="#" class=" btn btn-primary "><span class="glyphicon glyphicon-download">删除</span></a>
                <a href="#" class="btn btn-primary btn-sm" onclick="addMenu();">添加</a>
                <br/><br/>
                <table class="table table-bordered table-striped text-center bg-info">
                    <thead >
                    <tr class="info">
                    	<th class="text-center">序号</th>
                    	<th class="text-center">菜单名称</th>
                        <th class="text-center">菜单路径</th>
                        <th class="text-center">上级菜单ID</th>
                        <th class="text-center">菜单描述</th>
                        <th class="text-center">菜单等级</th>
                        <th class="text-center">创建人</th>
                        <th class="text-center">创建日期</th>
                        <th class="text-center">修改人</th>
						<th class="text-center">修改日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.data}" var="menu" varStatus="index">
	                    <tr>
	                    	<td>${index.count }</td>
	                        <td>${menu.menuName }</td>
	                        <td>${menu.menuPath }</td>
	                        <td>${menu.parentMenuId }</td>
	                        <td>${menu.menuDesc }</td>
	                        <td>${menu.menuLevel }</td>
	                        <td>${menu.creator }</td>
	                        <td>${menu.createDate }</td>
	                        <td>${menu.Modifier  }</td>
	                        <td>${menu.ModifyDate }</td>
	                        
<!-- 	                        private	    long    id; -->
<!-- 							private		String	menuName; -->
<!-- 							private		String	menuPath; -->
<!-- 							private		String	parentMenuId; -->
<!-- 							private		String	menuDesc; -->
<!-- 							private		int	    menuLevel; -->
<!-- 							private		int	    creator; -->
<!-- 							private		String	createDate; -->
<!-- 							private		int	    Modifier; -->
<!-- 							private	    String  ModifyDate; -->
	                        
	                        <td>
	                            <a href="#" class="btn btn-primary btn-sm" onclick="editMenu (${menu.id });">编辑</a>
	                            <a href="#" class="btn btn-primary btn-sm" onclick="delMenu(${menu.id });">删除</a>
	                        </td>
	                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
				<page:PageTag key="${key}" pageNo="${page.pageNo }" pageSize="${page.pageSize }" pageUrl="${pageContext.request.contextPath}/sys/menu/menuList" pageLast="${page.totalPage }"/>
            </div>
            <!--右侧内容结束-->
            
            
            <!-- Modal begin-->
            <!--添加-->
            <div class="modal fade" id="addMenu" tabindex="-1" role="dialog" aria-labelledby="addMenu">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="addMenu">新增角色信息</h4>
                        </div>
                        <div class="modal-body">
                            <form id="addForm" class="form-horizontal" role="form">
                            	<!-- 隐藏域，目的是做编辑操作的时候需要使用到 -->
                            	<input type="hidden" name="id" value=""/>
<!--                             	<input type="hidden" name="rolerId" value=""/> -->


								<div class="form-group">
							      <label for="menuName" class="col-sm-4 control-label">菜单名称</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" name="menuName" placeholder="请输入菜单名称">
							      </div>
							    </div>
                            	<div class="form-group">
							      <label for="menuPath" class="col-sm-4 control-label">菜单路径</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" name="menuPath" placeholder="请输入菜单路径">
							      </div>
							   </div>
							    <div class="form-group">
							      <label for="parentMenuId" class="col-sm-4 control-label">上级菜单ID</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" name="parentMenuId" placeholder="请输人上级菜单ID">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="menuDesc" class="col-sm-4 control-label">菜单描述</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" name="menuDesc" placeholder="请输人菜单描述">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="menuLevel" class="col-sm-4 control-label">菜单等级</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" name="menuLevel" placeholder="请输人菜单等级">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="creator" class="col-sm-4 control-label">创建人</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" name="creator" placeholder="请输人创建人">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="createDate" class="col-sm-4 control-label">创建日期</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" name="createDate" placeholder="请输人创建日期">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="Modifier" class="col-sm-4 control-label">修改人</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" name="Modifier" placeholder="请输人修改人">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="ModifyDate" class="col-sm-4 control-label">修改日期</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" name="ModifyDate" placeholder="请输人修改日期">
							      </div>
							   </div>
							</form>
                        </div>
                        <div class="modal-footer">
                            <button type="reset" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
                            <button type="button" id="saveMenuBtn" class="btn btn-primary btn-sm">保存</button>
                        </div>
                    </div>
                </div>
            </div>
            
            <!--Modal end-->
</section>

<footer class="bg-primary navbar-fixed-bottom">
    <p class="text-center text-white">版权所有&copy;ZLYG</p>
</footer>

<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.3.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

<script>
//     新增角色信息
    $("#saveMenuBtn").click (function () {
    	if($(".modal-title").text()=="新增菜单信息"){
    	$.post("${pageContext.request.contextPath}/sys/menu/add"
    			,$("#addForm").serialize(),
    			   function(data){
    			     if (data=='1'){
    			    	 alert('添加成功');
    			    	 window.location.reload();
    			     }else{
    			    	 alert("添加失败");
    			     }
    			   });
    	}
    	if($(".modal-title").text()=="编辑菜单信息"){
    		$.post("${pageContext.request.contextPath}/sys/menu/edit"
        			,$("#addForm").serialize(),
        			   function(data){
        			     if (data=='1'){
        			    	 alert('编辑成功');
        			    	 window.location.reload();
        			     }else{
        			    	 alert("编辑失败");
        			     }
        			   });
    	}
    });
    
//     新增角色信息
    function addMenu() {
    	// 网页中在标签中设置属性data-toggle="modal" data-target="#addMenu"来切换模态框
    	$(".modal-title").text ("新增菜单信息");
    	$('#addMenu').modal('toggle');// 手动切换模态框
    	// 清空一些不必要的信息
    	$("#addForm [name='id']").val('');
    	$("#addForm [name='menuName']").val('');
    	$("#addForm [name='menuPath']").val('');
    	$("#addForm [name='parentMenuId']").val('');
    	$("#addForm [name='menuDesc']").val('');
    	$("#addForm [name='menuLevel']").val('');
    	$("#addForm [name='creator']").val('');
    	$("#addForm [name='createDate']").val('');
    	$("#addForm [name='Modifier']").val('');
    	$("#addForm [name='ModifyDate']").val('');
    	
    };
  
    // 编辑角色信息
    function editMenu (id) {
    	$(".modal-title").text ("编辑菜单信息");
    	$('#addMenu').modal('toggle');
    	
    	$.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/sys/menu/get/"+id,
            dataType: "json",
            success: function(data){
            	//$.parseJSON(jsonstr);jQuery.parseJSON(jsonstr),可以将json字符串转换成json对象 jQuery插件支持的转换方式
            	//JSON.parse(jsonstr); //可以将json字符串转换成json对象 JSON.stringify(jsonobj); //可以将json对象转换成json对符串 (Firefox，chrome，opera，safari，ie9，ie8)
            	//alert(JSON.stringify(data));
            	// 为表单元素赋值
            	$("#addForm [name='id']").val(data.id);
            	$("#addForm [name='menuName']").val(data.menuNname);
            	$("#addForm [name='menuPath']").val(data.menuPath);
            	$("#addForm [name='parentMenuId']").val(data.parentMenuId);
            	$("#addForm [name='menuDesc']").val(data.menuEesc);
            	$("#addForm [name='menuLevel']").val(data.menuLevel);
            	$("#addForm [name='creator']").val(data.creator);
            	$("#addForm [name='createDate']").val(data.createDate);
            	$("#addForm [name='Modifier']").val(data.Modifier);
            	$("#addForm [name='ModifyDate']").val(data.Modify_date);
                     }
        });
    };
    
    // 删除角色信息
    function delMenu (id) {
		var isOK = confirm("你确定要删除么?");
		if (isOK) {
// 			document.location.href = "remove.do?userId=" + userId;
			$.post("${pageContext.request.contextPath}/sys/Menu/delete"
	    			,{id:id},
	    			   function(data){
	    			     if (data=='1'){
	    			    	 alert('删除成功');
	    			    	 window.location.reload();
	    			     }else{
	    			    	 alert("删除失败");
	    			     }
	    			   });
		};
	};
	
	//查询用户信息，传用户名模糊
// 	$("#find").click (function (){
// 		$.post("${pageContext.request.contextPath}/sys/user/findList"
//     			,$("#key").serialize());
    			
// 	});
	
	
// 	$("#find").click (function (){
// 		document.location="${pageContext.request.contextPath}/sys/user/findList?key="+document.getElementById("key").value;
// 	});
		
	
    
</script>
</body>
</html>