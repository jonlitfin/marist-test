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

package marist.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Server}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Server
 * @generated
 */
@ProviderType
public class ServerWrapper implements Server, ModelWrapper<Server> {
	public ServerWrapper(Server server) {
		_server = server;
	}

	@Override
	public Class<?> getModelClass() {
		return Server.class;
	}

	@Override
	public String getModelClassName() {
		return Server.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("serverId", getServerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("distribution", getDistribution());
		attributes.put("version", getVersion());
		attributes.put("vpn", isVpn());
		attributes.put("memory", getMemory());
		attributes.put("disk", getDisk());
		attributes.put("cpu", getCpu());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long serverId = (Long)attributes.get("serverId");

		if (serverId != null) {
			setServerId(serverId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String distribution = (String)attributes.get("distribution");

		if (distribution != null) {
			setDistribution(distribution);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Boolean vpn = (Boolean)attributes.get("vpn");

		if (vpn != null) {
			setVpn(vpn);
		}

		Integer memory = (Integer)attributes.get("memory");

		if (memory != null) {
			setMemory(memory);
		}

		Integer disk = (Integer)attributes.get("disk");

		if (disk != null) {
			setDisk(disk);
		}

		String cpu = (String)attributes.get("cpu");

		if (cpu != null) {
			setCpu(cpu);
		}
	}

	@Override
	public Object clone() {
		return new ServerWrapper((Server)_server.clone());
	}

	@Override
	public int compareTo(Server server) {
		return _server.compareTo(server);
	}

	/**
	* Returns the company ID of this server.
	*
	* @return the company ID of this server
	*/
	@Override
	public long getCompanyId() {
		return _server.getCompanyId();
	}

	/**
	* Returns the cpu of this server.
	*
	* @return the cpu of this server
	*/
	@Override
	public String getCpu() {
		return _server.getCpu();
	}

	/**
	* Returns the create date of this server.
	*
	* @return the create date of this server
	*/
	@Override
	public Date getCreateDate() {
		return _server.getCreateDate();
	}

	/**
	* Returns the disk of this server.
	*
	* @return the disk of this server
	*/
	@Override
	public int getDisk() {
		return _server.getDisk();
	}

	/**
	* Returns the distribution of this server.
	*
	* @return the distribution of this server
	*/
	@Override
	public String getDistribution() {
		return _server.getDistribution();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _server.getExpandoBridge();
	}

	/**
	* Returns the group ID of this server.
	*
	* @return the group ID of this server
	*/
	@Override
	public long getGroupId() {
		return _server.getGroupId();
	}

	/**
	* Returns the memory of this server.
	*
	* @return the memory of this server
	*/
	@Override
	public int getMemory() {
		return _server.getMemory();
	}

	/**
	* Returns the modified date of this server.
	*
	* @return the modified date of this server
	*/
	@Override
	public Date getModifiedDate() {
		return _server.getModifiedDate();
	}

	/**
	* Returns the name of this server.
	*
	* @return the name of this server
	*/
	@Override
	public String getName() {
		return _server.getName();
	}

	/**
	* Returns the primary key of this server.
	*
	* @return the primary key of this server
	*/
	@Override
	public long getPrimaryKey() {
		return _server.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _server.getPrimaryKeyObj();
	}

	/**
	* Returns the server ID of this server.
	*
	* @return the server ID of this server
	*/
	@Override
	public long getServerId() {
		return _server.getServerId();
	}

	/**
	* Returns the user ID of this server.
	*
	* @return the user ID of this server
	*/
	@Override
	public long getUserId() {
		return _server.getUserId();
	}

	/**
	* Returns the user name of this server.
	*
	* @return the user name of this server
	*/
	@Override
	public String getUserName() {
		return _server.getUserName();
	}

	/**
	* Returns the user uuid of this server.
	*
	* @return the user uuid of this server
	*/
	@Override
	public String getUserUuid() {
		return _server.getUserUuid();
	}

	/**
	* Returns the uuid of this server.
	*
	* @return the uuid of this server
	*/
	@Override
	public String getUuid() {
		return _server.getUuid();
	}

	/**
	* Returns the version of this server.
	*
	* @return the version of this server
	*/
	@Override
	public String getVersion() {
		return _server.getVersion();
	}

	/**
	* Returns the vpn of this server.
	*
	* @return the vpn of this server
	*/
	@Override
	public boolean getVpn() {
		return _server.getVpn();
	}

	@Override
	public int hashCode() {
		return _server.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _server.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _server.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _server.isNew();
	}

	/**
	* Returns <code>true</code> if this server is vpn.
	*
	* @return <code>true</code> if this server is vpn; <code>false</code> otherwise
	*/
	@Override
	public boolean isVpn() {
		return _server.isVpn();
	}

	@Override
	public void persist() {
		_server.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_server.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this server.
	*
	* @param companyId the company ID of this server
	*/
	@Override
	public void setCompanyId(long companyId) {
		_server.setCompanyId(companyId);
	}

	/**
	* Sets the cpu of this server.
	*
	* @param cpu the cpu of this server
	*/
	@Override
	public void setCpu(String cpu) {
		_server.setCpu(cpu);
	}

	/**
	* Sets the create date of this server.
	*
	* @param createDate the create date of this server
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_server.setCreateDate(createDate);
	}

	/**
	* Sets the disk of this server.
	*
	* @param disk the disk of this server
	*/
	@Override
	public void setDisk(int disk) {
		_server.setDisk(disk);
	}

	/**
	* Sets the distribution of this server.
	*
	* @param distribution the distribution of this server
	*/
	@Override
	public void setDistribution(String distribution) {
		_server.setDistribution(distribution);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_server.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_server.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_server.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this server.
	*
	* @param groupId the group ID of this server
	*/
	@Override
	public void setGroupId(long groupId) {
		_server.setGroupId(groupId);
	}

	/**
	* Sets the memory of this server.
	*
	* @param memory the memory of this server
	*/
	@Override
	public void setMemory(int memory) {
		_server.setMemory(memory);
	}

	/**
	* Sets the modified date of this server.
	*
	* @param modifiedDate the modified date of this server
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_server.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this server.
	*
	* @param name the name of this server
	*/
	@Override
	public void setName(String name) {
		_server.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_server.setNew(n);
	}

	/**
	* Sets the primary key of this server.
	*
	* @param primaryKey the primary key of this server
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_server.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_server.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the server ID of this server.
	*
	* @param serverId the server ID of this server
	*/
	@Override
	public void setServerId(long serverId) {
		_server.setServerId(serverId);
	}

	/**
	* Sets the user ID of this server.
	*
	* @param userId the user ID of this server
	*/
	@Override
	public void setUserId(long userId) {
		_server.setUserId(userId);
	}

	/**
	* Sets the user name of this server.
	*
	* @param userName the user name of this server
	*/
	@Override
	public void setUserName(String userName) {
		_server.setUserName(userName);
	}

	/**
	* Sets the user uuid of this server.
	*
	* @param userUuid the user uuid of this server
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_server.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this server.
	*
	* @param uuid the uuid of this server
	*/
	@Override
	public void setUuid(String uuid) {
		_server.setUuid(uuid);
	}

	/**
	* Sets the version of this server.
	*
	* @param version the version of this server
	*/
	@Override
	public void setVersion(String version) {
		_server.setVersion(version);
	}

	/**
	* Sets whether this server is vpn.
	*
	* @param vpn the vpn of this server
	*/
	@Override
	public void setVpn(boolean vpn) {
		_server.setVpn(vpn);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Server> toCacheModel() {
		return _server.toCacheModel();
	}

	@Override
	public Server toEscapedModel() {
		return new ServerWrapper(_server.toEscapedModel());
	}

	@Override
	public String toString() {
		return _server.toString();
	}

	@Override
	public Server toUnescapedModel() {
		return new ServerWrapper(_server.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _server.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServerWrapper)) {
			return false;
		}

		ServerWrapper serverWrapper = (ServerWrapper)obj;

		if (Objects.equals(_server, serverWrapper._server)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _server.getStagedModelType();
	}

	@Override
	public Server getWrappedModel() {
		return _server;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _server.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _server.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_server.resetOriginalValues();
	}

	private final Server _server;
}