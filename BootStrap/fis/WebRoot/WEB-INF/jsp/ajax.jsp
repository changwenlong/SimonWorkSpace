<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>基金推荐</title>

	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
	<script src="scripts/jquery.min.js"></script>
	<link rel="stylesheet" href="bootstrap/css/demo.css">
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/responsiveslides.min.js"></script>
	<script src="scripts/Chart.js"></script>

	<!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
	<!--[if lt IE 9]>
		 <script src="bootstrap/js/html5shiv.min.js"></script>
		 <script src="bootstrap/js/respond.min.js"></script>
	<![endif]-->
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
  	<script type="text/javascript">
  		$(function(){
  			
  		});
  		
  	</script>
  	<style type="text/css"> 
  	body { font-family: Arial， Helvetica， sans-serif; font-size:12px; }
  	</style>
  </head>
  
  <body style="background-color:#111;">
  	<!-- <input id="mybutton" type="button" value="click"> -->
  	<div class="container">

	
	<div class="row">
		<div class="span">
			<nav class="navbar navbar-inverse" role="navigation">
			   <div class="navbar-header">	
				  <a class="navbar-brand" href="#"></a>				
				  <a class="navbar-brand" href="#"><h1>基金推荐</h1></a>
			   </div>
			   <div style="float:right;padding:15px 50px;">
					 <a data-toggle="modal" data-target="#familyModal" 
									style="float: right;"><h1>自我鉴定</h1></a>
				  <a class="navbar-brand" href="#"></a>		
			   </div>
			</nav>

		</div>
	</div>

	<div class="row">
		<div class="span">
			&nbsp;&nbsp;<font color="red" id="recommendFund"></font>
		</div>
	</div>
	
	<!--主要内容-->
	<div class="row">
	<div class="callbacks_container">
      	<div  id="canvasDiv" width="800px" style="float:left;">
			<canvas id="canvas" height="400" width="800" ></canvas>
		</div>
		<div style="float:left;">
		<table style="margin:10px;">
			<tr>
			<td><input type="button"  class="btn" value="汇丰晋信大盘" tag="0" style="background-color:#117723;border:0px #ff0000 solid;margin:20px;padding:5px;"/></td>
			<td><input type="button"  class="btn" value="上投摩根全球资源" tag="1" style="background-color:#1177ff;border:0px #ff0000 solid;padding:5px;"/></td>
			</tr>
			<tr>
			<td><input type="button"  class="btn" value="海富通国策导向" tag="2" style="background-color:#ff1177;border:0px #ff0000 solid;margin:20px;padding:5px;"/></td>
			<td><input type="button"  class="btn" value="嘉实绝对收益"  tag="3" style="background-color:#11ff77;border:0px #ff0000 solid;padding:5px;"/></td>
			</tr>
			<tr>
			<td><input type="button"  class="btn" value="博时裕益灵活配置" tag="4" style="background-color:#aaee33;border:0px #ff0000 solid;margin:20px;padding:5px;"/></td>
			<td><input type="button"  class="btn" value="天弘丰利债券"  tag="5" style="background-color:#33eeaa;border:0px #ff0000 solid;padding:5px;"/></td>
			</tr>
			<tr>
			<td><input type="button"  class="btn" value="诺安稳固收益债券" tag="6" style="background-color:#ee33aa;border:0px #ff0000 solid;margin:20px;padding:5px;"/></td>
			<td><input type="button"  class="btn" value="博时天颐A " tag="7" style="background-color:#661199;border:0px #ff0000 solid;padding:5px;"/></td>
			</tr>
			<tr>
			<td><input type="button"  class="btn" value="中证金融地产ETF" tag="8" style="background-color:#446655;border:0px #ff0000 solid;margin:20px;padding:5px;"/></td>
			<td><input type="button"  class="btn" value="长盛沪深300" tag="9" style="background-color:#aa8899;border:0px #ff0000 solid;padding:5px;"/></td>
			</tr>
		</table>
			
			
		</div>
    </div>
