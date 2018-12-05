<%@ include file="/init.jsp" %>

<portlet:renderURL var="editUrl">
    <portlet:param name="mvcPath" value="/edit.jsp"></portlet:param>
</portlet:renderURL>

<aui:button-row>
    <aui:button onClick="<%= editUrl.toString() %>" value="Add Server"></aui:button>
</aui:button-row>

<liferay-ui:search-container total="<%=ServerLocalServiceUtil.getServersCount()%>">
<liferay-ui:search-container-results
    results="<%=ServerLocalServiceUtil.getServers(QueryUtil.ALL_POS, QueryUtil.ALL_POS)%>" />

<liferay-ui:search-container-row
    className="marist.service.model.Server" modelVar="server">
					<liferay-ui:search-container-column-jsp
						path="/actions.jsp" name="Actions" />
    <liferay-ui:search-container-column-text property="name" name="Name" />
    <liferay-ui:search-container-column-text property="distribution" name="Distro" />
    <liferay-ui:search-container-column-text property="version" name="Version" />
    <liferay-ui:search-container-column-text property="vpn" name="VPN" />
    <liferay-ui:search-container-column-text property="memory" name="Memory" />
    <liferay-ui:search-container-column-text property="disk" name="Disk" />
    <liferay-ui:search-container-column-text property="cpu" name="CPU" />
    <liferay-ui:search-container-column-text property="createDate" name="Created"/>
    <liferay-ui:search-container-column-text property="modifiedDate" name="Modified" />

</liferay-ui:search-container-row>

<liferay-ui:search-iterator />

</liferay-ui:search-container>
