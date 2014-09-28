<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'test.jsp' starting page</title>

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
	<form class="form-horizontal" name="tablegameForm" id="tablegameForm"
		
		action="#" method="post">
		
		<table border="1">
			<tr>
				<td>
					<input type="checkbox" name="bet" id="checkAllChange" />
				</td>
				<td>表头1</td>
				<td>表头2</td>
				<td>表头3</td>
				<td>表头4</td>
			</tr>
			<tr>
				<td>
					<input type="checkbox" name="bet" class="userid" value="00"/>
				</td>
				<td>
					<input type="text" name="minbet1" id="minbet1" value="11">
				</td>
				<td>
					<input type="text" name="dizhu1" id="dizhu1" value="22">
				</td>
				<td>
					18888000
				</td>
				
				<td>
					<input type="text" name="remove1" id="remove1" value="33">
				</td>
			</tr>
			
				<tr>
				<td>
					<input type="checkbox" name="bet" class="userid" value="44"/>
				</td>
				<td>
					<input type="text" name="minbet1" id="minbet2" value="55">
				</td>
				<td>
					<input type="text" name="dizhu1" id="dizhu2" value="66">
				</td>
				<td>
					18888000
				</td>
				
				<td>
					<input type="text" name="remove1" id="remove2" value="77">
				</td>
			</tr>
		</table>
		
			<input type="button" value="提交数据" onclick="submitForm()"/>

		</form>	
		
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>	

<script type="text/javascript">
		function submitForm() {
			var obj = new Array();
			
			obj = document.getElementsByName("bet");
			
			for ( var i = 0; i < obj.length; i++) {
				obj[i] = new Array();
				if (obj[i].checked) {
					obj[i].value = $("#minbet" + i).val() + ","
							+ $("#dizhu" + i).val() + "," + $("#remove" + i).val();
				}
			}
			
			alert(obj[1].value + "--" + obj[2].value);
			
		/*
			$("#tablegameForm").submit();
		*/
		}
</script>
		
</body>
</html>


















