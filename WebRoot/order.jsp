<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>登录注册表单界面</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/user.js" type="text/javascript"></script>
</head>
<body>


<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="servlet/FindAllFrequency">八戒订票</a>
    </div>				
	<div>			 		
        <a class="navbar-brand" href="user.jsp">
			                欢迎，<%=session.getAttribute("username") %>
		</a>
	</div>
	<div>			 		
        <a class="navbar-brand" href="servlet/logout">
			               退出登录
		</a>
	</div>
      <a class="navbar-brand" href='servlet/QueryOrder?userid=<%=session.getAttribute("uid")%>'>
			               已订车票
		</a>
</nav>

<div class="col-md-10 col-md-offset-1" >
	<table class="table table-striped">
		<caption>车次信息</caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>用户id</th>
			<th>终点站</th>
			<th>车次</th>
			<th>价格</th>
			<th>退票</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="message" items="${orderlist}">
		<tr>
			<td>${message.oid}</td>
			<td>${message.userid}</td>
			<td>${message.finaladdress}</td>
			<td>${message.frequencyid}</td>
			<td>${message.price}</td>
			<td><a class="btn btn-danger btn-ms" href='servlet/UserDisOrder?uid=<%=session.getAttribute("uid")%>&oid=${message.oid}'          
			onclick="return confirm('确实要退Id为${message.oid}的票吗？')"
			       >退票</a></td>
		</tr>
	</c:forEach>
	</tbody>
	
	</table>
</div>



</body>
</html>