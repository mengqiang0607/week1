<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/index_work.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
</head>
<body>
<form action="add" method="post" enctype="multipart/form-data">
	<p>名称:<input  type="text" name="name" ></p>
	<p>英文:<input  type="text" name="ename" ></p>
	<p>尺寸:<input  type="text" name="size" ></p>
	<p>价格(元):<input  type="text" name="price" ></p>
	<p>数量:<input  type="text" name="counts" ></p>
	<p>描述:<input  type="text" name="message" ></p>
	<p>图片:<input  type="file" name="i" ></p>
	<p>品牌:<select name="brand.bid" id="one"></select></p>
	<p>类型:<select name="goodsKind.gid" id="two"></select></p>
	<input type="submit" value="保存" onclick="aa()">
</form>
<script type="text/javascript">
	$.post("showOne",function(obj){
		for ( var i in obj) {
			$("#one").append("<option value="+obj[i].bid+">"+obj[i].bname+"<option>")
		}
		
	},"json")
	
	$.post("showTwo",function(obj){
		for ( var i in obj) {
			$("#two").append("<option value="+obj[i].gid+">"+obj[i].gname+"<option>")
		}
		
	},"json")
	
	function aa(){
		alert("新增成功!")
	}
</script>
</body>
</html>