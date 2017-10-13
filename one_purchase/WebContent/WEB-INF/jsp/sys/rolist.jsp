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
                    <span class="glyphicon glyphicon-user"></span>&nbsp;<span id="m">系统管理员</span><span class="caret"></span>
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
                    <li class="active">系统管理 - 角色管理</li>
                </ol>
<!--                 <div class="input-group line left"> -->
<!--                     <span class="input-group-addon" id="basic-addon2"><span class="glyphicon glyphicon-search"></span></span> -->
<!--                     <input type="text" class="form-control" id="key" name="key" placeholder="输入关键字搜索" aria-describedby="basic-addon2"> -->
<!--                 </div> -->
                <select class="form-control line left">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
                
<!--                 <a href="#" class=" btn btn-primary"  ><span id="find"   class="glyphicon glyphicon-search">查询</span></a> -->
                <a href="#" class=" btn btn-primary "><span class="glyphicon glyphicon-download">删除</span></a>
                <a href="#" class="btn btn-primary btn-sm" onclick="addRoler();">添加</a>
                <br/><br/>
                <table class="table table-bordered table-striped text-center bg-info">
                    <thead >
                    <tr class="info">
                    	<th class="text-center">序号</th>
                    	<th class="text-center">角色编码</th>
                        <th class="text-center"><a onclick="this.blur(); return sortTable('offTblBdy', 3, false);">角色名称</th>
                         <th class="text-center">角色权限功能列表</th>
                        <th  class="text-center">角色功能描述</th>
                       	<th></th>
                      
                    </tr>
                    </thead>
                    <tbody id="offTblBdy">
                    <c:forEach items="${page.data}" var="roler" varStatus="index">
	                    <tr>
	                    	<td>${index.count }</td>
	                        <td>${roler.roleId }</td>
	                        <td>${roler.roleName }</td>
<%-- 	                         <td>${roler.dataPri }</td> --%>
	                        <td> <span><c:forEach items="${roler.dataPri}" var="pri">${pri.priName},    </c:forEach></span></td>
						    

	                        <td>${roler.remark }</td>
	                        
	                        <td >
	                            <a id="${index.count }"  href="#" class="btn btn-primary btn-sm" onclick="editRoler (${roler.id });">编辑</a>
	                            <a  href="#" class="btn btn-primary btn-sm" onclick="delRoler(${roler.id });">删除</a>
	                        </td>
	                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
				<page:PageTag  key="${key}" pageNo="${page.pageNo }" pageSize="${page.pageSize }" pageUrl="${pageContext.request.contextPath}/sys/roler/rolist" pageLast="${page.totalPage }"/>
            </div>
            <!--右侧内容结束-->
            
            
            <!-- Modal begin-->
            <!--添加-->
            <div class="modal fade" id="addRoler" tabindex="-1" role="dialog" aria-labelledby="addRoler">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="addRoler">新增角色信息</h4>
                        </div>
                        <div class="modal-body">
                            <form id="addForm" class="form-horizontal" role="form">
                            	<!-- 隐藏域，目的是做编辑操作的时候需要使用到 -->
                            	<input type="hidden" name="id" value=""/>
<!--                             	<input type="hidden" name="rolerId" value=""/> -->
									<textarea id="jsonTree" hidden="hidden">${jsonTree }</textarea>
										
								<div class="form-group">
							      <label for="roleId" class="col-sm-4 control-label">角色编码</label>
							      <div class="col-sm-8">
							         <input type="text"  class="form-control" name="roleId" placeholder="">
							      </div>
							    </div>
                            	<div class="form-group">
							      <label for="roleName" class="col-sm-4 control-label">角色名称</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" name="roleName" placeholder="角色名称">
							      </div>
							   </div>
							     <div class="form-group">
							      <label for="permission" class="col-sm-4 control-label">权限</label>
							      <div id="treeview-checkable" class="col-sm-8"></div>
							   </div>
							   
							   <!-- <div class="form-group">
							      <label for="priId" class="col-sm-4 control-label">角色权限</label>
							      <div class="col-sm-8">
							       <input type="checkbox"   name="priId1"  value="1001"  />add &nbsp;&nbsp;
							       <input type="checkbox"   name="priId2"  value="1002"  />del &nbsp;&nbsp;
							       <input type="checkbox"   name="priId3"  value="1003"  />edit &nbsp;&nbsp;
							       <input type="checkbox"   name="priId4"  value="1004"  />find &nbsp;&nbsp; -->
							       
							         
							    <%--    <c:forEach items="${pri}" var="role" varStatus="index">
					                    
					                  <input type="checkbox"  id="priId" name="priId" value="${role.priId}"  />${role.priName} &nbsp;&nbsp;
					                   
					               </c:forEach> --%>
					                
							      </div>
							      </div>
							      
