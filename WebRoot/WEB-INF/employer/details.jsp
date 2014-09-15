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
	<title>XXX系统</title>
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
		span {
			font-weight: bold;
		}
	</style>
	
	</head>

<body>
	<div class="container">

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		  <div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
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

    <!-- Collect the nav links, forms, and other content for toggling -->
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
	           	<li><a href="employer/emp-empInfo.do">用户：${employer.name } <span class="glyphicon glyphicon-user"></span></a></li>
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
				  <a href="employer/emp-recruitList.do" class="list-group-item">我的招聘</a>
				  <a href="employer/publish.do" class="list-group-item">发布招聘</a>
				  <a href="employer/emp-stuList.do" class="list-group-item">发放工资</a>
				</div>
			</div>
      	</div>
    
    
    	
      	<div class="col-md-10">
	        <div class="panel panel-primary">
	          <div class="panel-heading">招聘信息详情</div>
	          <div class="panel-body">
	            <p>招聘啦！</p>
	          </div>
	        
	        <s:if test="#request.recruit == null">
	            	没有招聘信息！
	        </s:if>
	        <s:else>
	         	<input type="hidden" id="rId" value="${recruit.id}"/>
	         	
	         	<table class="table table-bordered table-hover table-condensed">
	         		<caption>招聘信息</caption>
	         		<tr>
	         			<td><span>招聘信息标题：</span>${recruit.title }</td>
	         			<td><span>发布单位：</span>${recruit.employer.name }</td>
	         		</tr>
	         		<tr>
	         			<td><span>岗位名称：</span>${recruit.postName }</td>
	         			<td><span>薪资待遇：</span>${recruit.salary }</td>
	         		</tr>
	         		<tr>
	         			<td><span>招聘人数：</span>${recruit.postNum }</td>
	         			<td><span>已报名人数：</span>${recruit.applyNum }</td>
	         		</tr>
	         		<tr>
	         			<td colspan="2">
		         			<span>工作要求：</span>
			        		<s:if test="recruit.context  == null">
			        			暂无
			        		</s:if>
			        		<s:else>
			        			${recruit.context }
			        		</s:else>
	         			</td>
	         		</tr>
					
					<tr>
						<td><span>发布时间：</span><s:date name="recruit.releaseDate" format="yyyy-MM-dd"/></td>
						<td><span>截止时间：</span>${recruit.endDate }</td>
					</tr>
					
					<tr>
						<td><span>备注：</span>${recruit.remarks }</td>
					</tr>
	         	</table>
				<button id="showStudents">查看已报名学生</button>

	        </s:else>
	        
	        
	        <div id="students"></div>
	         
	        </div> <!-- end of panel -->
	      
    	</div>
      
	</div>
    
   </div><!-- /.container -->
   
   
   <div class="footer">
   
   </div>


<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$("#showStudents").button().on("click", function() {
		$.post("<%=request.getContextPath()%>/employer/queryStudents.do", {"id": $("#rId").val()}, function(data){
		
		$("#students").empty();
		if(data.students == null || data.students.length == 0){
			alert("还没有学生报名！");
			return;
		}
		
		var html = "<table class='table table-bordered table-hover table-condensed'>"
			 + "<caption>学生信息</caption>"
			 + "<tr>"
			 + "<th>学号</th> <th>姓名</th> <th>专业</th>"
			 + "</tr>";
			 
			for(var i = 0; i < data.students.length; i++){
				var student = data.students[i];
				html += "<tr>"
					 + "<td align='center'>"+student.number+"</td>"+ "<td>"+student.name+"</td>"
					 + "<td>"+student.profession+"</td>" 
					 + "</tr>";
			}
				html += "</table>";

			$("#students").append(html);
			
		});
	});

</script>



</body>
</html>






















