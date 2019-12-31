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
<table>
<tr>
	<td colspan="15">
		<form action="list">
			输入名称:<input type="text" name="name">
			<input type="submit" value="搜索">
			<a href="add.jsp"><input type="button" value="增加"></a>
			<input type="button" value="批量删除" onclick="dels()">
		</form>
	</td>
</tr>
  <tr>
    <td><input type="checkbox" id="box"></td>
    <td>编号</td>
    <td>名称</td>
    <td>英文</td>
    <td>尺寸</td>
    <td>价格</td>
    <td>数量</td>
    <td>描述</td>
    <td>图片</td>
    <td>品牌</td>
    <td>操作</td>
  </tr>
  <c:forEach items="${plist.list }" var="p">
  <tr>
     <td><input type="checkbox" name="ck" value="${p.id}"></td>
    <td>${p.id}</td>
    <td>${p.name}</td>
    <td>${p.ename}</td>
    <td>${p.size}</td>
    <td>${p.price}</td>
    <td>${p.counts}</td>
    <td>${p.message}</td>
    <td><img alt="图片受损" src="${p.img}" width="50px" height="50px" ></td>
    <td>${p.brand.bname}</td>
    <td><a href="show.jsp?id=${p.id}">【详情】</a>
    	<a href="update.jsp?id=${p.id}">【编辑】</a>
    	<a href="delOne?id=${p.id}">【删除】</a>
    </td>
  </tr>
  </c:forEach>
  	<tr>
			<td colspan="15">
			当前${plist.pageNum }/${plist.pages }页，总${plist.total }记录，
			<a href="list.do?pageNum=${plist.firstPage }">首页</a>
			<a href="list.do?pageNum=${plist.prePage }">上一页</a>
			<a href="list.do?pageNum=${plist.nextPage }">下一页</a>
			<a href="list.do?pageNum=${plist.lastPage }">末页</a>
			</td>
		</tr>
</table>

<script type="text/javascript">
	$("#box").click(function(){
		$("[name=ck]").each(function(){
			this.checked=!this.checked
		})
	})
	
	function dels(){
		var ids="";
		$("[name=ck]:checked").each(function(){
			ids+=this.value+","
		})
		if(confirm("确定要删除吗?")){
			
		$.post("dels","ids="+ids,function(obj){
			if(obj>0){
				location="list"
			}
		},"json")
	}
		}
</script>
</body>
</html>