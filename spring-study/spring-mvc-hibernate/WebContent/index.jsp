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
		li1.innerHTML = "<a href='/springMVC1/user/logout'> 退出  </a>";
　　　　ul.appendChild(li1);

}
			var day = "";
            var time = new Date();
            var numOfWeek = time.getDay();
            switch (numOfWeek) {
                case 0:
                    day = "Sun";
                    break;
                case 1:
                    day="Mon";
                    break;
                case 2:
                    day = "Tues";
                    break;
                case 3:
                    day = "Wed";
                    break;
                case 4:
                    day = "Thur";
                    break;
                case 5:
                    day = "Fri";
                    break;
                case 6:
                    day = "Sat";
                    break;
            }
            var stringBuilder = [];

stringBuilder.push("<h1><a href=''>");
stringBuilder.push(day);
stringBuilder.push("<br/>");
stringBuilder.push("<span>Now</span></a>");
stringBuilder.push("</h1>");
stringBuilder.push("<div class='logoTriangle'></div>");
var resultString = stringBuilder.join("");
            document.getElementById("logo").innerHTML = resultString;
    
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
            <div class="logo" id="logo">
                <h1><a href=""> <br><span>Now</span></a></h1>
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
                
                
            <c:if test="${!empty toplist }">
			<c:forEach items="${toplist }" var="tf">
                    <div data-thumb="<%=path %>/images/slides/thumbs/1.jpg" data-src="<%=path %>/${tf.filmURL1 } ">
                        <div class="camera_caption fadeFromBottom">${tf.filmName } <em> </em></div>
                    </div>			

			</c:forEach>
			</c:if>
                
                
                
                <!--
              
                    <div data-thumb="<%=path %>/images/slides/thumbs/1.jpg" data-src="<%=path %>/images/slides/ybzy.jpg">
                        <div class="camera_caption fadeFromBottom">Wed 1 <em> </em></div>
                    </div>
                    <div data-thumb="<%=path %>/images/slides/thumbs/2.jpg" data-src="<%=path %>/images/slides/bwgqmy.jpg">
                        <div class="camera_caption fadeFromBottom">Wed 2 <em> </em></div>
                    </div>
                    <div data-thumb="<%=path %>/images/slides/thumbs/3.jpg" data-src="<%=path %>/images/slides/zqwhs.jpg">
                        <div class="camera_caption fadeFromBottom">Wed 3 <em> </em></div>
                    </div>
                    <div data-thumb="<%=path %>/images/slides/thumbs/4.jpg" data-src="<%=path %>/images/slides/4.jpg">
                        <div class="camera_caption fadeFromBottom">Wed 4 <em> </em></div>
                    </div>
                    <div data-thumb="<%=path %>/images/slides/thumbs/5.jpg" data-src="<%=path %>/images/slides/5.jpg">
                        <div class="camera_caption fadeFromBottom">Wed 5 <em> </em></div>
                    </div>
               --> 
                </div>
            </div>
            <!--end slider-->
            <div class="description">
                <h2>欢迎光临本站</h2>
                <p>
                　　    你经常对着书店里的绵绵不绝的封面发呆吗？或者头晕脑涨地从音像店的琳琅满目中逃出？宽带下载和网上购物降临之后，即使在最小的城镇，你的选择也在每天成百上千地增加。这其中一定有你会喜爱的东西，但十有八九它们会在不知不觉中和你擦肩而过。媒体让老少咸宜的大片无处不在，对只适合一群人的东西却显得力不从心。而且，萝卜青菜，各有所爱，不管电视的娱乐编辑和报纸的书评作家多么公正和勤勉，他们的帮助都不可能对所有人同样有效。
                </p>
                <p>
                　　    豆瓣的发起者发现，对多数人做选择最有效的帮助其实来自亲友和同事。随意的一两句推荐，不但传递了他们自己真实的感受，也包含了对你口味的判断和随之而行的筛选。他们不会向单身汉推荐育儿大全，也不会给老妈带回赤裸特工。遗憾的是，你我所有的亲友加起来，听过看过的仍然有限。而且，口味最类似的人却往往是陌路。
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
    
<c:if test="${!empty filmlist }">
	<c:forEach items="${filmlist }" var="f">
   		<c:choose>

		   <c:when test="${f.filmRank}!=3"> 
		   
		    <div class="box">
	            <h2>${f.filmName}</h2>
	           <a href="/springMVC1/film/getFilm?id=${f.id }"><img src="<%=path %>/${f.filmURL}" alt="pic1"> </a> 
	            <br/>
	            <p>
	            <br/>
	           ${f.filmSynopsis } 
	            </p>
       		</div>
		   
		   

		   </c:when>
		   
		   <c:otherwise>  
  		   
		   
		    <div class="box lastBox">
            <h2>${f.filmName}</h2>
            <a href="/springMVC1/film/getFilm?id=${f.id }"> <img src="<%=path %>/ ${f.filmURL}" alt="pic3"> </a>
            <br/>
            <p>
            <br/>
           ${f.filmSynopsis } 
            </p>
        	</div>
        	
		   </c:otherwise>
  
		</c:choose>

	</c:forEach>
</c:if>

 

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
                <li><a href="">My Comments</a></li>
                <li><a href="">Start Estimate</a></li>
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