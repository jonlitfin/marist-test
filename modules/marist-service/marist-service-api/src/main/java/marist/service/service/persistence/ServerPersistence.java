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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import marist.service.exception.NoSuchServerException;

import marist.service.model.Server;

/**
 * The persistence interface for the server service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see marist.service.service.persistence.impl.ServerPersistenceImpl
 * @see ServerUtil
 * @generated
 */
@ProviderType
public interface ServerPersistence extends BasePersistence<Server> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServerUtil} to access the server persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the servers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching servers
	*/
	public java.util.List<Server> findByUuid(String uuid);

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
	public java.util.List<Server> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Server> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

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
	public java.util.List<Server> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first server in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public Server findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Returns the first server in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server, or <code>null</code> if a matching server could not be found
	*/
	public Server fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

	/**
	* Returns the last server in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public Server findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Returns the last server in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server, or <code>null</code> if a matching server could not be found
	*/
	public Server fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

	/**
	* Returns the servers before and after the current server in the ordered set where uuid = &#63;.
	*
	* @param serverId the primary key of the current server
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next server
	* @throws NoSuchServerException if a server with the primary key could not be found
	*/
	public Server[] findByUuid_PrevAndNext(long serverId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Removes all the servers where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of servers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching servers
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the server where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchServerException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public Server findByUUID_G(String uuid, long groupId)
		throws NoSuchServerException;

	/**
	* Returns the server where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching server, or <code>null</code> if a matching server could not be found
	*/
	public Server fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the server where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching server, or <code>null</code> if a matching server could not be found
	*/
	public Server fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the server where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the server that was removed
	*/
	public Server removeByUUID_G(String uuid, long groupId)
		throws NoSuchServerException;

	/**
	* Returns the number of servers where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching servers
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the servers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching servers
	*/
	public java.util.List<Server> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Server> findByUuid_C(String uuid, long companyId,
		int start, int end);

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
	public java.util.List<Server> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

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
	public java.util.List<Server> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first server in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public Server findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Returns the first server in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server, or <code>null</code> if a matching server could not be found
	*/
	public Server fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

	/**
	* Returns the last server in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public Server findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Returns the last server in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server, or <code>null</code> if a matching server could not be found
	*/
	public Server fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

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
	public Server[] findByUuid_C_PrevAndNext(long serverId, String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Removes all the servers where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of servers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching servers
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Returns all the servers where distribution = &#63;.
	*
	* @param distribution the distribution
	* @return the matching servers
	*/
	public java.util.List<Server> findByDistribution(String distribution);

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
	public java.util.List<Server> findByDistribution(String distribution,
		int start, int end);

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
	public java.util.List<Server> findByDistribution(String distribution,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

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
	public java.util.List<Server> findByDistribution(String distribution,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first server in the ordered set where distribution = &#63;.
	*
	* @param distribution the distribution
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public Server findByDistribution_First(String distribution,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Returns the first server in the ordered set where distribution = &#63;.
	*
	* @param distribution the distribution
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server, or <code>null</code> if a matching server could not be found
	*/
	public Server fetchByDistribution_First(String distribution,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

	/**
	* Returns the last server in the ordered set where distribution = &#63;.
	*
	* @param distribution the distribution
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public Server findByDistribution_Last(String distribution,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Returns the last server in the ordered set where distribution = &#63;.
	*
	* @param distribution the distribution
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server, or <code>null</code> if a matching server could not be found
	*/
	public Server fetchByDistribution_Last(String distribution,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

	/**
	* Returns the servers before and after the current server in the ordered set where distribution = &#63;.
	*
	* @param serverId the primary key of the current server
	* @param distribution the distribution
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next server
	* @throws NoSuchServerException if a server with the primary key could not be found
	*/
	public Server[] findByDistribution_PrevAndNext(long serverId,
		String distribution,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Removes all the servers where distribution = &#63; from the database.
	*
	* @param distribution the distribution
	*/
	public void removeByDistribution(String distribution);

	/**
	* Returns the number of servers where distribution = &#63;.
	*
	* @param distribution the distribution
	* @return the number of matching servers
	*/
	public int countByDistribution(String distribution);

	/**
	* Returns all the servers where vpn = &#63;.
	*
	* @param vpn the vpn
	* @return the matching servers
	*/
	public java.util.List<Server> findByVPN(boolean vpn);

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
	public java.util.List<Server> findByVPN(boolean vpn, int start, int end);

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
	public java.util.List<Server> findByVPN(boolean vpn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

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
	public java.util.List<Server> findByVPN(boolean vpn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first server in the ordered set where vpn = &#63;.
	*
	* @param vpn the vpn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public Server findByVPN_First(boolean vpn,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Returns the first server in the ordered set where vpn = &#63;.
	*
	* @param vpn the vpn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server, or <code>null</code> if a matching server could not be found
	*/
	public Server fetchByVPN_First(boolean vpn,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

	/**
	* Returns the last server in the ordered set where vpn = &#63;.
	*
	* @param vpn the vpn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public Server findByVPN_Last(boolean vpn,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Returns the last server in the ordered set where vpn = &#63;.
	*
	* @param vpn the vpn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server, or <code>null</code> if a matching server could not be found
	*/
	public Server fetchByVPN_Last(boolean vpn,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

	/**
	* Returns the servers before and after the current server in the ordered set where vpn = &#63;.
	*
	* @param serverId the primary key of the current server
	* @param vpn the vpn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next server
	* @throws NoSuchServerException if a server with the primary key could not be found
	*/
	public Server[] findByVPN_PrevAndNext(long serverId, boolean vpn,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Removes all the servers where vpn = &#63; from the database.
	*
	* @param vpn the vpn
	*/
	public void removeByVPN(boolean vpn);

	/**
	* Returns the number of servers where vpn = &#63;.
	*
	* @param vpn the vpn
	* @return the number of matching servers
	*/
	public int countByVPN(boolean vpn);

	/**
	* Returns all the servers where cpu = &#63;.
	*
	* @param cpu the cpu
	* @return the matching servers
	*/
	public java.util.List<Server> findByCPU(String cpu);

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
	public java.util.List<Server> findByCPU(String cpu, int start, int end);

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
	public java.util.List<Server> findByCPU(String cpu, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

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
	public java.util.List<Server> findByCPU(String cpu, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first server in the ordered set where cpu = &#63;.
	*
	* @param cpu the cpu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public Server findByCPU_First(String cpu,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Returns the first server in the ordered set where cpu = &#63;.
	*
	* @param cpu the cpu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching server, or <code>null</code> if a matching server could not be found
	*/
	public Server fetchByCPU_First(String cpu,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

	/**
	* Returns the last server in the ordered set where cpu = &#63;.
	*
	* @param cpu the cpu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server
	* @throws NoSuchServerException if a matching server could not be found
	*/
	public Server findByCPU_Last(String cpu,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Returns the last server in the ordered set where cpu = &#63;.
	*
	* @param cpu the cpu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching server, or <code>null</code> if a matching server could not be found
	*/
	public Server fetchByCPU_Last(String cpu,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

	/**
	* Returns the servers before and after the current server in the ordered set where cpu = &#63;.
	*
	* @param serverId the primary key of the current server
	* @param cpu the cpu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next server
	* @throws NoSuchServerException if a server with the primary key could not be found
	*/
	public Server[] findByCPU_PrevAndNext(long serverId, String cpu,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException;

	/**
	* Removes all the servers where cpu = &#63; from the database.
	*
	* @param cpu the cpu
	*/
	public void removeByCPU(String cpu);

	/**
	* Returns the number of servers where cpu = &#63;.
	*
	* @param cpu the cpu
	* @return the number of matching servers
	*/
	public int countByCPU(String cpu);

	/**
	* Caches the server in the entity cache if it is enabled.
	*
	* @param server the server
	*/
	public void cacheResult(Server server);

	/**
	* Caches the servers in the entity cache if it is enabled.
	*
	* @param servers the servers
	*/
	public void cacheResult(java.util.List<Server> servers);

	/**
	* Creates a new server with the primary key. Does not add the server to the database.
	*
	* @param serverId the primary key for the new server
	* @return the new server
	*/
	public Server create(long serverId);

	/**
	* Removes the server with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serverId the primary key of the server
	* @return the server that was removed
	* @throws NoSuchServerException if a server with the primary key could not be found
	*/
	public Server remove(long serverId) throws NoSuchServerException;

	public Server updateImpl(Server server);

	/**
	* Returns the server with the primary key or throws a {@link NoSuchServerException} if it could not be found.
	*
	* @param serverId the primary key of the server
	* @return the server
	* @throws NoSuchServerException if a server with the primary key could not be found
	*/
	public Server findByPrimaryKey(long serverId) throws NoSuchServerException;

	/**
	* Returns the server with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param serverId the primary key of the server
	* @return the server, or <code>null</code> if a server with the primary key could not be found
	*/
	public Server fetchByPrimaryKey(long serverId);

	@Override
	public java.util.Map<java.io.Serializable, Server> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the servers.
	*
	* @return the servers
	*/
	public java.util.List<Server> findAll();

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
	public java.util.List<Server> findAll(int start, int end);

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
	public java.util.List<Server> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator);

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
	public java.util.List<Server> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Server> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the servers from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of servers.
	*
	* @return the number of servers
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}