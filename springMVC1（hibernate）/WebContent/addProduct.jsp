<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<script type="text/javascript" src="../js/jquery-1.7.1.min.js">
</script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
function addProduct() {
	var form = document.forms[0];
	form.action = "/springMVC1/product/addProduct";
	form.method = "post";
	form.submit();
}
</script>
	</head>
	<body>
		<h1>
		添加商品
		</h1>
		<form name="productForm" action="">
			ID：
			<input type="text" name="proID">
			名字：
			<input type="text" name="proName">
			数量：
			<input type="text" name="proNo">
			评价：
			<input type="text" name="proEstimate">
			其他：
			<input type="text" name="proO">
		
			<input type="button" value="添加商品" onclick="addProduct()">

		</form>



	</body>
</html>