<%@ include file="/init.jsp"%>

<%
	ResultRow searchContainerRow = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Server server = (Server) searchContainerRow.getObject();
%>


<portlet:renderURL var="editUrl">
	<portlet:param name="mvcPath" value="/edit.jsp"></portlet:param>
	<portlet:param name="serverId"
		value="<%=String.valueOf(server.getServerId())%>" />
</portlet:renderURL>

<portlet:actionURL name="deleteServer" var="deleteServerUrl">
	<portlet:param name="serverId"
		value="<%=String.valueOf(server.getServerId())%>" />
</portlet:actionURL>

<liferay-ui:icon image="edit" message="Edit"
	url="<%=editUrl.toString()%>" />
	
<liferay-ui:icon image="delete" url="<%=deleteServerUrl.toString()%>" />