<!-- 							   <div class="form-group"> -->
<!-- 							      <label for="sex" class="col-sm-4 control-label">性别</label> -->
<!-- 							      <div class="col-sm-8"> -->
<%-- 							       <c:forEach items="${pri}" var="role" varStatus="index"> --%>
					                    
<%-- 					                    <option ><input type="checkbox" checked="checked" name="sex" value="1"/>${role.priName} &nbsp;&nbsp;</option> --%>
					                   
<%-- 					                 </c:forEach> --%>
							        
<!-- 							      </div> -->
<!-- 							   </div> -->
<!-- 							   <form action=""> -->
<!-- 										名字: <input type="text" name="user"><br> -->
<!-- 										我有一辆自行车: -->
<!-- 										<input type="checkbox" name="vehicle" value="Bike"><br> -->
<!-- 										我有一辆汽车: -->
<!-- 										<input type="checkbox" name="vehicle" value="Car" checked="checked"><br> -->
<!-- 										我有一架飞机: -->
<!-- 										<input type="checkbox" name="vehicle" value="Airplane"><br> -->
<!-- 										<input type="submit"> -->
<!-- 										</form> -->
							    <div class="form-group">
							      <label for="remark" class="col-sm-4 control-label">功能描述</label>
							      <div class="col-sm-8">
							         <input type="text" class="form-control" id="remark" name="remark" placeholder="请输人功能描述">
							      </div>
							   </div>
							</form>
                        </div>
                        <div class="modal-footer">
                            <button type="reset" class="btn btn-default btn-sm" data-dismiss="modal">取消</button>
                            <button type="button" id="saveRolerBtn" class="btn btn-primary btn-sm">保存</button>
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

		
		//alert(JSON.stringify(json));
		
		// 全选
		function checkAll () {
		  $('#treeview-checkable').treeview('checkAll', { silent: true });
		}
		
		// 反选
		function uncheckAll () {
		  $('#treeview-checkable').treeview('uncheckAll', { silent: true });
		}
		
		// 选中父节点，默认选中父节点下的所有子节点
		function toggleChildren(currentNode,state){
		  if( currentNode.state.checked != state ){
		  	$('#treeview-checkable').treeview('toggleNodeChecked', [ currentNode.nodeId , { silent: true } ]);
		  }
		  var sons = currentNode.nodes;
		  if(sons){
			  for ( var i in sons ) {
			  	toggleChildren(sons[i],state);
			  }
		  }else {
		  	return;
		  }
		}
		
		// 选中子节点的时候，父节点默认选中
		function toggleParent (node) {
		  var parentNode = $('#treeview-checkable').treeview('getParent', node);
		  
		  try{
			  if (!parentNode.state.checked){
				  parentNode.state.checked = true;
			  } 
		  }catch(e) {
			  return;
		  }
		  toggleParent(parentNode);
		}

