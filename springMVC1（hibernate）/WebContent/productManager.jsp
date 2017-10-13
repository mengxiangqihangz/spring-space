<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del(id){
		$.get("/springMVC13/product/delProduct?id=" + id,function(data){
			alert(data.result);
			if("success" == data.result){
				alert("删除成功!");
				window.location.reload(); 
			}else{
				alert("删除失败!")
			}
		});
	}

</script>
</head>
<body>
	
	<table border="1">
		<tbody>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>编辑</th>
			</tr>
			<c:if test="${!empty product }">
			<c:forEach items="${product }" var="p">
			<tr>
				<td>${p.proID }</td>
				<td>${p.proName }</td>
				<td>
					<a href="/springMVC13/product/getProduct?id=${p.id }">编辑</a>
					<a href="javascript:del('${p.id }')">删除</a>
				</td>
			</tr>
			</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>