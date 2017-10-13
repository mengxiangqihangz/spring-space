<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,java.text.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
    <title>商铺首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Up.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/touch.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/srcolltop.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/timer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/xlmenu.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pro.js"></script>
    <script
				src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script>
			<script
				src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.bootstrap.js"></script>
    
</head>
<body>
	<center><h1>欢迎来到德莱联盟</h1></center>
	<h1>切记导入jquery.dataTables.min.js/jquery.dataTables.bootstrap.js</h1>
	<h1>在css中考入js</h1>
	<h1>添加除了以上两个jar包外，</h1>
	<div class="recording_style">
		<div class="type_title">管理员登陆记录</div>
		<div class="recording_list">
			
			<table  width="100%" height="100" border="0" cellpadding="0" cellspacing="1" bgcolor="ff00ff"
			id="sample-table">
				<thead>
					<tr class="text-c">
						<th>商品编号</th>
						<th>商品名称</th>
						<th>商品价格</th>
						<th>库存</th>
						<th>图片地址</th>
						<th>类别</th>
						<th>商家</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
<script>
// 	$(document).ready(function() {
// 		$('#example').dataTable();
// 		} );


	 jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
/*-------------- 这个表示提供或关闭哪些支持 -------------------------*/
			"aaSorting" : [ [ 0, "desc" ] ],    //默认按第几列排序，从0开始。"aaSorting": [[4, "desc"]],		
			"bStateSave" : true,				//状态保存，使用了翻页或者改变了每页显示数据数量，会保存在cookie中，下回访问时会显示上一次关闭页面时的内容。
			"bProcessing" : true,				//载入数据时显示进度
            "bServerSide" : true,				//启用服务端导入数据
			"bInfo" : true, 					//支持显示总记录数
			"bFilter" : true,   				// 搜索栏
			"bSort" : false,					// 支持排序
			"bLengthChange" : true,				// 支持对每页显示数据的数量的更改（默认10,25,50,100 。也可利用aLengthMenu对此数量进行更改）
			"aLengthMenu": [[12,100,500,1000,10000], [12,100,500,1000,10000]],	//定义每页显示数据数量
      	    "paging" : true,					//
            "bAutoWidth":true, 					//自动宽度
//         	"bJQueryUI": true,					//
//         	"bPaginate" : true, 	 			// 分页按钮		
// 			"iDisplayLength" : 10,	每页显示行数    

/* ===============设置显示格式========================================================= */			
	
			"sPaginationType" : "full_numbers", //设置文字翻页样式。默认1，2，3为竖的，现在变成横的。
// 			"bScrollCollapse": true,
// 			"iScrollLoadGap":400,//用于指定当DataTable设置为滚动时，最多可以一屏显示多少条数据
// 			"bWidth":true,
			"sScrollY": "100px",		//现在竖直方向占用高度			
			"sScrollX": "50%",
			"sScrollXInner": "110%",
			"bPaginate": false,		//是否分页，默认为true
// 			"bDestroy": true,
// 			"bSortCellsTop": true,	
	            
/* -------完全没必要汉化，封装的就是汉化好的 。但是格式不好看，这个是更改显示格式的  --------------------------------*/ 
            "oLanguage" : { // 汉化   
				"sProcessing" : "正在加载数据...",		//支持图片"<img src='./loading.gif' />"	  //加载数据前显示。一般看不到。
				"sLengthMenu" : "显示_MENU_条 ",			//代替默认的"每页显示条数: "
				"sZeroRecords" : "没有您要搜索的内容",		//若是没有记录。则在表中显示的内容。
				"sInfo" : "从_START_ 到 _END_ 条记录——总记录数为 _TOTAL_ 条",  		//将默认的“第 11 到 20 条记录，共 53 条，进行更改”
				"sInfoEmpty" : "记录数为0",				//若是没有记录。则代替sInfo显示。
				"sSearch" : "搜索",			//对默认的“搜索：”进行更改
// 				"sInfoFiltered" : "(全部记录数 _TOTAL_  条)",
//				"sInfoPostFix" : "",				

				"oPaginate" : {				/*将默认的首页、上页、下页进行更改  */
					"sFirst" : "第一页",
					"sPrevious" : " 上一页 ",
					"sNext" : " 下一页 ",
					"sLast" : " 最后一页 "
				}
			},

/* 对2,3列进行隐藏，  */
// 			"aoColumnDefs": [ 
// 					{ "bSearchable": false, "bVisible": false, "aTargets": [ 2 ] },
// 					{ "bVisible": false, "aTargets": [ 3 ] }
// 			], 
/* --------------------请求路径，及数据封装------------------------------------------*/		
			"sAjaxSource" : "${pageContext.request.contextPath}/product/ajaxhandler",	//请求数据的url
            "aoColumns" : [ 
            {"mDataProp" : "gid",},
            {"mDataProp" : "gname",}, 
            {"mDataProp" : "gprice",}, 
            {"mDataProp" : "gremainNum",}, 
            {"mDataProp" : "gpicture",}, 
            {"mDataProp" : "category",}, 
            {"mDataProp" : "sysmobile",}, 
            ],
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
// 	隐藏 $(document).ready(function() {
// 			$('#sample-table').dataTable( {
// 				"aoColumnDefs": [ 
// 					{ "bSearchable": false, "bVisible": false, "aTargets": [ 2 ] },
// 					{ "bVisible": false, "aTargets": [ 3 ] }
// 				] } );
// 		} );

</script>
</body>
</html>