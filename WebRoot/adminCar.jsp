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
    
    <title>My JSP 'admin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>Bootstrap 实例 - 面包屑导航</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
	function confirmDel(){
				var result = confirm("确认要删除吗？");			
					if(result==true){		 
						$.get('servlet/DeleteServlet',{'uid':'${message.uid}'},function(data){
							{alert("删除成功")}
						});		
			
}
}

 function update(fid,fname,faddress,starttime,kilometers,type,level){
   var updatefrequency= document.getElementById("updateFrequencyForm");
   		updatefrequency.id.value=fid;
  		updatefrequency.fid.value=fid;
  		updatefrequency.fname.value=fname;
  		updatefrequency.faddress.value=faddress;
  		updatefrequency.starttime.value=starttime;
  		updatefrequency.kilometers.value=kilometers;
  		updatefrequency.type.value=type;
  		updatefrequency.level.value=level;
 }
	</script>
</head>
<body>

<ol class="breadcrumb">
	<li><a href="servlet/AdminFindAll">八戒订票</a></li>
	<li>你好，<%=session.getAttribute("username") %></li>
	<li><a href="servlet/logout">退出登录</a></li>
	<li><a href="servlet/AdminFindAll">全部用户信息</a></li>
	<li><a href="servlet/AdminQueryFrequencyAll">全部车次信息</a></li>
	<li><button class="btn btn-primary" data-toggle="modal" data-target="#adduser"">增加车次</a></li>
	<li><button class="btn btn-primary" data-toggle="modal" data-target="#queryuser"">查询车次</a></li>
</ol>
<div class="col-md-10 col-md-offset-1" >
	<table class="table table-striped">
		<caption>当前用户</caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>车次</th>
			<th>终点站</th>
			<th>开车时间</th>
			<th>距离</th>
			<th>车型</th>
			<th>级别</th>
			<th>修改</th>
			<th>删除</th>
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
				<td><button class="btn btn-success btn-ms" onclick="update(${message.fid},'${message.fname}','${message.faddress}','${message.starttime}',${message.kilometers},'${message.type}',${message.level})"; data-toggle="modal" data-target="#myModal">修改</button></td>
 			  <td><a class="btn btn-danger" href='servlet/AdminDeleteFrequency?fid=${message.fid}' onclick="return confirm('确实要删除Id为${message.fid}的记录吗？')">删除</a></td>
		</tr>
	</c:forEach>
	</tbody>
	
	</table>
</div>
            

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h3 class="modal-title" id="myModalLabel">
					修改车次信息
				</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="updateFrequencyForm" method="post" action="servlet/AdminUpdateFrequency" role="form">
					    <div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">序号</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control" disabled name="id" >
					        </div>
					    </div>
					    <div class="form-group">
					        <div class="col-sm-10">
					            <input type="hidden" class="form-control" name="fid" >
					        </div>
					    </div>
						 <div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">车次</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control"  name="fname" >
					        </div>
					    </div>
						 <div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">终点站</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control" name="faddress" >
					        </div>
					    </div>
					     <div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">开车时间</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control"  name="starttime" >
					        </div>
					    </div>
					    <div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">距离</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control"  name="kilometers" >
					        </div>
					    </div>
					    <div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">类型</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control"  name="type" >
					        </div>
					    </div>
					    <div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">级别</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control"  name="level" >
					        </div>
					    </div>
					    <div class="form-group">
					        <div class="col-sm-2 col-md-offset-8">
					            <input type="submit" value="修改"  class="form-control btn-primary" >
					        </div>
					    </div>
				</form>
			</div>
			
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


<!-- 增加用户 -->
<div class="modal fade" id="adduser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h3 class="modal-title" id="myModalLabel">
					增加车次
				</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal"  method="post" action="servlet/AdminAddFrequency" role="form">
					    
						<div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">车次</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control"  name="fname" >
					        </div>
					    </div>
						 <div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">终点站</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control" name="faddress" >
					        </div>
					    </div>
					     <div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">开车时间</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control"  name="starttime" >
					        </div>
					    </div>
					    <div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">距离</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control"  name="kilometers" >
					        </div>
					    </div>
					    <div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">类型</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control"  name="type" >
					        </div>
					    </div>
					    <div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">级别</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control"  name="level" >
					        </div>
					    </div>
					    <div class="form-group">
					        <div class="col-sm-2 col-md-offset-8">
					            <input type="submit" value="增加"  class="form-control btn-primary" >
					        </div>
					    </div>
				</form>
			</div>
			
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>




<!-- 查询用户 -->
<div class="modal fade" id="queryuser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h3 class="modal-title" id="myModalLabel">
					查询车次
				</h3>
			</div>
			<div class="modal-body">
				<form class="form-horizontal"  method="post" action="servlet/AdminQueryFrequency" role="form">
					 
						 <div class="form-group">
					        <label for="firstname" class="col-sm-2 control-label">车次名称</label>
					        <div class="col-sm-10">
					            <input type="text" class="form-control"  name="fname" >
					        </div>
					    </div>	 
					    <div class="form-group">
					        <div class="col-sm-2 col-md-offset-8">
					            <input type="submit" value="查询"  class="form-control btn-primary" >
					        </div>
					    </div>
				</form>
			</div>
			
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

</body>
</html>