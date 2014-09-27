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
	<title>我的工作</title>
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
	          <div class="panel-heading">我的工作</div>
	        
		      <s:if test="#request.recruitStudents == null || #request.recruitStudents.size() == 0">
	            		暂无工作！快去报名吧...
	          </s:if>	
	        
	          <s:else>
	          <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	                <tr>
	                   	<th>岗位名称</th> <th>所在单位</th> <th>报名时间</th> <td>月薪</td>
	                </tr>
	            </thead>
	            <tbody>
            		<s:iterator value="#request.recruitStudents">
           				<tr>
	            			<td>${recruit.postName }</td> 
	            			<td>${recruit.employer.name }</td>
	            			<td><s:date name="applyDate" format="yyyy-MM-dd"/></td>
            				<td>${recruit.salary }</td>
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