</div>

	<div class="row">
		<div class="span12">
			
			<!-- Modal -->
			<!-- 添加家人信息 -->
			<div class="modal fade" id="familyModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" style="width: 500px;">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">
								<b>调查问卷</b>
							</h4>
						</div>

						<div class="modal-body">

							<div style="margin-bottom: 20px">
								<table class="chwl_table">
									<tr>
										<td>1、您的年龄是：<br/>
											<input type="radio" name="q1" value="A"  />A、30岁以下 <br/>
											<input type="radio" name="q1" value="B" />B、30-40岁 <br/>
											<input type="radio" name="q1" value="C" />C、40-50岁<br/>
											<input type="radio" name="q1" value="D" />D、50-60岁<br/>
											<input type="radio" name="q1" value="E" />E、60岁及以上<br/><br/>
										</td>
									</tr>
									<tr>
										<td>2、您的性别是：<br/>
											<input type="radio" name="q2" value="A" />A、男<br/>
											<input type="radio" name="q2" value="B" />B、女<br/><br/>
										</td>
									</tr>
									<tr>
										<td>3、总体而言，您持有单只基金的平均时间约为：<br/>
											<input type="radio" name="q3" value="A"  />A、5年以上 <br/>
											<input type="radio" name="q3" value="B" />B、3-5年 <br/>
											<input type="radio" name="q3" value="C" />C、1-3年<br/>
											<input type="radio" name="q3" value="D" />D、半年到一年<br/>
											<input type="radio" name="q3" value="E" />E、少于6个月<br/><br/>
										</td>
									</tr>
									<tr>
										<td>4、以下几种投资组合，您更偏好哪一种：<br/>
											<input type="radio" name="q4" value="A"  />A、收益最高可达50%，但也可能亏损30% <br/>
											<input type="radio" name="q4" value="B" />B、收益最高可达20%，但也可能亏损10% <br/>
											<input type="radio" name="q4" value="C" />C、收益最高可达10%，但也可能亏损5%<br/>
											<input type="radio" name="q4" value="D" />D、收益最高只有3%，但不亏损<br/><br/>
										</td>
									</tr>
									<tr>
										<td>5、您投资基金多长时间：<br/>
											<input type="radio" name="q5" value="A"  />A、多于10年  <br/>
											<input type="radio" name="q5" value="B" />B、5-10年 <br/>
											<input type="radio" name="q5" value="C" />C、3-5年<br/>
											<input type="radio" name="q5" value="D" />D、1-3年<br/>
											<input type="radio" name="q5" value="E" />E、少于1年<br/><br/>
										</td>
									</tr>
									<tr>
										<td>6、2014年您的税后年收入（证券收益除外）是：<br/>
											<input type="radio" name="q6" value="A"  />A、30万元以上 <br/>
											<input type="radio" name="q6" value="B" />B、15-30万元 <br/>
											<input type="radio" name="q6" value="C" />C、10-15万元<br/>
											<input type="radio" name="q6" value="D" />D、5-10万元<br/>
											<input type="radio" name="q6" value="E" />E、5万元以下<br/><br/>
										</td>
									</tr>
									<tr>
										<td>7、购买基金后，您通常采取的态度是：<br/>
											<input type="radio" name="q7" value="A"  />A、一般不查看账户盈亏，注重长期收益  <br/>
											<input type="radio" name="q7" value="B" />B、偶尔查看以下账户盈亏，觉得差不多了就赎回 <br/>
											<input type="radio" name="q7" value="C" />C、很紧张投资的盈亏，每天查看净值、收益率及每日业绩排名<br/>
											<input type="radio" name="q7" value="D" />D、频繁的申购、赎回或转换，以短期套利<br/><br/>
										</td>
									</tr>
									<tr>
										<td>8、您目前有几家基金公司的基金产品：<br/>
											<input type="radio" name="q8" value="A" />A、5家以上 <br/>
											<input type="radio" name="q8" value="B" />B、4家 <br/>
											<input type="radio" name="q8" value="C" />C、3家<br/>
											<input type="radio" name="q8" value="D" />D、2家<br/>
											<input type="radio" name="q8" value="E" />E、1家<br/><br/>
										</td>
									</tr>
								</table>

							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="mybutton">确定</button>
							<button type="button" class="btn btn-default" data-dismiss="modal" id="cancelDiv">取消</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row" id="bottomDiv">
		<div class="span">
			<div  align="center" style="background:#222;padding:12px;color:#999;">2014金融信息技术小组 copyright@2014-2024 &nbsp;&nbsp;
			
			</div>
			
		</div>
	</div>
		
