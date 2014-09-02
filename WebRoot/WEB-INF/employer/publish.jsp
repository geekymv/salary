<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发布招聘信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   		<form action="employer/emp-publish.action" method="post">
   		
   		招聘标题:<input type="text" name="recruit.title"/> <br />
   		岗位名称:<input type="text" name="recruit.postName"/> <br />
   		招聘人数:<input type="text" name="recruit.postNum"/> <br />
   		薪资待遇:<input type="text" name="recruit.salary"/> <br />
   		截止日期:<input type="text" name="recruit.endDate"/> <br />
   		备注:<input type="text" name="recruit.remarks"/> <br />
   		
   		<input type="submit" value="发布">
   		
   		</form>
  </body>
</html>






















