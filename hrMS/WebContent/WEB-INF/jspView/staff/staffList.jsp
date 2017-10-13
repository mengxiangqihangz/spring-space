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
                    <span class="glyphicon glyphicon-user"></span>&nbsp;<span id="xitong">系统管理员</span><span class="caret"></span>
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
                    <li class="active">系统管理 - 员工管理</li>
                </ol>
                <div class="input-group line left" id="abc">
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
                
                <a href="#" class=" btn btn-primary "><span id="queryda"class="glyphicon glyphicon-search"onclick="fineda();" >查询</span></a>
                <a href="#" class=" btn btn-primary "><span class="glyphicon glyphicon-download">删除</span></a>
                <a href="#" class="btn btn-primary btn-sm" onclick="addUser();">添加</a>
                <br/><br/>
                <table class="table table-bordered table-striped text-center bg-info">
                    <thead >
                    <tr class="info">
                    	<th class="text-center">序号</th>
                        <th class="text-center">员工编码</th>
                        <th class="text-center">员工姓名</th>
                        <th class="text-center">性别</th>
                        <th class="text-center">员工状态</th>
                        <th class="text-center">来源</th>
                        <th class="text-center">预约人</th>
                        <th class="text-center">创建日期</th>
                        <th class="text-center">创建人</th>
                        <th class="text-center">来访日期</th>
                        <th class="text-center">出生日期</th>
                        <th class="text-center">毕业学校</th>
                        <th class="text-center">最高学历</th>
                        <th class="text-center">联系方式</th>
                        <th class="text-center">紧急联系人</th>
                        <th class="text-center">紧急联系人电话</th>
                        <th class="text-center">面试职位</th>
                        <th class="text-center">面试人id</th>
                        <th class="text-center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.data}" var="staff" varStatus="index">
	                    <tr>
	                    	<td>${index.count }</td>
	                        <td>${staff.staff_id }</td>
	                        <td>${staff.staff_name }</td>
	                        <td>
<%-- 	                        	<c:if test="${staff.sex eq '1'}">男</c:if> --%>
<%-- 	                        	<c:if test="${staff.sex eq '0'}">女</c:if> --%>
								<c:choose>
									<c:when test="${staff.sex == '1'}">男</c:when>
									<c:when test="${staff.sex == '0'}">女</c:when>
								</c:choose>
	                        </td>
	                        <td>${staff.status}</td>
	                        <td>${staff.source }</td>
	                        <td>${staff.reservation }</td>
	                        <td>${staff.buildDate }</td>
	                        <td>${staff.buildMan }</td>
	                        <td>${staff.visitDate }</td>
	                        <td>${staff.birthday }</td>
	                        <td>${staff.graduateSchool }</td>
	                        <td>${staff.education }</td>
	                        <td>${staff.contact }</td>
	                        <td>${staff.urgencyName }</td>
	                        <td>${staff.urgencyPhone }</td>
	                        <td>${staff.jobInterview }</td>
<%-- 	                        <td>${staff.visible }</td> --%>
	                        <td>${staff.userId }</td>
	                        <td>
	                            <a href="#" class="btn btn-primary btn-sm" onclick="editUser (${staff.id});">编辑</a>
	                            <a href="#" class="btn btn-primary btn-sm" onclick="delUser(${staff.id });">拉黑</a>
	                        </td>
	                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
				<page:PageTag key="${key}" pageNo="${page.pageNo }" pageSize="${page.pageSize }" pageUrl="${pageContext.request.contextPath}/sys/staff/quda"  pageLast="${page.totalPage }"/>
            </div>
            <!--右侧内容结束-->
            
            
            <!-- Modal begin-->
            <!--添加-->
            <div class="modal fade" id="addUser" tabindex="-1" role="dialog" aria-labelledby="addUser">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="addUser">新增员工信息</h4>
                        </div>
                        <div class="modal-body">
                            <form id="addForm" class="form-horizontal" role="form">
                            	<!-- 隐藏域，目的是做编辑操作的时候需要使用到 -->
                            	<input type="hidden" name="id" value=""/>
                            	<div class="form-group">
							      <label for="staff_id" class="col-sm-4 control-label">员工编号</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="staff_id" name="staff_id" placeholder="请输入员工编号">
							      </div>
							   </div>
							    <div class="form-group">
							      <label for="staff_name" class="col-sm-4 control-label">用户名</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" name="staff_name" placeholder="请输入员工姓名">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="sex" class="col-sm-4 control-label">性别</label>
							      <div class="col-sm-8">
							         <input type="radio" name="sex" value="1"/>男 &nbsp;&nbsp;
							         <input type="radio" name="sex" value="0"/>女
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="status" class="col-sm-4 control-label">员工状态</label>
							      <div class="col-sm-8">
