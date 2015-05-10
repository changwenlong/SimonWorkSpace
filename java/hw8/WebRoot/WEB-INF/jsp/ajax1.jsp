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
	<title>开会时间</title>

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
		form {
			padding-top:30px;
		}
	</style>

</head>
  
  <body>
  	
	<div class="container">
	
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				  <h2 class="text-center">小组开会时间建议</h2>
				  <div class="form-group">
				    <label for="groupName">组名</label>
				  	<input type="text" class="form-control" id="groupName" placeholder="Enter group name">
				  </div>
				  <div class="form-group">
				    <label for="leaderName">组长</label>
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
			</div>
			<div class="col-sm-4"></div>
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
			var groupName="#groupName";
			var leaderName="#leaderName";
			var startDate="#startDate";
			var endDate="#endDate";
			var comment="#comment";
			$.ajax({
				url:"test/ajax.do",
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
					alert(responseText);
				},
				error:function(){
					alert("system error");
				}
			});
		});
	});
	

	$('.form_date').datetimepicker({
		format: 'yyyy-mm-dd',
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
