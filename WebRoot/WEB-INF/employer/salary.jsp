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
	<title>发放工资</title>
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
	          <div class="panel-heading">招聘信息</div>
	          <div class="panel-body">
	            <p>发工资啦！</p>
	          </div>
	        
	           <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	                <tr>
	                   	<th>选择</th> <th>学号</th> <th>姓名</th> <th>基本工资</th> <th>工具费</th> <th>奖金</th> <th>备注</th>  
	                </tr>
	            </thead>
	            <tbody>
	            	<s:if test="#request.students == null || #request.students.size() == 0">
	            		没有学生信息！
	            	</s:if>
	            	<s:else>
            		<form action="employer/payoff.do" method="post">
	            		<s:iterator value="#request.students">
	            			<tr>
	            				<td>
	            					<input type="checkbox" name="ids" id="select"
	            						value="${id }&&${sessionScope.employer.id } "/>
	            				</td>
		            			<td>
		            				${number }
		            			</td> 
		            			<td>${name }</td> 
		            			<td>
		            				<input type="text" name="salarys" value="0"/>
		            			</td>
		            			<td>
		            				<input type="text" name="toolfees" value="0">
		            			</td>
		            			<td>
		            				<input type="text" name="bonus" value="0">
		            			</td>
		            			<td>
		            				<input type="text" name="remarks" value="无" >
		            			</td>
	            			</tr>
	            		</s:iterator>
            			月份：<select name="month">
								<%
									for(int i = 1; i <= 12; i++){
									%>
									<option value="<%=i %>">
										<%=i %>
									</option>			
									<%	
									}
								 %>
            				</select>
            				&nbsp;&nbsp;
            			<input type="submit" value="提交"/>
            		
            		</form>
	            	</s:else>
	            </tbody>
	          </table>

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