<!-- 							         <input type="text" class="form-control" id="status" name="status" placeholder="请输入员工状态"> -->
							         <select class="form-control" id="status" name="status">
					                    <option>预约</option>
					                    <option>面试</option>
					                    <option>考核</option>
					                    <option>入职</option>
					                    <option>转正</option>
					                </select>
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="source" class="col-sm-4 control-label">来源</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="source" name="source" placeholder="请输入员工来源">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="reservation" class="col-sm-4 control-label">预约人</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="reservation" name="reservation" placeholder="请输入预约人">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="buildDate" class="col-sm-4 control-label">创建日期</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="buildDate" name="buildDate" placeholder="请输入创建日期">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="buildMan" class="col-sm-4 control-label">创建人</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="buildMan" name="buildMan" placeholder="请输入创建人">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="visitDate" class="col-sm-4 control-label">来访日期</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="visitDate" name="visitDate" placeholder="请输入来访日期">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="birthday" class="col-sm-4 control-label">出生日期</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="birthday" name="birthday" placeholder="请输入出生日期">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="graduateSchool" class="col-sm-4 control-label">毕业学校</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="graduateSchool" name="graduateSchool" placeholder="请输入毕业学校">
							      </div>
							   </div>
							    <div class="form-group">
							      <label for="education" class="col-sm-4 control-label">最高学历</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="education" name="education" placeholder="请输入最高学历">
							      </div>
							   </div>
							    <div class="form-group">
							      <label for="contact" class="col-sm-4 control-label">联系方式</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="contact" name="contact" placeholder="请输入联系方式">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="urgencyName" class="col-sm-4 control-label">紧急联系人</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="urgencyName" name="urgencyName" placeholder="请输入紧急联系人">
							      </div>
							   </div>
							    <div class="form-group">
							      <label for="urgencyPhone" class="col-sm-4 control-label">紧急联系人电话</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="urgencyPhone" name="urgencyPhone" placeholder="请输入紧急联系人电话">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="jobInterview" class="col-sm-4 control-label">面试职位</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="jobInterview" name="jobInterview" placeholder="请输入面试职位">
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="visible" class="col-sm-4 control-label">是否可见</label>
							      <div class="col-sm-8">
							         <input type="radio" name="visible" value="1"/>是 &nbsp;&nbsp;
							         <input type="radio" name="visible" value="0"/>否
							      </div>
							   </div>
							   <div class="form-group">
							      <label for="userId" class="col-sm-4 control-label">面试人id</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="userId" name="userId" placeholder="请输入面试人id">
							      </div>
							   </div>
							</form>
                        </div>
                        <div class="modal-footer">
                            <button type="reset" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
                            <button type="button" id="saveUserBtn" class="btn btn-primary btn-sm">保存</button>
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
    // 新增用户信息
    $("#saveUserBtn").click (function () {
    	if($(".modal-title").text() =="编辑员工信息"){
    		$.post("${pageContext.request.contextPath}/sys/staff/edit"
    			,$("#addForm").serialize(),
    			   function(data){
    			     if (data=='1'){ 
    			    	 alert('编辑成功');
    			    	 document.location.href = "${pageContext.request.contextPath }/sys/staff/list"
    			     }else{
    			    	 alert("编辑失败");
    			     }
    		});
   		 }else{
    		$.post("${pageContext.request.contextPath}/sys/staff/add"
    			,$("#addForm").serialize(),
    			   function(data){
    			     if (data=='1'){
    			    	 alert('添加成功');
    			    	 document.location.href = "${pageContext.request.contextPath }/sys/staff/list"
    			     }else{
    			    	 alert("添加失败");
    			     }
    	 });
    }
    });
    
    
    

    // 新增用户信息
    function addUser() {
    	// 网页中在标签中设置属性data-toggle="modal" data-target="#addUser"来切换模态框
    	$(".modal-title").text ("新增员工信息");
    	$('#addUser').modal('toggle');// 手动切换模态框
    	// 清空一些不必要的信息
    	$("#addForm [name='id']").val('');
    	$("#addForm [name='staff_id']").val('');
    	$("#addForm [name='staff_name']").val('');
    	$("#addForm [name='sex'][value="+1+"]").attr("checked","checked");
    	$("#addForm [name='status']").val('预约');
    	$("#addForm [name='source']").val('');
    	$("#addForm [name='reservation']").val('');
    	$("#addForm [name='buildDate']").val('');
    	$("#addForm [name='buildMan']").val('');
    	$("#addForm [name='visitDate']").val('');
    	$("#addForm [name='birthday']").val('');
    	$("#addForm [name='graduateSchool']").val('');
    	$("#addForm [name='education']").val('');
    	$("#addForm [name='contact']").val('');
    	$("#addForm [name='urgencyName']").val('');
    	$("#addForm [name='urgencyPhone']").val('');
    	$("#addForm [name='jobInterview']").val('');
    	$("#addForm [name='visible'][value="+1+"]").attr("checked","checked");
    	$("#addForm [name='userId']").val('');
    };
    
    // 编辑用户信息
    function editUser (Id) {
    	$(".modal-title").text ("编辑员工信息");
    	$('#addUser').modal('toggle');
    	$.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/sys/staff/get/"+Id,
            dataType: "json",
            success: function(data){
            	//$.parseJSON(jsonstr);jQuery.parseJSON(jsonstr),可以将json字符串转换成json对象 jQuery插件支持的转换方式
            	//JSON.parse(jsonstr); //可以将json字符串转换成json对象 JSON.stringify(jsonobj); //可以将json对象转换成json对符串 (Firefox，chrome，opera，safari，ie9，ie8)
// 				alert(JSON.stringify(data));
//             	alert(data.sex);
            	// 为表单元素赋值
            	$("#addForm [name='id']").val(data.id);
            	$("#addForm [name='staff_id']").val(data.staff_id);
            	$("#addForm [name='staff_name']").val(data.staff_name);
            	$("#addForm [name='sex'][value="+data.sex+"]").attr("checked","checked");
            	$("#addForm [name='status']").val(data.status);
            	$("#addForm [name='source']").val(data.source);
            	$("#addForm [name='reservation']").val(data.reservation);
            	$("#addForm [name='buildDate']").val(data.buildDate);
            	$("#addForm [name='buildMan']").val(data.buildMan);
            	$("#addForm [name='visitDate']").val(data.visitDate);
            	$("#addForm [name='birthday']").val(data.birthday);
            	$("#addForm [name='graduateSchool']").val(data.graduateSchool);
            	$("#addForm [name='education']").val(data.education);
            	$("#addForm [name='contact']").val(data.contact);
            	$("#addForm [name='urgencyName']").val(data.urgencyName);
            	$("#addForm [name='urgencyPhone']").val(data.urgencyPhone);
            	$("#addForm [name='jobInterview']").val(data.jobInterview);
            	$("#addForm [name='visible'][value="+data.visible+"]").attr("checked","checked");
            	$("#addForm [name='userId']").val(data.userId);
                     }
        });
    };
     // 删除用户信息
    function delUser (Id) {
		if (confirm("你确定要删除么?")) {
			$.post("${pageContext.request.contextPath}/sys/staff/delete",{id:Id},
	    			   function(data){
	    			     	if (data=='1'){
	    			    		 alert('删除成功');
	    			    		 document.location.href = "${pageContext.request.contextPath }/sys/staff/list"
	    			     	}else{
	    			    		 alert("删除失败");
	    			     	}
	    		});
		};
	};
	
// 	 $("#queryda").click (function () {
// 	    	$.post("${pageContext.request.contextPath}/sys/user/quda"
// 	    		,$("#key").serialize());
// 	 });

	function fineda(){
		 document.location.href = "${pageContext.request.contextPath }/sys/staff/quda?key="+document.getElementById('key').value;
	}
	
// 	 $("#xitong").bind("click",function(){
// 		$("#ganwei").css("display","none");
// 		});
	 
// 	 window.onload=function(){
// 		 if(document.getElementById('xitong').innerHTML =="系统管理员"){
// 				$("#ganwei").css("display","none");
// 		 }
// 	 }
    
</script>
</body>
</html>