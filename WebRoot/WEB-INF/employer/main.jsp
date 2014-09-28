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
	<title>我的招聘</title>
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
					<li>删除学生</li>
					<li class="ui-state-disabled">添加学生</li>
				</ul>
			</li>
			<li>工资管理
				<ul>
					<!-- 
					<li class="ui-state-disabled">不能使用</li>
					 -->
					<li><a href="employer/emp-stuList.do">发放工资</a></li>
					<li><a href="employer/salary-list.do">工资列表</a></li>
					<li><a href="employer/salary-list.do">下载工资表</a></li>
				</ul>
			</li>
		</ul>
		</div>	
			
      	</div>
    
    
    	
      	<div class="col-md-10">
	        <div class="panel panel-primary">
	          <div class="panel-heading">招聘信息</div>
	          <div class="panel-body">
	            <p>招聘啦！employer！！！</p>
	          </div>
	        
	           <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	                <tr>
	                   	<th>招聘信息标题</th> <th>岗位名称</th> <th>发布单位</th>
			  			<th>发布时间</th> <th>截止日期</th>  <th>查看详情</th>
	                </tr>
	            </thead>
	            <tbody>
	            	
	            	<s:if test="#request.pageUtil == null || #request.pageUtil.datas.size() == 0">
	            		没有招聘信息！
	            	</s:if>
	            	<s:else>
	            		<s:iterator value="#request.pageUtil.datas">
	            			<tr>
		            			<td>${title }</td> 
		            			<td>${postName }</td> 
		            			<td>${employer.name }</td>
		            			<td><s:date name="releaseDate" format="yyyy-MM-dd"/></td>
			  					<td><s:date name="endDate" format="yyyy-MM-dd"/></td>
			  					<td><a href="employer/emp-details.do?id=${id }">查看</a></td>
	            			</tr>
	            		</s:iterator>
	            	
	            	</s:else>
	            </tbody>
	          
	          </table>
	            <div class="panel-footer">
	          	 <ul class="pager">
	
	          	 	<li>当前页 ：<s:property value="page"/>&nbsp;&nbsp;</li>
	          	 	<li>总页数：<s:property value="#request.pageUtil.totalPage"/></li>
	          	 	
	          	 	<s:if test="page-1 > 0">
	          	 		<li><a href="employer/emp-recruitList.do?page=<s:property value=" page-1 "/>" >上一页</a></li>
	          	 	</s:if>
			
					<s:set var="totalPage" value="#request.pageUtil.totalPage"></s:set>
					<%-- totalPage: <s:property value="#totalPage"/>--%>

	          	 	<s:if test="page+1 <= #totalPage">
				  		<li><a href="employer/emp-recruitList.do?page=<s:property value=" page+1 "/>" >下一页</a></li>
	          	 	</s:if>

				</ul>
	          </div>
	         
	         
	        </div> <!-- end of panel -->
	      
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
