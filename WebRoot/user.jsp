<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<head>
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
        <a class="navbar-brand" href="servlet/login">
			               退出登录
		</a>
	</div>
	<div>			 		
        <a class="navbar-brand"  href='servlet/QueryOrder?userid=<%=session.getAttribute("uid")%>' >
			               用户管理
		</a>
	</div>
	<div>			 		
        <a class="navbar-brand" href='servlet/QueryOrder?userid=<%=session.getAttribute("uid")%>'>
			               已订车票
		</a>
	</div>
	</div>
</nav>

<h1>没让完成。不先写了</h1>

</body>
</html>