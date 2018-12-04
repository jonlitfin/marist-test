/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package marist.service.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Server. This utility wraps
 * {@link marist.service.service.impl.ServerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ServerLocalService
 * @see marist.service.service.base.ServerLocalServiceBaseImpl
 * @see marist.service.service.impl.ServerLocalServiceImpl
 * @generated
 */
@ProviderType
public class ServerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link marist.service.service.impl.ServerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the server to the database. Also notifies the appropriate model listeners.
	*
	* @param server the server
	* @return the server that was added
	*/
	public static marist.service.model.Server addServer(
		marist.service.model.Server server) {
		return getService().addServer(server);
	}

	/**
	* Creates a new server with the primary key. Does not add the server to the database.
	*
	* @param serverId the primary key for the new server
	* @return the new server
	*/
	public static marist.service.model.Server createServer(long serverId) {
		return getService().createServer(serverId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the server with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serverId the primary key of the server
	* @return the server that was removed
	* @throws PortalException if a server with the primary key could not be found
	*/
	public static marist.service.model.Server deleteServer(long serverId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteServer(serverId);
	}

	/**
	* Deletes the server from the database. Also notifies the appropriate model listeners.
	*
	* @param server the server
	* @return the server that was removed
	*/
	public static marist.service.model.Server deleteServer(
		marist.service.model.Server server) {
		return getService().deleteServer(server);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link marist.service.model.impl.ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link marist.service.model.impl.ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static marist.service.model.Server fetchServer(long serverId) {
		return getService().fetchServer(serverId);
	}

	/**
	* Returns the server matching the UUID and group.
	*
	* @param uuid the server's UUID
	* @param groupId the primary key of the group
	* @return the matching server, or <code>null</code> if a matching server could not be found
	*/
	public static marist.service.model.Server fetchServerByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchServerByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the server with the primary key.
	*
	* @param serverId the primary key of the server
	* @return the server
	* @throws PortalException if a server with the primary key could not be found
	*/
	public static marist.service.model.Server getServer(long serverId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getServer(serverId);
	}

	/**
	* Returns the server matching the UUID and group.
	*
	* @param uuid the server's UUID
	* @param groupId the primary key of the group
	* @return the matching server
	* @throws PortalException if a matching server could not be found
	*/
	public static marist.service.model.Server getServerByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getServerByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the servers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link marist.service.model.impl.ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @return the range of servers
	*/
	public static java.util.List<marist.service.model.Server> getServers(
		int start, int end) {
		return getService().getServers(start, end);
	}

	/**
	* Returns all the servers matching the UUID and company.
	*
	* @param uuid the UUID of the servers
	* @param companyId the primary key of the company
	* @return the matching servers, or an empty list if no matches were found
	*/
	public static java.util.List<marist.service.model.Server> getServersByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService().getServersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of servers matching the UUID and company.
	*
	* @param uuid the UUID of the servers
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching servers, or an empty list if no matches were found
	*/
	public static java.util.List<marist.service.model.Server> getServersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<marist.service.model.Server> orderByComparator) {
		return getService()
				   .getServersByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of servers.
	*
	* @return the number of servers
	*/
	public static int getServersCount() {
		return getService().getServersCount();
	}

	/**
	* Updates the server in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param server the server
	* @return the server that was updated
	*/
	public static marist.service.model.Server updateServer(
		marist.service.model.Server server) {
		return getService().updateServer(server);
	}

	public static ServerLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ServerLocalService, ServerLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ServerLocalService.class);

		ServiceTracker<ServerLocalService, ServerLocalService> serviceTracker = new ServiceTracker<ServerLocalService, ServerLocalService>(bundle.getBundleContext(),
				ServerLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}