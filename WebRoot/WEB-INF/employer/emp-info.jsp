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
	<title>首页</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">	
	
	<style type="text/css">
		.custom{
			height:51px;
		}
		
		.footer {
			background-color:  #333;
			width: 100%;
			height: 200px;
			
			margin-top: 400px;
		}
		.col-md-10 ul li {
			line-height: 40px;
		}
	</style>
	
	</head>

<body>
	<div class="container">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		  <div class="container">
			<div class="navbar-header">
			  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 			     
               data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
			  <a class="navbar-brand" href="#">
              	<img alt="首页" src="img/index.png" height="25"/>
              	首页
              </a>
			</div>
    	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
           <ul class="nav navbar-nav">
                <li><a href="#">系统简介</a></li>
                <li><a href="#">关于我们</a></li>
              
                <li role="presentation" class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">
               		 开发人员
                    <span class="caret"></span>
                  </a>
                 
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#">Geek_ymv</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                    <li class="divider"></li>
                    <li><a href="#">One more separated link</a></li>
                  </ul>
                </li>
          </ul>
		  <ul class="nav navbar-nav navbar-right">
	         	<li>
	         		<a href="employer/emp-empInfo.do">用户：${employer.name } <span class="glyphicon glyphicon-user"></span>
	         		</a>
	         	</li>
	           	<li class="divider-vertical"></li>
	           	<li><a href="user/user-logout">退出 <span class="glyphicon glyphicon-log-out"></span></a></li>
	      </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
    <!-- 以上是导航菜单-->
    
    <!--空白处-->
    <div class="custom">
    </div>
      
    <div class="row">
    	<div class="col-md-2">
    		<div class="panel panel-primary">
		        <div class="panel-heading">功能导航</div>
			   	<div class="list-group">
				  <a href="employer/emp-empInfo.do" class="list-group-item">我的资料</a>
				  <a href="#" class="list-group-item">我的招聘</a>
				  <a href="employer/publish.do" class="list-group-item">发布招聘</a>
				  <a href="#" class="list-group-item">发放工资</a>
				</div>
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
