<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link
			href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css"
			rel="stylesheet" />
		<link rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
		<link
			href="${pageContext.request.contextPath}/resources/assets/css/codemirror.css"
			rel="stylesheet">
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/assets/css/ace.min.css" />
			<link rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/font/css/font-awesome.min.css" />
			<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/ace-ie.min.css" />
		<![endif]-->
			<script
				src="${pageContext.request.contextPath}/resources/js/jquery-1.9.1.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/resources/assets/layer/layer.js"
				type="text/javascript"></script>
			<script
				src="${pageContext.request.contextPath}/resources/assets/laydate/laydate.js"
				type="text/javascript"></script>
			<script
				src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/resources/assets/js/typeahead-bs2.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/resources/assets/js/jquery.dataTables.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/resources/assets/js/jquery.dataTables.bootstrap.js"></script>

			<title>个人信息管理</title>
</head>

<body>
	<div class="clearfix">
		<div class="admin_info_style">
			<div class="admin_modify_style" id="Personal">
				<div class="type_title">管理员信息</div>
				<div class="xinxi">
					<div class="form-group" style="display: none;">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">用户编号： </label>
						<div class="col-sm-9">
							<input type="text" name="用户名" id="userId"
								value="${sysUser.userId}" class="col-xs-7 text_info"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">用户名： </label>
						<div class="col-sm-9">
							<input type="text" name="用户名" id="userName"
								value="${sysUser.userName}" class="col-xs-7 text_info"
								disabled="disabled"/> &nbsp;&nbsp;&nbsp;
								<button type="button" onclick="change_Password()"
									class="btn btn-warning btn-xs">修改密码</button>
						</div>

					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">性别： </label>
						<div class="col-sm-9">
							<span class="sex">${sysUser.sex}</span>
							<div class="add_sex">
								<label>
									<input type="radio" id="sex1" class="ace"name="sex" value="保密" checked="checked" /> <span class="lbl">保密</span>&nbsp;&nbsp;
									<input type="radio" id="sex2" class="ace" name="sex" value="男" /><span class="lbl">男</span>&nbsp;&nbsp;
									<input type="radio" id="sex3" class="ace" name="sex" value="女" /><span class="lbl">女</span>
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">年龄： </label>
						<div class="col-sm-9">
							<input type="text" name="年龄" id="age" value="${sysUser.age}"
								class="col-xs-7 text_info" disabled="disabled"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">移动电话： </label>
						<div class="col-sm-9">
							<input type="text" name="移动电话" id="mobile"
								value="${sysUser.mobile}" class="col-xs-7 text_info"
								disabled="disabled"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">电子邮箱： </label>
						<div class="col-sm-9">
							<input type="text" name="电子邮箱" id="email"
								value="${sysUser.email}" class="col-xs-7 text_info"
								disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">QQ： </label>
						<div class="col-sm-9">
							<input type="text" name="qq" id="qq" value="${sysUser.qq}"
								class="col-xs-7 text_info" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">地址： </label>
						<div class="col-sm-9">
							<input type="text" name="addr" id="addr" value="${sysUser.addr}"
								class="col-xs-7 text_info" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">权限： </label>
						<div class="col-sm-9">
							<span>普通管理员</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">注册时间： </label>
						<div class="col-sm-9">
							<span>${sysUser.createDate}</span>
						</div>
					</div>
					<div class="Button_operation clearfix">
						<button onclick="modify()" class="btn btn-danger radius"
							type="button">修改信息</button>
						<button onclick="save_info()" class="btn btn-success radius"
							type="sumbit">保存修改</button>
					</div>

				</div>
			</div>
			
			<%
				String path = request.getContextPath();
				String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			
			%>
			<div class="recording_style">
				<div class="type_title">管理员登陆记录</div>
				<div class="recording_list">
					
					<table
						class="table table-border table-bordered table-bg table-hover table-sort"
						id="sample-table">
						<thead>
							<tr class="text-c">
								<th>用户编号</th>
								<th>类型</th>
								<th>内容</th>
								<th>登陆地点</th>
								<th>用户名</th>
								<th>客户端IP</th>
								<th>时间</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--修改密码样式-->
	<div class="change_Pass_style" id="change_Pass">
		<ul class="xg_style">
			<li><label class="label_name">原&nbsp;&nbsp;密&nbsp;码</label><input
				name="pwd" type="password" class="" id="password"></li>
			<li><label class="label_name">新&nbsp;&nbsp;密&nbsp;码</label><input
				name="password" type="password" class="" id="Nes_pas"></li>
			<li><label class="label_name">确认密码</label><input name="再次确认密码"
				type="password" class="" id="c_mew_pas"></li>
		</ul>
		<!-- <div class="center"> <button onclick="change_Password()" class="btn btn-primary" type="sumbit" id="submit" >确认修改</div></button> -->
	</div>
