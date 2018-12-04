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

package marist.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import marist.service.model.Server;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the server service. This utility wraps {@link marist.service.service.persistence.impl.ServerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServerPersistence
 * @see marist.service.service.persistence.impl.ServerPersistenceImpl
 * @generated
 */
@ProviderType
public class ServerUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Server server) {
		getPersistence().clearCache(server);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Server> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Server> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Server> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Server> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Server update(Server server) {
		return getPersistence().update(server);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Server update(Server server, ServiceContext serviceContext) {
		return getPersistence().update(server, serviceContext);
	}

	/**
	* Returns all the servers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching servers
	*/
	public static List<Server> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the servers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @return the range of matching servers
	*/
	public static List<Server> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the servers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching servers
	*/
	public static List<Server> findByUuid(String uuid, int start, int end,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the servers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching servers
	*/
	public static List<Server> findByUuid(String uuid, int start, int end,
		OrderByComparator<Server> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first server in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public static Server findByUuid_First(String uuid,
		OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first server in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server, or <code>null</code> if a matching server could not be found
	*/
	public static Server fetchByUuid_First(String uuid,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last server in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public static Server findByUuid_Last(String uuid,
		OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last server in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server, or <code>null</code> if a matching server could not be found
	*/
	public static Server fetchByUuid_Last(String uuid,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the servers before and after the current server in the ordered set where uuid = &#63;.
	*
	* @param serverId the primary key of the current server
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next server
	* @throws NoSuchServerException if a server with the primary key could not be found
	*/
	public static Server[] findByUuid_PrevAndNext(long serverId, String uuid,
		OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence()
				   .findByUuid_PrevAndNext(serverId, uuid, orderByComparator);
	}

	/**
	* Removes all the servers where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of servers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching servers
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the server where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchServerException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public static Server findByUUID_G(String uuid, long groupId)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the server where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching server, or <code>null</code> if a matching server could not be found
	*/
	public static Server fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the server where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching server, or <code>null</code> if a matching server could not be found
	*/
	public static Server fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the server where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the server that was removed
	*/
	public static Server removeByUUID_G(String uuid, long groupId)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of servers where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching servers
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the servers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching servers
	*/
	public static List<Server> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the servers where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @return the range of matching servers
	*/
	public static List<Server> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the servers where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching servers
	*/
	public static List<Server> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Server> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the servers where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching servers
	*/
	public static List<Server> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Server> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first server in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public static Server findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first server in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server, or <code>null</code> if a matching server could not be found
	*/
	public static Server fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last server in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public static Server findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last server in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server, or <code>null</code> if a matching server could not be found
	*/
	public static Server fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the servers before and after the current server in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param serverId the primary key of the current server
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next server
	* @throws NoSuchServerException if a server with the primary key could not be found
	*/
	public static Server[] findByUuid_C_PrevAndNext(long serverId, String uuid,
		long companyId, OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(serverId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the servers where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of servers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching servers
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the servers where distribution = &#63;.
	*
	* @param distribution the distribution
	* @return the matching servers
	*/
	public static List<Server> findByDistribution(String distribution) {
		return getPersistence().findByDistribution(distribution);
	}

	/**
	* Returns a range of all the servers where distribution = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param distribution the distribution
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @return the range of matching servers
	*/
	public static List<Server> findByDistribution(String distribution,
		int start, int end) {
		return getPersistence().findByDistribution(distribution, start, end);
	}

	/**
	* Returns an ordered range of all the servers where distribution = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param distribution the distribution
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching servers
	*/
	public static List<Server> findByDistribution(String distribution,
		int start, int end, OrderByComparator<Server> orderByComparator) {
		return getPersistence()
				   .findByDistribution(distribution, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the servers where distribution = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param distribution the distribution
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching servers
	*/
	public static List<Server> findByDistribution(String distribution,
		int start, int end, OrderByComparator<Server> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDistribution(distribution, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first server in the ordered set where distribution = &#63;.
	*
	* @param distribution the distribution
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public static Server findByDistribution_First(String distribution,
		OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence()
				   .findByDistribution_First(distribution, orderByComparator);
	}

	/**
	* Returns the first server in the ordered set where distribution = &#63;.
	*
	* @param distribution the distribution
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server, or <code>null</code> if a matching server could not be found
	*/
	public static Server fetchByDistribution_First(String distribution,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence()
				   .fetchByDistribution_First(distribution, orderByComparator);
	}

	/**
	* Returns the last server in the ordered set where distribution = &#63;.
	*
	* @param distribution the distribution
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public static Server findByDistribution_Last(String distribution,
		OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence()
				   .findByDistribution_Last(distribution, orderByComparator);
	}

	/**
	* Returns the last server in the ordered set where distribution = &#63;.
	*
	* @param distribution the distribution
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server, or <code>null</code> if a matching server could not be found
	*/
	public static Server fetchByDistribution_Last(String distribution,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence()
				   .fetchByDistribution_Last(distribution, orderByComparator);
	}

	/**
	* Returns the servers before and after the current server in the ordered set where distribution = &#63;.
	*
	* @param serverId the primary key of the current server
	* @param distribution the distribution
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next server
	* @throws NoSuchServerException if a server with the primary key could not be found
	*/
	public static Server[] findByDistribution_PrevAndNext(long serverId,
		String distribution, OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence()
				   .findByDistribution_PrevAndNext(serverId, distribution,
			orderByComparator);
	}

	/**
	* Removes all the servers where distribution = &#63; from the database.
	*
	* @param distribution the distribution
	*/
	public static void removeByDistribution(String distribution) {
		getPersistence().removeByDistribution(distribution);
	}

	/**
	* Returns the number of servers where distribution = &#63;.
	*
	* @param distribution the distribution
	* @return the number of matching servers
	*/
	public static int countByDistribution(String distribution) {
		return getPersistence().countByDistribution(distribution);
	}

	/**
	* Returns all the servers where vpn = &#63;.
	*
	* @param vpn the vpn
	* @return the matching servers
	*/
	public static List<Server> findByVPN(boolean vpn) {
		return getPersistence().findByVPN(vpn);
	}

	/**
	* Returns a range of all the servers where vpn = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vpn the vpn
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @return the range of matching servers
	*/
	public static List<Server> findByVPN(boolean vpn, int start, int end) {
		return getPersistence().findByVPN(vpn, start, end);
	}

	/**
	* Returns an ordered range of all the servers where vpn = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vpn the vpn
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching servers
	*/
	public static List<Server> findByVPN(boolean vpn, int start, int end,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence().findByVPN(vpn, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the servers where vpn = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vpn the vpn
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching servers
	*/
	public static List<Server> findByVPN(boolean vpn, int start, int end,
		OrderByComparator<Server> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByVPN(vpn, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first server in the ordered set where vpn = &#63;.
	*
	* @param vpn the vpn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public static Server findByVPN_First(boolean vpn,
		OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence().findByVPN_First(vpn, orderByComparator);
	}

	/**
	* Returns the first server in the ordered set where vpn = &#63;.
	*
	* @param vpn the vpn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server, or <code>null</code> if a matching server could not be found
	*/
	public static Server fetchByVPN_First(boolean vpn,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence().fetchByVPN_First(vpn, orderByComparator);
	}

	/**
	* Returns the last server in the ordered set where vpn = &#63;.
	*
	* @param vpn the vpn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public static Server findByVPN_Last(boolean vpn,
		OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence().findByVPN_Last(vpn, orderByComparator);
	}

	/**
	* Returns the last server in the ordered set where vpn = &#63;.
	*
	* @param vpn the vpn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server, or <code>null</code> if a matching server could not be found
	*/
	public static Server fetchByVPN_Last(boolean vpn,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence().fetchByVPN_Last(vpn, orderByComparator);
	}

	/**
	* Returns the servers before and after the current server in the ordered set where vpn = &#63;.
	*
	* @param serverId the primary key of the current server
	* @param vpn the vpn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next server
	* @throws NoSuchServerException if a server with the primary key could not be found
	*/
	public static Server[] findByVPN_PrevAndNext(long serverId, boolean vpn,
		OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence()
				   .findByVPN_PrevAndNext(serverId, vpn, orderByComparator);
	}

	/**
	* Removes all the servers where vpn = &#63; from the database.
	*
	* @param vpn the vpn
	*/
	public static void removeByVPN(boolean vpn) {
		getPersistence().removeByVPN(vpn);
	}

	/**
	* Returns the number of servers where vpn = &#63;.
	*
	* @param vpn the vpn
	* @return the number of matching servers
	*/
	public static int countByVPN(boolean vpn) {
		return getPersistence().countByVPN(vpn);
	}

	/**
	* Returns all the servers where cpu = &#63;.
	*
	* @param cpu the cpu
	* @return the matching servers
	*/
	public static List<Server> findByCPU(String cpu) {
		return getPersistence().findByCPU(cpu);
	}

	/**
	* Returns a range of all the servers where cpu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cpu the cpu
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @return the range of matching servers
	*/
	public static List<Server> findByCPU(String cpu, int start, int end) {
		return getPersistence().findByCPU(cpu, start, end);
	}

	/**
	* Returns an ordered range of all the servers where cpu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cpu the cpu
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching servers
	*/
	public static List<Server> findByCPU(String cpu, int start, int end,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence().findByCPU(cpu, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the servers where cpu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param cpu the cpu
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching servers
	*/
	public static List<Server> findByCPU(String cpu, int start, int end,
		OrderByComparator<Server> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByCPU(cpu, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first server in the ordered set where cpu = &#63;.
	*
	* @param cpu the cpu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public static Server findByCPU_First(String cpu,
		OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence().findByCPU_First(cpu, orderByComparator);
	}

	/**
	* Returns the first server in the ordered set where cpu = &#63;.
	*
	* @param cpu the cpu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server, or <code>null</code> if a matching server could not be found
	*/
	public static Server fetchByCPU_First(String cpu,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence().fetchByCPU_First(cpu, orderByComparator);
	}

	/**
	* Returns the last server in the ordered set where cpu = &#63;.
	*
	* @param cpu the cpu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public static Server findByCPU_Last(String cpu,
		OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence().findByCPU_Last(cpu, orderByComparator);
	}

	/**
	* Returns the last server in the ordered set where cpu = &#63;.
	*
	* @param cpu the cpu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server, or <code>null</code> if a matching server could not be found
	*/
	public static Server fetchByCPU_Last(String cpu,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence().fetchByCPU_Last(cpu, orderByComparator);
	}

	/**
	* Returns the servers before and after the current server in the ordered set where cpu = &#63;.
	*
	* @param serverId the primary key of the current server
	* @param cpu the cpu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next server
	* @throws NoSuchServerException if a server with the primary key could not be found
	*/
	public static Server[] findByCPU_PrevAndNext(long serverId, String cpu,
		OrderByComparator<Server> orderByComparator)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence()
				   .findByCPU_PrevAndNext(serverId, cpu, orderByComparator);
	}

	/**
	* Removes all the servers where cpu = &#63; from the database.
	*
	* @param cpu the cpu
	*/
	public static void removeByCPU(String cpu) {
		getPersistence().removeByCPU(cpu);
	}

	/**
	* Returns the number of servers where cpu = &#63;.
	*
	* @param cpu the cpu
	* @return the number of matching servers
	*/
	public static int countByCPU(String cpu) {
		return getPersistence().countByCPU(cpu);
	}

	/**
	* Caches the server in the entity cache if it is enabled.
	*
	* @param server the server
	*/
	public static void cacheResult(Server server) {
		getPersistence().cacheResult(server);
	}

	/**
	* Caches the servers in the entity cache if it is enabled.
	*
	* @param servers the servers
	*/
	public static void cacheResult(List<Server> servers) {
		getPersistence().cacheResult(servers);
	}

	/**
	* Creates a new server with the primary key. Does not add the server to the database.
	*
	* @param serverId the primary key for the new server
	* @return the new server
	*/
	public static Server create(long serverId) {
		return getPersistence().create(serverId);
	}

	/**
	* Removes the server with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serverId the primary key of the server
	* @return the server that was removed
	* @throws NoSuchServerException if a server with the primary key could not be found
	*/
	public static Server remove(long serverId)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence().remove(serverId);
	}

	public static Server updateImpl(Server server) {
		return getPersistence().updateImpl(server);
	}

	/**
	* Returns the server with the primary key or throws a {@link NoSuchServerException} if it could not be found.
	*
	* @param serverId the primary key of the server
	* @return the server
	* @throws NoSuchServerException if a server with the primary key could not be found
	*/
	public static Server findByPrimaryKey(long serverId)
		throws marist.service.exception.NoSuchServerException {
		return getPersistence().findByPrimaryKey(serverId);
	}

	/**
	* Returns the server with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param serverId the primary key of the server
	* @return the server, or <code>null</code> if a server with the primary key could not be found
	*/
	public static Server fetchByPrimaryKey(long serverId) {
		return getPersistence().fetchByPrimaryKey(serverId);
	}

	public static java.util.Map<java.io.Serializable, Server> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the servers.
	*
	* @return the servers
	*/
	public static List<Server> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the servers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @return the range of servers
	*/
	public static List<Server> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the servers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of servers
	*/
	public static List<Server> findAll(int start, int end,
		OrderByComparator<Server> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the servers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of servers
	* @param end the upper bound of the range of servers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of servers
	*/
	public static List<Server> findAll(int start, int end,
		OrderByComparator<Server> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the servers from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of servers.
	*
	* @return the number of servers
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ServerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ServerPersistence, ServerPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ServerPersistence.class);

		ServiceTracker<ServerPersistence, ServerPersistence> serviceTracker = new ServiceTracker<ServerPersistence, ServerPersistence>(bundle.getBundleContext(),
				ServerPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}