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
    <div>
        <form class="navbar-form navbar-left" role="search" method="post" action="servlet/UserQueryFrequency">
        	<div class="form-group">
				<label for="name">查询条件</label>
				<select class="form-control" name="keywords">
					<option value="fname">车次</option>
					<option selected="selected" value="faddress">终点站</option>
					<option value="type">车型</option>
				</select>
			</div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search" name="critera">
            </div>
            <button type="submit" class="btn btn-primary">查询</button>
        </form>
    </div>
	</div>
</nav>

<div class="col-md-10 col-md-offset-1" >
	<table class="table table-striped">
		<caption>车次信息</caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>车次</th>
			<th>终点站</th>
			<th>开车时间</th>
			<th>距离</th>
			<th>车型</th>
			<th>级别</th>
			<th>订票</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="message" items="${frequencylist}">
		<tr>
			<td>${message.fid}</td>
			<td>${message.fname}</td>
			<td>${message.faddress}</td>
			<td>${message.starttime}</td>
			<td>${message.kilometers}</td>
			<td>${message.type}</td>
			<td>${message.level}</td>
			<td><a class="btn btn-success btn-ms" href='servlet/UserOrder?uid=<%=session.getAttribute("uid")%>&fid=${message.fid}'>订票</a></td>
 	
		</tr>
	</c:forEach>
	</tbody>
	
	</table>
</div>



</body>
</html>