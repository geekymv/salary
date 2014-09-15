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
	
	<style type="text/css">
		.custom{
			height:51px;
		}
		
		.footer {
			background-color:  #333;
			width: 100%;
			height: 200px;
			
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
	
	</head>

<body>
	<div class="container">
    <jsp:include page="nav.jsp"></jsp:include>   
       
    <div class="row">
    	<div class="col-md-2">
    		<div class="panel panel-primary">
		        <div class="panel-heading">功能导航</div>
			   	<div class="list-group">
				  <a href="employer/emp-empInfo.do" class="list-group-item">我的资料</a>
				  <a href="employer/emp-recruitList.do" class="list-group-item">我的招聘</a>
				  <a href="employer/publish.do" class="list-group-item">发布招聘</a>
				  <a href="#" class="list-group-item">发放工资</a>
				</div>
			</div>
      	</div>
    
      	<div class="col-md-10">
      		 <div class="panel panel-primary">
	          <div class="panel-heading">发布招聘信息</div>
	          	<div class="publish">
			     	<form action="employer/emp-publish.do" method="post">
			   		招聘标题:<input type="text" name="recruit.title"/> <br />
			   		岗位名称:<input type="text" name="recruit.postName"/> <br />
			   		招聘人数:<input type="text" name="recruit.postNum"/> <br />
			   		薪资待遇:<input type="text" name="recruit.salary"/> <br />
			   		工作要求：<br/><textarea rows="5" cols="40" name="recruit.context"></textarea><br/>
			   		截止日期:<input type="text" name="recruit.endDate"/> <br />
			   		备注:<input type="text" name="recruit.remarks"/> <br />
			   		
			   		<input type="submit" value="发布">
			   		
			   		</form>
		   		</div>
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
