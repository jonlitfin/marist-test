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

package marist.service.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import marist.service.exception.NoSuchServerException;

import marist.service.model.Server;
import marist.service.model.impl.ServerImpl;
import marist.service.model.impl.ServerModelImpl;

import marist.service.service.persistence.ServerPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the server service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServerPersistence
 * @see marist.service.service.persistence.ServerUtil
 * @generated
 */
@ProviderType
public class ServerPersistenceImpl extends BasePersistenceImpl<Server>
	implements ServerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServerUtil} to access the server persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, ServerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, ServerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, ServerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, ServerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ServerModelImpl.UUID_COLUMN_BITMASK |
			ServerModelImpl.DISTRIBUTION_COLUMN_BITMASK |
			ServerModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the servers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching servers
	 */
	@Override
	public List<Server> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Server> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Server> findByUuid(String uuid, int start, int end,
		OrderByComparator<Server> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Server> findByUuid(String uuid, int start, int end,
		OrderByComparator<Server> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Server> list = null;

		if (retrieveFromCache) {
			list = (List<Server>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Server server : list) {
					if (!Objects.equals(uuid, server.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SERVER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Server>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Server>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first server in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server
	 * @throws NoSuchServerException if a matching server could not be found
	 */
	@Override
	public Server findByUuid_First(String uuid,
		OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = fetchByUuid_First(uuid, orderByComparator);

		if (server != null) {
			return server;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchServerException(msg.toString());
	}

	/**
	 * Returns the first server in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server, or <code>null</code> if a matching server could not be found
	 */
	@Override
	public Server fetchByUuid_First(String uuid,
		OrderByComparator<Server> orderByComparator) {
		List<Server> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last server in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server
	 * @throws NoSuchServerException if a matching server could not be found
	 */
	@Override
	public Server findByUuid_Last(String uuid,
		OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = fetchByUuid_Last(uuid, orderByComparator);

		if (server != null) {
			return server;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchServerException(msg.toString());
	}

	/**
	 * Returns the last server in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server, or <code>null</code> if a matching server could not be found
	 */
	@Override
	public Server fetchByUuid_Last(String uuid,
		OrderByComparator<Server> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Server> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Server[] findByUuid_PrevAndNext(long serverId, String uuid,
		OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = findByPrimaryKey(serverId);

		Session session = null;

		try {
			session = openSession();

			Server[] array = new ServerImpl[3];

			array[0] = getByUuid_PrevAndNext(session, server, uuid,
					orderByComparator, true);

			array[1] = server;

			array[2] = getByUuid_PrevAndNext(session, server, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Server getByUuid_PrevAndNext(Session session, Server server,
		String uuid, OrderByComparator<Server> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVER_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ServerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(server);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Server> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Server server : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(server);
		}
	}

	/**
	 * Returns the number of servers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching servers
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "server.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "server.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(server.uuid IS NULL OR server.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, ServerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ServerModelImpl.UUID_COLUMN_BITMASK |
			ServerModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the server where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchServerException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching server
	 * @throws NoSuchServerException if a matching server could not be found
	 */
	@Override
	public Server findByUUID_G(String uuid, long groupId)
		throws NoSuchServerException {
		Server server = fetchByUUID_G(uuid, groupId);

		if (server == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchServerException(msg.toString());
		}

		return server;
	}

	/**
	 * Returns the server where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching server, or <code>null</code> if a matching server could not be found
	 */
	@Override
	public Server fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the server where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching server, or <code>null</code> if a matching server could not be found
	 */
	@Override
	public Server fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Server) {
			Server server = (Server)result;

			if (!Objects.equals(uuid, server.getUuid()) ||
					(groupId != server.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SERVER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Server> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Server server = list.get(0);

					result = server;

					cacheResult(server);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Server)result;
		}
	}

	/**
	 * Removes the server where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the server that was removed
	 */
	@Override
	public Server removeByUUID_G(String uuid, long groupId)
		throws NoSuchServerException {
		Server server = findByUUID_G(uuid, groupId);

		return remove(server);
	}

	/**
	 * Returns the number of servers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching servers
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SERVER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "server.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "server.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(server.uuid IS NULL OR server.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "server.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, ServerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, ServerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ServerModelImpl.UUID_COLUMN_BITMASK |
			ServerModelImpl.COMPANYID_COLUMN_BITMASK |
			ServerModelImpl.DISTRIBUTION_COLUMN_BITMASK |
			ServerModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the servers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching servers
	 */
	@Override
	public List<Server> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Server> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Server> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Server> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Server> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Server> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Server> list = null;

		if (retrieveFromCache) {
			list = (List<Server>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Server server : list) {
					if (!Objects.equals(uuid, server.getUuid()) ||
							(companyId != server.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SERVER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Server>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Server>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Server findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (server != null) {
			return server;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchServerException(msg.toString());
	}

	/**
	 * Returns the first server in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server, or <code>null</code> if a matching server could not be found
	 */
	@Override
	public Server fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Server> orderByComparator) {
		List<Server> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Server findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (server != null) {
			return server;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchServerException(msg.toString());
	}

	/**
	 * Returns the last server in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server, or <code>null</code> if a matching server could not be found
	 */
	@Override
	public Server fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Server> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Server> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Server[] findByUuid_C_PrevAndNext(long serverId, String uuid,
		long companyId, OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = findByPrimaryKey(serverId);

		Session session = null;

		try {
			session = openSession();

			Server[] array = new ServerImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, server, uuid,
					companyId, orderByComparator, true);

			array[1] = server;

			array[2] = getByUuid_C_PrevAndNext(session, server, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Server getByUuid_C_PrevAndNext(Session session, Server server,
		String uuid, long companyId,
		OrderByComparator<Server> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SERVER_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ServerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(server);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Server> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Server server : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(server);
		}
	}

	/**
	 * Returns the number of servers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching servers
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SERVER_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "server.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "server.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(server.uuid IS NULL OR server.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "server.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DISTRIBUTION =
		new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, ServerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDistribution",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISTRIBUTION =
		new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, ServerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDistribution",
			new String[] { String.class.getName() },
			ServerModelImpl.DISTRIBUTION_COLUMN_BITMASK |
			ServerModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DISTRIBUTION = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDistribution",
			new String[] { String.class.getName() });

	/**
	 * Returns all the servers where distribution = &#63;.
	 *
	 * @param distribution the distribution
	 * @return the matching servers
	 */
	@Override
	public List<Server> findByDistribution(String distribution) {
		return findByDistribution(distribution, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Server> findByDistribution(String distribution, int start,
		int end) {
		return findByDistribution(distribution, start, end, null);
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
	@Override
	public List<Server> findByDistribution(String distribution, int start,
		int end, OrderByComparator<Server> orderByComparator) {
		return findByDistribution(distribution, start, end, orderByComparator,
			true);
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
	@Override
	public List<Server> findByDistribution(String distribution, int start,
		int end, OrderByComparator<Server> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISTRIBUTION;
			finderArgs = new Object[] { distribution };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DISTRIBUTION;
			finderArgs = new Object[] {
					distribution,
					
					start, end, orderByComparator
				};
		}

		List<Server> list = null;

		if (retrieveFromCache) {
			list = (List<Server>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Server server : list) {
					if (!Objects.equals(distribution, server.getDistribution())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SERVER_WHERE);

			boolean bindDistribution = false;

			if (distribution == null) {
				query.append(_FINDER_COLUMN_DISTRIBUTION_DISTRIBUTION_1);
			}
			else if (distribution.equals("")) {
				query.append(_FINDER_COLUMN_DISTRIBUTION_DISTRIBUTION_3);
			}
			else {
				bindDistribution = true;

				query.append(_FINDER_COLUMN_DISTRIBUTION_DISTRIBUTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDistribution) {
					qPos.add(distribution);
				}

				if (!pagination) {
					list = (List<Server>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Server>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first server in the ordered set where distribution = &#63;.
	 *
	 * @param distribution the distribution
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server
	 * @throws NoSuchServerException if a matching server could not be found
	 */
	@Override
	public Server findByDistribution_First(String distribution,
		OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = fetchByDistribution_First(distribution,
				orderByComparator);

		if (server != null) {
			return server;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("distribution=");
		msg.append(distribution);

		msg.append("}");

		throw new NoSuchServerException(msg.toString());
	}

	/**
	 * Returns the first server in the ordered set where distribution = &#63;.
	 *
	 * @param distribution the distribution
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server, or <code>null</code> if a matching server could not be found
	 */
	@Override
	public Server fetchByDistribution_First(String distribution,
		OrderByComparator<Server> orderByComparator) {
		List<Server> list = findByDistribution(distribution, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last server in the ordered set where distribution = &#63;.
	 *
	 * @param distribution the distribution
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server
	 * @throws NoSuchServerException if a matching server could not be found
	 */
	@Override
	public Server findByDistribution_Last(String distribution,
		OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = fetchByDistribution_Last(distribution, orderByComparator);

		if (server != null) {
			return server;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("distribution=");
		msg.append(distribution);

		msg.append("}");

		throw new NoSuchServerException(msg.toString());
	}

	/**
	 * Returns the last server in the ordered set where distribution = &#63;.
	 *
	 * @param distribution the distribution
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server, or <code>null</code> if a matching server could not be found
	 */
	@Override
	public Server fetchByDistribution_Last(String distribution,
		OrderByComparator<Server> orderByComparator) {
		int count = countByDistribution(distribution);

		if (count == 0) {
			return null;
		}

		List<Server> list = findByDistribution(distribution, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Server[] findByDistribution_PrevAndNext(long serverId,
		String distribution, OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = findByPrimaryKey(serverId);

		Session session = null;

		try {
			session = openSession();

			Server[] array = new ServerImpl[3];

			array[0] = getByDistribution_PrevAndNext(session, server,
					distribution, orderByComparator, true);

			array[1] = server;

			array[2] = getByDistribution_PrevAndNext(session, server,
					distribution, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Server getByDistribution_PrevAndNext(Session session,
		Server server, String distribution,
		OrderByComparator<Server> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVER_WHERE);

		boolean bindDistribution = false;

		if (distribution == null) {
			query.append(_FINDER_COLUMN_DISTRIBUTION_DISTRIBUTION_1);
		}
		else if (distribution.equals("")) {
			query.append(_FINDER_COLUMN_DISTRIBUTION_DISTRIBUTION_3);
		}
		else {
			bindDistribution = true;

			query.append(_FINDER_COLUMN_DISTRIBUTION_DISTRIBUTION_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ServerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDistribution) {
			qPos.add(distribution);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(server);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Server> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servers where distribution = &#63; from the database.
	 *
	 * @param distribution the distribution
	 */
	@Override
	public void removeByDistribution(String distribution) {
		for (Server server : findByDistribution(distribution,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(server);
		}
	}

	/**
	 * Returns the number of servers where distribution = &#63;.
	 *
	 * @param distribution the distribution
	 * @return the number of matching servers
	 */
	@Override
	public int countByDistribution(String distribution) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DISTRIBUTION;

		Object[] finderArgs = new Object[] { distribution };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVER_WHERE);

			boolean bindDistribution = false;

			if (distribution == null) {
				query.append(_FINDER_COLUMN_DISTRIBUTION_DISTRIBUTION_1);
			}
			else if (distribution.equals("")) {
				query.append(_FINDER_COLUMN_DISTRIBUTION_DISTRIBUTION_3);
			}
			else {
				bindDistribution = true;

				query.append(_FINDER_COLUMN_DISTRIBUTION_DISTRIBUTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDistribution) {
					qPos.add(distribution);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DISTRIBUTION_DISTRIBUTION_1 = "server.distribution IS NULL";
	private static final String _FINDER_COLUMN_DISTRIBUTION_DISTRIBUTION_2 = "server.distribution = ?";
	private static final String _FINDER_COLUMN_DISTRIBUTION_DISTRIBUTION_3 = "(server.distribution IS NULL OR server.distribution = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VPN = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, ServerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVPN",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VPN = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, ServerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVPN",
			new String[] { Boolean.class.getName() },
			ServerModelImpl.VPN_COLUMN_BITMASK |
			ServerModelImpl.DISTRIBUTION_COLUMN_BITMASK |
			ServerModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VPN = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVPN",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the servers where vpn = &#63;.
	 *
	 * @param vpn the vpn
	 * @return the matching servers
	 */
	@Override
	public List<Server> findByVPN(boolean vpn) {
		return findByVPN(vpn, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Server> findByVPN(boolean vpn, int start, int end) {
		return findByVPN(vpn, start, end, null);
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
	@Override
	public List<Server> findByVPN(boolean vpn, int start, int end,
		OrderByComparator<Server> orderByComparator) {
		return findByVPN(vpn, start, end, orderByComparator, true);
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
	@Override
	public List<Server> findByVPN(boolean vpn, int start, int end,
		OrderByComparator<Server> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VPN;
			finderArgs = new Object[] { vpn };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VPN;
			finderArgs = new Object[] { vpn, start, end, orderByComparator };
		}

		List<Server> list = null;

		if (retrieveFromCache) {
			list = (List<Server>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Server server : list) {
					if ((vpn != server.isVpn())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SERVER_WHERE);

			query.append(_FINDER_COLUMN_VPN_VPN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vpn);

				if (!pagination) {
					list = (List<Server>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Server>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first server in the ordered set where vpn = &#63;.
	 *
	 * @param vpn the vpn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server
	 * @throws NoSuchServerException if a matching server could not be found
	 */
	@Override
	public Server findByVPN_First(boolean vpn,
		OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = fetchByVPN_First(vpn, orderByComparator);

		if (server != null) {
			return server;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vpn=");
		msg.append(vpn);

		msg.append("}");

		throw new NoSuchServerException(msg.toString());
	}

	/**
	 * Returns the first server in the ordered set where vpn = &#63;.
	 *
	 * @param vpn the vpn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server, or <code>null</code> if a matching server could not be found
	 */
	@Override
	public Server fetchByVPN_First(boolean vpn,
		OrderByComparator<Server> orderByComparator) {
		List<Server> list = findByVPN(vpn, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last server in the ordered set where vpn = &#63;.
	 *
	 * @param vpn the vpn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server
	 * @throws NoSuchServerException if a matching server could not be found
	 */
	@Override
	public Server findByVPN_Last(boolean vpn,
		OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = fetchByVPN_Last(vpn, orderByComparator);

		if (server != null) {
			return server;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vpn=");
		msg.append(vpn);

		msg.append("}");

		throw new NoSuchServerException(msg.toString());
	}

	/**
	 * Returns the last server in the ordered set where vpn = &#63;.
	 *
	 * @param vpn the vpn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server, or <code>null</code> if a matching server could not be found
	 */
	@Override
	public Server fetchByVPN_Last(boolean vpn,
		OrderByComparator<Server> orderByComparator) {
		int count = countByVPN(vpn);

		if (count == 0) {
			return null;
		}

		List<Server> list = findByVPN(vpn, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Server[] findByVPN_PrevAndNext(long serverId, boolean vpn,
		OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = findByPrimaryKey(serverId);

		Session session = null;

		try {
			session = openSession();

			Server[] array = new ServerImpl[3];

			array[0] = getByVPN_PrevAndNext(session, server, vpn,
					orderByComparator, true);

			array[1] = server;

			array[2] = getByVPN_PrevAndNext(session, server, vpn,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Server getByVPN_PrevAndNext(Session session, Server server,
		boolean vpn, OrderByComparator<Server> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVER_WHERE);

		query.append(_FINDER_COLUMN_VPN_VPN_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ServerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(vpn);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(server);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Server> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servers where vpn = &#63; from the database.
	 *
	 * @param vpn the vpn
	 */
	@Override
	public void removeByVPN(boolean vpn) {
		for (Server server : findByVPN(vpn, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(server);
		}
	}

	/**
	 * Returns the number of servers where vpn = &#63;.
	 *
	 * @param vpn the vpn
	 * @return the number of matching servers
	 */
	@Override
	public int countByVPN(boolean vpn) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VPN;

		Object[] finderArgs = new Object[] { vpn };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVER_WHERE);

			query.append(_FINDER_COLUMN_VPN_VPN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vpn);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VPN_VPN_2 = "server.vpn = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CPU = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, ServerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCPU",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CPU = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, ServerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCPU",
			new String[] { String.class.getName() },
			ServerModelImpl.CPU_COLUMN_BITMASK |
			ServerModelImpl.DISTRIBUTION_COLUMN_BITMASK |
			ServerModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CPU = new FinderPath(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCPU",
			new String[] { String.class.getName() });

	/**
	 * Returns all the servers where cpu = &#63;.
	 *
	 * @param cpu the cpu
	 * @return the matching servers
	 */
	@Override
	public List<Server> findByCPU(String cpu) {
		return findByCPU(cpu, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Server> findByCPU(String cpu, int start, int end) {
		return findByCPU(cpu, start, end, null);
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
	@Override
	public List<Server> findByCPU(String cpu, int start, int end,
		OrderByComparator<Server> orderByComparator) {
		return findByCPU(cpu, start, end, orderByComparator, true);
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
	@Override
	public List<Server> findByCPU(String cpu, int start, int end,
		OrderByComparator<Server> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CPU;
			finderArgs = new Object[] { cpu };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CPU;
			finderArgs = new Object[] { cpu, start, end, orderByComparator };
		}

		List<Server> list = null;

		if (retrieveFromCache) {
			list = (List<Server>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Server server : list) {
					if (!Objects.equals(cpu, server.getCpu())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SERVER_WHERE);

			boolean bindCpu = false;

			if (cpu == null) {
				query.append(_FINDER_COLUMN_CPU_CPU_1);
			}
			else if (cpu.equals("")) {
				query.append(_FINDER_COLUMN_CPU_CPU_3);
			}
			else {
				bindCpu = true;

				query.append(_FINDER_COLUMN_CPU_CPU_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ServerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCpu) {
					qPos.add(cpu);
				}

				if (!pagination) {
					list = (List<Server>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Server>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first server in the ordered set where cpu = &#63;.
	 *
	 * @param cpu the cpu
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server
	 * @throws NoSuchServerException if a matching server could not be found
	 */
	@Override
	public Server findByCPU_First(String cpu,
		OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = fetchByCPU_First(cpu, orderByComparator);

		if (server != null) {
			return server;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cpu=");
		msg.append(cpu);

		msg.append("}");

		throw new NoSuchServerException(msg.toString());
	}

	/**
	 * Returns the first server in the ordered set where cpu = &#63;.
	 *
	 * @param cpu the cpu
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching server, or <code>null</code> if a matching server could not be found
	 */
	@Override
	public Server fetchByCPU_First(String cpu,
		OrderByComparator<Server> orderByComparator) {
		List<Server> list = findByCPU(cpu, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last server in the ordered set where cpu = &#63;.
	 *
	 * @param cpu the cpu
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server
	 * @throws NoSuchServerException if a matching server could not be found
	 */
	@Override
	public Server findByCPU_Last(String cpu,
		OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = fetchByCPU_Last(cpu, orderByComparator);

		if (server != null) {
			return server;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cpu=");
		msg.append(cpu);

		msg.append("}");

		throw new NoSuchServerException(msg.toString());
	}

	/**
	 * Returns the last server in the ordered set where cpu = &#63;.
	 *
	 * @param cpu the cpu
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching server, or <code>null</code> if a matching server could not be found
	 */
	@Override
	public Server fetchByCPU_Last(String cpu,
		OrderByComparator<Server> orderByComparator) {
		int count = countByCPU(cpu);

		if (count == 0) {
			return null;
		}

		List<Server> list = findByCPU(cpu, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Server[] findByCPU_PrevAndNext(long serverId, String cpu,
		OrderByComparator<Server> orderByComparator)
		throws NoSuchServerException {
		Server server = findByPrimaryKey(serverId);

		Session session = null;

		try {
			session = openSession();

			Server[] array = new ServerImpl[3];

			array[0] = getByCPU_PrevAndNext(session, server, cpu,
					orderByComparator, true);

			array[1] = server;

			array[2] = getByCPU_PrevAndNext(session, server, cpu,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Server getByCPU_PrevAndNext(Session session, Server server,
		String cpu, OrderByComparator<Server> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVER_WHERE);

		boolean bindCpu = false;

		if (cpu == null) {
			query.append(_FINDER_COLUMN_CPU_CPU_1);
		}
		else if (cpu.equals("")) {
			query.append(_FINDER_COLUMN_CPU_CPU_3);
		}
		else {
			bindCpu = true;

			query.append(_FINDER_COLUMN_CPU_CPU_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ServerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCpu) {
			qPos.add(cpu);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(server);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Server> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the servers where cpu = &#63; from the database.
	 *
	 * @param cpu the cpu
	 */
	@Override
	public void removeByCPU(String cpu) {
		for (Server server : findByCPU(cpu, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(server);
		}
	}

	/**
	 * Returns the number of servers where cpu = &#63;.
	 *
	 * @param cpu the cpu
	 * @return the number of matching servers
	 */
	@Override
	public int countByCPU(String cpu) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CPU;

		Object[] finderArgs = new Object[] { cpu };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVER_WHERE);

			boolean bindCpu = false;

			if (cpu == null) {
				query.append(_FINDER_COLUMN_CPU_CPU_1);
			}
			else if (cpu.equals("")) {
				query.append(_FINDER_COLUMN_CPU_CPU_3);
			}
			else {
				bindCpu = true;

				query.append(_FINDER_COLUMN_CPU_CPU_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCpu) {
					qPos.add(cpu);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CPU_CPU_1 = "server.cpu IS NULL";
	private static final String _FINDER_COLUMN_CPU_CPU_2 = "server.cpu = ?";
	private static final String _FINDER_COLUMN_CPU_CPU_3 = "(server.cpu IS NULL OR server.cpu = '')";

	public ServerPersistenceImpl() {
		setModelClass(Server.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the server in the entity cache if it is enabled.
	 *
	 * @param server the server
	 */
	@Override
	public void cacheResult(Server server) {
		entityCache.putResult(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerImpl.class, server.getPrimaryKey(), server);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { server.getUuid(), server.getGroupId() }, server);

		server.resetOriginalValues();
	}

	/**
	 * Caches the servers in the entity cache if it is enabled.
	 *
	 * @param servers the servers
	 */
	@Override
	public void cacheResult(List<Server> servers) {
		for (Server server : servers) {
			if (entityCache.getResult(ServerModelImpl.ENTITY_CACHE_ENABLED,
						ServerImpl.class, server.getPrimaryKey()) == null) {
				cacheResult(server);
			}
			else {
				server.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all servers.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ServerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the server.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Server server) {
		entityCache.removeResult(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerImpl.class, server.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ServerModelImpl)server, true);
	}

	@Override
	public void clearCache(List<Server> servers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Server server : servers) {
			entityCache.removeResult(ServerModelImpl.ENTITY_CACHE_ENABLED,
				ServerImpl.class, server.getPrimaryKey());

			clearUniqueFindersCache((ServerModelImpl)server, true);
		}
	}

	protected void cacheUniqueFindersCache(ServerModelImpl serverModelImpl) {
		Object[] args = new Object[] {
				serverModelImpl.getUuid(), serverModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			serverModelImpl, false);
	}

	protected void clearUniqueFindersCache(ServerModelImpl serverModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					serverModelImpl.getUuid(), serverModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((serverModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					serverModelImpl.getOriginalUuid(),
					serverModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new server with the primary key. Does not add the server to the database.
	 *
	 * @param serverId the primary key for the new server
	 * @return the new server
	 */
	@Override
	public Server create(long serverId) {
		Server server = new ServerImpl();

		server.setNew(true);
		server.setPrimaryKey(serverId);

		String uuid = PortalUUIDUtil.generate();

		server.setUuid(uuid);

		server.setCompanyId(companyProvider.getCompanyId());

		return server;
	}

	/**
	 * Removes the server with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serverId the primary key of the server
	 * @return the server that was removed
	 * @throws NoSuchServerException if a server with the primary key could not be found
	 */
	@Override
	public Server remove(long serverId) throws NoSuchServerException {
		return remove((Serializable)serverId);
	}

	/**
	 * Removes the server with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the server
	 * @return the server that was removed
	 * @throws NoSuchServerException if a server with the primary key could not be found
	 */
	@Override
	public Server remove(Serializable primaryKey) throws NoSuchServerException {
		Session session = null;

		try {
			session = openSession();

			Server server = (Server)session.get(ServerImpl.class, primaryKey);

			if (server == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(server);
		}
		catch (NoSuchServerException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Server removeImpl(Server server) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(server)) {
				server = (Server)session.get(ServerImpl.class,
						server.getPrimaryKeyObj());
			}

			if (server != null) {
				session.delete(server);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (server != null) {
			clearCache(server);
		}

		return server;
	}

	@Override
	public Server updateImpl(Server server) {
		boolean isNew = server.isNew();

		if (!(server instanceof ServerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(server.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(server);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in server proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Server implementation " +
				server.getClass());
		}

		ServerModelImpl serverModelImpl = (ServerModelImpl)server;

		if (Validator.isNull(server.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			server.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (server.getCreateDate() == null)) {
			if (serviceContext == null) {
				server.setCreateDate(now);
			}
			else {
				server.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!serverModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				server.setModifiedDate(now);
			}
			else {
				server.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (server.isNew()) {
				session.save(server);

				server.setNew(false);
			}
			else {
				server = (Server)session.merge(server);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ServerModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { serverModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					serverModelImpl.getUuid(), serverModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { serverModelImpl.getDistribution() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DISTRIBUTION, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISTRIBUTION,
				args);

			args = new Object[] { serverModelImpl.isVpn() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_VPN, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VPN,
				args);

			args = new Object[] { serverModelImpl.getCpu() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CPU, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CPU,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((serverModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { serverModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { serverModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((serverModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serverModelImpl.getOriginalUuid(),
						serverModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						serverModelImpl.getUuid(),
						serverModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((serverModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISTRIBUTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serverModelImpl.getOriginalDistribution()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DISTRIBUTION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISTRIBUTION,
					args);

				args = new Object[] { serverModelImpl.getDistribution() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DISTRIBUTION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DISTRIBUTION,
					args);
			}

			if ((serverModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VPN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { serverModelImpl.getOriginalVpn() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VPN, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VPN,
					args);

				args = new Object[] { serverModelImpl.isVpn() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VPN, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VPN,
					args);
			}

			if ((serverModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CPU.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { serverModelImpl.getOriginalCpu() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CPU, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CPU,
					args);

				args = new Object[] { serverModelImpl.getCpu() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CPU, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CPU,
					args);
			}
		}

		entityCache.putResult(ServerModelImpl.ENTITY_CACHE_ENABLED,
			ServerImpl.class, server.getPrimaryKey(), server, false);

		clearUniqueFindersCache(serverModelImpl, false);
		cacheUniqueFindersCache(serverModelImpl);

		server.resetOriginalValues();

		return server;
	}

	/**
	 * Returns the server with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the server
	 * @return the server
	 * @throws NoSuchServerException if a server with the primary key could not be found
	 */
	@Override
	public Server findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServerException {
		Server server = fetchByPrimaryKey(primaryKey);

		if (server == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return server;
	}

	/**
	 * Returns the server with the primary key or throws a {@link NoSuchServerException} if it could not be found.
	 *
	 * @param serverId the primary key of the server
	 * @return the server
	 * @throws NoSuchServerException if a server with the primary key could not be found
	 */
	@Override
	public Server findByPrimaryKey(long serverId) throws NoSuchServerException {
		return findByPrimaryKey((Serializable)serverId);
	}

	/**
	 * Returns the server with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the server
	 * @return the server, or <code>null</code> if a server with the primary key could not be found
	 */
	@Override
	public Server fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ServerModelImpl.ENTITY_CACHE_ENABLED,
				ServerImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Server server = (Server)serializable;

		if (server == null) {
			Session session = null;

			try {
				session = openSession();

				server = (Server)session.get(ServerImpl.class, primaryKey);

				if (server != null) {
					cacheResult(server);
				}
				else {
					entityCache.putResult(ServerModelImpl.ENTITY_CACHE_ENABLED,
						ServerImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ServerModelImpl.ENTITY_CACHE_ENABLED,
					ServerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return server;
	}

	/**
	 * Returns the server with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serverId the primary key of the server
	 * @return the server, or <code>null</code> if a server with the primary key could not be found
	 */
	@Override
	public Server fetchByPrimaryKey(long serverId) {
		return fetchByPrimaryKey((Serializable)serverId);
	}

	@Override
	public Map<Serializable, Server> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Server> map = new HashMap<Serializable, Server>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Server server = fetchByPrimaryKey(primaryKey);

			if (server != null) {
				map.put(primaryKey, server);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ServerModelImpl.ENTITY_CACHE_ENABLED,
					ServerImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Server)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SERVER_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Server server : (List<Server>)q.list()) {
				map.put(server.getPrimaryKeyObj(), server);

				cacheResult(server);

				uncachedPrimaryKeys.remove(server.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ServerModelImpl.ENTITY_CACHE_ENABLED,
					ServerImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the servers.
	 *
	 * @return the servers
	 */
	@Override
	public List<Server> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Server> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Server> findAll(int start, int end,
		OrderByComparator<Server> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Server> findAll(int start, int end,
		OrderByComparator<Server> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Server> list = null;

		if (retrieveFromCache) {
			list = (List<Server>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SERVER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVER;

				if (pagination) {
					sql = sql.concat(ServerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Server>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Server>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the servers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Server server : findAll()) {
			remove(server);
		}
	}

	/**
	 * Returns the number of servers.
	 *
	 * @return the number of servers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SERVER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ServerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the server persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ServerImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SERVER = "SELECT server FROM Server server";
	private static final String _SQL_SELECT_SERVER_WHERE_PKS_IN = "SELECT server FROM Server server WHERE serverId IN (";
	private static final String _SQL_SELECT_SERVER_WHERE = "SELECT server FROM Server server WHERE ";
	private static final String _SQL_COUNT_SERVER = "SELECT COUNT(server) FROM Server server";
	private static final String _SQL_COUNT_SERVER_WHERE = "SELECT COUNT(server) FROM Server server WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "server.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Server exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Server exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ServerPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}