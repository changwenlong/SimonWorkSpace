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
		.container .table-responsive{
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
					<li><a href="test/toHome.do">主页</a></li>
					<li><a href="test/toGroup.do">创建小组</a></li>
					<li class="active"><a href="test/toTime.do">空闲时间</a></li>
					<li><a href="test/toResult.do">结果查看</a></li>
				</ul>
				
				
			</div>
		</div>
	</nav>
	<!-- 导航结束 -->
	
	<div class="container">
		<label>下面的表格是组长定的开会时间表，请标记出你的空闲时间，然后点击确认。</label>
		<div class="table-responsive">
		  <table class="table table-hover table-condensed table-bordered">
			<tr id="timeTr">
			  <td></td>
			</tr>
			<tr id="mytr1">
			  <td>上午</td>
			</tr>
			<tr id="mytr2">
			  <td>下午</td>
			</tr>
			<tr id="mytr3">
			  <td>晚上</td>
			</tr>
		
		  </table>
		</div>
				  
		<button type="submit" class="btn btn-default" style="text-align:center;" id="mybutton">确定</button>
		
		<!-- 隐藏的label用于保存开始与结束时间 -->
		<label id="hideStartDate"  style="display: none;">${startDate}</label>
		<label id="hideEndDate" style="display: none;">${endDate}</label>
		<label id="path" style="display: none;"><%=basePath %></label>
	</div>



	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!-- <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script> -->
	<script src="js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script src="js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
	<script src="js/myjs.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		var startDate = $("#hideStartDate").html();
		var endDate=$("#hideEndDate").html();
		createTable(startDate,endDate);
		
		$("#mybutton").click(function(){
			var arr="";
			for(var i=0;i<count*3;i++){
				if($("#"+i+"").is(':checked')){
					arr=arr+i+",";
				}
			}
			if(arr==""){
				return;
			}
			$.ajax({
				url:"test/time.do",
				type:"post",
				dataType:"text",
				data:{
					"timeArr":arr
				},
				success:function(responseText){
					if(responseText=="OK"){
						window.location.href=$("#path").html()+'/test/toResult.do';
					}
				},
				error:function(){
					alert("system error");
				}
			});
		}); 
	});
	
	/*传入开始预结算时间，创建table*/
	//保存天数
	var count;
	function createTable(startDate,endDate){
		count=getInterval( startDate,endDate );
		var trContent='';
		for(var i=0;i<count;i++){
			trContent=trContent+'<td>'+addDay(startDate,i)+'</td>';
		}
		$("#timeTr").append(trContent);
		var mytr1c='',mytr2c='',mytr3c='';
		for(var i=0;i<count;i++){
			mytr1c=mytr1c+'<td><input type="checkbox" id="'+i+'"/></td>';
			mytr2c=mytr2c+'<td><input type="checkbox" id="'+(count+i)+'"/></td>';
			mytr3c=mytr3c+'<td><input type="checkbox" id="'+(count*2+i)+'"/></td>';
		}
		$("#mytr1").append(mytr1c);
		$("#mytr2").append(mytr2c);
		$("#mytr3").append(mytr3c);
	}
	
	</script>
</body>
</html>