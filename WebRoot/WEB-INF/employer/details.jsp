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
			height: 165px;
			
			margin-top: 450px;
		}
		ul li {
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
    		<%--
	   	  	<div class="panel panel-primary">
		        <div class="panel-heading">功能导航</div>
			   	<div class="list-group">
				  <a href="employer/emp-empInfo.do" class="list-group-item">我的资料</a>
				  <a href="employer/emp-recruitList.do" class="list-group-item">我的招聘</a>
				  <a href="employer/publish.do" class="list-group-item">发布招聘</a>
				  <a href="employer/emp-stuList.do" class="list-group-item">发放工资</a>
				</div>
			</div>
			 --%>
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
	        </s:else>
	        </div> <!-- end of panel -->
	      
	      <!-- 报名学生-->
	      <div class="panel panel-primary">
	          <div class="panel-heading">报名情况</div>
	        
	        <s:if test="#request.recruitStudents == null || #request.recruitStudents.size() == 0">
	            	暂无学生报名！
	        </s:if>
	        <s:else>
	         	<input type="hidden" id="rId" value="${recruit.id}"/>
	         	
	         	<table class="table table-bordered table-hover table-condensed">
	         		<caption>学生信息</caption>
	         		<tr>
						<td>学号</td> <td>姓名</td> <td>专业</td> <td>手机号码</td> <td>操作</td>
	         		</tr>
	         		
	         		<s:iterator value="#request.recruitStudents">
	         		<tr>
						<td>${student.number }</td>	         		
						<td>${student.name }</td>	         		
	         			<td>${student.profession }</td>
	         			<td>${student.mobile }</td>
	         			<td>
	         				<s:if test="status == 0">
	         					<span style="color:red">等待处理</span>
	         						<input type="hidden" id="stuId" name="stuId" value="${student.id }">
	         						<input type="hidden" name="recId" value="${recruit.id }">
	         						<button id="pass" onclick="pass(1)">通过</button>
	         						<button id="notpass" onclick="notpass(-1)">不通过</button>
	         				</s:if>
	         				<s:elseif test="status == 1">
	         					<span style="color:red">已通过</span>
	         				</s:elseif>
	         				<s:else>
	         					<span style="color:red">未通过</span>
	         				</s:else>
	         			</td>	         		
	         		</tr>
	         		</s:iterator>
					
					
	         	</table>
	         		
	        </s:else>
	        </div> <!-- end of panel -->
	      
    	</div>
      
	</div>
    
   </div><!-- /.container -->
   
   
   <div class="footer">
   <jsp:include page="../main/footer.jsp"></jsp:include>
   </div>


<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function pass(num){
		$.post("<%=request.getContextPath()%>/employer/examineStudent.do", 
				{"id": $("#rId").val(), "examine":num,"stuId":$("#stuId").val()}, 
				function(data){
			
			window.location.reload();	//刷新当前页面
		});
	}
	
	function notpass(num){
		$.post("<%=request.getContextPath()%>/employer/examineStudent.do", 
				{"id": $("#rId").val(), "examine":num,"stuId":$("#stuId").val()}, 
				function(data){
			
			window.location.reload();	//刷新当前页面
		});
	}

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


















