<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="java.util.*,java.text.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<<script >
// 	$(function(){
// 	    $("#collapseOne ul > li").click(function(){
// 	        $(this).addClass("current").siblings().removeClass("current");
// 	})
// 	}) 
	</script>
    <div class="container-fluid">
        <div class="row ">
            <!--左侧导航开始-->
            <div class="col-xs-2 bg-blue">
                <br/>
                <div class="panel-group sidebar-menu" id="accordion" aria-multiselectable="true">
                    <div class="panel panel-default menu-first menu-first-active">
                        <a data-toggle="collapse" data-parent="#accordion" href="index.html" aria-expanded="true"
                           aria-controls="collapseOne">
                            <i class="icon-home icon-large"></i> 主页
                        </a>
                    </div>
                    <div class="panel panel-default menu-first">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true"
                           aria-controls="collapseOne">
                            <i class="icon-user-md icon-large"></i> 系统管理</a>
                        </a>
                        <div id="collapseOne" class="panel-collapse collapse in" >
                            <ul class="nav nav-list menu-second">
<%--                                 <c:if test="${name==page}" > --%>
                                 <li id="manager" <c:if test="${menu eq 'user'}">class="menu-second-selected"</c:if>
                                 ><a href="${pageContext.request.contextPath}/sys/user/list"><i class="icon-user"></i>用户管理</a></li>
                                 
                                 <li id="role" <c:if test="${menu eq 'role'}">class="menu-second-selected"</c:if>
                                ><a href="${pageContext.request.contextPath}/sys/roler/rolist"><i class="icon-user"></i>角色管理</a></li>
                                
                                <li id="menu" <c:if test="${menu eq 'menu'}">class="menu-second-selected"</c:if>
                                ><a href="${pageContext.request.contextPath}/sys/menu/menuList"><i class="icon-user"></i>菜单管理</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
                           aria-expanded="false" aria-controls="collapseTwo">
                            <i class="icon-book icon-large"></i>员工管理</a>
                        </a>
                        <div id="collapseTwo" class="panel-collapse collapse in">
                            <ul class="nav nav-list menu-second">
                                <li <c:if test="${menu eq 'jobs'}">class="menu-second-selected"</c:if>
                                ><a href="${pageContext.request.contextPath}/sys/staff/list"><i class="icon-user"></i>员工信息</a></li>
                                
                                <li><a href="#"><i class="icon-user"></i>我的跟踪</a></li>
                                <li><a href="#"><i class="icon-edit"></i>我的招聘</a></li>
                                <li <c:if test="${menu eq 'blacklist'}">class="menu-second-selected"</c:if>
                                ><a href="${pageContext.request.contextPath}/sys/staff/blackList"><i class="icon-user"></i>黑名单</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
                           aria-expanded="false" aria-controls="collapseTwo">
                            <i class="icon-book icon-large"></i>合同管理</a>
                        </a>
                        <div id="collapseTwo" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#"><i class="icon-user"></i>合同列表</a></li>
                                <li><a href="#"><i class="icon-edit"></i>添加合同</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree"
                           aria-expanded="false" aria-controls="collapseThree">
                            <i class="icon-book icon-large"></i>商家管理</a>
                        </a>

                        <div id="collapseThree" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#"><i class="icon-user"></i>商家列表</a></li>
                                <li><a href="#"><i class="icon-edit"></i>添加商家</a></li>
                            </ul>
                        </div>
                    </div>
                    
                    
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour"
                           aria-expanded="false" aria-controls="collapseFour">
                            <i class="icon-book icon-large"></i>商品类别管理</a>
                        </a>

                        <div id="collapseFour" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#"><i class="icon-user"></i>类别列表</a></li>
                                <li><a href="#"><i class="icon-edit"></i>添加类别</a></li>
                            </ul>
                        </div>
                    </div>
                    
                    
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="col lapse" data-parent="#accordion" href="#collapseFive"
                           aria-expanded="false" aria-controls="collapseFive">
                            <i class="icon-book icon-large"></i>商品管理</a>
                        </a>

                        <div id="collapseFive" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#"><i class="icon-user"></i>商品列表</a></li>
                                <li><a href="#"><i class="icon-edit"></i>添加商品</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseSix"
                           aria-expanded="false" aria-controls="collapseSix">
                            <i class="icon-book icon-large"></i>账户管理</a>
                        </a>

                        <div id="collapseSix" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#"><i class="icon-user"></i>我的账户</a></li>
                                <li><a href="#"><i class="icon-edit"></i>在线充值</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseSeven"
                           aria-expanded="false" aria-controls="collapseSeven">
                            <i class="icon-book icon-large"></i>在售商品管理</a>
                        </a>

                        <div id="collapseSeven" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#"><i class="icon-user"></i>在售商品列表</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseEight"
                           aria-expanded="false" aria-controls="collapseEight">
                            <i class="icon-book icon-large"></i>我的销售</a>
                        </a>

                        <div id="collapseEight" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#"><i class="icon-user"></i>订单列表</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>