<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" pageEncoding="utf-8" %>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:x="http://java.sun.com/jstl/xml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
<title>内容列表页面</title>
<link href="<%=basePath%>resources/css/all.css" rel="stylesheet"
	type="text/css" />
<script src="<%=basePath%>resources/js/common/jquery-1.8.0.min.js"></script>
<script src="<%=basePath%>resources/js/back/list.js"></script>
</head>
<body style="background: #e1e9eb;">

	<form action="<%=basePath%>InsertOneServlet.action" id="mainForm" method="post">
		<%--使用EL表达式取出存储在session中的token--%>
    	<input type="hidden" name="token" value="${token}"/> 
	
		<div class="right">
			<div class="current">
				当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a>
				&gt; 内容列表
			</div>
			<div class="rightCont">
				<p class="g_title fix">内容列表</p>
				<table class="tab1">
					<tbody>
						<tr>
							<td width="90" align="right">指令名称：</td>
							<td><input type="text" name="command" class="allInput"
								value="" /></td>
						</tr>
						<tr>
							<td width="90" align="right">描述：</td>
							<td><input type="text" name="description" class="allInput"
								value="" /></td>
						</tr>
						<tr>
							<td width="90" align="right">内容：</td>
							<td><textarea rows="8" cols="35" name="content" class="textareaII"></textarea>
							</td>
						</tr>
						<tr>
							<td width="85" align="right"><input type="submit" class="tabSub" value="保 存" /></td>
							<td width="85" align="right"><input type="reset" class="tabSub" value="取 消" onclick="javascript:history.go(-1);"/></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
</body>
</html>