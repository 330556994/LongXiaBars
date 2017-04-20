#LongXiaBar
杩欐槸涓�釜绫讳技浜庤创鍚х殑璁哄潧椤圭洰

这里是 Hibernate 配置的

<c:forEach items="${allBarCategory }" var="abc" varStatus="vs">
	<div class="tab-pane" id="panel-${vs.current.id }">
		<c:forEach items="${allBarCategoryTwo }" var="abct" varStatus="vst">
			<c:if test="${vst.current.barCategory.id==vs.current.id }">
				 <button type="button" class="btn btn-success btn-lg" onclick="showBar(${vst.current.id})">${abct.categoryname }</button>
			</c:if>
		</c:forEach>
	</div>
</c:forEach>