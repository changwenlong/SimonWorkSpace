<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>    
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>啥时候开会呢？</title>

	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
    
	<style type="text/css">
		body {
			padding-top:50px;
			font-family: Arial， Helvetica， sans-serif; font-size:12px;
		    /* text-align:center; */
		}
		.container {
			padding-top:30px;
		}
		.row label{
			padding-top:30px;
		}
	</style>

</head>
<body>
	<!-- 导航开始 -->
	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand">啥时候开会呢？</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="test/toHome.do">主页</a></li>
					<li><a href="test/toGroup.do">创建小组</a></li>
					<li><a href="test/toTime.do">空闲时间</a></li>
					<li><a href="test/toResult.do">结果查看</a></li>
				</ul>
				
				
			</div>
		</div>
	</nav>
	<!-- 导航结束 -->
	
	<div class="container">
	
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				  <h2 class="text-center">小组开会时间建议</h2>
				  <div class="form-group">
				    <label>1.小组已存在请点击“已建小组”</label>
				  	<!-- Button trigger modal -->
					<a data-toggle="modal" data-target="#myModal">
					  已建小组
					</a>
				  </div>
				  <div class="form-group">
				    <label>2.小组不存在或遗失小组编号，请点击“创建小组”</label>
				    <a href="test/toGroup.do">创建小组</a>
				  </div>
			</div>
			<div class="col-sm-4"><label id="path" style="display: none;"><%=basePath %></label></div>
		</div>	


		<!-- Modal -->
		<div class="modal fade  bs-example-modal-sm"  id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog" style="width:300px">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">小组信息</h4>
		      </div>
		      <div class="modal-body">
		          <div class="form-group">
				    <label for="name">你的姓名</label>
				  	<input type="text" class="form-control" id="name">
				  </div>
				  <div class="form-group">
				    <label for="groupId">小组编号</label>
				    <input type="text" class="form-control" id="groupId">
				  </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		        <button type="button" class="btn btn-primary" id="mybutton">确定</button>
		      </div>
		    </div>
		  </div>
		</div>
					
	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!-- <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script> -->
	<script src="js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script src="js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#mybutton").click(function(){
			var name=$("#name").val();
			var groupId=$("#groupId").val();
			if(name==""||groupId==""){
				alert("姓名与小组编号不能为空！");
				return;
			}
			$.ajax({
				url:"test/home.do",
				type:"post",
				dataType:"text",
				data:{
					"name":name,
					"groupId":groupId
				},
				success:function(responseText){
					if(responseText=="wrong"){
						alert("小组编号错误，请重新输入！");
						$("#groupId").val("");
					}
					else{
						window.location.href=$("#path").html()+'/test/toTime.do';
					}
				},
				error:function(){
					alert("system error");
				}
			});
		});
	});
	</script>
</body>
</html>