<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <!-- 
       nitial-scale=1.0 确保网页加载时，以 1:1 的比例呈现，不会有任何的缩放。
       在移动设备浏览器上，通过为 viewport meta 标签添加 user-scalable=no 可以禁用其缩放（zooming）功能。 
       通常情况下，maximum-scale=1.0 与 user-scalable=no 一起使用。这样禁用缩放功能后，用户只能滚动屏幕，就能让您的网站看上去更像原生应用的感觉。
   -->
   <meta name="viewport" content="width=device-width, 
                                  initial-scale=1.0, 
                                  maximum-scale=1.0, 
                                  user-scalable=no">
   <title>欢迎来到 LongXia 吧</title>
   
   <!--  
   	   <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	   <style type="text/css">
	   </style>
	   <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	   <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   -->
   
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">  
   <style type="text/css">
   </style>
   <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
   <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
   <script type="text/javascript">
   		//启动函数
   		$(function(){
   			//$(".nav-tabs li:first").addClass("active");	//默认让一级分类的第一项选中
   			$(".nav-tabs a:first").click();	
   		});
   		//一键换肤函数
   		var i = 133;
   		function changebackground(){
   			$("body").css({"background-image":"url('https://ss0.bdstatic.com/k4oZeXSm1A5BphGlnYG/skin/"+i+".jpg?2","background-size": "100% 100%"});
   			i++;
   		}
   		function showBar(ctNum){
   			var barHtml =  
   						+  "<c:forEach items='${allBar }' var='ab' varStatus='vs'>"
						+		"<c:if test='${vs.current.barCategorTwo.id==1}'>"
						+			"<h4>${ab.name }</h4>"
						+		"</c:if>"
						+  "</c:forEach>";
			$("#showBarArea").html(barHtml);
			
   		}
   </script>
</head>
<body  style="background-color:rgb(64, 64, 64);background-image:url('https://ss0.bdstatic.com/k4oZeXSm1A5BphGlnYG/skin/70.jpg?2'); background-size: '100% 100%';background-repeat:no-repeat;background-attachment:fixed;">
  <!-- 由于内边距（padding）是固定宽度，默认情况下容器是不可嵌套的。 -->
  <div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">LongXia</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							 <a href="#">Link</a>
						</li>
						<li>
							 <a href="#">Link</a>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="#">Action</a>
								</li>
								<li>
									 <a href="#">Another action</a>
								</li>
								<li>
									 <a href="#">Something else here</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="#">Separated link</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="#">One more separated link</a>
								</li>
							</ul>
						</li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" />
						</div> <button type="submit" class="btn btn-default btn-success">进入贴吧</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<c:choose>
							<c:when test="${sessionScope.currentUser==null }">
								<li>
								 	<a href="${pageContext.request.contextPath }/login">登录</a>
								</li>
								<li>
								 	<a href="${pageContext.request.contextPath }/registry">注册</a>
								</li>
							</c:when>
							<c:otherwise>
								<li>
								 	<a href="#">
								 		<img src="${pageContext.request.contextPath }/image/head.jpg" style="height: 23px;width: 23px;padding: 0px;" class="img-responsive img-circle"  alt="响应式图像">
								 	</a>
								</li>
								<li>
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">${currentUser.nickname}</a>
									<ul class="dropdown-menu">
										<li><a href="#">个人信息</a></li>
										<li><a href="#">积分商城</a></li>
										<li><a href="#">粉丝</a></li>
										<li class="divider"></li>
										<li><a href="javascript:void(0)" onclick="exit()">退出</a></li>
									</ul>
								</li>
							</c:otherwise>
						</c:choose>
						<li>
							<a href="javascript:void(0)" onclick="changebackground()">一键换肤</a>
						</li>
					</ul>
				</div>
				
			</nav>
		</div>
	</div>
</div>