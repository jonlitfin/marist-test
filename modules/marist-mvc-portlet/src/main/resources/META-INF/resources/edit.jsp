<%@ include file="/init.jsp"%>

<portlet:renderURL var="viewUrl">
	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="editServer" var="editUrl"></portlet:actionURL>

<%
	long serverId = ParamUtil.getLong(request, "serverId");
	Server server = null;

	if (serverId > 0) {
		server = ServerLocalServiceUtil.getServer(serverId);
	}
%>

<aui:form action="<%=editUrl%>" name="<portlet:namespace />fm">
	<aui:input type="hidden" name="serverId"
		value='<%=server == null ? "" : server.getServerId()%>'>
	</aui:input>
	<aui:fieldset>
		<aui:input name="name" label="Name"
			value='<%=server == null ? "" : server.getName()%>'>
			<aui:validator name="required" />
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<aui:input name="distribution" label="Distribution"
			value='<%=server == null ? "" : server.getDistribution()%>'>
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
		<aui:input name="version" label="Version"
			value='<%=server == null ? "" : server.getVersion()%>'>
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>

		<aui:input name="vpn" label="VPN" type="checkbox"
			checked="<%=server == null ? false : server.getVpn()%>">
		</aui:input>
		<aui:input name="memory" label="Memory"
			value='<%=server == null ? "" : server.getMemory()%>'></aui:input>
		<aui:input name="disk" label="Disk"
			value='<%=server == null ? "" : server.getDisk()%>'></aui:input>
		<aui:input name="cpu" label="CPU"
			value='<%=server == null ? "" : server.getCpu()%>'>
			<aui:validator name="maxLength">75</aui:validator>
		</aui:input>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%= viewUrl.toString() %>"></aui:button>
	</aui:button-row>
</aui:form>