</body>
</html>
<script type="text/javascript" charset="utf-8">
	//按钮点击事件
	function modify() {
		$('.text_info').attr("disabled", false);
		$('.text_info').addClass("add");
		$('#Personal').find('.xinxi').addClass("hover");
		$('#Personal').find('.btn-success').css({
			'display' : 'block'
		});
	};
	function save_info() {
		var num = 0;
		var str = "";
		$(".xinxi input[type$='text']").each(function(n) {
			if ($(this).val() == "") {
				layer.alert(str += "" + $(this).attr("name") + "不能为空！\r\n", {
					title : '提示框',
					icon : 0,
				});
				num++;
				return false;
			}
		});
		if (num > 0) {
			return false;
		} else {
			$.ajax({
				type : "POST", //提交方式  
				url : "${pageContext.request.contextPath}/admin/save",//路径  
				data : {
					userId : $("#userId").val(),
					userName : $("#userName").val(),
					sex : $("input[name='sex']:checked").val(),
					age : $("#age").val(),
					mobile : $("#mobile").val(),
					email : $("#email").val(),
					qq : $("#qq").val(),
					addr : $("#addr").val(),
				},//数据，这里使用的是Json格式进行传输  
				success : function(data) {//返回数据根据结果进行相应的处理  
					if (data == "1") {
						alert("修改资料成功");
						location.reload();

					} else {
						alert("修改资料失败，请重新修改！");
					}
				}
			});

			/* layer.alert('修改成功！',{
			title: '提示框',				
			icon:1,			   		
			});
			$('#Personal').find('.xinxi').removeClass("hover");
			$('#Personal').find('.text_info').removeClass("add").attr("disabled", true);
			$('#Personal').find('.btn-success').css({'display':'none'});
			layer.close(index); */

		}
	};
	//初始化宽度、高度    
	$(".admin_modify_style").height($(window).height());
	$(".recording_style").width($(window).width() - 400);
	//当文档窗口发生改变时 触发  
	$(window).resize(function() {
		$(".admin_modify_style").height($(window).height());
		$(".recording_style").width($(window).width() - 400);
	});
	//修改密码
	function change_Password() {
		layer.open({
					type : 1,
					title : '修改密码',
					area : [ '300px', '300px' ],
					shadeClose : true,
					content : $('#change_Pass'),
					btn : [ '确认修改' ],
					yes : function(index, layero) {
						if ($("#password").val() == "") {
							layer.alert('原密码不能为空!', {
								title : '提示框',
								icon : 0,

							});
							return false;
						}
						if ($("#password").val() != "${sysUser.userPwd}") {
							layer.alert('原密码输入错误!', {
								title : '提示框',
								icon : 0,

							});
							return false;
						}

						if ($("#Nes_pas").val() == "") {
							layer.alert('新密码不能为空!', {
								title : '提示框',
								icon : 0,

							});
							return false;
						}

						if ($("#c_mew_pas").val() == "") {
							layer.alert('确认新密码不能为空!', {
								title : '提示框',
								icon : 0,

							});
							return false;
						}
						if (!$("#c_mew_pas").val
								|| $("#c_mew_pas").val() != $("#Nes_pas").val()) {
							layer.alert('密码不一致!', {
								title : '提示框',
								icon : 0,

							});
							return false;
						} else {
							$.post("${pageContext.request.contextPath}/admin/changepwd",
											{
												userPwd : $("#Nes_pas").val(),
												userId : $("#userId").val()
											},
											function(data) {
												if (data == "login") {
													alert("密码修改成功,请重新登录！");
													top.location.href="${pageContext.request.contextPath}/sys/login";

												} else {
													alert("修改失败,请重新修改");
													location.reload();
												}
											});

						}
					}

				});

	}
