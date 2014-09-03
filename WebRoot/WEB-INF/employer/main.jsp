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
	          
	           	<li><a href="login.jsp">用户：${sessionScope.student.name } <span class="glyphicon glyphicon-user"></span></a></li>
	            
	           	<li class="divider-vertical"></li>
	           	<li><a href="login.jsp">退出 <span class="glyphicon glyphicon-log-out"></span></a></li>
	      </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
    <!-- 以上是导航菜单-->
    
    <!--空白处-->
    <div class="custom">
    
    </div>
    
     
      
    <div class="row">
    
    	<div class="col-md-3">
	      	<pre>左边</pre>
	      	<img src="img/hello.jpg" alt="这是一张图片" title="这是一张图片吗" class="img-thumbnail">
	
	        <div class="btn-group">
			  <button type="button" class="btn btn-success">Action</button>
			  <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
			    <span class="caret"></span>
			    <span class="sr-only">Toggle Dropdown</span>
			  </button>
			  <ul class="dropdown-menu" role="menu">
			    <li><a href="#">Action</a></li>
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Something else here</a></li>
			    <li class="divider"></li>
			    <li><a href="#">Separated link</a></li>
			  </ul>
			</div>
      	</div>
    
    
    	
      	<div class="col-md-9">
	        <div class="panel panel-primary">
	          <div class="panel-heading">招聘信息</div>
	          <div class="panel-body">
	            <p>招聘啦！employer：<a href="emp.action">发布招聘信息</a></p>
	          </div>
	        
	          <!-- Table -->
	          <table class="table table-bordered table-hover table-condensed">
	            <thead>
	            	
	                <tr>
	                   	<th>招聘信息标题</th> <th>发布单位</th> <th>发布时间</th>
			  			<th>岗位名称</th><th>截止日期</th>  <th>查看</th>
	                </tr>
	            </thead>
	            <tbody>
	            
            	 	<tr>
                   		<td>招聘信息标题</td> <td>发布单位</td> <td>发布时间</td>
		  				<td>岗位名称</td><td>截止日期</td>  <td>备注</td>
                 	</tr>
                 	<tr>
                   		<td>招聘信息标题</td> <td>发布单位</td> <td>发布时间</td>
		  				<td>岗位名称</td><td>截止日期</td>  <td>备注</td>
                 	</tr>
                 	<tr>
                   		<td>招聘信息标题</td> <td>发布单位</td> <td>发布时间</td>
		  				<td>岗位名称</td><td>截止日期</td>  <td>备注</td>
                 	</tr>
	            <!-- 
	            	<s:if test="#request.pageUtil == null || #request.pageUtil.datas.size() == 0">
	            		没有设备信息！
	            	</s:if>
	            	<s:else>
	            		<s:iterator value="#request.pageUtil.datas">
					  		<tr>
					  			<td>${num }</td>
					  			<td><s:property value="name"/></td>
					  			<td><s:property value="useYear"/></td>
					  			
					  			<td>
					  				<s:date name="proDate" format="yyyy-MM-dd"/>
					  			</td>
					  			<td>
					  				<s:date name="useDate" format="yyyy-MM-dd"/>
					  			</td>
					  			<%--
					  			<td><s:property value="#m.useDate"/></td>
					  			 --%>
					  			<td><s:property value="suppliper"/></td>
					  			<td><s:property value="type.name"/></td>
					  			
					  			<%--设备状态 --%>
					  			<s:if test="status == false">
					  				<td>未使用</td>
					  			</s:if>
					  			<s:else>
					  				<td>已使用</td>
					  			</s:else>
	
					  			<td><s:property value="function"/></td>
					  			
					  			<td>
					  				<a href="machine/machine!edit.do?id=${id }">修改</a>|
					  				<a href="machine/machine!delete.do?id=${id }">删除</a>
					  			</td>
					  			
					  		</tr>
		  				</s:iterator>
	            	</s:else>
	              
	            </tbody>
	            -->
	          </table>
	          <!-- 
	            <div class="panel-footer">
	          	 <ul class="pager">
	
	          	 	<li>当前页 ：<s:property value="pageNO"/>&nbsp;&nbsp;</li>
	          	 	<li>总页数：<s:property value="#request.pageUtil.totalPage"/></li>
	          	 	
	          	 	<s:if test="pageNO-1 > 0">
	          	 		<li><a href="machine/machine!list.do?pageNO=<s:property value=" pageNO-1 "/>" >上一页</a></li>
	          	 	</s:if>
			
					<s:set var="totalPage" value="#request.pageUtil.totalPage"></s:set>
					<%-- totalPage: <s:property value="#totalPage"/>--%>
					<%--
	          	 	<s:if test="pageNO+1 <= #totalPage">
				  		<li><a href="machine/machine!list.do?pageNO=<s:property value=" pageNO+1 "/>" >下一页</a></li>
	          	 	</s:if>
	          	 	--%>
				</ul>
	          </div>
	         -->
	         
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
