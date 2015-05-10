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
					<li><a href="test/toTime.do">空闲时间</a></li>
					<li class="active"><a href="test/toResult.do">结果查看</a></li>
				</ul>
				
				
			</div>
		</div>
	</nav>
	<!-- 导航结束 -->
	
	<div class="container">
		<div class="row">
			<div class="col-sm-9">
				<label>小组成员空闲时间统计如下表。</label>
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
						  

				<!-- 隐藏的label用于保存开始与结束时间 -->
				<label id="hideStartDate"  style="display: none;">${startDate}</label>
				<label id="hideEndDate" style="display: none;">${endDate}</label>
				<label id="time" style="display: none;">${time}</label>
			</div>
			<div class="col-sm-3">
				  <h3 class="text-center">小组信息</h3>
				  <div class="form-group">
				    <label>组名：${groupName}</label>
				  </div>		  
				  <div class="form-group">
				    <label for="leaderName">小组人数：${memberNames.size() }</label>
				  </div>
				  <div class="form-group">
				  	<label id="hideNames" style="display: none;">${memberNames }</label>
				    <label id="names">小组成员：</label>
				  </div>
				  <div class="form-group">
				    <label for="leaderName">开会时间：${startDate } 至 ${endDate }</label>
				  </div>
				  <div class="form-group">
				    <label for="leaderName">备注：${comment }</label>
				  </div>
				  <div class="form-group">
				    <label>开会时间建议：</label><br>
					<label id="hideAdvice" style="display: none;">${advice}</label>
					<label id="advice"></label>
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
	<script src="js/myjs.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		var startDate = $("#hideStartDate").html();
		var endDate=$("#hideEndDate").html();
		createTable(startDate,endDate);	
		
		//显示建议开会时间
		var arr=$("#hideAdvice").html().split(',');
		var timeArr=["上午","下午","晚上"];
		for(var i=0;i<arr.length;i++){
			var day=arr[i]%count;
			var time=Math.floor(arr[i]/count);
			$("#advice").html($("#advice").html()+addDay(startDate, day)+" "+timeArr[time]+"<br>");
		}
		//像是小组成员
		var names=$("#hideNames").html();
		var nn=names.replace(/"/g,'').replace("[",'').replace("]",'');
		$("#names").html($("#names").html()+nn);
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
		var time=$("#time").html();
		for(var i=0;i<count;i++){
			var str;
			var subStr="time"+i+"=[";
			var index01=time.indexOf(subStr);
			if(index01==-1){
				str="";
			}else{
				var index02=time.indexOf(']',index01);
				str=time.substring(index01+subStr.length,index02);
			}
			mytr1c=mytr1c+'<td><label>'+str.replace(/"/g,'')+'</label></td>';
			var str1;
			var subStr1="time"+(count+i)+"=[";
			var index11=time.indexOf(subStr1);
			if(index11==-1){
				str1="";
			}else{
				var index12=time.indexOf(']',index11);
				str1=time.substring(index11+subStr1.length,index12);
			}
			mytr2c=mytr2c+'<td><label>'+str1.replace(/"/g,'')+'</label></td>';
			var str2;
			var subStr2="time"+(count*2+i)+"=[";
			var index21=time.indexOf(subStr2);
			if(index21==-1){
				str2="";
			}else{
				var index22=time.indexOf(']',index21);
				str2=time.substring(index21+subStr2.length,index22);
			}
			mytr3c=mytr3c+'<td><label>'+str2.replace(/"/g,'')+'</label></td>';
		}
		$("#mytr1").append(mytr1c);
		$("#mytr2").append(mytr2c);
		$("#mytr3").append(mytr3c);
	}
	
	</script>
</body>
</html>