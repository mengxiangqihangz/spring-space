<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>云联天下后台管理框架</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/js/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/skins/_all-skins.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/assets/css/ace.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini" style="overflow:hidden;">
	<!--中间内容-->
    <div class="page-content clearfix">
	    <div id="Member_Ratings">
		    <div class="d_Confirm_Order_style">
		    	<!-- 条件搜索栏 -->
		   	 	<div class="search_style">
		    		<div class="title_names">搜索查询</div>
			        <ul class="search_content clearfix">
				        <li><label class="l_f">会员名称</label><input name="" type="text"  class="text_add" placeholder="输入会员名称、电话、邮箱"  style=" width:400px"/></li>
				        <li><label class="l_f">添加时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li>
				        <li style="width:90px;"><button type="button" class="btn_search"><i class="icon-search"></i>查询</button></li>
			      	</ul>
		     	</div>
		     	
		     	<!-- 操作栏，显示总记录数 -->
			    <div class="border clearfix">
			    	<span class="l_f">
			    		<a href="javascript:ovid()" class="btn btn-warning"><i class="fa fa-remove"></i>添加用户</a>
			    		<a href="javascript:ovid()" class="btn btn-danger"><i class="fa fa-trash-o fa-lg"></i>批量删除</a>
			    	</span>
			    	<span class="r_f">共：<b>2345</b>条</span>
			    </div>
			    
			    <!-- datatables表格 -->
			    <div class="table_menu_list">
       				<table class="table table-striped table-bordered table-hover" id="sample-table">
						<thead>
		 					<tr>
								<th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
								<th width="80">ID</th>
								<th width="100">用户名</th>
								<th width="80">性别</th>
								<th width="120">手机</th>
								<th width="150">邮箱</th>
								<th width="">地址</th>
								<th width="180">加入时间</th>
                				<th width="100">等级</th>
								<th width="80">状态</th>                
								<th width="250">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
          						<td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
					          	<td>1</td>
					          	<td><u style="cursor:pointer" class="text-primary" onclick="member_show('张三','member-show.html','10001','500','400')">张三</u></td>
					          	<td>男</td>
					          	<td>asasasasasas</td>
					          	<td>admin@mail.com</td>
					          	<td class="text-l">北京市 海淀区</td>
					          	<td>2014-6-11 11:11:42</td>
					          	<td>普通用户</td>
					          	<td class="td-status"><span class="label label-success radius">已启用</span></td>
					          	<td class="td-manage">
					          		<a title="停用" href="javascript:;" class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
					          		<a title="编辑" href="javascript:;" class="btn btn-xs btn-info" ><i class="icon-remove-sign"></i></a> 
					          		<a title="删除" href="javascript:;" class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
					          	</td>
							</tr>
      					</tbody>
					</table>
   				</div>
			    
		   	</div>
	  	</div>
 	</div>
        
    <script src="${pageContext.request.contextPath }/resources/js/jquery/jQuery-2.2.0.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/js/index.js"></script>
    <script src="${pageContext.request.contextPath }/resources/assets/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/assets/js/jquery.dataTables.bootstrap.js"></script>
    
    <script>
    jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable( {
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
  		//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
  		{"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		] } );
		
		
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
			.each(function(){
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			});
		});
	});
    
    </script>
</body>
</html>
