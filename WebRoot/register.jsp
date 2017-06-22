<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>登录注册表单界面</title>
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css"/>
	<link rel="stylesheet"  type="text/css" href="css/style.css" />
	<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="js/user.js" type="text/javascript"></script>
</head>
<body>
	<div class="htmleaf-container">
		<header class="htmleaf-header">
			<h1>八戒订票 </h1>
		</header>
		<p class="center">管理员：admin，1</p>
		<p class="center">用户：21，21</p>

		<div id="wrapper" class="login-page">
		  <div id="login_form" class="form">
		    <form class="register-form" method="post" action="servlet/register">
		      <input type="text" placeholder="用户名"  name="username1" />
		      <input type="password" placeholder="密码" name="password1" />
		     
		      <input type="submit" value="创建账户">

		      <p class="message">已经有了一个账户? <a class="messageb" href="javascript:void(0);">立刻登录</a></p>
		    </form>

		    <form class="login-form" method="post" action="servlet/login">
		      <input type="text" placeholder="用户名" name="username2"/>
		      <input type="password" placeholder="密码"  name="password2"/>
		      <input type="submit" value="登录"  class="btn btn-default"/>
		      <p class="message">还没有账户? <a class="messageb"  href="javascript:void(0);">立刻创建</a></p>
		    </form>
		  </div>
		</div>
		<div id="mes">123</div>
	</div>

</body>
</html>
