<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 嵌入头部公用页面 -->
<jsp:include page="../shared/header.jsp"/>

<div class="container" style="margin-top: 150px;opacity:0.9;">
	
	<div class="row clearfix">
		<div class="col-md-6 column">
			<div class="jumbotron">
				<h2>欢迎登陆LongXiaBar!!!</h2><br/>
				<form id="loginAreaForm" class="form-horizontal" role="form">
					<div class="form-group  form-group-lg">
						<label for="inputUserName" class="col-sm-3 control-label">用户名</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="inputUserName" />
						</div>
					</div>
					<div class="form-group form-group-lg">
						<label for="inputPassword" class="col-sm-3 control-label">密&nbsp;&nbsp;&nbsp; 码</label>
						<div class="col-sm-9" style="">
							<input type="password" class="form-control" id="inputPassword" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-12 column">
							 <button type="button" class="btn btn-lg btn-success active btn-block" onclick="login()">登&nbsp;&nbsp;录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>


<!-- 嵌入尾部公用页面 -->
<jsp:include page="../shared/footer.jsp"/>

<script>
	function login() {
		$.post("/LongXiaBar/login",
		  {
		    username:$("#inputUserName").val(),
		    password:$("#inputPassword").val()
		  },
		  function(data){
		    var result = eval('(' + data + ')');
			if(result.success == -1){
				$("#modalforlogin").click();
				$(".modal-body").html("用户名或密码输入错误，登录失败！！！");
			}else if(result.success == 0){
				location.href="${pageContext.request.contextPath}/index";
			}		    
		  });
	}
</script>
