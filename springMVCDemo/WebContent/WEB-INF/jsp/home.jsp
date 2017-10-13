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
    <script>
        $(function () {
            $("figure:eq(0)").css({
                border:'none'
            });
            $("figure:eq(1)").css({
                border:'none'
            });
                var titleName=$(".ycmenu a");
                for(var i =0;i<titleName.length;i++){
                titleName[i].id=i;
                titleName[i].onmouseover=function(){
                for(var j =0;j<titleName.length;j++){
                titleName[j].className="";
            }
                this.className = "a";
            }}
        })
    </script>
</head>
<body>
<div>
	
</div>
<div>
    <div>
        <a href="">发现身边美好的生活！<button>下载宅生活</button></a>      
        <c:set var="vip" value="${vip}"></c:set>
        	<c:choose>					
			 	<c:when test="${vip.memberName == null}">
			 		<a href="${pageContext.request.contextPath}/member/login" style="float:right"><button>登录</button> </a>
			 	</c:when>			
				<c:otherwise>
					<span id="${vip.mid}" onclick="memberMessage(${vip.mid});" style="float:right"><button>${vip.memberName}</button></span>
				</c:otherwise>
			</c:choose>
        
        <a href="" style="float:right"><button>注册</button></a>
        
    </div>
         <div align="center">
	<form action="" method="">
		<input id="arvato_q" type="text" name="q" value=""  class="headSearchBox commonInput" autocomplete="off" placeholder="请输入您要搜索的关键字" />
		<input type="submit" value="搜索" name="sousuo"/>
	</form>
</div>
</div>
<div class="container">
    <div class="allLogo">
        <div class="logo"><img src="${pageContext.request.contextPath}/resources/img/u16.png" alt="logo"/></div>
        <div class="head"><a href="javascript:;"><img src="${pageContext.request.contextPath}/resources/img/u61.png" alt="头像"/></a></div>
        <div class="headInfo"><a href="#">天天猫</a></div>
   
    </div>

    <div class="SeckillOne">
        <div>
            <img src="${pageContext.request.contextPath}/resources/img/1.jpg" alt=""/>
        </div>
        <div id="CountMsg" class="HotDate">
            <br/><a>倒计时</a><br/>
            <span class="t_d">00天</span><br/>
            <span class="t_h">00:</span>
            <span class="t_m">00:</span>
            <span class="t_s">00</span>
        </div>
        <div class="hurry">
                <a href="Mgroup.html"><button>立即参团 <img src="${pageContext.request.contextPath}/resources/img/jian.png"/></button></a>
        </div>
        <div class="number">
            <p>已抢 25 份 剩余 25 份</p>
        </div>
    </div>
    <div class="SeckillTwo">
        <div>
            <img src="${pageContext.request.contextPath}/resources/img/1.jpg" alt=""/>
        </div>
        <div  class="HotDate">
            <br/><a>倒计时</a><br/>
            <span class="t_d">00天</span><br/>
            <span class="t_h">00:</span>
            <span class="t_m">00:</span>
            <span class="t_s">00</span>
        </div>
        <div class="hurry">
            <a href="Mgroup.html"><button>立即参团 <img src="${pageContext.request.contextPath}/resources/img/jian.png"/></button></a>
        </div>
        <div class="number">
            <p>已抢 25 份 剩余 25 份</p>
        </div>
    </div>
    <div class="store">
        <ul>
            <li class="li1"><a href="#">商品</a></li>
            <li class="li2"><a href="javascript:;" class="xlmenu">全部&nbsp;<img src="${pageContext.request.contextPath}/resources/img/donw.png" style="width: 12px;display: inline"/></a>&nbsp;共<span style="color: #e4393c;font-size: 1.8rem">40</span>件</li>
        </ul>
        <div class="ycmenu">
            <ul>
                <li><a href="${pageContext.request.contextPath}/resources/allGoods.html" class="a">全部商品</a></li>
                <li><a href="${pageContext.request.contextPath}/resources/nydg.html">奶油蛋糕</a></li>
                <li><a href="${pageContext.request.contextPath}/resources/nydg.html">奶油蛋糕</a></li>
                <li><a href="${pageContext.request.contextPath}/resources/nydg.html">奶油蛋糕</a></li>
                <li><a href="${pageContext.request.contextPath}/resources/nydg.html">奶油蛋糕</a></li>
                <li><a href="${pageContext.request.contextPath}/resources/nydg.html">奶油蛋糕</a></li>
                <li><a href="${pageContext.request.contextPath}/resources/nydg.html">奶油蛋糕</a></li>
            </ul>
        </div>
    </div>
    <div class="clear"></div>
    <div class="border">

    </div>
    <div class="allsp">
			<c:out value="success"></c:out>
    	<c:forEach items="${pag}" var="goods" varStatus="index">
    		
    		<c:out value="${pageContext.request.contextPath}/${goods.gpicture}"></c:out>
	        <div>
	           <a href="#" > <span id="${goods.gid}" onclick="showDetail(${goods.gid});"><img src="${pageContext.request.contextPath}/${goods.gpicture}" alt="${goods.gname}" style="width:450px;height:300px" class="xqtp" /></span></a>
	           <c:out value="${goods.gname}"></c:out>  
	            <div class="info">
	                <em class="sat">￥${goods.gprice/100}&nbsp;<small>￥46</small></em>
	                <span  onclick="shopping(${goods.gid});"><img src="${pageContext.request.contextPath}/resources/img/u20.png" alt="购物车" style="width: 30px;height: 30px" align="right"/></span>
	            </div>
	       </div>
	    </c:forEach>
        <div class="clear"></div>
    </div>
    <div class="wx_nav" id="wx_nav">
        <a href="${pageContext.request.contextPath }/product/show" class="nav_index" id="nav_index">首页</a>
        <a href="${pageContext.request.contextPath }/shopping/shoppingShow" class="nav_shopcart" id="nav_shopcart">购物车</a>
        <a href="javascript:;" class="nav_me on" id="nav_me on">订单</a>
    </div>
    </div>
<div>
    <div class="footer">
        <p>没有更多了</p>
    </div>
</div>
<div class="actGotop"><a href="javascript:;" title="返回顶部"></a> <img src="${pageContext.request.contextPath}/resources/img/fanhui.png" alt=""/></div>
<div class="theme-popover-mask"></div>
<script>
	function showDetail(id){
		 document.location.href = "${pageContext.request.contextPath }/product/detail?key="+id;
	}
	function memberMessage(mid){
		 document.location.href = "${pageContext.request.contextPath }/member/showMember?key="+mid;
	}
	
	function shopping(Id){
		var name="${vip.memberName}"
		alert(name);
		if(name==null||name==""){
			 document.location.href ="${pageContext.request.contextPath}/member/login";
		}else{
			$.post("${pageContext.request.contextPath}/shopping/shoppingAdd",{gid:Id},
		 			   function(data){
		 			     	if (data=='1'){
		 			    		 alert('添加成功');
		 			     	}else{
		 			    		 alert("添加失败");
		 			     	}
		 		});
		}		
// 		document.location.href = "${pageContext.request.contextPath }/shopping/shoppingAdd?key="+Id;		
	};

</script>
</body>
</html>