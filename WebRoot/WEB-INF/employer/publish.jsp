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
	<title>发布招聘信息</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">	
	
	<link rel="stylesheet" href="jquery-ui/jquery-ui.css">
	
	<style type="text/css">
		.custom{
			height:51px;
		}
		
		.footer {
			background-color:  #333;
			width: 100%;
			height: 165px;
			
			margin-top: 300px;
		}
		
		.publish {
			margin-left: 320px;
		}
		
		form input {
			margin: 0 auto;
			margin-top: 10px;
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
		em{
			font-weight: bold;
			margin-left: 1em;
			vertical-align: middle;
			color: red;
		}
	</style>

<script type="text/javascript" src="validation/jquery-1.10.0.js"></script>
<script type="text/javascript" src="validation/jquery.validate.js"></script>
<script type="text/javascript" src="validation/jquery.metadata.js"></script>
<script type="text/javascript" src="validation/messages_zh.js"></script>
	
<script type="text/javascript">
	$(function() {
		$("#commentForm").validate();
	});

</script>

	
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
			<%--
			<li>Saarland</li>
			<li>Salzburg
				<ul>
					<li>Delphi
						<ul>
							<li>Ada</li>
							<li>Saarland</li>
							<li>Salzburg</li>
						</ul>
					</li>
					<li>Delphi
						<ul>
							<li>Ada</li>
							<li>Saarland</li>
							<li>Salzburg</li>
						</ul>
					</li>
					<li>Perch</li>
				</ul>
			</li>
			 --%>
		</ul>
		</div>	
			
			
      	</div>
    
      	<div class="col-md-10">
      		 <div class="panel panel-primary">
	          <div class="panel-heading">发布招聘信息</div>
	          	<div class="publish">
			     	<form action="employer/emp-publish.do" id="commentForm" method="post">
			   		招聘标题:<input type="text" id="title" name="recruit.title" class="required"/><em>*</em> <br />
			   		岗位名称:<input type="text" name="recruit.postName"/><em>*</em> <br />
			   		招聘人数:<input type="text" name="recruit.postNum"/><em>*</em> <br />
			   		薪资待遇:<input type="text" name="recruit.salary"/><em>*</em> <br />
			   		工作要求：<br/><textarea id="context" rows="5" cols="40" name="recruit.context"></textarea><em>*</em><br/>
			   		截止日期:<input type="text" id="datepicker" name="recruit.endDate"/><em>*</em> <br />
			   		备注:<input type="text" name="recruit.remarks"/><em>&nbsp;</em> <br />
			   		
			   		<input type="submit" value="发布">
			   		
			   		</form>
		   		</div>
		     </div>
    	</div>
      
	</div>
    
   </div><!-- /.container -->
   
   
   <div class="footer">
   <jsp:include page="../main/footer.jsp"></jsp:include>
   </div>


<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript" src="jquery-ui/jquery-ui.min.js"></script>
<script type="text/javascript">
	$(function() {
		$( "#datepicker" ).datepicker({
			dateFormat:"yy-mm-dd",		
		});
	});
	
</script>
<script src="jquery-ui/external/jquery/jquery.js"></script>
<script src="jquery-ui/jquery-ui.js"></script>
<script>
	$(function() {
		$("#menu").menu();
	});
</script>

</body>
</html>
