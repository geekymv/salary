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
	<title></title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">	
	
	<style type="text/css">
	
		#foot {
			font-style: normal;
			font-size: large;
			padding-top: 70px;
			text-align: center;
		}
	
	</style>
	
	</head>
<body>
	<div id="foot">
		<small style="color:white">
			Copyright &copy; 2014  安徽农业大学嘿客科技传媒 All Rights Reserved
		</small>
	</div>
		
</body>
</html>
