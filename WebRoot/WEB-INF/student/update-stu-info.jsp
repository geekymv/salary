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
			
			margin-top: 450px;
		}
		ul li {
			line-height: 40px;
		}
		ul li input {
			line-height: 20px;
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
				  <a href="student/preUpdatePassword.do" class="list-group-item">修改密码</a> 
				</div>
			</div>
      	</div>
    
      	<div class="col-md-10">
      		 <div class="panel panel-primary">
	          	 <div class="panel-heading">${student.name }的资料</div>
				 <form action="student/update.do" method="post">
		     	 <ul>
		        	<li>
		        		学号：${student.number }
		        		<input type="hidden" name="student.number" value="${student.number}"/>
		        		<input type="hidden" name="student.id" value="${student.id }"/>	
		        		<input type="hidden" name="student.password" value="${student.password }"/>	
		        	</li>
		        	
		        	<li>
		        		姓名：
		        		<input type="text" name="student.name" value="${student.name}"/>
		        	</li>
		        	<li>
		        		性别：
		        		<s:if test='student.gender == "男"'>
		        			<input type="radio" name="student.gender" value="男" checked="checked"/>男
		        			<input type="radio" name="student.gender" value="女"/>女
		        		</s:if>
		        		<s:else>
			   				<input type="radio" name="student.gender" value="男" />男
		        			<input type="radio" name="student.gender" value="女" checked="checked"/>女
		        		</s:else>
		        	</li>
		        	<li>
		        		学院：
		        		<input type="text" class="input" name="student.college" value="${student.college }"/>
		        	</li>
		        	<li>
		        		专业：
		        		<input type="text" class="input" name="student.profession" value="${student.profession }"/>
		        	</li>
		        	
		        	<li>
		        		手机号码：
		        		<input type="text" class="input" name="student.mobile" value="${student.mobile }"/>
		        	</li>
		        	
		        	<li>自我介绍：<br />
		        		<s:if test="student.introduce == null">
		        			<textarea rows="5" cols="40" name="student.introduce">
		        				无！
		        			</textarea>
		        		</s:if>
		        		<s:else>
		        			<textarea rows="2" cols="40" name="student.introduce">
		        				${student.introduce }
		        			</textarea>
		        		</s:else>
		        	</li>	
		        	<li>
		        		注册时间：
		        		<s:date name="student.regTime" format="yyyy-MM-dd" />
		        		<input type="hidden" name="student.regTime" value="${student.regTime }">
		        		</li>
		        </ul>
		        
		        	<input type="submit" value="保存"/>
		        </form>
		        
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
