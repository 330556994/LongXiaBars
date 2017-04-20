<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 嵌入头部公用页面 -->
<jsp:include page="../shared/header.jsp"/>

<div class="container" style="margin-top:53px;opacity:0.8;">
	<div class="row clearfix">
		<div class="col-md-3 column">
			<div class="jumbotron">
				<h4>${currentUser.nickname}</h4>
				<img alt="" src="${pageContext.request.contextPath }/image/header.png" class="img-rounded"  style="height: 70px;width: 70px;">
			</div>
		</div>
		<div class="col-md-9 column">
			<div class="jumbotron">
				<h4>贴吧分类</h4>
				<div class="tabbable" id="tabs-001">
					<ul class="nav nav-tabs">
						<c:forEach items="${allBarCategory }" var="abc" varStatus="vs">
							<li>
							 	<a href="#panel-${vs.current.id }" data-toggle="tab">${abc.categoryname }</a>
							</li>
						</c:forEach>
					</ul>
					<div class="tab-content" style="margin-top:10px;">
						<c:forEach items="${allBarCategory }" var="abc" varStatus="vs">
							<div class="tab-pane" id="panel-${vs.current.id }">
								<c:forEach items="${allBarCategoryTwo }" var="abct" varStatus="vst">
									<c:if test="${abct.categoryId==vs.current.id }">
										 <button type="button" class="btn btn-success btn-lg" onclick="showBar(${vst.current.id})">${abct.categoryName }</button>
									</c:if>
								</c:forEach>
							</div>
						</c:forEach>
					</div>
				</div>
				<div id="showBarArea">
				
				</div>
				<h4>动态</h4>
				<div class="tabbable" id="tabs-002">
					<ul class="nav nav-tabs">
						<li class="active">
							 <a href="#panel-hot" data-toggle="tab">热门动态</a>
						</li>
						<li>
							 <a href="#panel-personal" data-toggle="tab">个性动态</a>
						</li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-hot">
							<p>
								I'm in Section 1.
							</p>
						</div>
						<div class="tab-pane" id="panel-personal">
							<p>
								Howdy, I'm in Section 2.
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script>

</script>



<!-- 嵌入尾部公用页面 -->
<jsp:include page="../shared/footer.jsp"/>