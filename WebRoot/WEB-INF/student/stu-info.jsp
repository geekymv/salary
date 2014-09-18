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
			height: 200px;
			
			margin-top: 450px;
		}
		ul li {
			line-height: 40px;
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
			   	<div class="list-group">
				  <a href="student/stu-stuInfo.do" class="list-group-item">我的资料</a>
				  <a href="student/stu-approveJob.do" class="list-group-item">我的工作</a>
				  <a href="student/stu-listJob.do" class="list-group-item">报名记录</a>
				  <a href="student/stu-listRecruit.do" class="list-group-item">查看招聘</a>
				</div>
			</div>
      	</div>
    
      	<div class="col-md-10">
      		 <div class="panel panel-primary">
	          <div class="panel-heading">${student.name }的资料</div>
		     	 <ul>
		        	<li>学号：${student.number}</li>
		        	<li>姓名：${student.name }</li>
		        	<li>性别：${student.gender }</li>
		        	<li>学院：${student.college }</li>
		        	<li>专业：${student.profession }</li>
		        	<li>手机号码：${student.mobile }</li>
		        	<li>自我介绍：
		        		<s:if test="student.introduce == null">
		        			无！
		        		</s:if>
		        		<s:else>
				        	${student.introduce }
		        		</s:else>
		        	</li>	
		        	<li>注册时间：<s:date name="student.regTime" format="yyyy-MM-dd" /></li>
		        </ul>	
		     </div>
    	</div>
      
	</div>
    
   </div><!-- /.container -->
   
   
   <div class="footer">
   
   </div>


<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
