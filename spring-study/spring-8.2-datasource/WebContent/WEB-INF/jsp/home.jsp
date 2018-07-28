<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,java.text.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
    <title>商铺首页</title>
   
</head>
<body>

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
       
</body>
</html>