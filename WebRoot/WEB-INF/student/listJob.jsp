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
	<title>学生首页</title>
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
	           	<li><a href="stu-info.jsp">用户：${student.name } <span class="glyphicon glyphicon-user"></span></a></li>
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
				  <a href="student/stu-stuInfo.do" class="list-group-item">我的资料</a>
				  <a href="#" class="list-group-item">我的工作</a>
				  <a href="student/stu-listJob.do" class="list-group-item">报名记录</a>
				  <a href="student/stu-listRecruit.do" class="list-group-item">查看招聘</a>
				</div>
			</div>
      	</div>
    
      	<div class="col-md-10">
	        <div class="panel panel-primary">
	          <div class="panel-heading">我的报名记录</div>
	        
		      <s:if test="#request.recruits == null || #request.recruits.size() == 0">
	            		没有报名信息！
	          </s:if>	
	        
	          <s:else>
	          <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	                <tr>
	                   	<th>招聘信息标题</th> <th>岗位名称</th> <th>发布单位</th>
			  			<th>发布时间</th> <th>截止日期</th>  <th>是否通过</th>
	                </tr>
	            </thead>
	            <tbody>
            		<s:iterator value="#request.recruits">
            			<tr>
	            			<td><a href="student/stu-details.do?id=${id }">${title }</a></td> 
	            			<td>${postName }</td> 
	            			<td>${employer.name }</td>
	            			<td><s:date name="releaseDate" format="yyyy-MM-dd"/></td>
		  					<td><s:date name="endDate" format="yyyy-MM-dd"/></td>
		  					<td>
		  						 待审核
		  					</td>
            			</tr>
            		</s:iterator>
	            	
	            </tbody>
	          
	          </table>

	         </s:else>
	         
	         
	        </div> <!-- end of panel -->
	      
    	</div>
      
	</div>
    
   </div><!-- /.container -->
   
   
   <div class="footer">
   
   </div>


<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
