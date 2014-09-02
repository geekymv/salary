<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=0.95, user-scalable=no" />
<title>系统首页</title>

<link rel="stylesheet" type="text/css" href="template/ue-content/templates/images/ue_grid.css" />
<link rel="stylesheet" type="text/css" href="template/ue-content/templates/images/style.css" />
<link rel="stylesheet" type="text/css" href="template/ue-content/templates/css/style.css" />

<script src="js/jquery-1.11.1.js" type="text/javascript"></script>

<script type="text/javascript" src="script/jquery.easing.min.js"></script>
<script type="text/javascript" src="script/custom.js"></script>



</head>
<body style="padding-top:90px">
<div id="header">
  <div class="common"> 
    <div class="login fr">
      <div class="loginmenu"><a title="登录或注册"></a></div>
      <ul>
        <li class="openlogin"><a href="login" onclick="return false;">登录</a>&nbsp;&nbsp;</li>
        <li class="reg"><a href="register.jsp" >注册</a></li>
        
        <%--
        onClick="window.location.href='register.jsp'"
        --%>
      </ul>
    </div>   
    <div class="clear"></div>
  </div>
</div>
<div class="clear"></div>
<div class="loginmask"></div>
<div id="loginalert">
  <div class="pd20 loginpd">
  	<!-- 关闭登录框--> 
    <h3>
    	<i class="closealert fr"></i>
    </h3>
     
    <div class="loginwrap">
      <div class="loginh">
        <div class="fl">用户登录</div>
        <div class="fr">还没有账号<a id="sigup_now" href="register.jsp" >立即注册</a></div>
        <div class="clear"></div>
      </div>
	  <div class="clear"></div>

      <form action="user/user-login.do" method="post" id="login_form">
        <div class="logininput">
          <input type="text" name="account" class="loginusername" placeholder="用户名"/>
          <input type="password" name="password" class="loginuserpasswordt" placeholder="密码" />
          
          <input type="radio" name="identity" value="employer">部门
          <input type="radio" name="identity" value="student">学生
          
        </div>
        <div class="loginbtn">
          <div class="loginsubmit fl">
            <input type="submit" value="登录" />
            <div class="loginsubmiting">
              <div class="loginsubmiting_inner"></div>
            </div>
          </div>
          <div class="logcheckbox fl">
            <input id="bcdl" type="checkbox" checked="checked" />
          	  记住我一周
		  </div>
          <div class="fr"><a href="#">忘记密码?</a></div>
          <div class="clear"></div>
        </div>
      </form>

    </div>
  </div>

</div>
 
<div style="text-align:center;clear:both">
	<p>首页</p>
</div>

</body>
</html>

