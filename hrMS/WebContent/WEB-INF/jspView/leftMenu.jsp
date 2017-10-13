<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="java.util.*,java.text.*" %>
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
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false"
                           aria-controls="collapseOne">
                            <i class="icon-user-md icon-large"></i> 系统管理</a>
                        </a>

                        <div id="collapseOne" class="panel-collapse collapse in">
                            <ul class="nav nav-list menu-second">
                                <li class="menu-second-selected"><a href="${pageContext.request.contextPath}/sys/user/list"><i class="icon-user"></i>用户管理</a></li>
                                <li><a href="#"><i class="icon-user"></i>角色管理</a></li>
                                <li><a href="#"><i class="icon-edit"></i>权限 管理</a></li>
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
                                <li class="menu-second-selected"><a href="${pageContext.request.contextPath}/sys/staff/list"><i class="icon-user"></i>员工信息</a></li>
                                <li><a href="#"><i class="icon-user"></i>我的跟踪</a></li>
                                <li><a href="#"><i class="icon-edit"></i>我的招聘</a></li>
                                <li class="menu-second-selected"><a href="${pageContext.request.contextPath}/sys/staff/blackList"><i class="icon-user"></i>黑名单</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel panel-default menu-first" id="ganwei">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree"
                           aria-expanded="false" aria-controls="collapseThree">
                            <i class="icon-book icon-large"></i>岗位管理</a>
                        </a>

                        <div id="collapseThree" class="panel-collapse collapse ">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#"><i class="icon-user"></i>#</a></li>
                                <li><a href="#"><i class="icon-edit"></i>#</a></li>
                            </ul>
                        </div>
                    </div>
                    
                    
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour"
                           aria-expanded="false" aria-controls="collapseFour">
                            <i class="icon-book icon-large"></i>部门管理</a>
                        </a>

                        <div id="collapseFour" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#"><i class="icon-user"></i>#</a></li>
                                <li><a href="#"><i class="icon-edit"></i>#</a></li>
                            </ul>
                        </div>
                    </div>
                    
                    
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFive"
                           aria-expanded="false" aria-controls="collapseFive">
                            <i class="icon-book icon-large"></i>薪酬管理</a>
                        </a>

                        <div id="collapseFive" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#"><i class="icon-user"></i>#</a></li>
                                <li><a href="#"><i class="icon-edit"></i>#</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseSix"
                           aria-expanded="false" aria-controls="collapseSix">
                            <i class="icon-book icon-large"></i>组织架构</a>
                        </a>

                        <div id="collapseSix" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#"><i class="icon-user"></i>#</a></li>
                                <li><a href="#"><i class="icon-edit"></i>#</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel panel-default menu-first">
                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseSeven"
                           aria-expanded="false" aria-controls="collapseSeven">
                            <i class="icon-book icon-large"></i>报表分析</a>
                        </a>

                        <div id="collapseSeven" class="panel-collapse collapse">
                            <ul class="nav nav-list menu-second">
                                <li><a href="#"><i class="icon-user"></i>月来访人数统计</a></li>
                                 <li><a href="#"><i class="icon-user"></i>月招聘人数分析</a></li>
                            </ul>
                        </div>
                    </div>
<!--                     <div class="panel panel-default menu-first"> -->
<!--                         <a id="yinc">隐藏菜单</a> -->
<!--                     </div> -->
 
                </div>
            </div>