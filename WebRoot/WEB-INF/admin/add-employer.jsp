<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
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
			height: 165px;
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
			               <p ><a href="admin/admin-listEmployer.do" target="_self">用工单位列表</a></p>
			               <p ><a href="admin/pre-addemployer.do" target="_self">添加用单位</a></p>
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
	          <form action="admin/admin-addEmployer.do" method="post">
			  	
			  	登录账号：<input type="text" id="account" name="employer.account" /> <br/>
			  	登录密码：<input type="password" name="employer.password" /> <br/>
			  	单位名称：<input type="text" name="employer.name" /> <br/>
			  	电话号码：<input type="tel" name="employer.mobile" /> <br/>
			  	负责老师：<input type="text" name="employer.teacher" /> <br/>
			  	岗位数：<input type="number" name="employer.postNum" /> <br/>
			  	月总金额：<input type="text" name="employer.totalMoney" /> <br/>
			  	备注信息：<input type="text" name="employer.remarks" /> <br/>
			  
			    <input type="submit" id="add" value="添加"/>	
	    	</form>
	        </div> <!-- end of panel -->
    	</div>
	</div>
   </div>
   </div><!-- /.container -->
   
   
   <div class="footer">
   <jsp:include page="../main/footer.jsp"></jsp:include>
   </div>



<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
