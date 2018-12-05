package marist.mvc.portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import marist.mvc.portlet.constants.MaristMvcPortletKeys;
import marist.service.model.Server;
import marist.service.service.ServerLocalService;

/**
 * @author jon
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Marist",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MaristMvcPortletKeys.MaristMvc,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MaristMvcPortlet extends MVCPortlet {

	private static final Log LOGGER = LogFactoryUtil.getLog(MaristMvcPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {
			List<Server> servers = _serverLocalService.getServers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			renderRequest.setAttribute("servers", servers);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Exception in MaristMvcPortlet.render: " + e.getMessage());
		}

		super.render(renderRequest, renderResponse);
	}

	public void editServer(ActionRequest request, ActionResponse response) {

		try {
			long serverId = ParamUtil.getLong(request, "serverId");
			Server server = null;
			Server editedServer = null;

			if (serverId > 0) {
				server = _serverLocalService.getServer(serverId);
			} else {
				server = _serverLocalService.createServer(CounterLocalServiceUtil.increment(Server.class.getName()));
			}

			server.setName(ParamUtil.getString(request, "name"));
			server.setDistribution(ParamUtil.getString(request, "distribution"));
			server.setVersion(ParamUtil.getString(request, "version"));
			server.setVpn(ParamUtil.getBoolean(request, "vpn"));
			server.setMemory(ParamUtil.getInteger(request, "memory"));
			server.setDisk(ParamUtil.getInteger(request, "disk"));
			server.setCpu(ParamUtil.getString(request, "cpu"));

			if (serverId > 0) {
				editedServer = _serverLocalService.updateServer(server);
			} else {
				editedServer = _serverLocalService.addServer(server);
			}

			response.setRenderParameter("mvcPath", "/view.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Exception in MaristMvcPortlet.editServer: " + e.getMessage());
		}
	}

	public void deleteServer(ActionRequest request, ActionResponse response) {
		
		try {
			long serverId = ParamUtil.getLong(request, "serverId");
			Server server = _serverLocalService.deleteServer(serverId);
			response.setRenderParameter("mvcPath", "/view.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Exception in MaristMvcPortlet.deleteServer: " + e.getMessage());
		}
	}

	@Reference
	protected void setServerLocalService(ServerLocalService serverLocalService) {
		_serverLocalService = serverLocalService;
	}

	private ServerLocalService _serverLocalService;
}