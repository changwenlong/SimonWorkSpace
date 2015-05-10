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
					<li><a href="test/toHome.do">主页</a></li>
					<li class="active"><a href="test/toGroup.do">创建小组</a></li>
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
				  <h2 class="text-center">创建小组</h2>
				  <div class="form-group">
				    <label for="groupName">组名</label>
				  	<input type="text" class="form-control" id="groupName" placeholder="Enter group name">
				  </div>
				  <div class="form-group">
				    <label for="leaderName">你的姓名</label>
				    <input type="text" class="form-control" id="leaderName" placeholder="Enter your name">
				  </div>
				  <div class="form-group">
				    <label for="startDate">开始日期</label>
				    <input type="text" class="form-control form_date" id="startDate" readonly  placeholder="Enter Start Time">
				    </div>
				  <div class="form-group">
				    <label for="endDate">结束日期</label>
				    <input type="text" class="form-control form_date" id="endDate" readonly placeholder="Enter End Time">
				  </div>
				  <div class="form-group">
				    <label for="comment">备注</label>
				    <textarea class="form-control" rows="3" id="comment" placeholder="Enter comment"></textarea>
				  </div>
				  <button type="submit" class="btn btn-default" style="text-align:center;" id="mybutton">确定</button>
				  <a data-toggle="modal" data-target="#myModal" id="amodel"></a>
				  <a href="test/toTime.do" class="btn btn-default" style="float:right;">填写空闲时间</a>
				  <label id="path" style="display: none;"><%=basePath %></label>
			</div>
			<div class="col-sm-4"></div>
		</div>	
		
		<!-- Modal -->
		<div class="modal fade  bs-example-modal-sm"  id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog" style="width:300px">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">复制小组编号</h4>
		      </div>
		      <div class="modal-body">	  
				  <div class="form-group">
				    <label for="groupId">小组编号</label>
				    <div class="row">
						<div class="col-sm-9">
							<input type="text" class="form-control" id="groupId" readonly placeholder="create id for you">
						</div>
						<div class="col-sm-3">
							<button type="submit" class="btn btn-default" style="text-align:center;" id="copyId">复制</button>
				 		</div>
					</div>				    
				   </div>
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
			if($("#groupId").val()!=""){
				alert("不能重复提交！");
				return;
			}
			var groupName=$("#groupName").val();
			var leaderName=$("#leaderName").val();
			var startDate=$("#startDate").val();
			var endDate=$("#endDate").val();
			var comment=$("#comment").val();
			if(leaderName==""||startDate==""||endDate==""){
				alert("姓名、开始时间与结束时间为必填项");
				return;
			}
			$.ajax({
				url:"test/group.do",
				type:"post",
				dataType:"text",
				data:{
					"groupName":groupName,
					"leaderName":leaderName,
					"startDate":startDate,
					"endDate":endDate,
					"comment":comment
				},
				success:function(responseText){
					$("#groupId").val(responseText);
					//跳出复制小组编号的对话框
					$("#amodel").click();
				},
				error:function(){
					alert("system error");
				}
			});
		});
		
		$("#copyId").click(function(){
			var con=$("#groupId").val();
			//目前只能使用IE
			window.clipboardData.setData('text',con); 
			var aa=window.clipboardData.getData('text');
			if(aa!=""&&aa==con){
				alert("小组编号已复制到剪切板！");
				window.location.href=$("#path").html()+'/test/toTime.do';
			}
		});
	});
	

	$('.form_date').datetimepicker({
		format: 'yyyy/mm/dd',
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
	</script>
</body>
</html>