/*  ------------------------------------------------------------------------------------------------------------------*/	
	/* jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 2, 3, 4, 5, 6 ]
			} // 制定列不参与排序
			]

		});
/* -------------------------------------------------------------------------------------------------------------- */	
	/* $(document).ready( function() {
		    var oTable1 = $("#sample-table").dataTable({
		    "aaSorting" : [ [ 0, "desc" ] ],//默认排序方式，第二列倒序排列
			"bStateSave" : true,//客户端状态记录保存，
		    "bFilter": false,//搜索框
            "bAutoWidth": true, //自适应宽度
            "sPaginationType" : "full_numbers",//详细分页组，支持直接跳转到某页
            "bPaginate" : true,//显示分页器
           	"bDestroy" : true,
           	"bProcessing" : true,//载入数据时显示进度
            "bServerSide" : true,//启用服务端导入数据
            "paging" : true,
            "sAjaxSource" : "${pageContext.request.contextPath}/admin/ajaxhandler?userId="+"${sysUser.userId}",
            "aoColumns" : [ {
                "mDataProp" : "userId",
            }, {
                "mDataProp" : "gener",
            }, {
                "mDataProp" : "content",
            }, {
                "mDataProp" : "site",
            }, {
                "mDataProp" : "userName",
            }, {
                "mDataProp" : "IP",
            }, {
                "mDataProp" : "loadTime",
            }, ],

			"oLanguage" : {
                "sProcessing" : "正在加载中......",
                "sLengthMenu" : "每页显示 _MENU_ 条记录",
                "sZeroRecords" : "没有数据！",
                "sEmptyTable" : "表中无数据存在！",
                "sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
                "sInfoEmpty" : "显示0到0条记录",
                "sInfoFiltered" : "数据表中共为 _MAX_ 条记录",
                "sSearch" : "搜索",
                "oPaginate" : {
                    "sFirst" : "首页",
                    "sPrevious" : "上一页",
                    "sNext" : "下一页",
                    "sLast" : "末页"
                }
            }
        }); */
/* ---------------------------------------------------------------------------------------------------------------------	 */	
		 jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"bProcessing" : true,//载入数据时显示进度
            "bServerSide" : true,//启用服务端导入数据
            "paging" : true,
        /*     "iDisplayLength" : 1, */
			"sAjaxSource" : "${pageContext.request.contextPath}/admin/ajaxhandler?userId="+"${sysUser.userId}",
            "aoColumns" : [ {
                "mDataProp" : "userId",
            }, {
                "mDataProp" : "gener",
            }, {
                "mDataProp" : "content",
            }, {
                "mDataProp" : "site",
            }, {
                "mDataProp" : "userName",
            }, {
                "mDataProp" : "IP",
            }, {
                "mDataProp" : "loadTime",
            }, ],
		});
		
		
		
		$('table th input:checkbox').on(
				'click',
				function() {
					var that = this;
					$(this).closest('table').find(
							'tr  > td:first-child input:checkbox').each(
							function() {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});

				});
	});  
</script>      
	
			
