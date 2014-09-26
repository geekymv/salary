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
		.footer {
			background-color:  #333;
			width: 100%;
			height: 200px;
			margin-top: 450px;
		}
	
	</style>
	
	<link href="css/zzsc.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script src="js/showlist.js" type="text/javascript"></script>
	</head>

<body>
	<div class="container">
		<jsp:include page="nav.jsp"></jsp:include>
		
		<div class="row">
    	<div class="col-md-2">
    		<div class="panel panel-primary">
    		  <div class="panel-heading">功能导航</div>	
			    <div class="left-sider">
			      <div class="operate">
			        <ul id="J_navlist">
			          <li>
			            <h4 >个人资料</h4>
			            <div class="list-item none">
			              <p ><a href="http://sc.chinaz.com/" target="_self">下载游戏</a></p>
			            </div>
			          </li>
			          <li >
			            <h4 >注册登录</h4>
			            <div class="list-item none">
			              <p ><a href="http://sc.chinaz.com/" target="_self">帐号问题</a></p>
			            </div>
			          </li>
			          <li >
			            <h4 >游戏充值</h4>
			            <div class="list-item none">
			              <p ><a href="http://sc.chinaz.com/" target="_self">游戏卡充值</a></p>
			              <p ><a href="http://sc.chinaz.com/" target="_self">第三方充值</a></p>
			            </div>
			          </li>
			          <li >
			            <h4 >用户管理</h4>
			            <div class="list-item none">
			              <p ><a href="http://sc.chinaz.com/" target="_self">添加二级用户</a></p>
			            </div>
			          </li>
			          <li >
			            <h4 >工资管理</h4>
			            <div class="list-item none">
			              <p ><a href="http://sc.chinaz.com/" target="_self">下载工资表</a></p>
			              <!-- 
			              <p ><a href="http://sc.chinaz.com/" target="_self">下载。。。</a></p>
			            -->
			            </div>
			          </li>
			          
			        </ul>
			        <script type="text/javascript">
						navList(1);
					</script>
			      </div>
			    </div>

			</div>

      	</div>
    
    
    	
      	<div class="col-md-10">
	        <div class="panel panel-primary">
	          <div class="panel-heading">招聘信息</div>
	          <div class="panel-body">
	            <p>添加二级用户！admin</p>
	          </div>
	          <div class="form">
	          <form action="admin/machine-save" method="post">
			  	<%--
			  	设备编号：<input type="text" name="machine.num" /> <br/>
			  	设备名称：<input type="text" name="machine.name" /> <br/>
			  	使用年限：<input type="text" name="machine.useYear" /> <br/>
			  	生产日期：<input type="text" name="machine.proDate" /> <br/>
			  	供应商：<input type="text" name="machine.suppliper" /> <br/>
			  	功能简介：<input type="text" name="machine.function" /> <br/>
			  	
			  	设备类型：<s:select list="#request.machineTypes"
					name="machine.type.id"
					listKey="id" listValue="name">
					
					</s:select>	
			  	<br />
			  	  --%>
			    <input type="submit" id="add" value="添加"/>	
	    	</form>
	        </div> <!-- end of panel -->
    	</div>
	</div>
   </div>
   </div><!-- /.container -->
   
   
   <div class="footer">
   
   </div>



<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
