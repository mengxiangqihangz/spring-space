<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% String path = request.getContextPath();

   String uname ;
	if(session.getAttribute("usersession") == null){
		uname = "unlogin";
	}else{
	uname = session.getAttribute("usersession").toString();
	}
 
%>
<link href="<%=path %>/css/styles.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' id='camera-css'  href='<%=path %>/css/camera.css' type='text/css' media='all'> 
<script type='text/javascript' src='<%=path %>/scripts/jquery.min.js'></script>
<script type='text/javascript' src='<%=path %>/scripts/jquery.mobile.customized.min.js'></script>
<script type='text/javascript' src='<%=path %>/scripts/jquery.easing.1.3.js'></script> 
<script type='text/javascript' src='<%=path %>/scripts/camera.min.js'></script> 
<script>
function myfun()
{
if('<%=uname  %>'==='unlogin'){
		var ul = document.getElementById("ulist"); 
		
		var li0 = document.createElement("li");
		li0.setAttribute("id", "li0");
		li0.innerHTML = "<a href='<%=path %>/login.jsp'> 登录 </a>";
　　　　ul.appendChild(li0);

		var li1 = document.createElement("li");
		li1.setAttribute("id", "li1");
		li1.innerHTML = "<a href='<%=path %>/register.jsp'>注册新用户</a>";
　　　　ul.appendChild(li1);



}else{
		var ul = document.getElementById("ulist"); 
		
		var li0 = document.createElement("li");
		li0.setAttribute("id", "li0");
		li0.innerHTML="<a href='register.jsp'> <%=uname  %> </a>";
　　　　ul.appendChild(li0);

		var li1 = document.createElement("li");
		li1.setAttribute("id", "li1");
		li1.innerHTML = "<a href='/springMVC13/user/logout'> 退出  </a>";
　　　　ul.appendChild(li1);

}
/*		var li0 = lis.item(0); 
		var li1 = lis.item(1); 		
		var li2 = lis.item(2); 		

	
	li1.innerHTML="<a href='register.jsp'> <%=uname  %> </a>";
	li2.innerHTML="<a href='register.jsp'> <%=uname  %> </a>";
*/
	
    
}

window.onload=myfun;

jQuery(function(){
	
	jQuery('#camera_wrap_1').camera({
		thumbnails: true
	});
});
</script>

</head>
<body>
<header class="wrapperContainer">
	<div class="wrapper">
        <div>
            <div class="logo">
                <h1><a href="">Wed<br><span>Now</span></a></h1>
                <div class="logoTriangle"></div>
            </div>
            <nav>
                <ul id="ulist">
                    <li class="active"><!--<a href="index.jsp">Home</a>--></li>
                    <li><!--<a href="register.jsp">注册新用户</a>--></li>
                    <li><!--<a href="<%=path %>/login.jsp">登录</a>--></li>
                </ul>
            </nav>
            <div class="clearfloat"></div>
        </div>
        <div class="clearfloat"></div>
    </div>
</header>
<div class="wrapperContainer">
	<div class="wrapper">
        <!--begin Welcome-->
        <div class="welcome">
            <!--begin slider-->
            <div class="mySlider">
                <div class="camera_wrap camera_green_skin" id="camera_wrap_1">
                    <div data-thumb="<%=path %>/images/slides/thumbs/1.jpg" data-src="<%=path %>/images/slides/1.jpg">
                        <div class="camera_caption fadeFromBottom">Wed 1 <em>Wed description</em></div>
                    </div>
                    <div data-thumb="<%=path %>/images/slides/thumbs/2.jpg" data-src="<%=path %>/images/slides/2.jpg">
                        <div class="camera_caption fadeFromBottom">Wed 2 <em>Wed description</em></div>
                    </div>
                    <div data-thumb="<%=path %>/images/slides/thumbs/3.jpg" data-src="<%=path %>/images/slides/3.jpg">
                        <div class="camera_caption fadeFromBottom">Wed 3 <em>Wed description</em></div>
                    </div>
                    <div data-thumb="<%=path %>/images/slides/thumbs/4.jpg" data-src="<%=path %>/images/slides/4.jpg">
                        <div class="camera_caption fadeFromBottom">Wed 4 <em>Wed description</em></div>
                    </div>
                    <div data-thumb="<%=path %>/images/slides/thumbs/5.jpg" data-src="<%=path %>/images/slides/5.jpg">
                        <div class="camera_caption fadeFromBottom">Wed 5 <em>Wed description</em></div>
                    </div>
                </div>
            </div>
            <!--end slider-->
            <div class="description">
                <h2>Welcome</h2>
                <p>
                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. 
                </p>
                <p>
                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. 
                </p>
                <p class="button">
                    <a href="">Details...</a>
                </p>
            </div>
            <div class="clearfloat"></div>
        </div>
        <!--end Welcome-->
	</div>
</div>
<div class="wrapper">
    <!--begin Boxex -->
    <div class="boxex">
    
<c:if test="${!empty product }">
	<c:forEach items="${product }" var="p">
   		<c:choose>

		   <c:when test="${p.proID}==3"> 
		   </c:when>
		   
		   <c:otherwise>  否则
		   </c:otherwise>
  
		</c:choose>

	</c:forEach>
</c:if>
        <div class="box">
            <h2>Titl1 1</h2>
            <img src="<%=path %>/images/pic1.jpg" alt="pic1"> 
            <p>
            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer 
            </p>
        </div>
        <div class="box">
            <h2>Titl1 2</h2>
            <img src="<%=path %>/images/pic2.jpg" alt="pic2"> 
            <p>
            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer 
            </p>
        </div>
        <div class="box lastBox">
            <h2>Titl1 3</h2>
            <img src="<%=path %>/images/pic3.jpg" alt="pic3"> 
            <p>
            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer 
            </p>
        </div>
        <div class="clearfloat"></div>
    </div>
    <!--end Boxex-->
    <!--begin Sidebar -->
    <div class="sidebar">
    	<div class="sBox">
            <h2>Sidebar</h2>
            <ul>
                <li><a href="">Lorem Ipsum is simply </a></li>
                <li><a href="">Dummy text of the</a></li>
                <li><a href="">Printing and typesetting</a></li>
                <li><a href="">Industry lorem Ipsum</a></li>
                <li><a href="">Has been the industry's</a></li>
                <li><a href="">Standard dummy text</a></li>
                <li><a href="">Ever since the 1500s</a></li>
                <li><a href="">When an unknown</a></li>
                <li><a href="">Printer took a galley</a></li>
            </ul>
        </div>	
    </div>
    <!--end Sidebar-->
    <div class="clearfloat"></div>
</div>
<div class="clearfloat"></div>
<div class="wrapperContainer">
    <footer>
        <p>
            Copyright &copy; <a href="#">Your Site Name</a> | Collect Form <a href="http://www.cssmoban.com/" title="网页模板">网页模板</a>
        </p>
        <div class="icons">
            <ul>
                <li><a href=""><img src="<%=path %>/images/facebook.png" alt="facebook icon"></a></li>
                <li><a href=""><img src="<%=path %>/images/twitter.png" alt="twitter icon"></a></li>
                <li><a href=""><img src="<%=path %>/images/googleplus.png" alt="google plus icon"></a></li>
                <li><a href=""><img src="<%=path %>/images/dribbble.png" alt="dribble icon"></a></li>
            </ul> 
        </div>
        <div class="clearfloat"></div>
    </footer>
</div>
</body>
</html>