</div>


<script>
	var lineChartData;
	setData();
	
	function getScore(ss){
		if(ss=='A'){
			return 9;
		}
		if(ss=='B'){
			return 7;
		}
		if(ss=='C'){
			return 5;
		}
		if(ss=='D'){
			return 3;
		}
		if(ss=='E'){
			return 1;
		}
		return 0;
	}
	$(document).ready(function(){
		//计算用户向量，并推荐基金
		$("#mybutton").click(function(){
			var item2=0,item3=0;
			//题1-8 共9道
			item3+=getScore($('input[name="q1"]:checked').val());
			item2+=getScore($('input[name="q2"]:checked').val());
			item3+=getScore($('input[name="q3"]:checked').val());
			item2+=getScore($('input[name="q4"]:checked').val());
			item3+=getScore($('input[name="q5"]:checked').val());
			item2+=getScore($('input[name="q6"]:checked').val());
			item3+=getScore($('input[name="q7"]:checked').val());
			item2+=getScore($('input[name="q8"]:checked').val());
			var userVertor=""+item2/4+","+item3/4;
			$.ajax({
				url:"test/ajax.do",
				type:"post",
				dataType:"text",
				data:{
					name:userVertor
				},
				success:function(responseText){
					var result="为您推荐最优的三支分别为：";
					var fundArr=responseText.split(",");
					for (var i = 0;i < fundArr.length;i++) { 
						result+=lineChartData.datasets[fundArr[i]].label+"  /  ";
					}
					lineChartData.datasets[fundArr[0]].fillColor="rgba(0,256,124,0.5)";
					showClick();
					$("#recommendFund").text(result);
					$("input:radio:checked").removeAttr("checked"); 
					$("#cancelDiv").click();
				},
				error:function(){
					alert("system error");
				}
			});
		});
	  //画基金走势图
	  initCanvas();
	  $("input").click(function(){
			var index=$(this).attr("tag");
			lineChartData.datasets[index].fillColor="rgba(0,256,124,0.5)";
			showClick();
	  });
	});

	function showClick(){
		initCanvas();
		for (var i = 0;i < 10;i++) { 
			lineChartData.datasets[i].fillColor="rgba(0,256,124,0)";
		}
	}

	function initCanvas(){
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myLine = new Chart(ctx).Line(lineChartData, {
			responsive: true
		});
	}
	
	function setData(){
		lineChartData = {
			labels : ["11-1","11-2","11-3","11-4","11-5","11-6","11-7","11-8","11-9","11-10","11-11","11-12","11-13","11-14","11-15","11-16","11-17","11-18","11-19","11-20","11-21","11-22","11-23","11-24","11-25","11-26","11-27","11-28","11-29","11-30"],
			datasets : [
				{
					label: "汇丰晋信大盘",
					fillColor : "rgba(11,77,22,0)",
					strokeColor : "#117723",
					pointColor : "#117723",
					pointHighlightStroke : "#117723",
					data : [0.17,-2.38,0.27,0.85,-5.33,0.38,-5.41,3.57,-3.17,-2.46,2.55,0.99,0.48,-1.43,3.48,2.70,0.14,1.57,2.89,-0.26,3.52,4.21,5.82,6.93,-1.81,5.17,2.47,6.73,13.50,14.80]
				},
				{
					label: "上投摩根全球资源",
					fillColor : "rgba(11,77,22,0)",
					strokeColor : "#1177ff",
					pointColor : "#1177ff",
					pointHighlightStroke : "#1177ff",
					data : [0.90,-1.92,-1.31,6.75,-0.62,-2.00,1.14,1.26,1.99,1.22,-0.96,1.70,14.70,-0.89,-1.57,-1.37,-0.12,-5.75,-10.50,-2.60,-5.61,1.78,-4.96,-3.69,-0.26,1.11,-0.35,-1.07,-4.33,-0.19]
				},
				{
					label: "海富通国策导向",
					fillColor : "rgba(11,77,22,0)",
					strokeColor : "#ff1177",
					pointColor : "#ff1177",
					pointHighlightStroke : "#ff1177",
					data : [8.22,3.90,7.58,1.27,-3.76,-0.98,-9.40,1.96,-10.71,-1.75,3.97,3.43,2.94,-2.93,3.77,2.25,5.26,-2.91,5.50,-2.90,8.83,-4.68,4.40,3.83,-3.12,2.34,0.99,2.17,-3.36,5.91]
				},
				{
					label: "嘉实绝对收益",
					fillColor : "rgba(11,77,22,0)",
					strokeColor : "#11ff77",
					pointColor : "#11ff77",
					pointHighlightStroke : "#11ff77",
					data : [0.0,0.30,0.79,0.30,0.01,-0.01,-0.29,0.20,-0.49,0.69,-0.59,1.09,-0.68,2.36,-1.54,1.07,-1.06,0.59,-0.87,0.88,-0.68,-1.66,-1.99,-1.42,0.87,-1.13,-0.24,1.45,2.12,-0.83]
				},
				{
					label: "博时裕益灵活配置",
					fillColor : "rgba(11,77,22,0)",
					strokeColor : "#aaee33",
					pointColor : "#aaee33",
					pointHighlightStroke : "#aaee33",
					data : [1.22,-0.84,0.96,-1.79,-0.88,0.33,-1.30,-1.86,-0.97,1.74,1.60,-1.26,0.85,-0.84,0.21,0.42,1.88,0.92,1.01,1.50,-1.08,5.38,7.47,7.83,4.49,-0.82,-3.32,1.97,1.30,2.25]
				},
				{
					label: "天弘丰利债券",
					fillColor : "rgba(11,77,22,0)",
					strokeColor : "#33eeaa",
					pointColor : "#33eeaa",
					pointHighlightStroke : "#33eeaa",
					data : [0.11,-1.70,0.51,1.36,-0.39,0.38,-0.71,-0.14,0.61,0.48,0.73,5.29,1.38,0.35,0.34,0.38,0.96,0.48,0.84,1.01,2.79,1.20,-2.92,-3.73,0.74,-1.13,-0.06,0.84,1.12,1.31]
				},
				{
					label: "诺安稳固收益债券",
					fillColor : "rgba(11,77,22,0)",
					strokeColor : "#ee33aa",
					pointColor : "#ee33aa",
					pointHighlightStroke : "#ee33aa",
					data : [3.42,0.49,0.29,0.88,0.0,0.19,0.19,0.58,0.48,0.48,0.38,0.28,0.28,0.38,0.56,-0.56,0.19,-1.23,0.40,0.60,0.79,0.29,-0.49,-0.69,0.04,0.92,-1.04,0.07,0.93,0.87]
				},
				{
					label: "博时天颐A",
					fillColor : "rgba(11,77,22,0)",
					strokeColor : "#661199",
					pointColor : "#661199",
					pointHighlightStroke : "#661199",
					data : [12.01,-1.32,0.82,1.43,1.31,-1.19,0.80,0.40,-0.70,-0.20,0.20,3.90,-1.83,1.08,-1.07,7.94,-1.18,1.65,-1.45,2.66,1.07,3.36,-1.32,0.03,-1.21,-1.04,1.88,2.14,-0.97,1.45]
				},
				{
					label: "中证金融地产ETF",
					fillColor : "rgba(11,77,22,0)",
					strokeColor : "#446655",
					pointColor : "#446655",
					pointHighlightStroke : "#446655",
					data : [-13.90,-5.13,2.47,-2.25,3.57,-5.60,-3.36,12.04,-5.76,1.71,2.04,-2.18,1.98,11.45,-4.32,5.48,-3.01,2.50,-0.93,2.27,2.78,4.42,4.91,6.83,8.83,2.91,4.73,4.24,6.21,7.90]
				},
				{
					label: "长盛沪深300",
					fillColor : "rgba(11,77,22,0)",
					strokeColor : "#aa8899",
					pointColor : "#aa8899",
					pointHighlightStroke : "#aa8899",
					data : [-2.91,-5.51,2.30,2.91,-3.71,-3.03,4.11,3.81,-5.77,-0.84,1.97,1.65,-1.90,2.49,8.49,0.37,0.00,1.36,3.91,-1.18,-3.57,8.63,-2.49,9.42,-5.87,1.63,7.27,7.43,11.96,14.91]
				}
			]

		};
	}
</script>
  </body>
</html>