//     新增角色信息
    $("#saveRolerBtn").click (function () {
    	if($(".modal-title").text()=="新增角色信息"){
    		
    	$.post("${pageContext.request.contextPath}/sys/roler/add"
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
    	if($(".modal-title").text()=="编辑角色信息"){
//     		var checkboxval = $("#checkbox_id").attr("value")；
    		$.post("${pageContext.request.contextPath}/sys/roler/edit"
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
    function addRoler() {
    	var json = JSON.parse($("#jsonTree").val());
    	$('#treeview-checkable').treeview({
    	    data: json,
    	    showIcon: false,
    	    showCheckbox: true,
    	    onNodeChecked: function(event, node) {
    	      //$('#checkable-output').prepend('<p>' + node.text + ' was checked</p>');
    	      //checkAll ();
    	      toggleParent(node);
    	      toggleChildren(node,true);
    	    },
    	    onNodeUnchecked: function (event, node) {
    	      //$('#checkable-output').prepend('<p>' + node.text + ' was unchecked</p>');
    	    	toggleChildren(node,false);
    	    	}
    	  });
    	// 网页中在标签中设置属性data-toggle="modal" data-target="#addroler"来切换模态框
    	$(".modal-title").text ("新增角色信息");
    	$('#addRoler').modal('toggle');// 手动切换模态框
    	// 清空一些不必要的信息
    	$("#addForm [name='id']").val('');
    	$("#addForm [name='roleId']").val('');
    	$("#addForm [name='roleName']").val('');
//     	$("#addForm [name='priId1']").val('');
    	$("#addForm [name='remark']").val('');
    	
    };
    
    // 编辑角色信息
    function editRoler (id) {
    	$(".modal-title").text ("编辑角色信息");
    	$('#addRoler').modal('toggle');
    	
    	$.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/sys/roler/get/"+id,
            dataType: "json",
            success: function(data){
            	
            	$('#treeview-checkable').treeview({
            	    data: data.treeList,
            	    showIcon: false,
            	    showCheckbox: true,
            	    onNodeChecked: function(event, node) {
            	      toggleParent(node);
            	      toggleChildren(node,true);
            	    },
            	    onNodeUnchecked: function (event, node) {
            	    	toggleChildren(node,false);
            	    }
            	  });
            	//$.parseJSON(jsonstr);jQuery.parseJSON(jsonstr),可以将json字符串转换成json对象 jQuery插件支持的转换方式
            	//JSON.parse(jsonstr); //可以将json字符串转换成json对象 JSON.stringify(jsonobj); //可以将json对象转换成json对符串 (Firefox，chrome，opera，safari，ie9，ie8)
//             	alert(JSON.stringify(data));
            	// 为表单元素赋值
        
            	$("#addForm [name='id']").val(data.id);
            	$("#addForm [name='roleId']").val(data.roleId);
            	$("#addForm [name='roleName']").val(data.roleName);
//             	$("#addForm [name='priId1'][value="+data.dataPri+"]").attr("checked","checked");
//             	$("#addForm [name='priId2'][value="+data.dataPri+"]").attr("checked","checked");
//             	$("#addForm [name='priId3'][value="+data.dataPri+"]").attr("checked","checked");
//             	$("#addForm [name='priId4'][value="+data.dataPri+"]").attr("checked","checked");
            	$("#addForm [name='remark']").val(data.remark);
                     }
        });
    };
    
    // 删除角色信息
    function delRoler (id) {
		var isOK = confirm("你确定要删除么?");
		if (isOK) {
// 			document.location.href = "remove.do?userId=" + userId;
			$.post("${pageContext.request.contextPath}/sys/roler/delete"
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
	

	window.onload=function(){
		var s=${hh};
		if(s=="1"){
			for (i=0;i<10;i++){
			$("#"+i).css("display","none");
			}
		}
		
		$('input:checkbox').each(function() {
	        if ($(this).attr('checked') ==true) {
	                alert($(this).val());
	        }
	});
			
// 			$("#role").css("display","block");
			
		}
	
	
	//查询用户信息，传用户名模糊
// 	$("#find").click (function (){
// 		$.post("${pageContext.request.contextPath}/sys/user/findList"
//     			,$("#key").serialize());
    			
// 	});
	
	
// 	$("#find").click (function (){
// 		document.location="${pageContext.request.contextPath}/sys/user/findList?key="+document.getElementById("key").value;
// 	});


	//alert(JSON.stringify(json));

  // 全选
 /*  function checkAll () {
	  $('#treeview-checkable').treeview('checkAll', { silent: true });
  }
  
  // 反选
  function uncheckAll () {
	  $('#treeview-checkable').treeview('uncheckAll', { silent: true });
  }
  
  // 选中父节点，默认选中父节点下的所有子节点
  function toggleChildren(currentNode,state){
	  if( currentNode.state.checked != state ){
	  	$('#treeview-checkable').treeview('toggleNodeChecked', [ currentNode.nodeId , { silent: true } ]);
	  }
	  var sons = currentNode.nodes;
	  if(sons){
		  for ( var i in sons ) {
		  	toggleChildren(sons[i],state);
		  }
	  }else {
	  	return;
	  }
	}
  
  // 选中子节点的时候，父节点默认选中
  function toggleParent (node) {
	  var parentNode = $('#treeview-checkable').treeview('getParent', node);
	  
	  try{
		  if (!parentNode.state.checked){
			  parentNode.state.checked = true;
		  } 
	  }catch(e) {
		  return;
	  }
	  toggleParent(parentNode);
  }
 */
		
	
    
</script>
</body>
</html>