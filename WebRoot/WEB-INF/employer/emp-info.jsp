<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="zh-CN">
	<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<title>我的资料</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">	
	
	<style type="text/css">
		.custom{
			height:51px;
		}
		
		.footer {
			background-color:  #333;
			width: 100%;
			height: 165px;
			
			margin-top: 400px;
		}
		.col-md-10 ul li {
			line-height: 40px;
		}
	</style>
	
	<link rel="stylesheet" type="text/css" href="jquery-ui/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="jquery-ui/jquery-ui.theme.css">
	<style>
		.ui-menu {
			width: 162px;
		}
		
		#menu li {
			line-height: 35px;
		}
	</style>
	
	</head>

<body>
	<div class="container">
	<jsp:include page="nav.jsp"></jsp:include>
      
    <div class="row">
    	<div class="col-md-2">
    		
			<div class="panel panel-primary">	 
			<div class="panel-heading">功能导航</div>
			<ul id="menu">
				<!-- 
				<li class="ui-state-disabled">不能使用</li>
				 -->
				<li><a href="employer/emp-empInfo.do">个人资料</a></li>
				<li>招聘管理
					<ul>
						<li><a href="employer/emp-recruitList.do">查看招聘</a></li>
						<li><a href="employer/publish.do">发布招聘</a></li>
					</ul>
				</li>
				<li>学生管理
					<ul>
						<li>添加学生</li>
						<li>删除学生</li>
					</ul>
				</li>
				<li>工资管理
					<ul>
						<!-- 
						<li class="ui-state-disabled">不能使用</li>
						 -->
						<li><a href="employer/emp-stuList.do">发放工资</a></li>
						<li><a href="employer/salary-list.do">修改工资</a></li>
					</ul>
				</li>
			</ul>
			</div>	
			
			
      	</div>
    
      	<div class="col-md-10">
      		 <div class="panel panel-primary">
	          <div class="panel-heading">我的资料
	          </div>
	     	  <ul>
	        	<li>账号：${employer.account}</li>
	        	<li>名称：${employer.name }</li>
	        	<li>电话号码：${employer.mobile }</li>
	        	<li>总岗位数：${employer.postNum }</li>
	        	<li>月总金额：${employer.totalMoney }</li>
	        	<li>备注：${employer.remarks }</li>
	         </ul>	
		     </div>
    	</div>
      
	</div>
    
   </div><!-- /.container -->
   
   
   <div class="footer">
   <jsp:include page="../main/footer.jsp"></jsp:include>
   </div>


<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="jquery-ui/external/jquery/jquery.js"></script>
<script src="jquery-ui/jquery-ui.js"></script>
<script>
	$(function() {
		$("#menu").menu();
	});
</script>
</body>
</html>
