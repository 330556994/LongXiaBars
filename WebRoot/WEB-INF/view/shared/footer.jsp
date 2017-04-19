<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			 <a id="modalforlogin" href="#modal-container-login" role="button" class="btn" data-toggle="modal" style="display:none;">触发遮罩窗体</a>
			<div class="modal fade" id="modal-container-login" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content" style="margin-top:150px;">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								提示信息
							</h4>
						</div>
						<div class="modal-body"></div>
						<div class="modal-footer">
							 <button id="close" type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
	</div>
</div>
</body>
</html>